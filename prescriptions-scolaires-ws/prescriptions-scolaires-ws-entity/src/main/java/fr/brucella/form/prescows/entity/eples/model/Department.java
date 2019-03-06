package fr.brucella.form.prescows.entity.eples.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents an department.
 *
 * @author BRUCELLA2
 */
public class Department {

  /** id of the department. */
  private Integer departmentId;

  /** code of the department. */
  @NotEmpty(message = "{department.code.empty}")
  @Size(min = 3, max = 3, message = "{department.code.size}")
  private String code;

  /** name of the department. */
  @NotEmpty(message = "{department.departmentName.empty}")
  @Size(min = 1, max = 50, message = "{department.departmentName.size}")
  private String departmentName;


  // ===== Constructor =====

  /** Default Constructor */
  public Department() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

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
  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  /**
   * Give the code of the department.
   *
   * @return the code of the department.
   */
  public String getCode() {
    return code;
  }

  /**
   * Set the code of the department.
   *
   * @param code the code of the department.
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   * Give the name of the department.
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
  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Department{");
    sb.append("departmentId=").append(departmentId);
    sb.append(", code='").append(code).append('\'');
    sb.append(", departmentName='").append(departmentName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
