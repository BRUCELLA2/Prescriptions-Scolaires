package fr.brucella.form.prescows.dao.impl.dao.prescriptions;

import fr.brucella.form.prescows.dao.contracts.dao.prescriptions.BookDao;
import fr.brucella.form.prescows.dao.impl.dao.AbstractDao;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto.BookFullDetailsDtoRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto.BookWithStatusDtoRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.BookRM;
import fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model.ProcessingBookRM;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
 * Book Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class BookDaoImpl extends AbstractDao implements BookDao {


  /** Book DAO logger. */
  private static final Log LOG = LogFactory.getLog(BookDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public BookDaoImpl() {
    super();
  }


  // ===== Methods =====
  /** {@inheritDoc} */
  @Override
  public Book getBook(final Integer bookId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book WHERE book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    final RowMapper<Book> bookRowMapper = new BookRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, bookRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookDao.getBook.notFound"), exception);
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
  public List<BookWithStatusDto> getBookWithStatusListPrescription(final Integer prescriptionId)
      throws TechnicalException {

    sql = "SELECT book.book_id, book.ean, book.title, book.author, book.comments, book.email_teacher_send, book.email_send_date, book.book_status_id, book.prescription_id, book_status.book_status_name FROM book INNER JOIN book_status ON book.book_status_id = book_status.book_status_id WHERE book.prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("prescriptionId", prescriptionId);

    final RowMapper<BookWithStatusDto> bookWithStatusDtoRowMapper = new BookWithStatusDtoRM();

    try {
      List<BookWithStatusDto> bookWithStatusDtoList = getNamedJdbcTemplate().query(sql, parameterSource, bookWithStatusDtoRowMapper);
      if(bookWithStatusDtoList.isEmpty()) {
        bookWithStatusDtoList = new ArrayList<>();
      }
      return bookWithStatusDtoList;
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
  public List<BookFullDetailsDto> getBookFullDetailsListPrescription(final Integer prescriptionId) throws TechnicalException {

    sql = "SELECT book.book_id, book.ean, book.title, book.author, book.comments, book.email_teacher_send, book.email_send_date, book.book_status_id, book.prescription_id, book_status.book_status_name, prescription.purchase_deadline FROM book INNER JOIN book_status ON book.book_status_id = book_status.book_status_id INNER JOIN prescription ON prescription.prescription_id = book.prescription_id WHERE book.prescription_id = :prescriptionId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("prescriptionId", prescriptionId);

    final RowMapper<BookFullDetailsDto> bookFullDetailsDtoRowMapper = new BookFullDetailsDtoRM();
    List<BookFullDetailsDto> bookFullDetailsDtoList;

    try {
      bookFullDetailsDtoList = getNamedJdbcTemplate().query(sql, parameterSource, bookFullDetailsDtoRowMapper);
      if(bookFullDetailsDtoList.isEmpty()) {
        bookFullDetailsDtoList = new ArrayList<>();
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

    // Add processing book list to book full details dto

    sql = "SELECT * FROM processing_book WHERE book_id = :bookId";

    for(final BookFullDetailsDto bookFullDetailsDto : bookFullDetailsDtoList) {
      final MapSqlParameterSource processingParameterSource = new MapSqlParameterSource();
      processingParameterSource.addValue("bookId", bookFullDetailsDto.getBookId());
      final RowMapper<ProcessingBook> processingBookRowMapper = new ProcessingBookRM();

      try {
        List<ProcessingBook> processingBookList = getNamedJdbcTemplate().query(sql, processingParameterSource, processingBookRowMapper);
        if(processingBookList.isEmpty()) {
          bookFullDetailsDto.setProcessingBookList(new ArrayList<>());
        } else {
          bookFullDetailsDto.setProcessingBookList(processingBookList);
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

    return bookFullDetailsDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<BookFullDetailsDto> getSearchBookFullDetailsList(SearchCriteriaDto searchCriteriaDto)
      throws TechnicalException {

    if(LOG.isDebugEnabled()) {
      LOG.debug("Search = " + searchCriteriaDto.toString());
    }

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();

    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT book.book_id, book.ean, book.title, book.author, book.comments, book.email_teacher_send, book.email_send_date, book.book_status_id, book.prescription_id, book_status.book_status_name, prescription.purchase_deadline FROM book INNER JOIN book_status ON book.book_status_id = book_status.book_status_id INNER JOIN prescription ON prescription.prescription_id = book.prescription_id INNER JOIN eple on eple.eple_id = prescription.eple_id INNER JOIN department ON department.department_id = eple.department_id INNER JOIN city ON city.city_id = eple.city_id INNER JOIN processing_book ON processing_book.book_id = book.book_id WHERE 1=1");

    if(searchCriteriaDto != null) {
      if(searchCriteriaDto.getDepartmentId() != null) {
        stringBuilder.append(" AND department.department_id = :departmentId");
        parameterSource.addValue("departmentId", searchCriteriaDto.getDepartmentId());
      }
      if(searchCriteriaDto.getCityId() != null) {
        stringBuilder.append(" AND city.city_id = :cityId");
        parameterSource.addValue("cityId", searchCriteriaDto.getCityId());
      }
      if(!StringUtils.isEmpty(searchCriteriaDto.getRne())) {
        stringBuilder.append(" AND eple.rne = :epleRne");
        parameterSource.addValue("epleRne", searchCriteriaDto.getRne());
      }
      if(searchCriteriaDto.getPurchaseDeadline() != null) {
        stringBuilder.append(" AND prescription.purchase_deadline > :purchaseDeadline");
        parameterSource.addValue("purchaseDeadline", searchCriteriaDto.getPurchaseDeadline());
      }
      if(searchCriteriaDto.getProcessing() != null && searchCriteriaDto.getUserId() != null) {
        if(searchCriteriaDto.getProcessing() == false) {
          stringBuilder.append(" AND processing_book.book_id = book.book_id and processing_book.user_id = :userId and processing_book.processing_status = :processingStatus");
          parameterSource.addValue("userId", searchCriteriaDto.getUserId());
          parameterSource.addValue("processingStatus", searchCriteriaDto.getProcessing());
        }
      }
    }
    sql = stringBuilder.toString();
    final RowMapper<BookFullDetailsDto> bookFullDetailsDtoRowMapper = new BookFullDetailsDtoRM();

    List<BookFullDetailsDto> bookFullDetailsDtoList;

    try {
      if(LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
      }
      bookFullDetailsDtoList = this.getNamedJdbcTemplate().query(sql, parameterSource, bookFullDetailsDtoRowMapper);
      if(bookFullDetailsDtoList.isEmpty()) {
        bookFullDetailsDtoList = new ArrayList<>();
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

    // Add processing book list to book full details dto

    sql = "SELECT * FROM processing_book WHERE book_id = :bookId";

    for(final BookFullDetailsDto bookFullDetailsDto : bookFullDetailsDtoList) {
      final MapSqlParameterSource processingParameterSource = new MapSqlParameterSource();
      processingParameterSource.addValue("bookId", bookFullDetailsDto.getBookId());
      final RowMapper<ProcessingBook> processingBookRowMapper = new ProcessingBookRM();

      try {
        List<ProcessingBook> processingBookList = getNamedJdbcTemplate().query(sql, processingParameterSource, processingBookRowMapper);
        if(processingBookList.isEmpty()) {
          bookFullDetailsDto.setProcessingBookList(new ArrayList<>());
        } else {
          bookFullDetailsDto.setProcessingBookList(processingBookList);
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

    return bookFullDetailsDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public void updateBook(final Book book) throws TechnicalException, NotFoundException {

    sql = "UPDATE book SET ean = :ean, title = :title, author = :author, comments = :comments, email_teacher_send = :emailTeacherSend, email_send_date = :emailSendDate, book_status_id = :bookStatusId, prescription_id = :prescriptionId WHERE book_id = :bookId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(book);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("book = " + book.toString());
        }
        throw new NotFoundException(messages.getString("bookDao.updateBook.NotFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookDao.updateBook.integrityViolation"), exception);
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
  public int insertBook(final Book book) throws TechnicalException {

    sql = "INSERT INTO public.book (book_id, ean, title, author, comments, email_teacher_send, email_send_date, book_status_id, prescription_id) VALUES(DEFAULT, :ean, :title, :author, :comments, :emailTeacherSend, :emailSendDate, :bookStatusId, :prescriptionId)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(book);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{"book_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookDao.insertBook.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookDao.insertBook.integrityViolation"), exception);
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
  public void deleteBook(final Integer bookId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM book WHERE book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookId = " + bookId);
        }
        throw new NotFoundException(messages.getString("bookDao.deleteBook.notFound"));
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
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
