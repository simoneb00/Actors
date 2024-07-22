package ActorLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.core.aspects.behaviour.BaseBehaviorAspectDescriptor;
import jetbrains.mps.core.aspects.behaviour.api.BHDescriptor;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.lang.smodel.ConceptSwitchIndex;
import jetbrains.mps.lang.smodel.ConceptSwitchIndexBuilder;
import jetbrains.mps.smodel.adapter.ids.MetaIdFactory;

public final class BehaviorAspectDescriptor extends BaseBehaviorAspectDescriptor {
  private final BHDescriptor myActorCreation__BehaviorDescriptor = new ActorCreation__BehaviorDescriptor();
  private final BHDescriptor myActorScript__BehaviorDescriptor = new ActorScript__BehaviorDescriptor();
  private final BHDescriptor myCreateActors__BehaviorDescriptor = new CreateActors__BehaviorDescriptor();

  public BehaviorAspectDescriptor() {
  }

  @Nullable
  public BHDescriptor getDescriptor(@NotNull SAbstractConcept concept) {
    SAbstractConcept cncpt = concept;
    switch (conceptIndex.index(cncpt)) {
      case 0:
        return myActorCreation__BehaviorDescriptor;
      case 1:
        return myActorScript__BehaviorDescriptor;
      case 2:
        return myCreateActors__BehaviorDescriptor;
      default:
    }
    return null;
  }
  private static final ConceptSwitchIndex conceptIndex = new ConceptSwitchIndexBuilder().put(MetaIdFactory.conceptId(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x13974e268157ad87L), MetaIdFactory.conceptId(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23376L), MetaIdFactory.conceptId(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x5d890eb3ec029424L)).seal();
}
