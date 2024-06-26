package ActorLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.Map;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseScopeProvider;
import org.jetbrains.mps.openapi.model.SNodeReference;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.scope.ListScope;
import java.util.HashMap;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class ForEachActorReferenceStatement_Constraints extends BaseConstraintsDescriptor {
  public ForEachActorReferenceStatement_Constraints() {
    super(CONCEPTS.ForEachActorReferenceStatement$Jq);
  }

  @Override
  protected Map<SReferenceLink, ReferenceConstraintsDescriptor> getSpecifiedReferences() {
    BaseReferenceConstraintsDescriptor d0 = new BaseReferenceConstraintsDescriptor(LINKS.actorReferenceList$RLVE, this, true, false) {
      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseScopeProvider() {
          @Override
          public SNodeReference getSearchScopeValidatorNode() {
            return new SNodePointer("r:ae140228-36a4-4270-a859-e66d990ac219(ActorLanguage.constraints)", "6009747775866145823");
          }
          @Override
          public Scope createScope(final ReferenceConstraintsContext _context) {
            final Iterable<SNode> list = SNodeOperations.getNodeDescendants(SNodeOperations.getNodeAncestor(_context.getReferenceNode(), CONCEPTS.CreateBehavior$iN, false, false), CONCEPTS.ActorReferenceList$4g, false, new SAbstractConcept[]{});
            return ListScope.forNamedElements(list);
          }
        };
      }
    };
    Map<SReferenceLink, ReferenceConstraintsDescriptor> references = new HashMap<SReferenceLink, ReferenceConstraintsDescriptor>();
    references.put(d0.getReference(), d0);
    return references;
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept ForEachActorReferenceStatement$Jq = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x401c50b1e5dbf567L, "ActorLanguage.structure.ForEachActorReferenceStatement");
    /*package*/ static final SConcept CreateBehavior$iN = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe5743ae753L, "ActorLanguage.structure.CreateBehavior");
    /*package*/ static final SConcept ActorReferenceList$4g = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x401c50b1e5ba7cb3L, "ActorLanguage.structure.ActorReferenceList");
  }

  private static final class LINKS {
    /*package*/ static final SReferenceLink actorReferenceList$RLVE = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x401c50b1e5dbf567L, 0x401c50b1e5dbf568L, "actorReferenceList");
  }
}
