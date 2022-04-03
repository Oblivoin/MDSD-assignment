/*
 * generated by Xtext 2.25.0
 */
grammar InternalMath;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package dk.sdu.mmmi.mdsd.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package dk.sdu.mmmi.mdsd.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import dk.sdu.mmmi.mdsd.services.MathGrammarAccess;

}
@parser::members {
	private MathGrammarAccess grammarAccess;

	public void setGrammarAccess(MathGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleOrigen
entryRuleOrigen
:
{ before(grammarAccess.getOrigenRule()); }
	 ruleOrigen
{ after(grammarAccess.getOrigenRule()); } 
	 EOF 
;

// Rule Origen
ruleOrigen 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOrigenAccess().getXAssignment()); }
		(rule__Origen__XAssignment)*
		{ after(grammarAccess.getOrigenAccess().getXAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleMathExp
entryRuleMathExp
:
{ before(grammarAccess.getMathExpRule()); }
	 ruleMathExp
{ after(grammarAccess.getMathExpRule()); } 
	 EOF 
;

// Rule MathExp
ruleMathExp 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMathExpAccess().getGroup()); }
		(rule__MathExp__Group__0)
		{ after(grammarAccess.getMathExpAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExp
entryRuleExp
:
{ before(grammarAccess.getExpRule()); }
	 ruleExp
{ after(grammarAccess.getExpRule()); } 
	 EOF 
;

// Rule Exp
ruleExp 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExpAccess().getExp1ParserRuleCall()); }
		ruleExp1
		{ after(grammarAccess.getExpAccess().getExp1ParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExp1
entryRuleExp1
:
{ before(grammarAccess.getExp1Rule()); }
	 ruleExp1
{ after(grammarAccess.getExp1Rule()); } 
	 EOF 
;

// Rule Exp1
ruleExp1 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExp1Access().getGroup()); }
		(rule__Exp1__Group__0)
		{ after(grammarAccess.getExp1Access().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExp2
entryRuleExp2
:
{ before(grammarAccess.getExp2Rule()); }
	 ruleExp2
{ after(grammarAccess.getExp2Rule()); } 
	 EOF 
;

// Rule Exp2
ruleExp2 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExp2Access().getGroup()); }
		(rule__Exp2__Group__0)
		{ after(grammarAccess.getExp2Access().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePrimary
entryRulePrimary
:
{ before(grammarAccess.getPrimaryRule()); }
	 rulePrimary
{ after(grammarAccess.getPrimaryRule()); } 
	 EOF 
;

// Rule Primary
rulePrimary 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimaryAccess().getAlternatives()); }
		(rule__Primary__Alternatives)
		{ after(grammarAccess.getPrimaryAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParenthesis
entryRuleParenthesis
:
{ before(grammarAccess.getParenthesisRule()); }
	 ruleParenthesis
{ after(grammarAccess.getParenthesisRule()); } 
	 EOF 
;

// Rule Parenthesis
ruleParenthesis 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParenthesisAccess().getGroup()); }
		(rule__Parenthesis__Group__0)
		{ after(grammarAccess.getParenthesisAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNumber
entryRuleNumber
:
{ before(grammarAccess.getNumberRule()); }
	 ruleNumber
{ after(grammarAccess.getNumberRule()); } 
	 EOF 
;

// Rule Number
ruleNumber 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNumberAccess().getValueAssignment()); }
		(rule__Number__ValueAssignment)
		{ after(grammarAccess.getNumberAccess().getValueAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleLet
entryRuleLet
:
{ before(grammarAccess.getLetRule()); }
	 ruleLet
{ after(grammarAccess.getLetRule()); } 
	 EOF 
;

// Rule Let
ruleLet 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getLetAccess().getGroup()); }
		(rule__Let__Group__0)
		{ after(grammarAccess.getLetAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleVariableUse
entryRuleVariableUse
:
{ before(grammarAccess.getVariableUseRule()); }
	 ruleVariableUse
{ after(grammarAccess.getVariableUseRule()); } 
	 EOF 
;

// Rule VariableUse
ruleVariableUse 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getVariableUseAccess().getRefAssignment()); }
		(rule__VariableUse__RefAssignment)
		{ after(grammarAccess.getVariableUseAccess().getRefAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp1Access().getGroup_1_0()); }
		(rule__Exp1__Group_1_0__0)
		{ after(grammarAccess.getExp1Access().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getExp1Access().getGroup_1_1()); }
		(rule__Exp1__Group_1_1__0)
		{ after(grammarAccess.getExp1Access().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp2Access().getGroup_1_0()); }
		(rule__Exp2__Group_1_0__0)
		{ after(grammarAccess.getExp2Access().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getExp2Access().getGroup_1_1()); }
		(rule__Exp2__Group_1_1__0)
		{ after(grammarAccess.getExp2Access().getGroup_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Primary__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimaryAccess().getNumberParserRuleCall_0()); }
		ruleNumber
		{ after(grammarAccess.getPrimaryAccess().getNumberParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getParenthesisParserRuleCall_1()); }
		ruleParenthesis
		{ after(grammarAccess.getPrimaryAccess().getParenthesisParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getVariableUseParserRuleCall_2()); }
		ruleVariableUse
		{ after(grammarAccess.getPrimaryAccess().getVariableUseParserRuleCall_2()); }
	)
	|
	(
		{ before(grammarAccess.getPrimaryAccess().getLetParserRuleCall_3()); }
		ruleLet
		{ after(grammarAccess.getPrimaryAccess().getLetParserRuleCall_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MathExp__Group__0__Impl
	rule__MathExp__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMathExpAccess().getVarKeyword_0()); }
	'var'
	{ after(grammarAccess.getMathExpAccess().getVarKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MathExp__Group__1__Impl
	rule__MathExp__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMathExpAccess().getNameAssignment_1()); }
	(rule__MathExp__NameAssignment_1)
	{ after(grammarAccess.getMathExpAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MathExp__Group__2__Impl
	rule__MathExp__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMathExpAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getMathExpAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__MathExp__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getMathExpAccess().getExpAssignment_3()); }
	(rule__MathExp__ExpAssignment_3)
	{ after(grammarAccess.getMathExpAccess().getExpAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp1__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group__0__Impl
	rule__Exp1__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getExp2ParserRuleCall_0()); }
	ruleExp2
	{ after(grammarAccess.getExp1Access().getExp2ParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getAlternatives_1()); }
	(rule__Exp1__Alternatives_1)*
	{ after(grammarAccess.getExp1Access().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp1__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_0__0__Impl
	rule__Exp1__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getPlusLeftAction_1_0_0()); }
	()
	{ after(grammarAccess.getExp1Access().getPlusLeftAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_0__1__Impl
	rule__Exp1__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getPlusSignKeyword_1_0_1()); }
	'+'
	{ after(grammarAccess.getExp1Access().getPlusSignKeyword_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getRightAssignment_1_0_2()); }
	(rule__Exp1__RightAssignment_1_0_2)
	{ after(grammarAccess.getExp1Access().getRightAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp1__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_1__0__Impl
	rule__Exp1__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getMinusLeftAction_1_1_0()); }
	()
	{ after(grammarAccess.getExp1Access().getMinusLeftAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_1__1__Impl
	rule__Exp1__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getHyphenMinusKeyword_1_1_1()); }
	'-'
	{ after(grammarAccess.getExp1Access().getHyphenMinusKeyword_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp1__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp1Access().getRightAssignment_1_1_2()); }
	(rule__Exp1__RightAssignment_1_1_2)
	{ after(grammarAccess.getExp1Access().getRightAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp2__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group__0__Impl
	rule__Exp2__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getPrimaryParserRuleCall_0()); }
	rulePrimary
	{ after(grammarAccess.getExp2Access().getPrimaryParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getAlternatives_1()); }
	(rule__Exp2__Alternatives_1)*
	{ after(grammarAccess.getExp2Access().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp2__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_0__0__Impl
	rule__Exp2__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getMultLeftAction_1_0_0()); }
	()
	{ after(grammarAccess.getExp2Access().getMultLeftAction_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_0__1__Impl
	rule__Exp2__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getAsteriskKeyword_1_0_1()); }
	'*'
	{ after(grammarAccess.getExp2Access().getAsteriskKeyword_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getRightAssignment_1_0_2()); }
	(rule__Exp2__RightAssignment_1_0_2)
	{ after(grammarAccess.getExp2Access().getRightAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exp2__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_1__0__Impl
	rule__Exp2__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getDivLeftAction_1_1_0()); }
	()
	{ after(grammarAccess.getExp2Access().getDivLeftAction_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_1__1__Impl
	rule__Exp2__Group_1_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getSolidusKeyword_1_1_1()); }
	'/'
	{ after(grammarAccess.getExp2Access().getSolidusKeyword_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exp2__Group_1_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__Group_1_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExp2Access().getRightAssignment_1_1_2()); }
	(rule__Exp2__RightAssignment_1_1_2)
	{ after(grammarAccess.getExp2Access().getRightAssignment_1_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parenthesis__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parenthesis__Group__0__Impl
	rule__Parenthesis__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0()); }
	'('
	{ after(grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parenthesis__Group__1__Impl
	rule__Parenthesis__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesisAccess().getExpAssignment_1()); }
	(rule__Parenthesis__ExpAssignment_1)
	{ after(grammarAccess.getParenthesisAccess().getExpAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parenthesis__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParenthesisAccess().getRightParenthesisKeyword_2()); }
	')'
	{ after(grammarAccess.getParenthesisAccess().getRightParenthesisKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Let__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__0__Impl
	rule__Let__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getLetKeyword_0()); }
	'let'
	{ after(grammarAccess.getLetAccess().getLetKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__1__Impl
	rule__Let__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getNameAssignment_1()); }
	(rule__Let__NameAssignment_1)
	{ after(grammarAccess.getLetAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__2__Impl
	rule__Let__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getEqualsSignKeyword_2()); }
	'='
	{ after(grammarAccess.getLetAccess().getEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__3__Impl
	rule__Let__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getValAssignment_3()); }
	(rule__Let__ValAssignment_3)
	{ after(grammarAccess.getLetAccess().getValAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__4__Impl
	rule__Let__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getInKeyword_4()); }
	'in'
	{ after(grammarAccess.getLetAccess().getInKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__5__Impl
	rule__Let__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getExpAssignment_5()); }
	(rule__Let__ExpAssignment_5)
	{ after(grammarAccess.getLetAccess().getExpAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Let__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getLetAccess().getEndKeyword_6()); }
	'end'
	{ after(grammarAccess.getLetAccess().getEndKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Origen__XAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOrigenAccess().getXMathExpParserRuleCall_0()); }
		ruleMathExp
		{ after(grammarAccess.getOrigenAccess().getXMathExpParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMathExpAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getMathExpAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__MathExp__ExpAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMathExpAccess().getExpExpParserRuleCall_3_0()); }
		ruleExp
		{ after(grammarAccess.getMathExpAccess().getExpExpParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__RightAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_0_2_0()); }
		ruleExp2
		{ after(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp1__RightAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_1_2_0()); }
		ruleExp2
		{ after(grammarAccess.getExp1Access().getRightExp2ParserRuleCall_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__RightAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_0_2_0()); }
		rulePrimary
		{ after(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exp2__RightAssignment_1_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_1_2_0()); }
		rulePrimary
		{ after(grammarAccess.getExp2Access().getRightPrimaryParserRuleCall_1_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parenthesis__ExpAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParenthesisAccess().getExpExpParserRuleCall_1_0()); }
		ruleExp
		{ after(grammarAccess.getParenthesisAccess().getExpExpParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Number__ValueAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNumberAccess().getValueINTTerminalRuleCall_0()); }
		RULE_INT
		{ after(grammarAccess.getNumberAccess().getValueINTTerminalRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLetAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getLetAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__ValAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLetAccess().getValExpParserRuleCall_3_0()); }
		ruleExp
		{ after(grammarAccess.getLetAccess().getValExpParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Let__ExpAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getLetAccess().getExpExpParserRuleCall_5_0()); }
		ruleExp
		{ after(grammarAccess.getLetAccess().getExpExpParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__VariableUse__RefAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getVariableUseAccess().getRefMathCrossReference_0()); }
		(
			{ before(grammarAccess.getVariableUseAccess().getRefMathIDTerminalRuleCall_0_1()); }
			RULE_ID
			{ after(grammarAccess.getVariableUseAccess().getRefMathIDTerminalRuleCall_0_1()); }
		)
		{ after(grammarAccess.getVariableUseAccess().getRefMathCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
