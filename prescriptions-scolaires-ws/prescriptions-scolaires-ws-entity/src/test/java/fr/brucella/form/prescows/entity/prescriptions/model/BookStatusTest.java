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
 * BookStatus unit tests.
 *
 * @author BRUCELLA2
 */
public class BookStatusTest {


  // ===== Constructor =====

  /** Default Constructor */
  public BookStatusTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Methods =====
  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    final PojoClass bookStatusPojo = PojoClassFactory.getPojoClass(BookStatus.class);
    final Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(bookStatusPojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(BookStatus.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }

}