#!/usr/bin/env python3
# SPDX-FileCopyrightText: 2008-2023 HPDCS Group <rootsim@googlegroups.com>
# SPDX-License-Identifier: GPL-3.0-only
"""Module for efficiently loading ROOT-Sim statistics from a binary file.

This class can be used to load and pre-process statistics generated by ROOT-Sim, a discrete-event simulator
for parallel and distributed systems. If you configured ROOT-Sim to produce a statistics file, a binary file
will be generated, which can be loaded using the `RSStats` class.

Usage:
    stats = RSStats('path/to/root_sim_stats_file.bin')

The `RSStats` class reads and processes the statistics file during instantiation, and exposes the resulting
data through several attributes.

Attributes:
    big_endian (bool): Whether the statistics file is in big endian format.
    metrics (Dict[str, List]): A dictionary mapping metric names to lists of statistics values.
    threads_count (List[int]): A list of thread counts for each node in the simulation.
    all_stats (List[Tuple]): A list of tuples, each containing global statistics, node statistics, and
        per-thread statistics for each node in the simulation.
    global_measures (Dict[str, List]): A dictionary mapping measure names to lists of global measure values.

The `RSStats` class is intended to be used as a helper class for post-processing ROOT-Sim statistics, and
exposes data in a format that can be easily consumed by downstream scripts and applications.
"""

import copy
import struct
import sys


