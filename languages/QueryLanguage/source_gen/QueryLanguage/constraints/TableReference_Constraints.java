package QueryLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.Map;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.SNodePointer;
import java.util.HashMap;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class TableReference_Constraints extends BaseConstraintsDescriptor {
  public TableReference_Constraints() {
    super(CONCEPTS.TableReference$DN);
  }

  @Override
  protected Map<SReferenceLink, ReferenceConstraintsDescriptor> getSpecifiedReferences() {
    BaseReferenceConstraintsDescriptor d0 = new BaseReferenceConstraintsDescriptor(LINKS.tableRef$boeY, this, true, false) {
      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return ReferenceScopeProvider.fromHierarchy(CONCEPTS.CreateTable$ca, new SNodePointer("r:7edf4f40-f81a-49df-87e2-b00351b83558(QueryLanguage.constraints)", "4258597989027530045"));
      }
    };
    Map<SReferenceLink, ReferenceConstraintsDescriptor> references = new HashMap<SReferenceLink, ReferenceConstraintsDescriptor>();
    references.put(d0.getReference(), d0);
    return references;
  }

  private static final class CONCEPTS {
    /*package*/ static final SConcept TableReference$DN = MetaAdapterFactory.getConcept(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x207f13a8b545f6deL, "QueryLanguage.structure.TableReference");
    /*package*/ static final SConcept CreateTable$ca = MetaAdapterFactory.getConcept(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b2eL, "QueryLanguage.structure.CreateTable");
  }

  private static final class LINKS {
    /*package*/ static final SReferenceLink tableRef$boeY = MetaAdapterFactory.getReferenceLink(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x207f13a8b545f6deL, 0x207f13a8b545f6dfL, "tableRef");
  }
}
