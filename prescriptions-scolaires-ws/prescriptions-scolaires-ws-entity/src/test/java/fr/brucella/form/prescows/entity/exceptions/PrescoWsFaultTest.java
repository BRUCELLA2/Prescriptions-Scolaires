package fr.brucella.form.prescows.entity.exceptions;

import static org.junit.Assert.*;

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

public class PrescoWsFaultTest {

  // ===== Constructor =====

  /** Default Constructor */
  public PrescoWsFaultTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    final PojoClass prescoWsFaultPojo = PojoClassFactory.getPojoClass(PrescoWsFault.class);
    final Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(prescoWsFaultPojo);
  }

  /**
   * Constructor testing.
   */
  @Test
  public void construtorTest() {

    final String faultString = "fault";
    final String faultCode = "001";

    final PrescoWsFault prescoWsFault = new PrescoWsFault(faultCode, faultString);

    Assert.assertEquals(faultCode, prescoWsFault.getFaultCode());
    Assert.assertEquals(faultString, prescoWsFault.getFaultString());
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(PrescoWsFault.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}