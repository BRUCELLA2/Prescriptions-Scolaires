package fr.brucella.form.prescows.dao.contracts.dao;

import fr.brucella.form.prescows.dao.contracts.dao.eples.CityDao;
import fr.brucella.form.prescows.dao.contracts.dao.eples.DepartmentDao;
import fr.brucella.form.prescows.dao.contracts.dao.eples.EpleDao;
import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.BookDao;
import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.BookStatusDao;
import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.ProcessingBookDao;
import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.ProcessingPrescriptionDao;
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

  /**
   * Gives the Department Data Access Object.
   *
   * @return the Department Data Access Object.
   */
  DepartmentDao getDepartmentDao();

  /**
   * Set the Department Data Access Object.
   *
   * @param departmentDao the Department Data Access Object.
   */
  void setDepartmentDao(final DepartmentDao departmentDao);

  /**
   * Gives the Eple Data Access Object.
   *
   * @return the Eple Data Access Object.
   */
  EpleDao getEpleDao();

  /**
   * Set the Eple Data Access Object.
   *
   * @param epleDao the Eple Data Access Object.
   */
  void setEpleDao(final EpleDao epleDao);

  /**
   * Gives the BookStatus Data Access Object.
   *
   * @return the BookStatus Data Access Object.
   */
  BookStatusDao getBookStatusDao();

  /**
   * Set the BookStatus Data Access Object.
   *
   * @param bookStatusDao the BookStatus Data Access Object.
   */
  void setBookStatusDao(final BookStatusDao bookStatusDao);

  /**
   * Gives the ProcessingBook Data Access Object.
   *
   * @return the ProcessingBook Data Access Object.
   */
  ProcessingBookDao getProcessingBookDao();

  /**
   * Set the ProcessingBook Data Access Object.
   *
   * @param processingBookDao the ProcessingBook Data Access Object.
   */
  void setProcessingBookDao(final ProcessingBookDao processingBookDao);

  /**
   * Gives the ProcessingPrescription Data Access Object.
   *
   * @return the ProcessingPrescription Data Access Object.
   */
  ProcessingPrescriptionDao getProcessingPrescriptionDao();

  /**
   * Set the ProcessingPrescription Data Access Object.
   *
   * @param processingPrescriptionDao the ProcessingPrescription Data Access Object.
   */
  void setProcessingPrescriptionDao(final ProcessingPrescriptionDao processingPrescriptionDao);

  /**
   * Gives the Book Data Access Object.
   *
   * @return the Book Data Access Object.
   */
  BookDao getBookDao();

  /**
   * Set the Book Data Access Object.
   *
   * @param bookDao the Book Data Access Object.
   */
  void setBookDao(final BookDao bookDao);
}
