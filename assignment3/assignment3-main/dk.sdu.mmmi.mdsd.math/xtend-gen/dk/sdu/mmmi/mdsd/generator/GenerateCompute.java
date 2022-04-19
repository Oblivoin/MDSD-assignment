/**
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator;

import com.google.common.collect.Iterators;
import dk.sdu.mmmi.mdsd.math.Div;
import dk.sdu.mmmi.mdsd.math.Expression;
import dk.sdu.mmmi.mdsd.math.ExternalCall;
import dk.sdu.mmmi.mdsd.math.LetBinding;
import dk.sdu.mmmi.mdsd.math.MathNumber;
import dk.sdu.mmmi.mdsd.math.Minus;
import dk.sdu.mmmi.mdsd.math.Mult;
import dk.sdu.mmmi.mdsd.math.Parenthesis;
import dk.sdu.mmmi.mdsd.math.Plus;
import dk.sdu.mmmi.mdsd.math.VariableUse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class GenerateCompute {
  private static Map<String, Stack<Expression>> vars = new HashMap<String, Stack<Expression>>();
  
  private static Stack<LetBinding> letStatements = new Stack<LetBinding>();
  
  private static Map<LetBinding, String> names = new HashMap<LetBinding, String>();
  
  private static int identifier = 0;
  
  private static Set<String> localDeclared = new HashSet<String>();
  
  public static String generateCompute(final Expression exp) {
    GenerateCompute.vars.clear();
    GenerateCompute.letStatements.clear();
    GenerateCompute.names.clear();
    GenerateCompute.localDeclared.clear();
    GenerateCompute.identifier = 0;
    GenerateCompute.scanForLetBindings(exp);
    String lets = "";
    while ((GenerateCompute.letStatements.size() > 0)) {
      String _lets = lets;
      String _generateLet = GenerateCompute.generateLet(GenerateCompute.letStatements.pop());
      lets = (_lets + _generateLet);
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(lets);
    _builder.newLineIfNotEmpty();
    _builder.append("return ");
    String _generateJavaCode = GenerateCompute.generateJavaCode(exp, null);
    _builder.append(_generateJavaCode);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public static void scanForLetBindings(final Expression exp) {
    boolean _matched = false;
    if (exp instanceof Plus) {
      _matched=true;
      GenerateCompute.scanForLetBindings(((Plus)exp).getLeft());
      GenerateCompute.scanForLetBindings(((Plus)exp).getRight());
    }
    if (!_matched) {
      if (exp instanceof Minus) {
        _matched=true;
        GenerateCompute.scanForLetBindings(((Minus)exp).getLeft());
        GenerateCompute.scanForLetBindings(((Minus)exp).getRight());
      }
    }
    if (!_matched) {
      if (exp instanceof Mult) {
        _matched=true;
        GenerateCompute.scanForLetBindings(((Mult)exp).getLeft());
        GenerateCompute.scanForLetBindings(((Mult)exp).getRight());
      }
    }
    if (!_matched) {
      if (exp instanceof Div) {
        _matched=true;
        GenerateCompute.scanForLetBindings(((Div)exp).getLeft());
        GenerateCompute.scanForLetBindings(((Div)exp).getRight());
      }
    }
    if (!_matched) {
      if (exp instanceof Parenthesis) {
        _matched=true;
        GenerateCompute.scanForLetBindings(((Parenthesis)exp).getExp());
      }
    }
    if (!_matched) {
      if (exp instanceof ExternalCall) {
        _matched=true;
        final Consumer<Expression> _function = (Expression it) -> {
          GenerateCompute.scanForLetBindings(it);
        };
        ((ExternalCall)exp).getArguments().forEach(_function);
      }
    }
    if (!_matched) {
      if (exp instanceof LetBinding) {
        _matched=true;
        GenerateCompute.addvars(((LetBinding)exp));
        GenerateCompute.letStatements.push(((LetBinding)exp));
        GenerateCompute.names.put(((LetBinding)exp), ("l" + Integer.valueOf(GenerateCompute.identifier)));
        GenerateCompute.identifier++;
        GenerateCompute.scanForLetBindings(((LetBinding)exp).getBinding());
        GenerateCompute.scanForLetBindings(((LetBinding)exp).getBody());
      }
    }
  }
  
  public static void addvars(final LetBinding let) {
    boolean _containsKey = GenerateCompute.vars.containsKey(let.getName());
    boolean _not = (!_containsKey);
    if (_not) {
      String _name = let.getName();
      Stack<Expression> _stack = new Stack<Expression>();
      GenerateCompute.vars.put(_name, _stack);
    }
    GenerateCompute.vars.get(let.getName()).push(let.getBinding());
  }
  
  public static Set<String> listvars(final EObject obj) {
    final HashSet<String> available = CollectionLiterals.<String>newHashSet();
    EObject container = obj.eContainer();
    while ((container != null)) {
      boolean _matched = false;
      if (container instanceof LetBinding) {
        _matched=true;
        available.add(((LetBinding)container).getName());
        container = ((LetBinding)container).eContainer();
      }
      if (!_matched) {
        container = container.eContainer();
      }
    }
    return available;
  }
  
  public static String generateLet(final LetBinding let) {
    final Set<String> availabeVars = GenerateCompute.listvars(let.getBody());
    final Function1<VariableUse, String> _function = (VariableUse it) -> {
      return it.getRef().getName();
    };
    final Set<String> required = IteratorExtensions.<String>toSet(IteratorExtensions.<VariableUse, String>map(Iterators.<VariableUse>filter(let.eAllContents(), VariableUse.class), _function));
    String code = "";
    for (final String reqVar : required) {
      if ((availabeVars.contains(reqVar) && GenerateCompute.vars.containsKey(reqVar))) {
        final Expression exp = GenerateCompute.vars.get(reqVar).pop();
        String _code = code;
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _contains = GenerateCompute.localDeclared.contains(reqVar);
          boolean _not = (!_contains);
          if (_not) {
            _builder.append(" int ");
          }
        }
        _builder.append(reqVar);
        _builder.append(" = ");
        String _generateJavaCode = GenerateCompute.generateJavaCode(exp, GenerateCompute.listvars(let));
        _builder.append(_generateJavaCode);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        String _plus = (_builder.toString() + "\n");
        code = (_code + _plus);
        GenerateCompute.localDeclared.add(reqVar);
        int _size = GenerateCompute.vars.get(reqVar).size();
        boolean _equals = (_size == 0);
        if (_equals) {
          GenerateCompute.vars.remove(reqVar);
        }
      }
    }
    String _code_1 = code;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int ");
    String _get = GenerateCompute.names.get(let);
    _builder_1.append(_get);
    _builder_1.append(" = ");
    String _generateJavaCode_1 = GenerateCompute.generateJavaCode(let.getBody(), GenerateCompute.listvars(let.getBody()));
    _builder_1.append(_generateJavaCode_1);
    String _plus_1 = (_builder_1.toString() + ";\n");
    code = (_code_1 + _plus_1);
    return code;
  }
  
  public static String generateJavaCode(final Expression exp, final Set<String> vars) {
    String _switchResult = null;
    boolean _matched = false;
    if (exp instanceof Plus) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _generateJavaCode = GenerateCompute.generateJavaCode(((Plus)exp).getLeft(), vars);
      _builder.append(_generateJavaCode);
      _builder.append(" + ");
      String _generateJavaCode_1 = GenerateCompute.generateJavaCode(((Plus)exp).getRight(), vars);
      _builder.append(_generateJavaCode_1);
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (exp instanceof Minus) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateJavaCode = GenerateCompute.generateJavaCode(((Minus)exp).getLeft(), vars);
        _builder.append(_generateJavaCode);
        _builder.append(" - ");
        String _generateJavaCode_1 = GenerateCompute.generateJavaCode(((Minus)exp).getRight(), vars);
        _builder.append(_generateJavaCode_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Div) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateJavaCode = GenerateCompute.generateJavaCode(((Div)exp).getLeft(), vars);
        _builder.append(_generateJavaCode);
        _builder.append(" / ");
        String _generateJavaCode_1 = GenerateCompute.generateJavaCode(((Div)exp).getRight(), vars);
        _builder.append(_generateJavaCode_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Mult) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateJavaCode = GenerateCompute.generateJavaCode(((Mult)exp).getLeft(), vars);
        _builder.append(_generateJavaCode);
        _builder.append(" * ");
        String _generateJavaCode_1 = GenerateCompute.generateJavaCode(((Mult)exp).getRight(), vars);
        _builder.append(_generateJavaCode_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof MathNumber) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        int _value = ((MathNumber)exp).getValue();
        _builder.append(_value);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Parenthesis) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        String _generateJavaCode = GenerateCompute.generateJavaCode(((Parenthesis)exp).getExp(), vars);
        _builder.append(_generateJavaCode);
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof VariableUse) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        {
          if (((vars == null) || (!vars.contains(((VariableUse)exp).getRef().getName())))) {
            _builder.append("this.");
          }
        }
        String _name = ((VariableUse)exp).getRef().getName();
        _builder.append(_name);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof ExternalCall) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("external.");
        String _name = ((ExternalCall)exp).getMethod().getName();
        _builder.append(_name);
        _builder.append("(");
        {
          EList<Expression> _arguments = ((ExternalCall)exp).getArguments();
          boolean _hasElements = false;
          for(final Expression arg : _arguments) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            String _generateJavaCode = GenerateCompute.generateJavaCode(arg, vars);
            _builder.append(_generateJavaCode);
          }
        }
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof LetBinding) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _get = GenerateCompute.names.get(exp);
        _builder.append(_get);
        _switchResult = _builder.toString();
      }
    }
    return _switchResult;
  }
}