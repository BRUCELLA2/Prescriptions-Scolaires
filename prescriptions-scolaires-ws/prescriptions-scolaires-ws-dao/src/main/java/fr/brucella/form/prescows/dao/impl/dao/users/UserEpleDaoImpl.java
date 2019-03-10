package fr.brucella.form.prescows.dao.impl.dao.users;

import fr.brucella.form.prescows.dao.contracts.dao.users.UserEpleDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.users.model.UserEpleRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.model.UserEple;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * UserEple Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class UserEpleDaoImpl extends AbstractDao implements UserEpleDao {

  /** UserEple DAO logger. */
  private static final Log LOG = LogFactory.getLog(RoleDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public UserEpleDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public List<UserEple> getUserEpleForUser(Integer userId) throws TechnicalException, NotFoundException {

    sql = "SELECT * from users_eple WHERE user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    final RowMapper<UserEple> userEpleRowMapper = new UserEpleRM();

    try {
      final List<UserEple> userEpleList = this.getNamedJdbcTemplate().query(sql, parameterSource, userEpleRowMapper);
      if(userEpleList.isEmpty()) {
        if(LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId : " + userId);
        }
        throw new NotFoundException("UserEpleDao.getUserEpleForUser.notFound");
      } else {
        return userEpleList;
      }
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
  public void insertUserEple(UserEple userEple) throws TechnicalException {

    sql = "INSERT INTO users_eple (user_id, eple_id) VALUES (:userId, :epleId)";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(userEple);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource);
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userEple : " + userEple.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("userEpleDaoImpl.insertUserEple.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userEple : " + userEple.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("userEpleDaoImpl.insertUserEple.integrityViolation"), exception);
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
  public void deleteUserEple(Integer userId, Integer epleId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM users_eple WHERE user_id = :userId AND eple_id = :epleId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("epleId", epleId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId : " + userId);
          LOG.debug("epleId : " + epleId);
        }
        throw new NotFoundException(messages.getString("userEpleDaoImpl.deleteUserEple.notFound"));
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
        LOG.debug("userId : " + userId);
        LOG.debug("epleId : " + epleId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
