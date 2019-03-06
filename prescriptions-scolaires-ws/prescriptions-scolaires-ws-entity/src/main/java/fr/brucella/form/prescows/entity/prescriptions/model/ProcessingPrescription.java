package fr.brucella.form.prescows.entity.prescriptions.model;

import javax.validation.constraints.NotNull;

/**
 * Represents the processing status of a prescription.
 *
 * @author BRUCELLA2
 */
public class ProcessingPrescription {


  /** id of the user. */
  @NotNull(message = "{processingPrescription.userId.null}")
  private Integer userId;

  /** id of the prescription. */
  @NotNull(message = "{processingPrescription.prescriptionId.null}")
  private Integer prescriptionId;

  /** Indicates if the prescription is process. */
  @NotNull(message = "{processingPrescription.processingStatus.null}")
  private Boolean processingStatus;


  // ===== Constructor =====

  /** Default Constructor */
  public ProcessingPrescription() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Gives the id of the user.
   *
   * @return the id of the user.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the id of the user.
   *
   * @param userId the id of the user.
   */
  public void setUserId(final Integer userId) {
    this.userId = userId;
  }

  /**
   * Gives the id of the prescription.
   *
   * @return the id of the prescription.
   */
  public Integer getPrescriptionId() {
    return prescriptionId;
  }

  /**
   * Set the id of the prescription.
   *
   * @param prescriptionId the id of the prescription.
   */
  public void setPrescriptionId(final Integer prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  /**
   * Give the processing status.
   *
   * @return the processing status.
   */
  public Boolean getProcessingStatus() {
    return processingStatus;
  }

  /**
   * Set the processing status.
   *
   * @param processingStatus the processing status.
   */
  public void setProcessingStatus(final Boolean processingStatus) {
    this.processingStatus = processingStatus;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ProcessingPrescription{");
    sb.append("userId=").append(userId);
    sb.append(", prescriptionId=").append(prescriptionId);
    sb.append(", processingStatus=").append(processingStatus);
    sb.append('}');
    return sb.toString();
  }
}
