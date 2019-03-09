package fr.brucella.form.prescows.entity.exceptions;

import junit.framework.Assert;
import org.junit.Test;

/**
 * FunctionalException unit test.
 *
 * @author BRUCELLA2
 */
public class FunctionalExceptionTest {

  // ===== Constructor =====

  /** Default Constructor */
  public FunctionalExceptionTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Constructors testing.
   */
  @Test
  public void ConstructorsTest() {

    final String message = "Message test";
    final FunctionalException functionalException = new FunctionalException(message);

    Assert.assertEquals(message, functionalException.getMessage());

    Throwable cause = new Throwable();
    final FunctionalException functionalExceptionWithCause = new FunctionalException(message, cause);

    Assert.assertEquals(message, functionalExceptionWithCause.getMessage());
    Assert.assertEquals(cause, functionalExceptionWithCause.getCause());
  }
}