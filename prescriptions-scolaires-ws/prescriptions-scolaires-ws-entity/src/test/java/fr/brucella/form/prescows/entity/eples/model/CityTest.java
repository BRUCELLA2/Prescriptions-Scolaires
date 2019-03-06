package fr.brucella.form.prescows.entity.eples.model;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

/**
 * City unit tests.
 *
 * @author BRUCELLA2
 */
public class CityTest {

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    PojoClass cityPojo = PojoClassFactory.getPojoClass(City.class);
    Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(cityPojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(City.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }

}