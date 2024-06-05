package QueryLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BaseStructureAspectDescriptor;
import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import jetbrains.mps.smodel.runtime.EnumerationDescriptor;
import java.util.Collection;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.adapter.ids.SConceptId;
import jetbrains.mps.smodel.runtime.DataTypeDescriptor;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.smodel.runtime.impl.ConceptDescriptorBuilder2;
import jetbrains.mps.smodel.adapter.ids.MetaIdFactory;
import jetbrains.mps.smodel.adapter.ids.PrimitiveTypeId;

public class StructureAspectDescriptor extends BaseStructureAspectDescriptor {
  /*package*/ final ConceptDescriptor myConceptAggregateFunction = createDescriptorForAggregateFunction();
  /*package*/ final ConceptDescriptor myConceptAverage = createDescriptorForAverage();
  /*package*/ final ConceptDescriptor myConceptColumn = createDescriptorForColumn();
  /*package*/ final ConceptDescriptor myConceptColumnRef = createDescriptorForColumnRef();
  /*package*/ final ConceptDescriptor myConceptCondition = createDescriptorForCondition();
  /*package*/ final ConceptDescriptor myConceptConditionSet = createDescriptorForConditionSet();
  /*package*/ final ConceptDescriptor myConceptConditionsSequence = createDescriptorForConditionsSequence();
  /*package*/ final ConceptDescriptor myConceptCount = createDescriptorForCount();
  /*package*/ final ConceptDescriptor myConceptCreateTable = createDescriptorForCreateTable();
  /*package*/ final ConceptDescriptor myConceptDBOperation = createDescriptorForDBOperation();
  /*package*/ final ConceptDescriptor myConceptDelete = createDescriptorForDelete();
  /*package*/ final ConceptDescriptor myConceptGroupBy = createDescriptorForGroupBy();
  /*package*/ final ConceptDescriptor myConceptInsertInto = createDescriptorForInsertInto();
  /*package*/ final ConceptDescriptor myConceptMax = createDescriptorForMax();
  /*package*/ final ConceptDescriptor myConceptMin = createDescriptorForMin();
  /*package*/ final ConceptDescriptor myConceptMultipleCondition = createDescriptorForMultipleCondition();
  /*package*/ final ConceptDescriptor myConceptOldCondition = createDescriptorForOldCondition();
  /*package*/ final ConceptDescriptor myConceptOrderBy = createDescriptorForOrderBy();
  /*package*/ final ConceptDescriptor myConceptScript = createDescriptorForScript();
  /*package*/ final ConceptDescriptor myConceptSelect = createDescriptorForSelect();
  /*package*/ final ConceptDescriptor myConceptSimpleCondition = createDescriptorForSimpleCondition();
  /*package*/ final ConceptDescriptor myConceptStatement = createDescriptorForStatement();
  /*package*/ final ConceptDescriptor myConceptSum = createDescriptorForSum();
  /*package*/ final ConceptDescriptor myConceptTableReference = createDescriptorForTableReference();
  /*package*/ final ConceptDescriptor myConceptUpdate = createDescriptorForUpdate();
  /*package*/ final ConceptDescriptor myConceptValue = createDescriptorForValue();
  /*package*/ final ConceptDescriptor myConceptWhere = createDescriptorForWhere();
  /*package*/ final EnumerationDescriptor myEnumerationAggregateFunctionTypes = new EnumerationDescriptor_AggregateFunctionTypes();
  /*package*/ final EnumerationDescriptor myEnumerationConditionOperator = new EnumerationDescriptor_ConditionOperator();
  /*package*/ final EnumerationDescriptor myEnumerationOperator = new EnumerationDescriptor_Operator();
  /*package*/ final EnumerationDescriptor myEnumerationType = new EnumerationDescriptor_Type();
  private final LanguageConceptSwitch myIndexSwitch;

  public StructureAspectDescriptor() {
    myIndexSwitch = new LanguageConceptSwitch();
  }


  @Override
  public void reportDependencies(jetbrains.mps.smodel.runtime.StructureAspectDescriptor.Dependencies deps) {
    deps.extendedLanguage(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, "jetbrains.mps.lang.core");
  }

