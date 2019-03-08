package fr.brucella.form.prescows.entity.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a PrescriptionFullDetails Data Transfert Object.
 * Includes all informations about the prescription.
 * Includes the name of the eple associated to the prescription.
 * Includes the city name of the eple associated to the prescription.
 * Includes the department of the eple associated to the prescription.
 * Includes the list of all the ProcessingPrescription associated to the prescription.
 *
 * @author BRUCELLA2
 */
public class PrescriptionFullDetailsDto extends Prescription {

  /** name of the eple. */
  @NotEmpty(message = "{eple.epleName.empty}")
  @Size(min = 1, max = 100, message = "{eple.epleName.size}")
  private String epleName;

  /** name of the city. */
  @NotEmpty(message = "{city.name.empty}")
  @Size(min = 1, max = 100, message = "{city.name.size}")
  private String cityName;

  /** name of the department. */
  @NotEmpty(message = "{department.departmentName.empty}")
  @Size(min = 1, max = 50, message = "{department.departmentName.size}")
  private String departmentName;

  /**
   * List of the ProcessingPrescription associated to the prescription.
   */
  private List<ProcessingPrescription> processingPrescriptionList;


  // ===== Constructor =====

  /** Default Constructor */
  public PrescriptionFullDetailsDto() {
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

  /**
   * Gives the name of the city.
   *
   * @return the name of the city.
   */
  public String getCityName() {
    return cityName;
  }

  /**
   * Set the name of the city.
   *
   * @param cityName the name of the city.
   */
  public void setCityName(final String cityName) {
    this.cityName = cityName;
  }

  /**
   * Gives the name of the department.
   *
   * @return the name of the department.
   */
  public String getDepartmentName() {
    return departmentName;
  }

  /**
   * Set the name of the department.
   *
   * @param departmentName the name of the department.
   */
  public void setDepartmentName(final String departmentName) {
    this.departmentName = departmentName;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PrescriptionFullDetailsDto{");
    sb.append("epleName='").append(epleName).append('\'');
    sb.append(", cityName='").append(cityName).append('\'');
    sb.append(", departmentName='").append(departmentName).append('\'');
    sb.append(", processingPrescriptionList=").append(processingPrescriptionList);
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }
}
