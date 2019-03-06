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
 * Prescription unit tests.
 *
 * @author BRUCELLA2
 */
public class PrescriptionTest {

  // ===== Constructor =====

  /** Default Constructor */
  public PrescriptionTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    final PojoClass prescriptionPojo = PojoClassFactory.getPojoClass(Prescription.class);
    final Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(prescriptionPojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(Prescription.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }

}