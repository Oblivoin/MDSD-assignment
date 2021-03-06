/*
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator

import dk.sdu.mmmi.mdsd.math.Div
import dk.sdu.mmmi.mdsd.math.LetBinding
import dk.sdu.mmmi.mdsd.math.MathExp
import dk.sdu.mmmi.mdsd.math.MathNumber
import dk.sdu.mmmi.mdsd.math.Minus
import dk.sdu.mmmi.mdsd.math.Mult
import dk.sdu.mmmi.mdsd.math.Plus
import dk.sdu.mmmi.mdsd.math.VarBinding
import dk.sdu.mmmi.mdsd.math.VariableUse
import java.util.HashMap
import java.util.Map
import javax.swing.JOptionPane
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.EObject
import dk.sdu.mmmi.mdsd.math.ExternalDeclaration
import java.util.List
import java.util.Stack
import java.util.Set
import java.util.HashSet
import dk.sdu.mmmi.mdsd.math.Parenthesis
import dk.sdu.mmmi.mdsd.math.ExternalCall
import dk.sdu.mmmi.mdsd.math.Expression

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */

class GenerateCompute{
	static Map<String, Stack<Expression>> vars = new HashMap();
	static Stack<LetBinding> letStatements = new Stack();
	static Map<LetBinding, String> names = new HashMap(); //find this and work 
	static int identifier = 0;
	
	static Set<String> localDeclared = new HashSet();
	
	static def String generateCompute(Expression exp){
		vars.clear();
		letStatements.clear();
		names.clear();
		localDeclared.clear();
		identifier = 0;
		
		exp.scanForLetBindings
		
		var lets = ""
		while (letStatements.size > 0){
			lets += letStatements.pop().generateLet
		}
		
		return '''
		«lets»
		return «exp.generateJavaCode(null)»;
		'''
	}
	
	static def void scanForLetBindings(Expression exp){
		switch (exp) {
			Plus: {
				exp.left.scanForLetBindings
				exp.right.scanForLetBindings
			}
			Minus: {
				exp.left.scanForLetBindings
				exp.right.scanForLetBindings
			}
			Mult: {
				exp.left.scanForLetBindings
				exp.right.scanForLetBindings
			}
			Div: {
				exp.left.scanForLetBindings
				exp.right.scanForLetBindings
			}
			Parenthesis: exp.exp.scanForLetBindings
			ExternalCall: exp.arguments.forEach[it.scanForLetBindings]
			LetBinding: {
				exp.addvars
				letStatements.push(exp)
				
				names.put(exp, "l" + identifier);
				identifier++;
				exp.binding.scanForLetBindings
				exp.body.scanForLetBindings
			}
		}
	}
	
	static def void addvars(LetBinding let) {
		if (!vars.containsKey(let.name)) {
			vars.put(let.name, new Stack());
		}
		vars.get(let.name).push(let.binding);
	}
	
	static def Set<String> listvars(EObject obj){
		val available = newHashSet()
		
		var container = obj.eContainer
		while (container !== null) {
			switch (container){
				LetBinding: {
					available.add(container.name)
					container = container.eContainer
				}
				default: container = container.eContainer
			}
		}
		
		return available
	}
	
	static def String generateLet(LetBinding let){
		val availabeVars = let.body.listvars;
		val required = let.eAllContents.filter(VariableUse).map[it.ref.name].toSet
		var code = ""
		
		for (String reqVar : required) {
			if ( availabeVars.contains(reqVar) && vars.containsKey(reqVar)) {
				val exp = vars.get(reqVar).pop()
				code += '''«IF !localDeclared.contains(reqVar)» int «ENDIF»«reqVar» = «exp.generateJavaCode(let.listvars)»;
				''' + "\n"
				localDeclared.add(reqVar)
				if (vars.get(reqVar).size == 0) {
					vars.remove(reqVar)
				}
			}
		}
		
		code += '''int «names.get(let)» = «generateJavaCode(let.body, let.body.listvars)»''' + ";\n"
		
		return code
	}
	
	static def String generateJavaCode(Expression exp, Set<String> vars) {
		return switch (exp) {
			Plus: '''«exp.left.generateJavaCode(vars)» + «exp.right.generateJavaCode(vars)»'''
			Minus: '''«exp.left.generateJavaCode(vars)» - «exp.right.generateJavaCode(vars)»'''
			Div: '''«exp.left.generateJavaCode(vars)» / «exp.right.generateJavaCode(vars)»'''
			Mult:'''«exp.left.generateJavaCode(vars)» * «exp.right.generateJavaCode(vars)»'''
			MathNumber: '''«exp.value»'''
			Parenthesis: '''(«exp.exp.generateJavaCode(vars)»)'''
			VariableUse: '''«IF vars ===null || !vars.contains(exp.ref.name)»this.«ENDIF»«exp.ref.name»'''
			ExternalCall: '''external.«exp.method.name»(«FOR arg : exp.arguments SEPARATOR ", "»«arg.generateJavaCode(vars)»«ENDFOR»)'''
			LetBinding: '''«names.get(exp)»'''
		}
	}
}