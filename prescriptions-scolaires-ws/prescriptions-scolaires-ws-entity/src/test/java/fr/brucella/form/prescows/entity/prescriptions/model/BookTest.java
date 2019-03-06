package fr.brucella.form.prescows.entity.prescriptions.model;

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
 * Book unit tests.
 *
 * @author BRUCELLA2
 */
public class BookTest {

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    PojoClass bookPojo = PojoClassFactory.getPojoClass(Book.class);
    Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(bookPojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(Book.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }

}