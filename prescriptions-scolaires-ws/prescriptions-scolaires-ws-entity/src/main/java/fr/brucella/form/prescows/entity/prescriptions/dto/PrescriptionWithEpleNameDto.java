package fr.brucella.form.prescows.entity.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a PrescriptionWithRneName Data Transfert Object.
 * Includes all informations about the prescriptions.
 * Includes the rne name associated to the prescription.
 *
 * @author BRUCELLA2
 */
public class PrescriptionWithEpleNameDto extends Prescription {

  /** name of the eple. */
  @NotEmpty(message = "{eple.epleName.empty}")
  @Size(min = 1, max = 100, message = "{eple.epleName.size}")
  private String epleName;


  // ===== Constructor =====

  /** Default Constructor */
  public PrescriptionWithEpleNameDto() {
    super();
  }


  // ===== Getters and Setters =====

  /**
   * Gives the name of the eple.
   *
   * @return the name of the eple.
   */
  public String getEpleName() {
    return epleName;
  }

  /**
   * Set the name of the eple.
   *
   * @param epleName the name of the eple.
   */
  public void setEpleName(final String epleName) {
    this.epleName = epleName;
  }


  // ===== Methods =====


  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PrescriptionWithEpleNameDto{");
    sb.append("epleName='").append(epleName).append('\'');
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }
}
