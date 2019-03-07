package fr.brucella.form.prescows.entity.users.dto;

import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.users.model.User;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a UserDetail Data Transfert Object.
 * Includes all informations about the user.
 * Includes the role name and the list of eple associated to the user.
 *
 * @author BRUCELLA2
 */
public class UserDetailsDto extends User {

  /** Name of the role. Can't be empty. Max size is 15 characters */
  @NotEmpty(message = "{role.roleName.empty}")
  @Size(min = 1, max = 15, message = "{role.roleName.size}")
  private String roleName;

  /** List of the eple associated to user. */
  private List<Eple> epleList;


  // ===== Constructor =====

  /** Default Constructor */
  public UserDetailsDto() {
    super();
  }


  // ===== Getters and Setters =====

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

  /**
   * Gives the list of the eple associated to the user.
   *
   * @return the list of the eple associated to the user.
   */
  public List<Eple> getEpleList() {
    return epleList;
  }

  /**
   * Set the list of the eple associated to the user.
   *
   * @param epleList the list of the eple associated to the user.
   */
  public void setEpleList(final List<Eple> epleList) {
    this.epleList = epleList;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("UserDetailsDto{");
    sb.append("roleName='").append(roleName).append('\'');
    sb.append(", epleList=").append(epleList);
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }


}
