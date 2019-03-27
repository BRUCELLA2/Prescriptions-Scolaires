package fr.brucella.form.prescoweb.enseignants.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.AuthentificationService;
import generated.authentificationserviceclient.AuthentificationService_Service;
import generated.authentificationserviceclient.PrescoWsException_Exception;
import generated.authentificationserviceclient.UserDetailsDto;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * User actions.
 *
 * @author BRUCELLA2
 */
public class UserAction extends ActionSupport implements SessionAware, ServletRequestAware {

  /** User Action logger */
  private static final Log LOG = LogFactory.getLog(UserAction.class);

  /** Login of the user. Max size is 30 characters. */
  private String userLogin;

  /** Password of the user. Max size is 100 characters. */
  private String userPass;

  /** the user password confirmation. Max size is 100 characters. */
  private String userPassConf;

  /** First name of the user. Max size is 50 characters. */
  private String firstName;

  /** Last name of the user. Max size is 50 characters. */
  private String lastName;

  /** Email of the user. Max size is 100 characters. */
  private String userEmail;

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;

  // ----- Constructors

  /** Default constructor. */
  public UserAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ----- Getters and Setters

  /**
   * Give the login of the user. Max size is 30 characters.
   *
   * @return the login of the user.
   */
  public String getUserLogin() {
    return this.userLogin;
  }

  /**
   * Set the login of the user. Max size is 30 characters.
   *
   * @param userLogin the login of the user.
   */
  public void setUserLogin(final String userLogin) {
    this.userLogin = userLogin;
  }

  /**
   * Give the user password. Max size is 100 characters.
   *
   * @return the password of the user.
   */
  public String getUserPass() {
    return this.userPass;
  }

  /**
   * Set the user password. Max size is 100 characters.
   *
   * @param userPass the password of the user.
   */
  public void setUserPass(final String userPass) {
    this.userPass = userPass;
  }

  /**
   * Give the user password confirmation. Max size is 100 characters.
   *
   * @return the user password confirmation. Max size is 100 characters.
   */
  public String getUserPassConf() {
    return this.userPassConf;
  }

  /**
   * Set the user password confirmation. Max size is 100 characters.
   *
   * @param userPassConf the user password confirmation. Max size is 100 characters.
   */
  public void setUserPassConf(final String userPassConf) {
    this.userPassConf = userPassConf;
  }

  /**
   * Give the first name of the user. Max size is 50 characters.
   *
   * @return the first name of the user. Max size is 50 characters.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Set the first name of the user. Max size is 50 characters.
   *
   * @param firstName the first name of the user. Max size is 50 characters.
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Give the last name of the user. Max size is 50 characters.
   *
   * @return the last name of the user. Max size is 50 characters.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Set the last name of the user. Max size is 50 characters.
   *
   * @param lastName the last name of the user. Max size is 50 characters.
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Give the user email. Max size is 100 characters.
   *
   * @return the user email.
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Set the user email. Max size is 100 characters.
   *
   * @param userEmail the user email.
   */
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }

  // ===== Methods =====

  /**
   * Connect a user. After login, user is add to session.
   *
   * @return ERROR if error occurred. INPUT if the login and password are null or empty or if the
   *     login and password don't match. SUCCESS otherwise.
   */
  public String doLogin() {

    if (StringUtils.isAllEmpty(this.userLogin, this.userPass)) {
      return Action.INPUT;
    }

    if (StringUtils.isEmpty(this.userLogin)) {
      this.addFieldError("userLogin", "L'identifiant doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPass)) {
      this.addFieldError("userPass", "Le mot de passe doit être renseigné");
    }

    if (this.hasActionErrors()) {
      return Action.INPUT;
    }

    final AuthentificationService_Service authentificationService =
        new AuthentificationService_Service();
    final AuthentificationService authentificationServicePort =
        authentificationService.getAuthentificationServicePort();

    try {
      final UserDetailsDto user = authentificationServicePort.login(this.userLogin, this.userPass);
      if (user == null) {
        this.addFieldError(
            "userLogin",
            "L'identifiant et/ou le mot de passe sont incorrects - La connexion n'a pu être réalisée");
        this.addFieldError(
            "userPass",
            "L'identifiant et/ou le mot de passe sont incorrects - La connexion n'a pu être réalisée");
        return Action.INPUT;
      } else {
        this.session.put("userLog", user);
      }
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Log out the user. Session is invalidate.
   *
   * @return SUCCESS
   */
  public String doLogout() {
    this.servletRequest.getSession().invalidate();
    return Action.SUCCESS;
  }

  /**
   * Modify an user account.
   *
   * @return ERROR if error occurred.
   *         INPUT if the input information needed are empty or null.
   *         SUCCESS otherwise.
   */
  public String doModification() {

    UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");

    if(StringUtils.isAllEmpty(this.userPass, this.firstName, this.lastName, this.userEmail, this.userPassConf)) {
      this.firstName = userDetailsDto.getFirstName();
      this.lastName = userDetailsDto.getLastName();
      this.userEmail = userDetailsDto.getEmail();
    }

    if (StringUtils.isEmpty(this.userPass)) {
      this.addFieldError("userPass", "Le mot de passe doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPassConf)) {
      this.addFieldError("userPassConf", "La confirmation du mot de passe doit être renseignée");
    }

    if(StringUtils.isEmpty(this.firstName)) {
      this.addFieldError("firstName", "Le prénom doit être renseigné");
    }

    if(StringUtils.isEmpty(this.lastName)) {
      this.addFieldError("lastName", "Le nom de famille doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userEmail)) {
      this.addFieldError("userEmail", "L'email doit être renseigné");
    }

    if (!StringUtils.equals(this.userPass, this.userPassConf)) {
      this.addFieldError(
          "userPassConf", "la confirmation du mot de passe ne correspond pas au mot de passe");
    }

    if (this.hasFieldErrors()) {
      return Action.INPUT;
    }

    userDetailsDto.setFirstName(this.firstName);
    userDetailsDto.setLastName(this.lastName);
    userDetailsDto.setEmail(this.userEmail);
    userDetailsDto.setPassword(this.userPass);

    final AuthentificationService_Service authentificationService = new AuthentificationService_Service();
    final AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();

    try {
      authentificationServicePort.modifyUser(userDetailsDto);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }
}
