package fr.brucella.form.prescows.dao.contracts.dao.users;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.model.Role;

/**
 * Interface for Role Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface RoleDao {

  /**
   * Gives the role with the specified id from the datastore.
   *
   * @param roleId id of the role.
   * @return the role with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the role is not found.
   */
  Role getRole(final Integer roleId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing role in the datastore.
   *
   * @param role the role with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the role is not found.
   */
  void updateRole(final Role role) throws TechnicalException, NotFoundException;

  /**
   * Insert a new role in the datastore.
   *
   * @param role the role to insert in datastore.
   * @return the id of the new role.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertRole(final Role role) throws TechnicalException;

  /**
   * Delete the role with the specified id in the datastore.
   *
   * @param roleId id of the role.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the role is not found.
   */
  void deleteRole(final Integer roleId) throws TechnicalException, NotFoundException;
}
