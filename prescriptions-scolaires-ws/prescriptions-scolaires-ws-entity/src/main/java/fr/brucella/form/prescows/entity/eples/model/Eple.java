package fr.brucella.form.prescows.entity.eples.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents an eple (établissement public local d'enseignement).
 *
 * @author BRUCELLA2
 */
public class Eple {

  /** id of the eple. */
  private Integer epleId;

  /** code rne (répertoire national des établissements) of the eple. Can't be empty. */
  @NotEmpty(message = "{eple.rne.empty}")
  @Size(min = 8, max = 8, message = "{eple.rne.size}")
  private String rne;

  /** name of the eple. */
  @NotEmpty(message = "{eple.epleName.empty}")
  @Size(min = 1, max = 100, message = "{eple.epleName.size}")
  private String epleName;

  /** id of the department. Can't be null. */
  @NotNull(message = "{eple.departmentId.null}")
  private Integer departmentId;

  /** id of the city. Can't be null. */
  @NotNull(message = "{eple.cityId.null}")
  private Integer cityId;


  // ===== Constructor =====

  /** Default Constructor */
  public Eple() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

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

  /**
   * Gives the code rne of the eple.
   *
   * @return the code rne of the eple.
   */
  public String getRne() {
    return rne;
  }

  /**
   * Set the code rne of the eple.
   *
   * @param rne the code rne of the eple.
   */
  public void setRne(final String rne) {
    this.rne = rne;
  }

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
   * Gives the id of the department.
   *
   * @return the id of the department.
   */
  public Integer getDepartmentId() {
    return departmentId;
  }

  /**
   * Set the id of the department.
   *
   * @param departmentId the id of the department.
   */
  public void setDepartmentId(final Integer departmentId) {
    this.departmentId = departmentId;
  }

  /**
   * Gives the id of the city.
   *
   * @return the id of the city.
   */
  public Integer getCityId() {
    return cityId;
  }

  /**
   * Set the id of the city.
   *
   * @param cityId the id of the city.
   */
  public void setCityId(final Integer cityId) {
    this.cityId = cityId;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Eple{");
    sb.append("epleId=").append(epleId);
    sb.append(", rne='").append(rne).append('\'');
    sb.append(", epleName='").append(epleName).append('\'');
    sb.append(", departmentId=").append(departmentId);
    sb.append(", cityId=").append(cityId);
    sb.append('}');
    return sb.toString();
  }
}
