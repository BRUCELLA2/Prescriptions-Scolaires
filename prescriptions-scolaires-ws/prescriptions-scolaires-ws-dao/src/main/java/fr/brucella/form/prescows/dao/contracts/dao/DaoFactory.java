package fr.brucella.form.prescows.dao.contracts.dao;

import fr.brucella.form.prescows.dao.contracts.dao.eples.CityDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.RoleDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.UserDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.UserEpleDao;

/**
 * Interface for the Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
public interface DaoFactory {

  /**
   * Gives the Role Data Access Object.
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

  /**
   * Gives the User Data Access Object.
   *
   * @return the User Data Access Object.
   */
  UserDao getUserDao();

  /**
   * Set the User Data Access Object.
   *
   * @param userDao the User Data Access Object.
   */
  void setUserDao(final UserDao userDao);

  /**
   * Gives the UserEple Data Access Object.
   *
   * @return the UserEple Data Access Object.
   */
  UserEpleDao getUserEpleDao();

  /**
   * Set the UserEple Data Access Object.
   *
   * @param userEpleDao the UserEple Data Access Object.
   */
  void setUserEpleDao(final UserEpleDao userEpleDao);

  /**
   * Gives the City Data Access Object.
   *
   * @return  the City Data Access Object.
   */
  CityDao getCity();

  /**
   * Set the City Data Access Object.
   *
   * @param cityDao the City Data Access Object.
   */
  void setCityDao(final CityDao cityDao);
}
