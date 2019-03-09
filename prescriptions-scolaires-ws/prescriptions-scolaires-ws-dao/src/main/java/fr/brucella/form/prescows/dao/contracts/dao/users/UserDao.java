package fr.brucella.form.prescows.dao.contracts.dao.users;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import fr.brucella.form.prescows.entity.users.model.User;

/**
 * Interface for user Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface UserDao {

  /**
   * Give the user with the specified id from the datastore.
   *
   * @param userId id of the user.
   * @return the user with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  User getUser(final Integer userId) throws TechnicalException, NotFoundException;

  /**
   * Give the full user dto with the specified login from the datastore.
   *
   * @param login login of the user.
   * @return the user details dto with the specified login.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  UserDetailsDto getUserByLogin(final String login) throws TechnicalException, NotFoundException;

  /**
   * Check if the login is not used.
   *
   * @param login the login.
   * @return true if the login is not used. False, if the login is already used.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  Boolean loginAvailable(final String login) throws TechnicalException;

  /**
   * Update an existing user in the database.
   *
   * @param user the user with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  void updateUser(final User user) throws TechnicalException, NotFoundException;

  /**
   * Insert a new user in the datastore.
   *
   * @param user the user to insert in datastore.
   * @return the id of the new user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertUser(final User user) throws TechnicalException;

  /**
   * Delete the user with the specified id in the datastore.
   *
   * @param userId id of the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  void deleteUser(final Integer userId) throws TechnicalException, NotFoundException;
}
