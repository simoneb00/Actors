package ActorLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;

public abstract class Header {
  public static void header(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);
    tgs.append("#include <stdio.h>");
    tgs.newLine();
    tgs.append("#include <sys/ipc.h>");
    tgs.newLine();
    tgs.append("#include <sys/msg.h>");
    tgs.newLine();
    tgs.append("#include <pthread.h>");
    tgs.newLine();
    tgs.append("#include <string.h>");
    tgs.newLine();
    tgs.append("#include <stdlib.h>");
    tgs.newLine();
    tgs.append("#include <unistd.h>");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("char *sender;");
    tgs.newLine();
    tgs.indent();
    tgs.append("char *receiver;");
    tgs.newLine();
    tgs.indent();
    tgs.append("float priority;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} envelope;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("size_t size;");
    tgs.newLine();
    tgs.indent();
    tgs.append("char **strings;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} payload;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("envelope *envelope;");
    tgs.newLine();
    tgs.indent();
    tgs.append("payload *payload;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} message;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("long mtype;");
    tgs.newLine();
    tgs.indent();
    tgs.append("message *msg;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} msgbuf;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("char **strings;");
    tgs.newLine();
    tgs.indent();
    tgs.append("size_t size;");
    tgs.newLine();
    tgs.indent();
    tgs.append("size_t capacity;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} linked_actors;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("char *key;");
    tgs.newLine();
    tgs.indent();
    tgs.append("linked_actors values;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} map_entry;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("map_entry *entries;");
    tgs.newLine();
    tgs.indent();
    tgs.append("size_t size;");
    tgs.newLine();
    tgs.indent();
    tgs.append("size_t capacity;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} topology;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("typedef struct {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("char **strings;");
    tgs.newLine();
    tgs.indent();
    tgs.append("size_t size;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.append("} strings_array;");
    tgs.newLine();
    tgs.newLine();

    tgs.append("pthread_mutex_t topology_mutex;");
    tgs.newLine();
    tgs.append("topology map;");
    tgs.newLine();
    tgs.newLine();


  }
}
