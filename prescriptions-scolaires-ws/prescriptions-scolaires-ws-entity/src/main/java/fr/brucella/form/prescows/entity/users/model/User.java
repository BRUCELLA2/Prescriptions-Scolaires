package fr.brucella.form.prescows.entity.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a User.
 *
 * @author BRUCELLA2
 */
public class User {

  /** id of the user. */
  private Integer userId;

  /** login of the user. Can't be empty. Max size is 30 characters. */
  @NotEmpty(message = "{user.login.empty}")
  @Size(min = 1, max = 30, message = "{user.login.size}")
  private String login;

  /** password of the user. Can't be empty. Max size is 100 characters after encryption */
  @NotEmpty(message = "{user.password.empty}")
  @Size(max = 100, message = "{user.password.size}")
  private String password;

  /** Last name of the user. Can't be empty. Max size is 50 characters. */
  @NotEmpty(message = "{user.lastName.empty}")
  @Size(min = 1, max = 50, message = "{user.lastName.size}")
  private String lastName;

  /** First name of the user. Can't be empty. Max size is 50 characters. */
  @NotEmpty(message = "{user.firstName.empty")
  @Size(min = 1, max = 50, message = "{user.firstName.size}")
  private String firstName;

  /** Email of the user. Can't be empty. Max size is 100 characters. */
  @NotEmpty(message = "{user.email.empty}")
  @Size(max = 100, message = "{user.email.size}")
  @Email(message = "{user.email.format}")
  private String email;

  /** id of the {@link Role} of the user. Can't be null. */
  @NotNull(message = "{user.role.null}")
  private Integer roleId;


  // ===== Constructor =====

  /** Default Constructor */
  public User() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Gives the id of the user.
   *
   * @return id of the user.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the id of the user.
   *
   * @param userId id of the user.
   */
  public void setUserId(final Integer userId) {
    this.userId = userId;
  }

  /**
   * Gives the login of the user.
   *
   * @return the login of the user.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Set the login of the user.
   *
   * @param login the login of the user.
   */
  public void setLogin(final String login) {
    this.login = login;
  }

  /**
   * Gives the password of the user.
   *
   * @return the password of the user.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the password of the user.
   *
   * @param password the password of the user.
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Gives the last name of the user.
   *
   * @return the last name of the user.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the user.
   *
   * @param lastName the last name of the user.
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gives the first name of the user.
   *
   * @return the first name of the user.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the user.
   *
   * @param firstName the first name of the user.
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gives the email of the user.
   *
   * @return the email of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email of the user.
   *
   * @param email the email of the user.
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Gives the role id of the user.
   *
   * @return the role id of the user.
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * Set the role id of the user.
   *
   * @param roleId the role id of the user.
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("userId=").append(userId);
    sb.append(", login='").append(login).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", roleId=").append(roleId);
    sb.append('}');
    return sb.toString();
  }
}
