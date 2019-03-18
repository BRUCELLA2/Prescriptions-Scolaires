package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Authentification Management Service.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AuthentificationService")
@Component
public class AuthentificationService extends SpringBeanAutowiringSupport {

  /** Authentification Management logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationService.class);

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired
  private ManagerFactory managerFactory;


  // ===== Constructor =====

  /** Default constructor. */
  public AuthentificationService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods =====

  /**
   * Check if login and password match and return the full user dto corresponding to this login.
   *
   * @param login login of the user.
   * @param password password of the user.
   * @return the full user dto corresponding to this login if login and password match. Return null
   *     otherwise.
   * @throws PrescoWsException Throw this exception if there is a technical problem or if login or
   *                           password is null or if password don't match with the login.
   */
  @WebMethod
  public UserDetailsDto login(final String login, final String password) throws PrescoWsException {

    if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
      LOG.error("Login ou password empty");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Le login ou le mot de passe est vide. Connexion impossible"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().getConnectUser(login, password);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Modify a user.
   *
   * @param userDetailsDto the full user dto with the modification.
   * @return true if password is correct and modification is done without problem, throws exception if not.
   * @throws PrescoWsException Throws this exception if there is technical problem.
   *                           This exception is throw if the UserDetailsDto is not valid (null or with invalid data).
   *                           This exception is throw if the password don't match with the user password stored in the datastore.
   */
  @WebMethod
  public Boolean modifyUser(final UserDetailsDto userDetailsDto) throws PrescoWsException {

    if(userDetailsDto == null) {
      LOG.error("fullUserDto null");
      throw new PrescoWsException(
          FUNC_ERROR,
          new PrescoWsFault(
              CLIENT, "L'utilisateur à modifier est vide. La modification n'a pu être faite"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().userModification(userDetailsDto);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }
}
