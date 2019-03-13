package fr.brucella.form.prescows.dao.impl.dao.prescriptions;

import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.PrescriptionDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto.PrescriptionWithEpleNameDtoRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.PrescriptionRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
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
 * Prescription Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class PrescriptionDaoImpl extends AbstractDao implements PrescriptionDao {


  /** Prescription DAO logger. */
  private static final Log LOG = LogFactory.getLog(PrescriptionDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public PrescriptionDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Prescription getPrescription(final Integer prescriptionId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM prescription WHERE prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("prescriptionId", prescriptionId);

    final RowMapper<Prescription> prescriptionRowMapper = new PrescriptionRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, prescriptionRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("prescriptionId = " + prescriptionId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("prescriptionDao.getPrescription.notFound"), exception);
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
  public List<PrescriptionWithEpleNameDto> getPrescriptionWithEpleNameDtoList(final Integer userId)
      throws TechnicalException {

    sql = "SELECT prescription.prescription_id, prescription.prescription_name, prescription.creation_date, prescription.user_id, prescription.purchase_deadline, prescription.validation_status, prescription.eple_id, eple.eple_name FROM prescription INNER JOIN eple ON prescription.eple_id = eple.eple_id WHERE prescription.user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    final RowMapper<PrescriptionWithEpleNameDto> prescriptionWithEpleNameDtoRowMapper = new PrescriptionWithEpleNameDtoRM();

    try {
      List<PrescriptionWithEpleNameDto> prescriptionWithEpleNameDtoList = getNamedJdbcTemplate().query(sql, parameterSource, prescriptionWithEpleNameDtoRowMapper);
      if(prescriptionWithEpleNameDtoList.isEmpty()) {
        prescriptionWithEpleNameDtoList = new ArrayList<>();
      }
      return prescriptionWithEpleNameDtoList;
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
  public void updatePrescription(final Prescription prescription) throws TechnicalException, NotFoundException {

    sql = "UPDATE prescription SET prescription_name = :prescriptionName, creation_date = :creationDate, user_id = :userId, purchase_deadline = :purchaseDeadline, validation_status = :validationStatus, eple_id = :epleId WHERE prescription_id = :prescriptionId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(prescription);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("prescription = " + prescription.toString());
        }
        throw new NotFoundException(messages.getString("prescriptionDao.updatePrescription.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("prescription : " + prescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("prescriptionDao.updatePrescription.integrityViolation"), exception);
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
  public int insertPrescription(final Prescription prescription) throws TechnicalException {

    sql = "INSERT INTO prescription (prescription_id, prescription_name, creation_date, user_id, purchase_deadline, validation_status, eple_id) VALUES (DEFAULT, :prescriptionName, :creationDate, :userId, :purchaseDeadline, :validationStatus, :epleId)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(prescription);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{"prescription_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("prescription : " + prescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("prescriptionDao.insertPrescription.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("prescription : " + prescription.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("prescriptionDao.insertPrescription.integrityViolation"), exception);
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
  public void deletePrescription(final Integer prescriptionId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM prescription WHERE prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("prescriptionId", prescriptionId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("prescriptionId = " + prescriptionId);
        }
        throw new NotFoundException(messages.getString("prescriptionDao.deletePrescription.notFound"));
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
        LOG.debug("prescriptionId = " + prescriptionId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

}
