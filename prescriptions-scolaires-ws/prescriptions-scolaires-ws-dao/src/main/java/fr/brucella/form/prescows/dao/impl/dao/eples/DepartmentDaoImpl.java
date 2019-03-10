package fr.brucella.form.prescows.dao.impl.dao.eples;

import fr.brucella.form.prescows.dao.contracts.dao.eples.DepartmentDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.eples.model.DepartmentRM;
import fr.brucella.form.prescows.entity.eples.model.Department;
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
import org.springframework.stereotype.Component;

/**
 * Department Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class DepartmentDaoImpl extends AbstractDao implements DepartmentDao {

  /** Department DAO logger. */
  private static final Log LOG = LogFactory.getLog(DepartmentDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public DepartmentDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Department getDepartment(final Integer departmentId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM department WHERE department_id = :departmentId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("departmentId", departmentId);

    final RowMapper<Department> departmentRowMapper = new DepartmentRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, departmentRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("departmentId = " + departmentId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("departmentDao.getDepartment.notFound"), exception);
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
  public void updateDepartment(final Department department) throws TechnicalException, NotFoundException {

    sql = "UPDATE department SET code = :code, department_name = :departmentName WHERE department_id = departmentId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("department = " + department.toString());
        }
        throw new NotFoundException(messages.getString("departmentDao.updateDepartment.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("department : " + department.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("departmentDao.updateDepartment.integrityViolation"), exception);
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
  public int insertDepartment(final Department department) throws TechnicalException {

    sql = "INSERT INTO department (department_id, code, department_name) VALUES (DEFAULT, :code, :departmentName)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{"department_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("department : " + department.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("departmentDao.insertDepartment.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("department : " + department.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("departmentDao.insertDepartment.integrityViolation"), exception);
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
  public void deleteDepartment(final Integer departmentId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM department WHERE department_id = :departmentId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("departmentId", departmentId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("departmentId = " + departmentId);
        }
        throw new NotFoundException(messages.getString("departmentDao.deleteDepartment.notFound"));
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
        LOG.debug("departmentId = " + departmentId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
