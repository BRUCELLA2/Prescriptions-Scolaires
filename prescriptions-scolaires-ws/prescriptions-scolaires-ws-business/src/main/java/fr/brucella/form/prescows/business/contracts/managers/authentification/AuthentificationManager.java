package fr.brucella.form.prescows.business.contracts.managers.authentification;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;

/**
 * Interface for Authentification Manager
 *
 * @author BRUCELLA2
 */
public interface AuthentificationManager {

  /**
   * Gives user details DTO authentified by login and password.
   * If login and password don't match, this method return null.
   *
   * @param login the login of the user.
   * @param password password of the user.
   * @return the UserDetailsDto
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the login or the password are not
   *     valid.
   */
  UserDetailsDto getConnectUser(final String login, final String password)
      throws TechnicalException, FunctionalException;
}
