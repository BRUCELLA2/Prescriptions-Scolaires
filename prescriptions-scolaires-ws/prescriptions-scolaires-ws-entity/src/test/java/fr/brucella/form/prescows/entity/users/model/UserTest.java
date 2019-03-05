package fr.brucella.form.prescows.entity.users.model;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.test.impl.ToStringTester;
import org.junit.Test;

public class UserTest {

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    PojoClass UserPojo = PojoClassFactory.getPojoClass(User.class);
    Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(UserPojo);
  }

  @Test
  public void validateToString() {
    ToStringVerifier.forClass(User.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}