  @Override
  public Collection<ConceptDescriptor> getDescriptors() {
    return Arrays.asList(myConceptAggregateFunction, myConceptAverage, myConceptColumn, myConceptColumnRef, myConceptCondition, myConceptConditionSet, myConceptConditionsSequence, myConceptCount, myConceptCreateTable, myConceptDBOperation, myConceptDelete, myConceptGroupBy, myConceptInsertInto, myConceptMax, myConceptMin, myConceptMultipleCondition, myConceptOldCondition, myConceptOrderBy, myConceptScript, myConceptSelect, myConceptSimpleCondition, myConceptStatement, myConceptSum, myConceptTableReference, myConceptUpdate, myConceptValue, myConceptWhere);
  }

  @Override
  @Nullable
  public ConceptDescriptor getDescriptor(SConceptId id) {
    switch (myIndexSwitch.index(id)) {
      case LanguageConceptSwitch.AggregateFunction:
        return myConceptAggregateFunction;
      case LanguageConceptSwitch.Average:
        return myConceptAverage;
      case LanguageConceptSwitch.Column:
        return myConceptColumn;
      case LanguageConceptSwitch.ColumnRef:
        return myConceptColumnRef;
      case LanguageConceptSwitch.Condition:
        return myConceptCondition;
      case LanguageConceptSwitch.ConditionSet:
        return myConceptConditionSet;
      case LanguageConceptSwitch.ConditionsSequence:
        return myConceptConditionsSequence;
      case LanguageConceptSwitch.Count:
        return myConceptCount;
      case LanguageConceptSwitch.CreateTable:
        return myConceptCreateTable;
      case LanguageConceptSwitch.DBOperation:
        return myConceptDBOperation;
      case LanguageConceptSwitch.Delete:
        return myConceptDelete;
      case LanguageConceptSwitch.GroupBy:
        return myConceptGroupBy;
      case LanguageConceptSwitch.InsertInto:
        return myConceptInsertInto;
      case LanguageConceptSwitch.Max:
        return myConceptMax;
      case LanguageConceptSwitch.Min:
        return myConceptMin;
      case LanguageConceptSwitch.MultipleCondition:
        return myConceptMultipleCondition;
      case LanguageConceptSwitch.OldCondition:
        return myConceptOldCondition;
      case LanguageConceptSwitch.OrderBy:
        return myConceptOrderBy;
      case LanguageConceptSwitch.Script:
        return myConceptScript;
      case LanguageConceptSwitch.Select:
        return myConceptSelect;
      case LanguageConceptSwitch.SimpleCondition:
        return myConceptSimpleCondition;
      case LanguageConceptSwitch.Statement:
        return myConceptStatement;
      case LanguageConceptSwitch.Sum:
        return myConceptSum;
      case LanguageConceptSwitch.TableReference:
        return myConceptTableReference;
      case LanguageConceptSwitch.Update:
        return myConceptUpdate;
      case LanguageConceptSwitch.Value:
        return myConceptValue;
      case LanguageConceptSwitch.Where:
        return myConceptWhere;
      default:
        return null;
    }
  }

  @Override
  public Collection<DataTypeDescriptor> getDataTypeDescriptors() {
    return Arrays.asList(myEnumerationAggregateFunctionTypes, myEnumerationConditionOperator, myEnumerationOperator, myEnumerationType);
  }

  /*package*/ int internalIndex(SAbstractConcept c) {
    return myIndexSwitch.index(c);
  }

