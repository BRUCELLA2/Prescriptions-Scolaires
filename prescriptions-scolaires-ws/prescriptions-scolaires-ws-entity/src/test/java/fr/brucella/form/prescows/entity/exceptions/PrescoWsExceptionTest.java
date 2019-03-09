package fr.brucella.form.prescows.entity.exceptions;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import junit.framework.Assert;
import org.junit.Test;

/**
 * PrescoWsException unit tests.
 *
 * @author BRUCELLA2
 */
public class PrescoWsExceptionTest {

  // ===== Constructor =====

  /** Default Constructor */
  public PrescoWsExceptionTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    final PojoClass prescoWsExceptionPojo = PojoClassFactory.getPojoClass(PrescoWsException.class);
    final Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(prescoWsExceptionPojo);
  }

  /**
   * Constructor testing.
   */
  @Test
  public void constructorTest() {
    final String message = "message";
    final Throwable cause = new Throwable();
    final PrescoWsFault fault = new PrescoWsFault();

    final PrescoWsException prescoWsException = new PrescoWsException(message, cause, fault);

    Assert.assertEquals(message, prescoWsException.getMessage());
    Assert.assertEquals(cause, prescoWsException.getCause());
    Assert.assertEquals(fault, prescoWsException.getFault());
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(PrescoWsException.class).withClassName(NameStyle.SIMPLE_NAME).withIgnoredFields("stackTrace").verify();
  }
}