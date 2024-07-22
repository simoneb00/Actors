package ActorLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.core.aspects.behaviour.BaseBHDescriptor;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.core.aspects.behaviour.api.SMethod;
import jetbrains.mps.core.aspects.behaviour.SMethodBuilder;
import jetbrains.mps.core.aspects.behaviour.SJavaCompoundTypeImpl;
import jetbrains.mps.core.aspects.behaviour.AccessPrivileges;
import java.util.List;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.core.aspects.behaviour.api.SConstructor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.core.aspects.behaviour.api.BHMethodNotFoundException;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import org.jetbrains.mps.openapi.language.SProperty;
import org.jetbrains.mps.openapi.language.SConcept;

public final class CreateActors__BehaviorDescriptor extends BaseBHDescriptor {
  private static final SAbstractConcept CONCEPT = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, "ActorLanguage.structure.CreateActors");

  public static final SMethod<Void> createActors_idI$NcBTsrE = new SMethodBuilder<Void>(new SJavaCompoundTypeImpl(Void.class)).name("createActors").modifiers(0, AccessPrivileges.PUBLIC).concept(CONCEPT).baseMethodId(13109696850675434L).languageId(0x9416196c5eca1268L, 0x10eda99958984cdeL).build2();

  private static final List<SMethod<?>> BH_METHODS = Arrays.<SMethod<?>>asList(createActors_idI$NcBTsrE);

  private static void ___init___(@NotNull SNode __thisNode__) {
  }

  /*package*/ static void createActors_idI$NcBTsrE(@NotNull SNode __thisNode__) {

    // safety check
    if (SPropertyOperations.getInteger(__thisNode__, PROPS.number$$XD7) == 0 || SPropertyOperations.getString(__thisNode__, PROPS.baseName$$Y79) == null || (SLinkOperations.getTarget(__thisNode__, LINKS.behavior$ew$H) == null)) {
      return;
    }

    // remove, if any, all the previously created actors
    for (SNode actor : ListSequence.fromList(SLinkOperations.getChildren(__thisNode__, LINKS.actors$HQEA))) {
      SNodeOperations.deleteNode(actor);
    }

    for (int i = 0; i < SPropertyOperations.getInteger(__thisNode__, PROPS.number$$XD7); i++) {
      SNode newActor = SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23364L, "ActorLanguage.structure.CreateActor"));
      SPropertyOperations.assign(newActor, PROPS.name$MnvL, SPropertyOperations.getString(__thisNode__, PROPS.baseName$$Y79) + String.valueOf(i));
      SLinkOperations.setTarget(newActor, LINKS.behavior$QgnL, SLinkOperations.getTarget(__thisNode__, LINKS.behavior$ew$H));
      SLinkOperations.setTarget(newActor, LINKS.messageQueue$L0ws, SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x6ac9b580f420bed7L, "ActorLanguage.structure.MessageQueue")));
      SPropertyOperations.assignEnum(newActor, PROPS.fetchPolicy$taMB, SPropertyOperations.getEnum(__thisNode__, PROPS.fetchPolicy$VsGQ));
      SPropertyOperations.assign(newActor, PROPS.address$DqJ_, (int) ActorScript__BehaviorDescriptor.getFreeAddress_id3JP6tIS4aZI.invoke(SNodeOperations.getNodeAncestor(__thisNode__, CONCEPTS.ActorScript$nz, false, false)));
      ListSequence.fromList(SLinkOperations.getChildren(__thisNode__, LINKS.actors$HQEA)).addElement(newActor);
    }
  }

  /*package*/ CreateActors__BehaviorDescriptor() {
  }

  @Override
  protected void initNode(@NotNull SNode node, @NotNull SConstructor constructor, @Nullable Object[] parameters) {
    ___init___(node);
  }

  @Override
  protected <T> T invokeSpecial0(@NotNull SNode node, @NotNull SMethod<T> method, @Nullable Object[] parameters) {
    int methodIndex = BH_METHODS.indexOf(method);
    if (methodIndex < 0) {
      throw new BHMethodNotFoundException(this, method);
    }
    switch (methodIndex) {
      case 0:
        createActors_idI$NcBTsrE(node);
        return null;
      default:
        throw new BHMethodNotFoundException(this, method);
    }
  }

  @Override
  protected <T> T invokeSpecial0(@NotNull SAbstractConcept concept, @NotNull SMethod<T> method, @Nullable Object[] parameters) {
    int methodIndex = BH_METHODS.indexOf(method);
    if (methodIndex < 0) {
      throw new BHMethodNotFoundException(this, method);
    }
    switch (methodIndex) {
      default:
        throw new BHMethodNotFoundException(this, method);
    }
  }

  @NotNull
  @Override
  public List<SMethod<?>> getDeclaredMethods() {
    return BH_METHODS;
  }

  @NotNull
  @Override
  public SAbstractConcept getConcept() {
    return CONCEPT;
  }

  private static final class LINKS {
    /*package*/ static final SReferenceLink behavior$ew$H = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, 0x13974e268151884fL, "behavior");
    /*package*/ static final SContainmentLink actors$HQEA = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, 0x2e933327a36608L, "actors");
    /*package*/ static final SReferenceLink behavior$QgnL = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23364L, 0x13974e2681516c72L, "behavior");
    /*package*/ static final SContainmentLink messageQueue$L0ws = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23364L, 0x5d890eb3ec03cef9L, "messageQueue");
  }

  private static final class PROPS {
    /*package*/ static final SProperty number$$XD7 = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, 0x5d890eb3ec029443L, "number");
    /*package*/ static final SProperty baseName$$Y79 = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, 0x5d890eb3ec029445L, "baseName");
    /*package*/ static final SProperty name$MnvL = MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name");
    /*package*/ static final SProperty fetchPolicy$taMB = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23364L, 0x42ce0f2f39c1b9ccL, "fetchPolicy");
    /*package*/ static final SProperty fetchPolicy$VsGQ = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L, 0x42ce0f2f39c1ba5dL, "fetchPolicy");
    /*package*/ static final SProperty address$DqJ_ = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23364L, 0x13974e2681512c34L, "address");
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept ActorScript$nz = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23376L, "ActorLanguage.structure.ActorScript");
  }
}
