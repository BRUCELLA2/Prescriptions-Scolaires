package fr.brucella.form.prescows.entity.exceptions;

import javax.xml.ws.WebFault;

/**
 * Exception send by the webservice.
 *
 * @author BRUCELLA2
 */
@WebFault(name = "PrescoWsException")
public class PrescoWsException extends Exception {

  /** PrescoWs Fault, hold fault code and fault message. */
  private PrescoWsFault fault;

  // ===== Constructors =====

  /**
   * Constructor without throwable cause.
   *
   * @param message message of the exception.
   * @param fault fault associated to the exception.
   */
  public PrescoWsException(final String message, final PrescoWsFault fault) {
    super(message);
    this.fault = fault;
  }

  public PrescoWsException(final String message, final Throwable cause, final PrescoWsFault fault) {
    super(message, cause);
    this.fault = fault;
  }

  // ===== Getters and Setters =====

  /**
   * Gives the fault associated to the exception.
   *
   * @return the fault associated to the exception.
   */
  public PrescoWsFault getFault() {
    return fault;
  }

  /**
   * Set the fault associated to the exception.
   *
   * @param fault the fault associated to the exception.
   */
  public void setFault(PrescoWsFault fault) {
    this.fault = fault;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PrescoWsException{");
    sb.append("fault=").append(fault);
    sb.append(", detailMessage=").append(super.getMessage());
    sb.append(", cause=").append(super.getCause());
    sb.append(", suppressedExceptions=").append(super.getSuppressed());
    sb.append('}');
    return sb.toString();
  }
}
