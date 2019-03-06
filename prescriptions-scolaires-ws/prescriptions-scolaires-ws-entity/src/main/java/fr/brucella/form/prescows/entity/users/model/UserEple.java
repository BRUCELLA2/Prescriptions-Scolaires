package fr.brucella.form.prescows.entity.users.model;

import javax.validation.constraints.NotNull;

/**
 * Represents the association of user and eple.
 *
 * @author BRUCELLA2
 */
public class UserEple {

  /** id of the user. Can't be null. */
  @NotNull(message = "{userEple.userId.null}")
  private Integer userId;

  /** id of the eple. Can't be null. */
  @NotNull(message = "{userEple.epleId.null}")
  private Integer epleId;


  // ===== Constructor =====

  /** Default Constructor */
  public UserEple() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====


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
    final StringBuilder sb = new StringBuilder("UserEple{");
    sb.append("userId=").append(userId);
    sb.append(", epleId=").append(epleId);
    sb.append('}');
    return sb.toString();
  }
}
