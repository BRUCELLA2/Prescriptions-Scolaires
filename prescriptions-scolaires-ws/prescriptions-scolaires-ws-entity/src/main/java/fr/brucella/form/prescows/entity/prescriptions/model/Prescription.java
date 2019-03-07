package fr.brucella.form.prescows.entity.prescriptions.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a prescription.
 *
 * @author BRUCELLA2
 */
public class Prescription {

  /** id of the prescription. */
  private Integer prescriptionId;

  /** name of the prescription. Can't be empty. */
  @NotEmpty(message = "{prescription.prescriptionName.empty}")
  @Size(min = 1, max = 150, message = "{prescription.prescriptionName.size}")
  private String prescriptionName;

  /** Creation date of the prescription. Can't be null. */
  @NotNull(message = "{prescription.creationDate.null}")
  private LocalDateTime creationDate;

  /** id of the user. Can't be null. */
  @NotNull(message = "{prescription.userId.null}")
  private Integer userId;

  /** Deadline date for book purchase. Can't be null. */
  @NotNull(message = "{prescription.purchaseDeadline.null}")
  private LocalDateTime purchaseDeadline;

  /** validationStatus. True if all books of the prescription are available, false else. Can't be null. */
  @NotNull(message = "{prescription.validationStatus.null}")
  private Boolean validationStatus;

  /** id of the eple associated to the prescription. Can't be null. */
  @NotNull(message = "{prescription.epleId.null}")
  private Integer epleId;


  // ===== Constructor =====

  /** Default Constructor */
  public Prescription() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

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
   * Gives the name of the prescription.
   *
   * @return the name of the prescription.
   */
  public String getPrescriptionName() {
    return prescriptionName;
  }

  /**
   * Set the name of the prescription.
   *
   * @param prescriptionName the name of the prescription.
   */
  public void setPrescriptionName(final String prescriptionName) {
    this.prescriptionName = prescriptionName;
  }

  /**
   * Gives the creation date of the prescription.
   *
   * @return the creation date of the prescription.
   */
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  /**
   * Set the creation date of the prescription.
   *
   * @param creationDate the creation date of the prescription.
   */
  public void setCreationDate(final LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

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
   * Gives the books purchase deadline.
   *
   * @return the books purchase deadline.
   */
  public LocalDateTime getPurchaseDeadline() {
    return purchaseDeadline;
  }

  /**
   * Set the books purchase deadline.
   *
   * @param purchaseDeadline the books purchase deadline.
   */
  public void setPurchaseDeadline(final LocalDateTime purchaseDeadline) {
    this.purchaseDeadline = purchaseDeadline;
  }

  /**
   * Gives the validation status.
   *
   * @return the validation status.
   */
  public Boolean getValidationStatus() {
    return validationStatus;
  }

  /**
   * Set the validation status.
   *
   * @param validationStatus the validation status.
   */
  public void setValidationStatus(final Boolean validationStatus) {
    this.validationStatus = validationStatus;
  }

  /**
   * Gives the id of the eple.
   *
   * @return the id of the eple.
   */
  public Integer getEpleId() {
    return epleId;
  }

  /**
   * Set the id of the eple.
   *
   * @param epleId the id of the eple.
   */
  public void setEpleId(final Integer epleId) {
    this.epleId = epleId;
  }

  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Prescription{");
    sb.append("prescriptionId=").append(prescriptionId);
    sb.append(", prescriptionName='").append(prescriptionName).append('\'');
    sb.append(", creationDate=").append(creationDate);
    sb.append(", userId=").append(userId);
    sb.append(", purchaseDeadline=").append(purchaseDeadline);
    sb.append(", validationStatus=").append(validationStatus);
    sb.append(", epleId=").append(epleId);
    sb.append('}');
    return sb.toString();
  }
}
