package ActorLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenDescriptorBase;
import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;

public class Receptionist_TextGen extends TextGenDescriptorBase {
  @Override
  public void generateText(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);
    tgs.append("void *receptionist(void *arg) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("int ret, has_links;");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgbuf rec_buf;");
    tgs.newLine();
    tgs.indent();
    tgs.append("payload *p;");
    tgs.newLine();
    tgs.indent();
    tgs.append("envelope *env;");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgbuf send_buf;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("topology *map = (topology *)arg;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("while(1) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("has_links = 0;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("ret = msgrcv(get_mqid(\"receptionist\"), (void *)&rec_buf, sizeof(rec_buf.msg), 2, 0);");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (ret == -1) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("perror(\"msgrcv\");");
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
    tgs.append("env = create_envelope(\"receptionist\", rec_buf.msg->envelope->sender, 0.0);");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("for (size_t i = 0; i < map->size; i++) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!strcmp(rec_buf.msg->envelope->sender, map->entries[i].key)) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("has_links = 1;");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("char **strings = malloc(map->entries[i].values.size * sizeof(char *));");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (!strings) {");
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
    tgs.append("for (size_t j = 0; j < map->entries[i].values.size; j++) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("strings[j] = map->entries[i].values.strings[j];");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("p = create_payload(strings, map->entries[i].values.size);");
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
    tgs.append("if (!has_links) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("printf(\"[RECEPTIONIST] the requesting actor %s does not have outcoming links\", rec_buf.msg->envelope->sender);");
    tgs.newLine();
    tgs.indent();
    tgs.append("puts(\"\");");
    tgs.newLine();
    tgs.indent();
    tgs.append("char *text = \"No linked actors\";");
    tgs.newLine();
    tgs.indent();
    tgs.append("p = create_payload(&text, -1);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("send_buf = create_message(env, p, 2);");
    tgs.newLine();
    tgs.indent();
    tgs.append("msgsnd(get_mqid(env->receiver), (void *)&send_buf, sizeof(send_buf.msg), 0);");
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
