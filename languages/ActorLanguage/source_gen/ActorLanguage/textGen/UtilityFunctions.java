package ActorLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;

public abstract class UtilityFunctions {
  public static void functions(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);

    tgs.append("void init_linked_actors(linked_actors *array) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("array->strings = NULL;");
    tgs.newLine();
    tgs.indent();
    tgs.append("array->size = 0;");
    tgs.newLine();
    tgs.indent();
    tgs.append("array->capacity = 0;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("void add_to_linked_actors(linked_actors *array, const char *str) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (array->size == array->capacity) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("array->capacity = (array->capacity == 0) ? 2 : array->capacity * 2;");
    tgs.newLine();
    tgs.indent();
    tgs.append("array->strings = realloc(array->strings, array->capacity * sizeof(char *));");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("array->strings[array->size] = strdup(str);");
    tgs.newLine();
    tgs.indent();
    tgs.append("array->size++;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("void init_topology(topology *map) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("map->entries = NULL;");
    tgs.newLine();
    tgs.indent();
    tgs.append("map->size = 0;");
    tgs.newLine();
    tgs.indent();
    tgs.append("map->capacity = 0;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("void add_to_topology(topology *map, const char *key, const char *value) {");
    tgs.newLine();
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();

    tgs.indent();
    tgs.append("pthread_mutex_lock(&topology_mutex);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("for (size_t i = 0; i < map->size; i++) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (strcmp(map->entries[i].key, key) == 0) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("add_to_linked_actors(&map->entries[i].values, value);");
    tgs.newLine();
    tgs.indent();
    tgs.append("pthread_mutex_unlock(&topology_mutex);");
    tgs.newLine();
    tgs.indent();
    tgs.append("return;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("if (map->size == map->capacity) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("map->capacity = (map->capacity == 0) ? 2 : map->capacity * 2;");
    tgs.newLine();
    tgs.indent();
    tgs.append("map->entries = realloc(map->entries, map->capacity * sizeof(map_entry));");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("map->entries[map->size].key = strdup(key);");
    tgs.newLine();
    tgs.indent();
    tgs.append("init_linked_actors(&map->entries[map->size].values);");
    tgs.newLine();
    tgs.indent();
    tgs.append("add_to_linked_actors(&map->entries[map->size].values, value);");
    tgs.newLine();
    tgs.indent();
    tgs.append("map->size++;");
    tgs.newLine();

    tgs.indent();
    tgs.append("pthread_mutex_unlock(&topology_mutex);");
    tgs.newLine();
    tgs.newLine();


    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("void create_actor(char *name, pthread_t thread, void *(behavior)(void *)) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("pthread_create(&thread, NULL, behavior, (void *)name);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("int get_mqid(const char* str) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("unsigned long hash = 5381;");
    tgs.newLine();
    tgs.indent();
    tgs.append("int c;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("while ((c = *str++)) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("hash = ((hash << 5) + hash) + c;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("return msgget(hash, 0666 | IPC_CREAT);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("envelope *create_envelope(char *sender, char *receiver, float priority) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("envelope *env;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("env = (envelope *)calloc(1, sizeof(envelope));");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!env) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"calloc\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("env->priority = priority;");
    tgs.newLine();
    tgs.indent();
    tgs.append("env->sender = strdup(sender);");
    tgs.newLine();
    tgs.indent();
    tgs.append("env->receiver = strdup(receiver);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("return env;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("payload *create_payload(char **strings, size_t size) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("payload *p;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("p = calloc(1, sizeof(payload));");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!p) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"calloc\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("p->size = size;");
    tgs.newLine();
    tgs.indent();
    tgs.append("p->strings = strings;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("return p;");
    tgs.newLine();

    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("msgbuf create_message(envelope *env, payload *p, int mtype) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("message *m;");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgbuf buf;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("m = calloc(1, sizeof(message));");
    tgs.indent();
    tgs.append("if (!m) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"calloc\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("m->envelope = env;");
    tgs.newLine();
    tgs.indent();
    tgs.append("m->payload = p;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("buf.msg = m;");
    tgs.newLine();
    tgs.indent();
    tgs.append("buf.mtype = mtype;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("return buf;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();


    tgs.append("strings_array *get_actors(char *actor_name) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("int mqid, ret;");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgbuf rec_buf;");
    tgs.newLine();
    tgs.indent();
    tgs.append("strings_array *list;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("char *text = \"topology\";");
    tgs.newLine();
    tgs.indent();
    tgs.append("payload *p = create_payload(&text, 1);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("/* ENVELOPE CREATION */");
    tgs.newLine();
    tgs.indent();
    tgs.append("envelope *env = create_envelope(actor_name, \"receptionist\", 5.0);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("/* MESSAGE CREATION */");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgbuf buf = create_message(env, p, 1);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("/* SEND MESSAGE */");
    tgs.newLine();
    tgs.indent();
    tgs.append("mqid = get_mqid(\"receptionist\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("ret = msgsnd(mqid, (void *)&buf, sizeof(buf.msg), 0);");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (ret == -1) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"msgsnd\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("/* GET RESPONSE */");
    tgs.newLine();
    tgs.indent();
    tgs.append("ret = msgrcv(get_mqid(actor_name), (void *)&rec_buf, sizeof(rec_buf.msg), 2, 0);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("if (rec_buf.msg->payload->size == -1) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("printf(\"[%s] This actor has not outcoming links in topology\", actor_name);");
    tgs.newLine();
    tgs.indent();
    tgs.append("puts(\"\");");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("free(rec_buf.msg->payload);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope->sender);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope->receiver);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg);");
    tgs.newLine();
    tgs.newLine();
    tgs.indent();
    tgs.append("return NULL;");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("} else {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("list = malloc(sizeof(strings_array));");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!list) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"malloc\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("list->size = rec_buf.msg->payload->size;");
    tgs.newLine();
    tgs.indent();
    tgs.append("list->strings = malloc(list->size * sizeof(char *));");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!list->strings) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"malloc\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("for (int i = 0; i < list->size; i++) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("list->strings[i] = strdup(rec_buf.msg->payload->strings[i]);");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!list->strings[i]) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"strdup\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("exit(EXIT_FAILURE);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("free(rec_buf.msg->payload->strings);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->payload);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope->sender);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope->receiver);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg->envelope);");
    tgs.newLine();
    tgs.indent();
    tgs.append("free(rec_buf.msg);");
    tgs.newLine();
    tgs.newLine();
    tgs.indent();
    tgs.append("return list;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();
  }
}