  private static ConceptDescriptor createDescriptorForAggregateFunction() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "AggregateFunction", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.interface_();
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599607924");
    b.version(3);
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForAverage() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Average", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b028394L);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599629716");
    b.version(3);
    b.alias("AVG");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForColumn() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Column", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b33L);
    b.class_(false, false, false);
    b.parent(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084499598131");
    b.version(3);
    b.property("type", 0x11100ee737443b37L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b39L)).origin("1229499084499598135").done();
    b.property("fullName", 0x207f13a8b5691efbL).type(PrimitiveTypeId.STRING).origin("2341611946574946043").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForColumnRef() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "ColumnRef", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084500457460");
    b.version(3);
    b.associate("column", 0x11100ee7375157f5L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b33L).optional(false).origin("1229499084500457461").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForCondition() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Condition", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L);
    b.interface_();
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6839590609873398295");
    b.version(3);
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForConditionSet() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "ConditionSet", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb86c06cL);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/2582920951876730988");
    b.version(3);
    b.aggregate("conditions", 0x23d860ebbb86c06dL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb7c2695L).optional(false).ordered(true).multiple(true).origin("2582920951876730989").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForConditionsSequence() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "ConditionsSequence", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb7c2695L);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/2582920951876036245");
    b.version(3);
    b.property("conditionOperator", 0x23d860ebbb86c0b3L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb7c269aL)).origin("2582920951876731059").done();
    b.aggregate("conditions", 0x23d860ebbb7c26b9L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737470ff3L).optional(false).ordered(true).multiple(true).origin("2582920951876036281").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForCount() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Count", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b028392L);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599629714");
    b.version(3);
    b.alias("COUNT");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForCreateTable() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "CreateTable", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b2eL);
    b.class_(false, false, false);
    b.parent(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084499598126");
    b.version(3);
    b.aggregate("columns", 0x75900635108ee054L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b33L).optional(true).ordered(true).multiple(true).origin("8471277724064735316").done();
    b.alias("CREATE TABLE");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForDBOperation() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "DBOperation", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.interface_();
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/3100867722287075684");
    b.version(3);
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForDelete() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Delete", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa642699L);
    b.class_(false, false, false);
    // extends: QueryLanguage.structure.Statement
    b.super_(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/3100867722286999193");
    b.version(3);
    b.aggregate("where", 0x2b087ec3aa64269bL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x619ceb902420e37bL).optional(true).ordered(true).multiple(false).origin("3100867722286999195").done();
    b.alias("DELETE");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForGroupBy() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "GroupBy", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa6a16ceL);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/3100867722287388366");
    b.version(3);
    b.aggregate("columns", 0x2b087ec3aa6a1759L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L).optional(false).ordered(true).multiple(true).origin("3100867722287388505").done();
    b.alias("GROUP BY");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForInsertInto() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "InsertInto", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1c72c8L);
    b.class_(false, false, false);
    // extends: QueryLanguage.structure.Statement
    b.super_(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/7087042522255225544");
    b.version(3);
    b.aggregate("values", 0x625a3ba00f1cc8a3L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1cc88bL).optional(true).ordered(true).multiple(true).origin("7087042522255247523").done();
    b.alias("INSERT INTO");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForMax() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Max", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b028390L);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599629712");
    b.version(3);
    b.alias("MAX");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForMin() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Min", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b02838dL);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599629709");
    b.version(3);
    b.alias("MIN");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForMultipleCondition() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "MultipleCondition", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea1bL);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6839590609873398299");
    b.version(3);
    b.property("operator", 0x5eeb1b6c0699ea20L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb7c269aL)).origin("6839590609873398304").done();
    b.aggregate("conditionDx", 0x5eeb1b6c0699ea4dL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L).optional(false).ordered(true).multiple(false).origin("6839590609873398349").done();
    b.aggregate("conditionSx", 0x5eeb1b6c0699ea59L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L).optional(false).ordered(true).multiple(false).origin("6839590609873398361").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForOldCondition() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "OldCondition", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737470ff3L);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084499783667");
    b.version(3);
    b.property("operator", 0x11100ee737471046L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737470ff9L)).origin("1229499084499783750").done();
    b.property("conditionOperator", 0x269884dd81b2ce21L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x23d860ebbb7c269aL)).origin("2781118856799899169").done();
    b.aggregate("value", 0x625a3ba00f1cc8a8L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1cc88bL).optional(false).ordered(true).multiple(false).origin("7087042522255247528").done();
    b.aggregate("column", 0x207f13a8b5c31a63L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L).optional(false).ordered(true).multiple(false).origin("2341611946580843107").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForOrderBy() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "OrderBy", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa61e251L);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/3100867722286850641");
    b.version(3);
    b.aggregate("columns", 0x2b087ec3aa6a16cfL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L).optional(false).ordered(true).multiple(true).origin("3100867722287388367").done();
    b.alias("ORDER BY");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForScript() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Script", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443bcdL);
    b.class_(false, false, true);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084499598285");
    b.version(3);
    b.aggregate("operations", 0x2b087ec3aa655166L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L).optional(true).ordered(true).multiple(true).origin("3100867722287075686").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForSelect() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Select", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x619ceb902420e379L);
    b.class_(false, false, false);
    // extends: QueryLanguage.structure.Statement
    b.super_(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.parent(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x33d23ee961a0cbf3L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/7033755722359825273");
    b.version(3);
    b.property("tableAlias", 0x7642dbf63a87dc6eL).type(PrimitiveTypeId.STRING).origin("8521615295528819822").done();
    b.aggregate("where", 0x11100ee73745172dL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x619ceb902420e37bL).optional(true).ordered(true).multiple(false).origin("1229499084499654445").done();
    b.aggregate("groupBy", 0x2b087ec3aa6a1779L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa6a16ceL).optional(true).ordered(true).multiple(false).origin("3100867722287388537").done();
    b.aggregate("orderBy", 0x2b087ec3aa61e429L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa61e251L).optional(true).ordered(true).multiple(false).origin("3100867722286851113").done();
    b.aggregate("aggregateFunction", 0x5d7e70837b028396L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L).optional(true).ordered(true).multiple(false).origin("6736945802599629718").done();
    b.aggregate("tables", 0x207f13a8b54616bfL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x207f13a8b545f6deL).optional(false).ordered(true).multiple(true).origin("2341611946572650175").done();
    b.alias("SELECT");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForSimpleCondition() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "SimpleCondition", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea18L);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6839590609873398296");
    b.version(3);
    b.property("operator", 0x5eeb1b6c0699ea24L).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737470ff9L)).origin("6839590609873398308").done();
    b.aggregate("value", 0x5eeb1b6c0699ea26L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1cc88bL).optional(false).ordered(true).multiple(false).origin("6839590609873398310").done();
    b.aggregate("column", 0x5eeb1b6c0699ea2bL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L).optional(false).ordered(true).multiple(false).origin("6839590609873398315").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForStatement() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Statement", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L);
    b.class_(false, true, false);
    b.parent(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x33d23ee961a0cbf3L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/1229499084499598128");
    b.version(3);
    b.associate("table", 0x207f13a8b5460e46L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b2eL).optional(true).origin("2341611946572648006").done();
    b.aggregate("columns", 0x75900635108a5f3bL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee7375157f4L).optional(true).ordered(true).multiple(true).origin("8471277724064440123").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForSum() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Sum", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b028393L);
    b.class_(false, false, false);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5d7e70837b022e74L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/6736945802599629715");
    b.version(3);
    b.alias("SUM");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForTableReference() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "TableReference", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x207f13a8b545f6deL);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/2341611946572642014");
    b.version(3);
    b.associate("tableRef", 0x207f13a8b545f6dfL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b2eL).optional(false).origin("2341611946572642015").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForUpdate() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Update", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f23853fL);
    b.class_(false, false, false);
    // extends: QueryLanguage.structure.Statement
    b.super_(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b30L);
    b.parent(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x2b087ec3aa655164L);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/7087042522255689023");
    b.version(3);
    b.aggregate("where", 0x625a3ba00f238543L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x619ceb902420e37bL).optional(false).ordered(true).multiple(false).origin("7087042522255689027").done();
    b.aggregate("values", 0x625a3ba00f23854bL).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1cc88bL).optional(true).ordered(true).multiple(true).origin("7087042522255689035").done();
    b.alias("UPDATE");
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForValue() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Value", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x625a3ba00f1cc88bL);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/7087042522255247499");
    b.version(3);
    b.property("type", 0x625a3ba00f1cc88cL).type(MetaIdFactory.dataTypeId(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x11100ee737443b39L)).origin("7087042522255247500").done();
    b.property("value", 0x625a3ba00f1cc88eL).type(PrimitiveTypeId.STRING).origin("7087042522255247502").done();
    return b.create();
  }
  private static ConceptDescriptor createDescriptorForWhere() {
    ConceptDescriptorBuilder2 b = new ConceptDescriptorBuilder2("QueryLanguage", "Where", 0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x619ceb902420e37bL);
    b.class_(false, false, false);
    b.origin("r:e2175f5d-85fc-4bdd-8ae1-8b72b7f266cc(QueryLanguage.structure)/7033755722359825275");
    b.version(3);
    b.aggregate("condition", 0x11100ee7374a23b4L).target(0x26d1395b1ee643adL, 0xb522c0cdd699ded3L, 0x5eeb1b6c0699ea17L).optional(true).ordered(true).multiple(false).origin("1229499084499985332").done();
    b.alias("WHERE");
    return b.create();
  }
}
