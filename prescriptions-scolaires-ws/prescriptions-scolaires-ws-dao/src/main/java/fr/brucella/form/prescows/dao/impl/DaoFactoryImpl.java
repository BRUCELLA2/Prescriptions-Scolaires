package fr.brucella.form.prescows.dao.impl;

import fr.brucella.form.prescows.dao.contracts.dao.DaoFactory;
import fr.brucella.form.prescows.dao.contracts.dao.eples.CityDao;
import fr.brucella.form.prescows.dao.contracts.dao.eples.DepartmentDao;
import fr.brucella.form.prescows.dao.contracts.dao.eples.EpleDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.RoleDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.UserDao;
import fr.brucella.form.prescows.dao.contracts.dao.users.UserEpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
@Component
public class DaoFactoryImpl implements DaoFactory {

  /** Role Data Access Object. */
  @Autowired private RoleDao roleDao;

  /** User Data Access Object. */
  @Autowired private UserDao userDao;

  /** UserEple Data Access Object. */
  @Autowired private UserEpleDao userEpleDao;

  /** City Data Access Object. */
  @Autowired private CityDao cityDao;

  /** Department Data Access Object. */
  @Autowired private DepartmentDao departmentDao;

  /** Eple Data Access Object. */
  @Autowired private EpleDao epleDao;

  // ===== Constructor =====

  /** Default Constructor */
  public DaoFactoryImpl() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /** {@inheritDoc} */
  @Override
  public RoleDao getRoleDao() {
    return roleDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setRoleDao(final RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  /** {@inheritDoc} */
  @Override
  public UserDao getUserDao() {
    return userDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setUserDao(final UserDao userDao) {
    this.userDao = userDao;
  }

  /** {@inheritDoc} */
  @Override
  public UserEpleDao getUserEpleDao() {
    return userEpleDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setUserEpleDao(final UserEpleDao userEpleDao) {
    this.userEpleDao = userEpleDao;
  }

  /** {@inheritDoc} */
  @Override
  public CityDao getCity() {
    return cityDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setCityDao(final CityDao cityDao) {
    this.cityDao = cityDao;
  }

  /** {@inheritDoc} */
  @Override
  public DepartmentDao getDepartmentDao() {
    return departmentDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setDepartmentDao(final DepartmentDao departmentDao) {
    this.departmentDao = departmentDao;
  }

  /** {@inheritDoc} */
  @Override
  public EpleDao getEpleDao() {
    return epleDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setEpleDao(EpleDao epleDao) {
    this.epleDao = epleDao;
  }
}
