#pragma once

#include <sys/types.h>

#include "include/pseudosql.h"

extern int is_valid_date_format(const char *str);
extern time_t convert_to_unix_timestamp(const char *datetime_str);
extern int is_valid_date_format(const char *str);
extern int is_float(const char *str);
extern int is_integer(const char *str);
extern int get_index(Row row, char *col_name);
extern double compute_average(RowsList list, char *col_name);
extern double compute_sum(RowsList list, char *col_name);
extern int are_equals(Row row1, Row row2, char *col1_name, char *col2_name);
extern void InitializeSchema(Schema *schema, char *header);
extern void PopulateRow(char *row_string, Row *row, Schema schema);
extern void PrintRow(const Row *row);
