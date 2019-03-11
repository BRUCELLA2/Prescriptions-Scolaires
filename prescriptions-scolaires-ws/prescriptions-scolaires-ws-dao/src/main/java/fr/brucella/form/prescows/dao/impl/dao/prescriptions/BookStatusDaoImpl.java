package fr.brucella.form.prescows.dao.impl.dao.prescriptions;

import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.BookStatusDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.BookStatusRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.BookStatus;
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
 * BookStatus Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class BookStatusDaoImpl extends AbstractDao implements BookStatusDao {

  /** BookStatus DAO logger. */
  private static final Log LOG = LogFactory.getLog(BookStatusDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public BookStatusDaoImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public BookStatus getBookStatus(Integer bookStatusId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book_status WHERE book_status_id = :bookStatusId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookStatusId", bookStatusId);

    final RowMapper<BookStatus> bookStatusRowMapper = new BookStatusRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, bookStatusRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookStatusId = " + bookStatusId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookStatusDao.getBookStatus.notFound"), exception);
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
  public void updateBookStatus(BookStatus bookStatus) throws TechnicalException, NotFoundException {

    sql = "UPDATE book_status SET book_status_name = :bookStatusName WHERE book_status_id = :bookStatusId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookStatus);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookStatus = " + bookStatus.toString());
        }
        throw new NotFoundException(messages.getString("bookStatusDao.updateBookStatus.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookStatus : " + bookStatus.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookStatusDao.updateBookStatus.integrityViolation"), exception);
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
  public int insertBookStatus(BookStatus bookStatus) throws TechnicalException {

    sql = "INSERT INTO book_status (book_status_id, book_status_name) VALUES (DEFAULT, :bookStatusName)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookStatus);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{"book_status_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookStatus : " + bookStatus.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookStatusDao.insertBookStatus.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookStatus : " + bookStatus.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookStatusDao.insertBookStatus.integrityViolation"), exception);
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
  public void deleteBookStatus(Integer bookStatusId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM book_status WHERE book_status_id = : bookStatusId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookStatusId", bookStatusId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookStatusId = " + bookStatusId);
        }
        throw new NotFoundException(messages.getString("bookStatusDao.deleteBookStatus.notFound"));
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
        LOG.debug("bookStatusId = " + bookStatusId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
