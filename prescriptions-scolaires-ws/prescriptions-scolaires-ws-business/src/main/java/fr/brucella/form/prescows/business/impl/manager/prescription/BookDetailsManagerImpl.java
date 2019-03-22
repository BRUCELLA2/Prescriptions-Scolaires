package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Book Details Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BookDetailsManagerImpl extends AbstractManager implements BookDetailsManager {

  /** Book Detail Manager logger. */
  private static final Log LOG = LogFactory.getLog(BookDetailsManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public BookDetailsManagerImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Integer addBook(final Book book) throws TechnicalException, FunctionalException {

    if(book == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.addBook.bookNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.addBook.bookNull"));
    }

    final Set<ConstraintViolation<Book>> violations = this.getConstraintValidator().validate(book);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Book> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("bookDetailsManagerImpl.addBook.constraints"));
      throw new FunctionalException(
          messages.getString("bookDetailsManagerImpl.addBook.constraints"));
    }

    return this.getDaoFactory().getBookDao().insertBook(book);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyBook(final Book book) throws TechnicalException, FunctionalException {

    if(book == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.modifyBook.bookNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.modifyBook.bookNull"));
    }

    final Set<ConstraintViolation<Book>> violations = this.getConstraintValidator().validate(book);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Book> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("bookDetailsManagerImpl.modifyBook.constraints"));
      throw new FunctionalException(
          messages.getString("bookDetailsManagerImpl.modifyBook.constraints"));
    }

    try {
      this.getDaoFactory().getBookDao().updateBook(book);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean deleteBook(final Integer bookId) throws TechnicalException, FunctionalException {

    if(bookId == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.deleteBook.bookIdNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.deleteBook.bookIdNull"));
    }

    try {
      this.getDaoFactory().getBookDao().deleteBook(bookId);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean changeBookStatus(final Integer bookId, final Integer bookStatusId) throws TechnicalException, FunctionalException {

    if(bookId == null && bookStatusId == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookIdAndBookStatusIdNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookIdAndBookStatusIdNull"));
    }
    else if(bookId == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookIdNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookIdNull"));
    }
    else if(bookStatusId == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookStatusId"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.changeBookStatus.bookStatusId"));
    }

    try {
      final Book book = this.getDaoFactory().getBookDao().getBook(bookId);
      book.setBookStatusId(bookStatusId);
      this.getDaoFactory().getBookDao().updateBook(book);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }
}
