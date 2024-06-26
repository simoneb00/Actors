package QueryLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SConcept;

public class check_InsertInto_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_InsertInto_NonTypesystemRule() {
  }
  public void applyRule(final SNode insertInto, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (ListSequence.fromList(SLinkOperations.getChildren(insertInto, LINKS.columns$5QXT)).count() != ListSequence.fromList(SLinkOperations.getChildren(insertInto, LINKS.values$mxTu)).count()) {
      {
        final MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(insertInto, "Exactly one value per selected column must be specified", "r:c16b6385-a54f-425c-958c-759f07935c87(QueryLanguage.typesystem)", "2582920951874809118", null, errorTarget);
      }
    }
  }
  public SAbstractConcept getApplicableConcept() {
    return CONCEPTS.InsertInto$mc;
  }
  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    return new IsApplicableStatus(argument.getConcept().isSubConceptOf(getApplicableConcept()), null);
  }
  public boolean overrides() {
    return false;
  }

  private static final class LINKS {
    /*package*/ static final SContainmentLink values$mxTu = MetaAdapterFactory.getContainmentLink(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1c72c8L, 0x625a3ba00f1cc8a3L, "values");
    /*package*/ static final SContainmentLink columns$5QXT = MetaAdapterFactory.getContainmentLink(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L, 0x75900635108a5f3bL, "columns");
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept InsertInto$mc = MetaAdapterFactory.getConcept(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1c72c8L, "QueryLanguage.structure.InsertInto");
  }
}
