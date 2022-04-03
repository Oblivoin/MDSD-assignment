/**
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.validation;

import com.google.common.base.Objects;
import dk.sdu.mmmi.mdsd.math.MathExp;
import dk.sdu.mmmi.mdsd.math.MathPackage;
import dk.sdu.mmmi.mdsd.math.Origen;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class MathValidator extends AbstractMathValidator {
  @Check
  public void checkMathStuff(final MathExp exp) {
    EObject _eContainer = exp.eContainer();
    final Function1<MathExp, String> _function = (MathExp it) -> {
      return it.getName();
    };
    List<String> valNames = IterableExtensions.<String>toList(ListExtensions.<MathExp, String>map(((Origen) _eContainer).getX(), _function));
    final Function1<String, Boolean> _function_1 = (String it) -> {
      String _name = exp.getName();
      return Boolean.valueOf(Objects.equal(it, _name));
    };
    Iterable<String> tempList = IterableExtensions.<String>filter(valNames, _function_1);
    final Function1<String, Boolean> _function_2 = (String it) -> {
      String _name = exp.getName();
      return Boolean.valueOf(Objects.equal(it, _name));
    };
    int _length = ((Object[])Conversions.unwrapArray(IterableExtensions.<String>filter(valNames, _function_2), Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      this.error("Variable is in use", MathPackage.Literals.LET__VAL, "invalidName");
    }
  }
}
