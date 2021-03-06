/*
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.serializer;

import com.google.inject.Inject;
import dk.sdu.mmmi.mdsd.math.Div;
import dk.sdu.mmmi.mdsd.math.Let;
import dk.sdu.mmmi.mdsd.math.MathExp;
import dk.sdu.mmmi.mdsd.math.MathPackage;
import dk.sdu.mmmi.mdsd.math.Minus;
import dk.sdu.mmmi.mdsd.math.Mult;
import dk.sdu.mmmi.mdsd.math.Origen;
import dk.sdu.mmmi.mdsd.math.Parenthesis;
import dk.sdu.mmmi.mdsd.math.Plus;
import dk.sdu.mmmi.mdsd.math.VariableUse;
import dk.sdu.mmmi.mdsd.services.MathGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MathSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MathGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MathPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MathPackage.DIV:
				sequence_Exp2(context, (Div) semanticObject); 
				return; 
			case MathPackage.LET:
				sequence_Let(context, (Let) semanticObject); 
				return; 
			case MathPackage.MATH_EXP:
				sequence_MathExp(context, (MathExp) semanticObject); 
				return; 
			case MathPackage.MINUS:
				sequence_Exp1(context, (Minus) semanticObject); 
				return; 
			case MathPackage.MULT:
				sequence_Exp2(context, (Mult) semanticObject); 
				return; 
			case MathPackage.NUMBER:
				sequence_Number(context, (dk.sdu.mmmi.mdsd.math.Number) semanticObject); 
				return; 
			case MathPackage.ORIGEN:
				sequence_Origen(context, (Origen) semanticObject); 
				return; 
			case MathPackage.PARENTHESIS:
				sequence_Parenthesis(context, (Parenthesis) semanticObject); 
				return; 
			case MathPackage.PLUS:
				sequence_Exp1(context, (Plus) semanticObject); 
				return; 
			case MathPackage.VARIABLE_USE:
				sequence_VariableUse(context, (VariableUse) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Exp returns Minus
	 *     Exp1 returns Minus
	 *     Exp1.Plus_1_0_0 returns Minus
	 *     Exp1.Minus_1_1_0 returns Minus
	 *
	 * Constraint:
	 *     (left=Exp1_Minus_1_1_0 right=Exp2)
	 */
	protected void sequence_Exp1(ISerializationContext context, Minus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MINUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MINUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExp1Access().getMinusLeftAction_1_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Plus
	 *     Exp1 returns Plus
	 *     Exp1.Plus_1_0_0 returns Plus
	 *     Exp1.Minus_1_1_0 returns Plus
	 *
	 * Constraint:
	 *     (left=Exp1_Plus_1_0_0 right=Exp2)
	 */
	protected void sequence_Exp1(ISerializationContext context, Plus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PLUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExp1Access().getPlusLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_0_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Div
	 *     Exp1 returns Div
	 *     Exp1.Plus_1_0_0 returns Div
	 *     Exp1.Minus_1_1_0 returns Div
	 *     Exp2 returns Div
	 *     Exp2.Mult_1_0_0 returns Div
	 *     Exp2.Div_1_1_0 returns Div
	 *
	 * Constraint:
	 *     (left=Exp2_Div_1_1_0 right=Primary)
	 */
	protected void sequence_Exp2(ISerializationContext context, Div semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIV__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIV__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.DIV__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.DIV__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExp2Access().getDivLeftAction_1_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Mult
	 *     Exp1 returns Mult
	 *     Exp1.Plus_1_0_0 returns Mult
	 *     Exp1.Minus_1_1_0 returns Mult
	 *     Exp2 returns Mult
	 *     Exp2.Mult_1_0_0 returns Mult
	 *     Exp2.Div_1_1_0 returns Mult
	 *
	 * Constraint:
	 *     (left=Exp2_Mult_1_0_0 right=Primary)
	 */
	protected void sequence_Exp2(ISerializationContext context, Mult semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULT__LEFT));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MULT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MULT__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExp2Access().getMultLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_0_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Let
	 *     Exp1 returns Let
	 *     Exp1.Plus_1_0_0 returns Let
	 *     Exp1.Minus_1_1_0 returns Let
	 *     Exp2 returns Let
	 *     Exp2.Mult_1_0_0 returns Let
	 *     Exp2.Div_1_1_0 returns Let
	 *     Primary returns Let
	 *     Let returns Let
	 *     Math returns Let
	 *
	 * Constraint:
	 *     (name=ID val=Exp exp=Exp)
	 */
	protected void sequence_Let(ISerializationContext context, Let semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATH__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATH__NAME));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.LET__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.LET__VAL));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATH__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATH__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLetAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLetAccess().getValExpParserRuleCall_3_0(), semanticObject.getVal());
		feeder.accept(grammarAccess.getLetAccess().getExpExpParserRuleCall_5_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MathExp returns MathExp
	 *     Math returns MathExp
	 *
	 * Constraint:
	 *     (name=ID exp=Exp)
	 */
	protected void sequence_MathExp(ISerializationContext context, MathExp semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATH__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATH__NAME));
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.MATH__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.MATH__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMathExpAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getMathExpAccess().getExpExpParserRuleCall_3_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Number
	 *     Exp1 returns Number
	 *     Exp1.Plus_1_0_0 returns Number
	 *     Exp1.Minus_1_1_0 returns Number
	 *     Exp2 returns Number
	 *     Exp2.Mult_1_0_0 returns Number
	 *     Exp2.Div_1_1_0 returns Number
	 *     Primary returns Number
	 *     Number returns Number
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Number(ISerializationContext context, dk.sdu.mmmi.mdsd.math.Number semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.NUMBER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.NUMBER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNumberAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Origen returns Origen
	 *
	 * Constraint:
	 *     x+=MathExp+
	 */
	protected void sequence_Origen(ISerializationContext context, Origen semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns Parenthesis
	 *     Exp1 returns Parenthesis
	 *     Exp1.Plus_1_0_0 returns Parenthesis
	 *     Exp1.Minus_1_1_0 returns Parenthesis
	 *     Exp2 returns Parenthesis
	 *     Exp2.Mult_1_0_0 returns Parenthesis
	 *     Exp2.Div_1_1_0 returns Parenthesis
	 *     Primary returns Parenthesis
	 *     Parenthesis returns Parenthesis
	 *
	 * Constraint:
	 *     exp=Exp
	 */
	protected void sequence_Parenthesis(ISerializationContext context, Parenthesis semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.PARENTHESIS__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.PARENTHESIS__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParenthesisAccess().getExpExpParserRuleCall_1_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exp returns VariableUse
	 *     Exp1 returns VariableUse
	 *     Exp1.Plus_1_0_0 returns VariableUse
	 *     Exp1.Minus_1_1_0 returns VariableUse
	 *     Exp2 returns VariableUse
	 *     Exp2.Mult_1_0_0 returns VariableUse
	 *     Exp2.Div_1_1_0 returns VariableUse
	 *     Primary returns VariableUse
	 *     VariableUse returns VariableUse
	 *
	 * Constraint:
	 *     ref=[Math|ID]
	 */
	protected void sequence_VariableUse(ISerializationContext context, VariableUse semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MathPackage.Literals.VARIABLE_USE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MathPackage.Literals.VARIABLE_USE__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableUseAccess().getRefMathIDTerminalRuleCall_0_1(), semanticObject.eGet(MathPackage.Literals.VARIABLE_USE__REF, false));
		feeder.finish();
	}
	
	
}
