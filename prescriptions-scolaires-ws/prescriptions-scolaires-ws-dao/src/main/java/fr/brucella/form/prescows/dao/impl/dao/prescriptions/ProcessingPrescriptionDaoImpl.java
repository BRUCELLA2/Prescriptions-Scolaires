package fr.brucella.form.prescows.dao.impl.dao.prescriptions;

import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.ProcessingPrescriptionDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.ProcessingPrescriptionRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;
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
import org.springframework.stereotype.Component;

/**
 * ProcessingPrescription Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class ProcessingPrescriptionDaoImpl extends AbstractDao implements ProcessingPrescriptionDao {

  /** ProcessingPrescription DAO logger. */
  private static final Log LOG = LogFactory.getLog(ProcessingPrescriptionDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public ProcessingPrescriptionDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public ProcessingPrescription getProcessingPrescription(final Integer userId, final Integer prescriptionId)
      throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM processing_prescription WHERE user_id = :userId AND prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("prescriptionId", prescriptionId);

    final RowMapper<ProcessingPrescription> processingPrescriptionRowMapper = new ProcessingPrescriptionRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, processingPrescriptionRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
        LOG.debug("prescriptionId = " + prescriptionId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("processingPrescriptionDao.getProcessingPrescription.notFound"), exception);
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
  public void updateProcessingPrescription(final ProcessingPrescription processingPrescription)
      throws TechnicalException, NotFoundException {

    sql ="UPDATE processing_prescription SET processing_status = :processingStatus WHERE user_id = :userId AND prescription_id = :prescriptionId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(processingPrescription);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("processingPrescription = " + processingPrescription.toString());
        }
        throw new NotFoundException(messages.getString("processingPrescriptionDao.updateProcessingPrescription.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingPrescription : " + processingPrescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("processingPrescriptionDao.updateProcessingPrescription.integrityViolation"), exception);
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
  public void insertProcessingPrescription(ProcessingPrescription processingPrescription) throws TechnicalException {

    sql = "INSERT INTO processing_prescription (user_id, prescription_id, processing_status) VALUES (:userId, :prescriptionId, :processingStatus)";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(processingPrescription);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource);
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingPrescription : " + processingPrescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("processingPrescriptionDao.insertProcessingPrescription.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingPrescription : " + processingPrescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("processingPrescriptionDao.insertProcessingPrescription.integrityViolation"), exception);
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
  public void deleteProcessingPrescription(Integer userId, Integer prescriptionId)
      throws TechnicalException, NotFoundException {

    sql = "DELETE FROM processing_prescription WHERE user_id = :userId AND prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("prescriptionId", prescriptionId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId = " + userId);
          LOG.debug("prescriptionId = " + prescriptionId);
        }
        throw new NotFoundException(messages.getString("processingPrescriptionDao.deleteProcessingPrescription.notFound"));
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
        LOG.debug("prescriptionId = " + prescriptionId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
