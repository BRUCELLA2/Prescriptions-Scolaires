package fr.brucella.form.prescows.dao.contracts.dao.users;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.model.UserEple;
import java.util.List;

/**
 * Interface for UserEple Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface UserEpleDao {

  /**
   * Gives the list of Eple for the user with the specified id from the datastore.
   *
   * @param userId id of the user.
   * @return the list of Eple for the user with the specified id from the datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no UserEple found.
   */
  List<UserEple> getUserEpleForUser(final Integer userId) throws TechnicalException, NotFoundException;

  /**
   * Insert a new userEple in the datastore.
   *
   * @param userEple the userEple to insert in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  void insertUserEple(final UserEple userEple) throws TechnicalException;

  /**
   * Delete the userEple with the specified userId and epleId in the datastore.
   *
   * @param userId id of the user.
   * @param epleId id of the eple.
   * @throws TechnicalException - the userEple to insert in datastore.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the userEple is not found.
   */
  void deleteUserEple(final Integer userId, final Integer epleId) throws TechnicalException, NotFoundException;
}

