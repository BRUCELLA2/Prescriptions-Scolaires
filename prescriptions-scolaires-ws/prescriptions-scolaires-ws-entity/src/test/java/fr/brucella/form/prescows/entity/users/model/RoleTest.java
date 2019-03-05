package fr.brucella.form.prescows.entity.users.model;

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
 * Role unit test.
 *
 * @author BRUCELLA2
 */
public class RoleTest {

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    PojoClass rolePojo = PojoClassFactory.getPojoClass(Role.class);
    Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(rolePojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(Role.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}