package fr.brucella.form.prescows.entity.prescriptions.dto;


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
 * PrescriptionWithRneNameDto unit tests.
 *
 * @author BRUCELLA2
 */
public class PrescriptionWithRneNameDtoTest {

  // ===== Constructor =====

  /** Default Constructor */
  public PrescriptionWithRneNameDtoTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Getters and setters testing.
   */
  @Test
  public void validateSettersAndGetters() {
    final PojoClass prescriptionWithRneNamePojo = PojoClassFactory.getPojoClass(PrescriptionWithRneNameDto.class);
    final Validator validator = ValidatorBuilder.create().with(new SetterTester(), new GetterTester()).build();
    validator.validate(prescriptionWithRneNamePojo);
  }

  /**
   * ToString testing.
   */
  @Test
  public void validateToString() {
    ToStringVerifier.forClass(PrescriptionWithRneNameDto.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}