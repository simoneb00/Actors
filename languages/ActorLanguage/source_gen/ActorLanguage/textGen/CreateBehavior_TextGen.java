package ActorLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenDescriptorBase;
import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SConcept;
import org.jetbrains.mps.openapi.language.SContainmentLink;

public class CreateBehavior_TextGen extends TextGenDescriptorBase {
  @Override
  public void generateText(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);
    tgs.append("void ");
    tgs.append(SPropertyOperations.getString(ctx.getPrimaryInput(), PROPS.name$MnvL));
    tgs.append("(char *name) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("int ret;");
    tgs.newLine();
    if (ListSequence.fromList(SNodeOperations.getNodeDescendants(ctx.getPrimaryInput(), CONCEPTS.CreateMessage$aX, false, new SAbstractConcept[]{})).isNotEmpty()) {
      tgs.indent();
      tgs.append("msgbuf send_buf;");
      tgs.newLine();
    }
    tgs.newLine();
    // for

    // free allocated memory

    for (SNode getActorAction : ListSequence.fromList(SNodeOperations.getNodeDescendants(ctx.getPrimaryInput(), CONCEPTS.GetActorsFromReceptionist$XR, false, new SAbstractConcept[]{}))) {
      tgs.indent();
      tgs.append("for(int i = 0; i < ");
      tgs.append(SPropertyOperations.getString(SLinkOperations.getTarget(getActorAction, LINKS.actorReferences$8P4C), PROPS.name$MnvL));
      tgs.append("->size; i++) {");
      tgs.newLine();
      ctx.getBuffer().area().increaseIndent();
      tgs.indent();
      tgs.append("free(");
      tgs.append(SPropertyOperations.getString(SLinkOperations.getTarget(getActorAction, LINKS.actorReferences$8P4C), PROPS.name$MnvL));
      tgs.append("->strings[i]);");
      tgs.newLine();
      ctx.getBuffer().area().decreaseIndent();
      tgs.indent();
      tgs.append("}");
      tgs.newLine();
      tgs.indent();
      tgs.append("free(");
      tgs.append(SPropertyOperations.getString(SLinkOperations.getTarget(getActorAction, LINKS.actorReferences$8P4C), PROPS.name$MnvL));
      tgs.append("->strings);");
      tgs.newLine();
      tgs.indent();
      tgs.append("free(");
      tgs.append(SPropertyOperations.getString(SLinkOperations.getTarget(getActorAction, LINKS.actorReferences$8P4C), PROPS.name$MnvL));
      tgs.append(");");
      tgs.newLine();
      tgs.newLine();
    }


    tgs.indent();
    tgs.append("return 0;");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().decreaseIndent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();
  }

  private static final class PROPS {
    /*package*/ static final SProperty name$MnvL = MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name");
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept CreateMessage$aX = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23371L, "ActorLanguage.structure.CreateMessage");
    /*package*/ static final SConcept GetActorsFromReceptionist$XR = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x13974e2681690352L, "ActorLanguage.structure.GetActorsFromReceptionist");
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink actions$MLkf = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe5743ae753L, 0x35a5eccbf2f8e453L, "actions");
    /*package*/ static final SContainmentLink actorReferences$8P4C = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x13974e2681690352L, 0x2e933327505d87L, "actorReferences");
  }
}
