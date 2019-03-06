package fr.brucella.form.prescows.entity.eples.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a city.
 *
 * @author BRUCELLA2
 */
public class City {

  /** id of the city. */
  private Integer cityId;

  /** code zip of the city. */
  @NotEmpty(message = "{city.zipcode.empty}")
  @Size(min = 5, max = 5, message = "{city.zipCode.size}")
  private String zipCode;

  /** name of the city. */
  @NotEmpty(message = "{city.name.empty}")
  @Size(min = 1, max = 100, message = "{city.name.size}")
  private String cityName;

  /** id of the department. */
  @NotNull(message = "{city.departmentId.null}")
  private Integer departmentId;


  // ===== Constructor =====

  /** Default Constructor */
  public City() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Give the id of the city.
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

  /**
   * Give the zip code of the city.
   *
   * @return the zip code of the city.
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Set the zip code of the city.
   *
   * @param zipCode the zip code of the city.
   */
  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * Give the name of the city.
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
   * Give the id of the department.
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


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("City{");
    sb.append("cityId=").append(cityId);
    sb.append(", zipCode='").append(zipCode).append('\'');
    sb.append(", cityName='").append(cityName).append('\'');
    sb.append(", departmentId=").append(departmentId);
    sb.append('}');
    return sb.toString();
  }
}
