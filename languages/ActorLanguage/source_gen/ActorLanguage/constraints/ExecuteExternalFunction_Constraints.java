package ActorLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Map;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.scope.ListScope;
import org.jetbrains.mps.openapi.language.SConcept;
import org.jetbrains.mps.openapi.language.SContainmentLink;

public class ExecuteExternalFunction_Constraints extends BaseConstraintsDescriptor {
  public ExecuteExternalFunction_Constraints() {
    super(CONCEPTS.ExecuteExternalFunction$6o);
  }

  public static class ResultName_Property extends BasePropertyConstraintsDescriptor {
    public ResultName_Property(ConstraintsDescriptor container) {
      super(PROPS.resultName$LVZv, container, false, true, false);
    }
    @Override
    public void setPropertyValue(SNode node, Object propertyValue) {
      staticSetPropertyValue(node, SPropertyOperations.castString(propertyValue));
    }
    private static void staticSetPropertyValue(SNode node, String propertyValue) {
      SPropertyOperations.assign(node, PROPS.resultName$LVZv, propertyValue);
      SNode payload = SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe574366688L, "ActorLanguage.structure.CreatePayload"));
      SPropertyOperations.assign(payload, PROPS.name$MnvL, propertyValue);
      SLinkOperations.setTarget(node, LINKS.result$LWVz, payload);
    }
  }
  @Override
  protected Map<SProperty, PropertyConstraintsDescriptor> getSpecifiedProperties() {
    Map<SProperty, PropertyConstraintsDescriptor> properties = new HashMap<SProperty, PropertyConstraintsDescriptor>();
    properties.put(PROPS.resultName$LVZv, new ResultName_Property(this));
    return properties;
  }
  @Override
  protected Map<SReferenceLink, ReferenceConstraintsDescriptor> getSpecifiedReferences() {
    BaseReferenceConstraintsDescriptor d0 = new BaseReferenceConstraintsDescriptor(LINKS.message$nfgc, this, true, false) {
      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseScopeProvider() {
          @Override
          public SNodeReference getSearchScopeValidatorNode() {
            return new SNodePointer("r:ae140228-36a4-4270-a859-e66d990ac219(ActorLanguage.constraints)", "7051067309803753061");
          }
          @Override
          public Scope createScope(final ReferenceConstraintsContext _context) {
            final Iterable<SNode> messages = SNodeOperations.getNodeDescendants(SNodeOperations.getNodeAncestor(_context.getReferenceNode(), CONCEPTS.CreateBehavior$iN, false, false), CONCEPTS.CreateMessage$aX, false, new SAbstractConcept[]{});
            return ListScope.forNamedElements(messages);
          }
        };
      }
    };
    BaseReferenceConstraintsDescriptor d1 = new BaseReferenceConstraintsDescriptor(LINKS.resultType$kuHm, this, false, true) {
      @Override
      public boolean validate(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode) {
        return true;
      }
      @Override
      public void onReferenceSet(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode) {
        SLinkOperations.setTarget(referenceNode, LINKS.resultType$kuHm, newReferentNode);
        SLinkOperations.setTarget(SLinkOperations.getTarget(referenceNode, LINKS.result$LWVz), LINKS.type$1_kc, newReferentNode);
      }
    };
    Map<SReferenceLink, ReferenceConstraintsDescriptor> references = new HashMap<SReferenceLink, ReferenceConstraintsDescriptor>();
    references.put(d0.getReference(), d0);
    references.put(d1.getReference(), d1);
    return references;
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept ExecuteExternalFunction$6o = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x61da6c5c302ab0f2L, "ActorLanguage.structure.ExecuteExternalFunction");
    /*package*/ static final SConcept CreateBehavior$iN = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe5743ae753L, "ActorLanguage.structure.CreateBehavior");
    /*package*/ static final SConcept CreateMessage$aX = MetaAdapterFactory.getConcept(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x35a5eccbf2f23371L, "ActorLanguage.structure.CreateMessage");
  }

  private static final class PROPS {
    /*package*/ static final SProperty resultName$LVZv = MetaAdapterFactory.getProperty(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x61da6c5c302ab0f2L, 0x338e7da8a4f37b27L, "resultName");
    /*package*/ static final SProperty name$MnvL = MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name");
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink result$LWVz = MetaAdapterFactory.getContainmentLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x61da6c5c302ab0f2L, 0x338e7da8a4f37b2bL, "result");
    /*package*/ static final SReferenceLink message$nfgc = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x61da6c5c302ab0f2L, 0x61da6c5c3038cdbaL, "message");
    /*package*/ static final SReferenceLink resultType$kuHm = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x61da6c5c302ab0f2L, 0x754f4cb23a3092feL, "resultType");
    /*package*/ static final SReferenceLink type$1_kc = MetaAdapterFactory.getReferenceLink(0x10eda99958984cdeL, 0x9416196c5eca1268L, 0x2176abe574366688L, 0x5fab333ad8631dc8L, "type");
  }
}
