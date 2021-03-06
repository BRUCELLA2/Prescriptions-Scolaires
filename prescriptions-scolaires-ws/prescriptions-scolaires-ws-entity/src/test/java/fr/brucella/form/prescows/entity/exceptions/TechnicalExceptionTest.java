package fr.brucella.form.prescows.entity.exceptions;


import junit.framework.Assert;
import org.junit.Test;

/**
 * TechnicalException unit test.
 *
 * @author BRUCELLA2
 */
public class TechnicalExceptionTest {

  // ===== Constructor =====

  /** Default Constructor */
  public TechnicalExceptionTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Constructors testing.
   */
  @Test
  public void constructorsTest() {

    final String message = "Message test";
    final TechnicalException technicalException = new TechnicalException(message);

    Assert.assertEquals(message, technicalException.getMessage());

    final Throwable cause = new Throwable();
    final TechnicalException technicalExceptionWithCause = new TechnicalException(message, cause);

    Assert.assertEquals(message, technicalExceptionWithCause.getMessage());
    Assert.assertEquals(cause, technicalExceptionWithCause.getCause());
  }
}