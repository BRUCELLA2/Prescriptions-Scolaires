package fr.brucella.form.prescows.entity.users.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a role which can be give to user.
 *
 * @author BRUCELLA2
 */
public class Role {


  /** id of the role. */
  private Integer roleId;

  /** Name of the role. Can't be empty. Max size is 15 characters */
  @NotEmpty(message = "{role.roleName.empty}")
  @Size(min = 1, max = 15, message = "{role.roleName.size}")
  private String roleName;

  // ===== Constructor =====

  /** Default Constructor */
  public Role() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Gives the role id  of the role.
   *
   * @return the role id of the role.
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * Set the role id of the role.
   *
   * @param roleId the role id of the role.
   */
  public void setRoleId(final Integer roleId) {
    this.roleId = roleId;
  }

  /**
   * Gives the name of the role.
   *
   * @return the name of the role.
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * Set the name of the role.
   *
   * @param roleName the name of the role.
   */
  public void setRoleName(final String roleName) {
    this.roleName = roleName;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Role{");
    sb.append("roleId=").append(roleId);
    sb.append(", roleName='").append(roleName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
