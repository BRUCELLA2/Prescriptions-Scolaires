package fr.brucella.form.prescows.dao.impl;

import fr.brucella.form.prescows.dao.contracts.dao.DaoFactory;
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
}