##
# @brief The statistics class used to load and pre-process ROOT-Sim statistics files
#
# If you configured ROOT-Sim to produce a statistics file, a binary file will be generated.
# You can use the facilities offered by this class to efficiently load those statistics.
class RSStats:
    """
    The `RSStats` class loads and pre-processes ROOT-Sim binary statistics files.

    You can use this class to efficiently load and process statistics generated by ROOT-Sim.

    Example usage:

    stats = RSStats("path/to/stats_file.bin")
    lps = stats.get_global_measure("lps")
    """

    def _pattern_unpack(self, ptrn):
        ptrn_size = struct.calcsize(ptrn)
        data_parse = self._data[self._data_idx:ptrn_size + self._data_idx]
        self._data_idx += ptrn_size
        ret = struct.unpack((">" if self.big_endian else "<") + ptrn, data_parse)
        return ret

    def _metric_names_load(self):
        metric_names = []
        n_stats = self._pattern_unpack("q")[0]
        for _ in range(n_stats):
            raw_name_len = self._pattern_unpack("B")[0]
            raw_name = self._pattern_unpack(f"{raw_name_len}s")[0]
            metric_name = raw_name.decode("utf-8").rstrip('\0')
            metric_names.append(metric_name)
            self._metrics[metric_name] = []
        return metric_names

    def _threads_unpack(self):
        metrics_len = len(self.metrics)
        n_stats = self._pattern_unpack("q")[0] // (metrics_len * 8)
        t_stats_fmt = str(metrics_len) + "Q"
        ret = []
        for _ in range(n_stats):
            ret.append(self._pattern_unpack(t_stats_fmt))
        return ret

    def _nodes_stats_load(self):
        nodes_count = self._pattern_unpack("q")[0]
        for _ in range(nodes_count):
            glob_stats = self._pattern_unpack("9Q")
            n_threads = glob_stats[0]
            self.threads_count.append(n_threads)
            n_stats = self._pattern_unpack("q")[0] // 16
            node_stats = []
            for _ in range(n_stats):
                node_stats.append(self._pattern_unpack("dQ"))

            threads_stats = []
            for _ in range(n_threads):
                threads_stats.append(self._threads_unpack())

            self.all_stats.append((glob_stats, node_stats, threads_stats))

    def _truncate_to_last_gvt(self):
        min_gvts = len(self.all_stats[0][1])
        for _, node_stats, threads_stats in self.all_stats:
            min_gvts = min(len(node_stats), min_gvts)
            for t_stats in threads_stats:
                min_gvts = min(len(t_stats), min_gvts)

        ret = []
        for glob_stats, node_stats, threads_stats in self.all_stats:
            t_node_stats = node_stats[:min_gvts]
            t_threads_stats = []
            for t_stats in threads_stats:
                t_threads_stats.append(t_stats[:min_gvts])
            ret.append((glob_stats, t_node_stats, t_threads_stats))

        self.all_stats = ret

    ##
    # @brief Construct a new RSStats object
    # @param self the RSStats instance being constructed
    # @param rs_stats_file the path of the binary statistics file generated by ROOT-Sim
    def __init__(self, rs_stats_file):
        with open(rs_stats_file, 'rb') as bin_file:
            self._data = bin_file.read()

        self._data_idx = 0
        self.big_endian = True
        magic_number = self._pattern_unpack("H")[0]
        if magic_number not in (4080, 61455):
            raise RuntimeWarning("Parsing failed, wrong initial magic number")

        self.big_endian = magic_number == 61455
        self._metrics = {}
        metric_names = self._metric_names_load()

        self.threads_count = []
        self.all_stats = []
        self._nodes_stats_load()

        if len(self._data) != self._data_idx:
            raise RuntimeWarning("Parsing failed, there's garbage at the end")

        self._gvts = []
        self._truncate_to_last_gvt()

        self._global_measures = {
            "lps": [],
            "maximum_resident_set": [],
            "node_init_time": [],
            "worker_threads_init_time": [],
            "processing_time": [],
            "worker_threads_fini_time": [],
            "node_fini_time": [],
            "node_total_time": [],
            "node_total_hr_time": [],
            "resident_set": []
        }
        for triple in self.all_stats:
            glob_stats, node_stats, threads_stats = triple

            self._global_measures["lps"].append(glob_stats[1])
            self._global_measures["maximum_resident_set"].append(glob_stats[2])
            self._global_measures["node_init_time"].append(glob_stats[3])
            self._global_measures["worker_threads_init_time"].append(glob_stats[4] - glob_stats[3])
            self._global_measures["processing_time"].append(glob_stats[5] - glob_stats[4])
            self._global_measures["worker_threads_fini_time"].append(glob_stats[6] - glob_stats[5])
            self._global_measures["node_fini_time"].append(glob_stats[7] - glob_stats[6])
            self._global_measures["node_total_time"].append(glob_stats[7] - glob_stats[3])
            self._global_measures["node_total_hr_time"].append(glob_stats[8])

            mem = []
            for i, (gvt, crs_mem) in enumerate(node_stats):
                if len(self._gvts) <= i:
                    self._gvts.append(gvt)
                elif self._gvts[i] != gvt:
                    raise RuntimeWarning("Parsing failed, inconsistent GVTs across nodes and/or threads")

                mem.append(crs_mem)

            self._global_measures["resident_set"].append(mem)

            for j, metric_name in enumerate(metric_names):
                metric_n_stat = []
                for t_stat in threads_stats:
                    metric_t_stat = []
                    for tup in t_stat:
                        metric_t_stat.append(tup[j])
                    metric_n_stat.append(metric_t_stat)

                self._metrics[metric_name].append(metric_n_stat)

    ##
    # @brief Get the GVT values
    # @return a list containing the computed GVTs (Global Virtual Times) in ascending order
    @property
    def gvts(self):
        """
        Returns a list containing the computed GVTs (Global Virtual Times) in ascending order

        Returns
        -------
            list: A list of gvts for the current object.
        """
        return list(self._gvts)

    ##
    # @brief Get the real time values
    # @return a list containing the computed real times in ascending order
    def rts(self, reduction=lambda x: sum(x) / len(x)):
        """
        Get the computed real times for each GVT value in ascending order.

        This method retrieves the "gvt real time" metrics stored in the object's internal `_metrics`
        dictionary and computes the real times for each GVT value. The resulting real times are
        returned as a list in ascending order.

        Parameters
        ----------
            reduction: (optional) A function that takes in a list of values and returns a single
                reduced value. By default, the function computes the average of the list.

        Returns
        -------
            A list of computed real times for each GVT value in ascending order.
        """
        real_times = self._metrics["gvt real time"]
        ret = []
        for i in range(len(self._gvts)):
            values = []
            for node_stats in real_times:
                for thread_stats in node_stats:
                    values.append(thread_stats[i])
            ret.append(reduction(values))
        return ret

    ##
    # @brief Get the thread-specific metric names
    # @return a list containing the metric names that you can use in #thread_metric_get()
    @property
    def metrics(self):
        """
        Get the thread-specific metric names.

        Returns a list of the names of the metrics that can be used in the #thread_metric_get() method.

        Returns
        -------
            A list of strings representing the names of the available thread-specific metrics.
        """
        return list(self._metrics)

    ##
    # @brief Get the node-specific statistics
    # @return a dictionary containing node-specific statistics
    # TODO more thorough description of what we have here
    @property
    def nodes_stats(self):
        """Retrieve the statistics for the specified node."""
        return self._global_measures

    @property
    def nodes_count(self):
        """Return the number of threads used in the simulation run"""
        return len(self.threads_count)

    ##
    # @brief Get the thread-specific metric values
    # @return a list of values
    # FIXME: much more complicated, explain it!
    # TODO: optionally provide stats normalized by real-time
    def thread_metric_get(self, metric, aggregate_gvts=False, aggregate_threads=False, aggregate_nodes=False):
        """Get the thread-specific metric values"""
        if metric not in self._metrics:
            raise RuntimeError(f"Asked stats for the non-existing thread_metric {metric}")

        if aggregate_nodes:
            aggregate_threads = True

        this_stats = copy.deepcopy(self._metrics[metric])

        if aggregate_gvts:
            for nstats in this_stats:
                for i, _ in enumerate(nstats):
                    nstats[i] = sum(nstats[i])

            if aggregate_threads:
                for i, _ in enumerate(this_stats):
                    this_stats[i] = sum(this_stats[i])

                if aggregate_nodes:
                    this_stats = sum(this_stats)
        else:
            if aggregate_threads:
                for i, _ in enumerate(this_stats):
                    gvt_stats = [0] * len(self._gvts)
                    for rstats in this_stats[i]:
                        for j, val in enumerate(rstats):
                            gvt_stats[j] += val
                    this_stats[i] = gvt_stats

                if aggregate_nodes:
                    gvt_stats = [0] * len(self._gvts)
                    for nstats in this_stats:
                        for j, val in enumerate(nstats):
                            gvt_stats[j] += val
                    this_stats = gvt_stats

        return this_stats


