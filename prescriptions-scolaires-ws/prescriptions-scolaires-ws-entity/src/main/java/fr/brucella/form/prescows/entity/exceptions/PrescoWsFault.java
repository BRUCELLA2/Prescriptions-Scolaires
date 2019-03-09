package fr.brucella.form.prescows.entity.exceptions;

/**
 * Represents a SOAP Fault.
 */
public class PrescoWsFault {

  /** Code of the fault. */
  private String faultCode;

  /** Message of the fault. */
  private String faultString;

  // ===== Constructors =====

  /** Default Constructor. */
  public PrescoWsFault() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Full Constructor.
   *
   * @param faultCode the fault code.
   * @param faultString the fault message.
   */
  public PrescoWsFault(final String faultCode, final String faultString) {
    this.faultCode = faultCode;
    this.faultString = faultString;
  }

  // ===== Getters and Setters =====

  /**
   * Give the fault code.
   *
   * @return the fault code.
   */
  public String getFaultCode() {
    return faultCode;
  }

  /**
   * Set the fault code.
   *
   * @param faultCode the fault code.
   */
  public void setFaultCode(final String faultCode) {
    this.faultCode = faultCode;
  }

  /**
   * Give the fault message.
   *
   * @return the fault message.
   */
  public String getFaultString() {
    return faultString;
  }

  /**
   * Set the fault message.
   *
   * @param faultString the fault message.
   */
  public void setFaultString(final String faultString) {
    this.faultString = faultString;
  }

  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PrescoWsFault{");
    sb.append("faultCode='").append(faultCode).append('\'');
    sb.append(", faultString='").append(faultString).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
