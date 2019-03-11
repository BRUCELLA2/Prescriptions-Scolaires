package fr.brucella.form.prescows.dao.impl.dao.prescriptions;

import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.ProcessingBookDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.ProcessingBookRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
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
import sun.security.krb5.internal.PAData;

/**
 * ProcessingBook Data Access Object.
 *
 * @author BRUCELLA2
 */
public class ProcessingBookDaoImpl extends AbstractDao implements ProcessingBookDao {


  /** ProcessingBook DAO logger. */
  private static final Log LOG = LogFactory.getLog(ProcessingBookDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public ProcessingBookDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public ProcessingBook getProcessingBook(final Integer userId, final Integer bookId)
      throws NotFoundException, TechnicalException {

    sql = "SELECT * FROM processing_book WHERE user_id = :userId AND book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("bookId", bookId);

    final RowMapper<ProcessingBook> processingBookRowMapper = new ProcessingBookRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, processingBookRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("processingBookDao.getProcessingBook.notFound"), exception);
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
  public void updateProcessingBook(ProcessingBook processingBook) throws TechnicalException, NotFoundException {

    sql = "UPDATE processing_book SET processing_status = :processingStatus WHERE user_id = :userId AND book_id = :bookId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(processingBook);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("processingBook = " + processingBook.toString());
        }
        throw new NotFoundException(messages.getString("processingBookDao.updateProcessingBook.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingBook : " + processingBook.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("processingBookDao.updateProcessingBook.integrityViolation"), exception);
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
  public void insertProcessingBook(ProcessingBook processingBook) throws TechnicalException {

    sql = "INSERT INTO processing_book (user_id, book_id, processing_status) VALUES (:userId, :bookId, :processingStatus)";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(processingBook);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource);
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingBook : " + processingBook.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("processingBookDao.insertProcessingBook.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("processingBook : " + processingBook.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("processingBookDao.insertProcessingBook.integrityViolation"), exception);
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
  public void deleteProcessingBook(Integer userId, Integer bookId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM processing_book WHERE user_id = :userId AND book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("bookId", bookId);


    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId = " + userId);
          LOG.debug("bookId = " + bookId);
        }
        throw new NotFoundException(messages.getString("processingBookDao.deleteProcessingBook.notFound"));
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
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
