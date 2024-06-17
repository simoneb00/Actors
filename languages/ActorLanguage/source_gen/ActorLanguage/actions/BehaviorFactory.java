package ActorLanguage.actions;

/*Generated by MPS */

import jetbrains.mps.openapi.actions.descriptor.NodeFactory;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SConcept;

public class BehaviorFactory {
  public static class NodeFactory_4813801747211756767 implements NodeFactory {
    public void setup(SNode newNode, SNode sampleNode, SNode enclosingNode, int index, SModel model) {
      ListSequence.fromList(SLinkOperations.getChildren(newNode, LINKS.actions$MLkf)).addElement(SNodeFactoryOperations.createNewNode(CONCEPTS.Fetch$Nj, null));
    }
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink actions$MLkf = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe5743ae753L, 0x35a5eccbf2f8e453L, "actions");
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept Fetch$Nj = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x619ceb90241d8975L, "ActorLanguage.structure.Fetch");
  }
}