def format_size(num, is_binary=True):
    """Format a number of bytes into a human-readable string.

    Parameters
    ----------
        num: The number of bytes to format.
        is_binary: (optional) If True, use binary prefixes (1024 bytes = 1 KiB).
            Otherwise, use decimal prefixes (1000 bytes = 1 KB).

    Returns
    -------
        str: The formatted size in a human-readable format. The format will vary
        based on the size of the input, and whether a binary or decimal system is
        being used. The result will be a string that includes the size with the
        appropriate unit (e.g. "10.5 KB" or "2.3 MiB").
    """
    div = 1024.0 if is_binary else 1000.0
    post_unit = "i" if is_binary else ""

    if num == 0:
        return "0"

    if abs(num) < div:
        if abs(num) > 1:
            return f"{num:3.1f}"
        num *= div
        for unit in ["m", "u", "n"]:
            if abs(num) > 1:
                return f"{num:3.1f}{unit}{post_unit}"
            num *= div
        return f"{num:3.1f}p{post_unit}"

    num /= div
    for unit in ["K", "M", "G", "T", "P"]:
        if abs(num) < div:
            return f"{num:.1f}{unit}{post_unit}"
        num /= div

    return f"{num:.1f}P{post_unit}"


def dump_text_report(filename):
    """
    Dump a text report of the simulation run.

    Parameters
    ----------
        filename: The name of the file to write the report to.
    """
    raw_stats = RSStats(filename)

    stat = {
        "simulation_time": raw_stats.nodes_stats["node_total_time"][0] / 1000000,
        "processing_time": raw_stats.nodes_stats["processing_time"][0] / 1000000,
        "processed_msgs": raw_stats.thread_metric_get("processed messages", aggregate_nodes=True, aggregate_gvts=True),
        "anti_msgs": raw_stats.thread_metric_get("anti messages", aggregate_nodes=True, aggregate_gvts=True),
        "rollback_msgs": raw_stats.thread_metric_get("rolled back messages", aggregate_nodes=True, aggregate_gvts=True),
        "silent_msgs": raw_stats.thread_metric_get("silent messages", aggregate_nodes=True, aggregate_gvts=True),
        "rollbacks": raw_stats.thread_metric_get("rollbacks", aggregate_nodes=True, aggregate_gvts=True),
        "checkpoints": raw_stats.thread_metric_get("checkpoints", aggregate_nodes=True, aggregate_gvts=True),
        "msgs_cost": raw_stats.thread_metric_get("processed messages time", aggregate_nodes=True, aggregate_gvts=True),
        "checkpoints_cost": raw_stats.thread_metric_get("checkpoints time", aggregate_nodes=True, aggregate_gvts=True),
        "recoveries_cost": raw_stats.thread_metric_get("recovery time", aggregate_nodes=True, aggregate_gvts=True),
        "checkpoints_size": raw_stats.thread_metric_get("checkpoints size", aggregate_nodes=True, aggregate_gvts=True),
        "peak_memory_usage": sum(raw_stats.nodes_stats["maximum_resident_set"]),
        "lps_count": sum(raw_stats.nodes_stats["lps"]),
        "avg_memory_usage": 0.0,
        "sim_speed": 0.0,
        "last_gvt": 0.0
    }
    stat["hr_ticks_per_second"] = raw_stats.nodes_stats["node_total_hr_time"][0] / stat["simulation_time"]
    stat["avg_checkpoint_size"] = stat["checkpoints_size"] / stat["checkpoints"] if stat["checkpoints"] != 0 else 0
    stat["avg_msg_cost"] = 0 if stat["processed_msgs"] == 0 else stat["msgs_cost"] / (
        stat["processed_msgs"] * stat["hr_ticks_per_second"])
    stat["avg_checkpoint_cost"] = 0 if stat["checkpoints"] == 0 else stat["checkpoints_cost"] / (
        stat["checkpoints"] * stat["hr_ticks_per_second"])
    stat["avg_recovery_cost"] = 0 if stat["rollbacks"] == 0 else stat["recoveries_cost"] / (
        stat["rollbacks"] * stat["hr_ticks_per_second"])

    stat["rollback_freq"] = 100 * stat["rollbacks"] / stat["processed_msgs"] if stat["processed_msgs"] != 0 else 0
    stat["rollback_len"] = stat["rollback_msgs"] / stat["rollbacks"] if stat["rollbacks"] != 0 else 0
    stat["efficiency"] = 100 * (stat["processed_msgs"] - stat["rollback_msgs"]) / stat["processed_msgs"] if stat[
        "processed_msgs"] else 100

    if raw_stats.gvts:
        stat["avg_memory_usage"] = sum(sum(t) for t in raw_stats.nodes_stats["resident_set"]) / len(raw_stats.gvts)
        stat["last_gvt"] = raw_stats.gvts[-1]
        stat["sim_speed"] = stat["last_gvt"] / len(raw_stats.gvts)

    out_name = sys.argv[1][:-4] if sys.argv[1].endswith(".bin") else sys.argv[1]
    out_name += ".txt"

    with open(out_name, "w", encoding="utf8") as out_file:
        out_file.write(f"TOTAL SIMULATION TIME ..... : {format_size(stat['simulation_time'], False)}s\n"
                       f"TOTAL PROCESSING TIME ..... : {format_size(stat['processing_time'], False)}s\n"
                       f"TOTAL KERNELS ............. : {raw_stats.nodes_count}\n"
                       f"TOTAL THREADS ............. : {sum(raw_stats.threads_count)}\n"
                       f"TOTAL LPS ................. : {stat['lps_count']}\n"
                       f"TOTAL EXECUTED EVENTS ..... : {stat['processed_msgs'] + stat['silent_msgs']}\n"
                       f"TOTAL COMMITTED EVENTS..... : {stat['processed_msgs'] - stat['rollback_msgs']}\n"
                       f"TOTAL REPROCESSED EVENTS... : {stat['rollback_msgs']}\n"
                       f"TOTAL SILENT EVENTS........ : {stat['silent_msgs']}\n"
                       f"TOTAL ROLLBACKS EXECUTED... : {stat['rollbacks']}\n"
                       f"TOTAL ANTIMESSAGES......... : {stat['anti_msgs']}\n"
                       f"ROLLBACK FREQUENCY......... : {stat['rollback_freq']:.2f}%\n"
                       f"ROLLBACK LENGTH............ : {stat['rollback_len']:.2f}\n"
                       f"EFFICIENCY................. : {stat['efficiency']:.2f}%\n"
                       f"AVERAGE EVENT COST......... : {format_size(stat['avg_msg_cost'], False)}s\n"
                       f"AVERAGE CHECKPOINT COST.... : {format_size(stat['avg_checkpoint_cost'], False)}s\n"
                       f"AVERAGE RECOVERY COST...... : {format_size(stat['avg_recovery_cost'], False)}s\n"
                       f"AVERAGE CHECKPOINT SIZE.... : {format_size(stat['avg_checkpoint_size'])}B\n"
                       f"LAST COMMITTED GVT ........ : {stat['last_gvt']}\n"
                       f"NUMBER OF GVT REDUCTIONS... : {len(raw_stats.gvts)}\n"
                       f"SIMULATION TIME SPEED...... : {stat['sim_speed']}\n"
                       f"AVERAGE MEMORY USAGE....... : {format_size(stat['avg_memory_usage'])}B\n"
                       f"PEAK MEMORY USAGE.......... : {format_size(stat['peak_memory_usage'])}B\n")


# Produce a boring textual report
if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Please, supply the name of the raw statistics file!", file=sys.stderr)
        sys.exit(1)

    dump_text_report(sys.argv[1])