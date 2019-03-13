package fr.brucella.form.prescows.entity.exceptions;

import junit.framework.Assert;
import org.junit.Test;

/**
 * NotFoundException unit test.
 *
 * @author BRUCELLA2
 */
public class NotFoundExceptionTest {

  // ===== Constructor =====

  /** Default Constructor */
  public NotFoundExceptionTest() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Constructors testing.
   */
  @Test
  public void constructorsTest() {
    final String message = "Message test";
    final NotFoundException notFoundExceptionTest = new NotFoundException(message);

    Assert.assertEquals(message, notFoundExceptionTest.getMessage());

    final Throwable cause = new Throwable();
    final NotFoundException notFoundExceptionTestWithCause = new NotFoundException(message, cause);

    Assert.assertEquals(message, notFoundExceptionTestWithCause.getMessage());
    Assert.assertEquals(cause, notFoundExceptionTestWithCause.getCause());
  }
}