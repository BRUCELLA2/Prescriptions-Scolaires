package fr.brucella.form.prescows.entity.searchcriteria.dto;

import java.time.LocalDateTime;

/**
 * Represents the searching criteria used by users.
 *
 * @author BRUCELLA2
 */
public class SearchCriteriaDto {

  /** id of the department. **/
  private Integer departmentId;

  /** id of the city. **/
  private Integer cityId;

  /** rne of an eple. **/
  private String rne;

  /** Deadline date for book purchase. */
  private LocalDateTime purchaseDeadline;

  /** indicate if the item search is process or not */
  private Boolean processing;


  // ===== Constructor =====

  /** Default Constructor */
  public SearchCriteriaDto() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

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

  /**
   * Gives the rne of the eple.
   *
   * @return the rne of the eple.
   */
  public String getRne() {
    return rne;
  }

  /**
   * Set the rne of the eple.
   *
   * @param rne the rne of the eple.
   */
  public void setRne(final String rne) {
    this.rne = rne;
  }

  /**
   * Gives the purchase deadline.
   *
   * @return the purchase deadline.
   */
  public LocalDateTime getPurchaseDeadline() {
    return purchaseDeadline;
  }

  /**
   * Set the purchase deadline.
   *
   * @param purchaseDeadline the purchase deadline.
   */
  public void setPurchaseDeadline(final LocalDateTime purchaseDeadline) {
    this.purchaseDeadline = purchaseDeadline;
  }

  /**
   * Indicates if the seach item is processed.
   *
   * @return Indicates if the seach item is processed.
   */
  public Boolean getProcessing() {
    return processing;
  }

  /**
   * Set if the seach item is processed.
   *
   * @param processing if the seach item is processed.
   */
  public void setProcessing(Boolean processing) {
    this.processing = processing;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("SearchCriteriaDto{");
    sb.append("departmentId=").append(departmentId);
    sb.append(", cityId=").append(cityId);
    sb.append(", rne='").append(rne).append('\'');
    sb.append(", purchaseDeadline=").append(purchaseDeadline);
    sb.append(", processing=").append(processing);
    sb.append('}');
    return sb.toString();
  }
}
