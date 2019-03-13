package fr.brucella.form.prescows.dao.impl.dao.users;

import fr.brucella.form.prescows.dao.contracts.dao.users.UserDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.eples.model.EpleRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.users.dto.UserDetailsDtoRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.users.model.UserRM;
import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import fr.brucella.form.prescows.entity.users.model.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * User Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class UserDaoImpl extends AbstractDao implements UserDao {


  /** Author DAO logger. */
  private static final Log LOG = LogFactory.getLog(UserDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public UserDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public User getUser(final Integer userId) throws TechnicalException, NotFoundException {
    sql = "SELECT * FROM users WHERE user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    final RowMapper<User> rowMapper = new UserRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("UserDao.getUser.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public UserDetailsDto getUserByLogin(final String login) throws TechnicalException, NotFoundException {
    sql = "SELECT users.user_id, users.login, users.password, users.last_name, users.first_name, users.email, users.role_id, role.role_name FROM users INNER JOIN role ON users.role_id = role.role_id WHERE users.login = :login";

    final MapSqlParameterSource userParameterSource = new MapSqlParameterSource();
    userParameterSource.addValue("login", login);

    final RowMapper<UserDetailsDto> userDetailsDtoRowMapper = new UserDetailsDtoRM();
    UserDetailsDto userDetailsDto;
    try {
      userDetailsDto = this.getNamedJdbcTemplate().queryForObject(sql, userParameterSource, userDetailsDtoRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("login = " + login);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("UserDao.getUserByLogin.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }

    // Get eples informations

    sql = "select * from eple inner join users_eple on users_eple.eple_id = eple.eple_id inner join users ON users.user_id = users_eple.user_id WHERE users.user_id = :userId;";

    final MapSqlParameterSource eplesParameterSource = new MapSqlParameterSource();
    eplesParameterSource.addValue("userId", userDetailsDto.getUserId());

    final RowMapper<Eple> epleRowMapper = new EpleRM();

    try {
      List<Eple> epleList = getNamedJdbcTemplate().query(sql, eplesParameterSource, epleRowMapper);
      if(epleList.isEmpty()) {
        epleList = new ArrayList<>();
      }
      userDetailsDto.setEpleList(epleList);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }

    return userDetailsDto;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean loginAvailable(final String login) throws TechnicalException {

    sql = "SELECT COUNT(login) FROM users WHERE login = :login";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("login", login);

    int count = 0;
    try {
      count = getNamedJdbcTemplate().queryForObject(sql, parameterSource, Integer.class);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }

    return count == 0;
  }

  /** {@inheritDoc} */
  @Override
  public void updateUser(final User user) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE users SET password = :password, email = :email, login = :login, phone = :phone, address_id = :addressId, user_options_id = :userOptionsId WHERE user_id = :userId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("user = " + user.toString());
        }
        throw new NotFoundException(messages.getString("UserDao.updateUser.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("UserDao.updateUser.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertUser(final User user) throws TechnicalException {

    sql =
        "INSERT INTO users (user_id, login, password, last_name, first_name, email, role_id) VALUES (DEFAULT, :login, :password, :lastName, :firstName, :email, :roleId)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[] {"user_id"});
      return keyHolder.getKey().intValue();

    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("userDao.insertUser.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("userDao.insertUser.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteUser(final Integer userId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM users WHERE user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId = " + userId);
        }
        throw new NotFoundException(messages.getString("userDao.deleteUser.notFound"));
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
