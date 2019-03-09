package fr.brucella.form.prescows.dao.contracts.dao;

import fr.brucella.form.prescows.dao.contracts.dao.users.RoleDao;

/**
 * Interface for the Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
public interface DaoFactory {

  /**
   * Give the Role Data Access Object.
   *
   * @return the Role Data Access Object.
   */
  RoleDao getRoleDao();

  /**
   * Set the Role Data Access Object.
   *
   * @param roleDao the Role Data Access Object.
   */
  void setRoleDao(final RoleDao roleDao);

}
