package fr.brucella.form.prescows.dao.impl.dao.eples;

import fr.brucella.form.prescows.dao.contracts.dao.eples.EpleDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.eples.model.EpleRM;
import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
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

/**
 * Eple Data Access Object.
 *
 * @author BRUCELLA2
 */
public class EpleDaoImpl extends AbstractDao implements EpleDao {



  /** Eple DAO logger. */
  private static final Log LOG = LogFactory.getLog(EpleDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public EpleDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Eple getEple(Integer epleId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM eple WHERE eple_id = :epleId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("epleId", epleId);

    final RowMapper<Eple> epleRowMapper = new EpleRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, epleRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("epleId = " + epleId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("epleDao.getEple.notFound"), exception);
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
  public void updateEple(Eple eple) throws TechnicalException, NotFoundException {

    sql = "UPDATE eple SET rne = :rne, department_id = :departmentId, city_id = :cityId, eple_name = :epleName WHERE eple_id = :epleId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(eple);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("eple = " + eple.toString());
        }
        throw new NotFoundException(messages.getString("epleDao.updateEple.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("eple : " + eple.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("epleDao.updateEple.integrityViolation"), exception);
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
  public int insertEple(Eple eple) throws TechnicalException {

    sql = "INSERT INTO eple (eple_id, rne, department_id, city_id, eple_name) VALUES (DEFAULT, :rne, :departmentId, :cityId, :epleName)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(eple);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{"eple_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("eple : " + eple.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("epleDao.insertEple.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("eple : " + eple.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("epleDao.insertEple.integrityViolation"), exception);
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
  public void deleteEple(Integer epleId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM eple WHERE eple_id = :epleId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("epleId", epleId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("epleId = " + epleId);
        }
        throw new NotFoundException(messages.getString("epleDao.deleteEple.notFound"));
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
        LOG.debug("epleId = " + epleId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
