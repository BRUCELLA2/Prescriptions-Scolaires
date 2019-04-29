package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;
import java.util.List;
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

  /** id for book status not check */
  private static final Integer BOOK_STATUS_NOT_CHECK = 1;


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

    Integer bookId = this.getDaoFactory().getBookDao().insertBook(book);

    try {
      PrescriptionFullDetailsDto prescription = this.getDaoFactory().getPrescriptionDao().getPrescriptionFullDetailsDto(book.getPrescriptionId());
      prescription.setValidationStatus(false);
      this.getDaoFactory().getPrescriptionDao().updatePrescription(prescription);

      for(ProcessingPrescription processingPrescription : prescription.getProcessingPrescriptionList()) {
        if(processingPrescription.getProcessingStatus()) {
          processingPrescription.setProcessingStatus(false);
          this.getDaoFactory().getProcessingPrescriptionDao().updateProcessingPrescription(processingPrescription);
        }
      }
    } catch (NotFoundException e) {
      LOG.debug(messages.getString("bookDetailsManagerImpl.addBook.prescriptionNotFound"));
    }

    return bookId;
  }

  /** {@inheritDoc} */
  @Override
  public Book bookInformations(final Integer bookId) throws TechnicalException, FunctionalException {

    if(bookId == null) {
      LOG.error(messages.getString("bookDetailsManagerImpl.bookInformations.bookIdNull"));
      throw new FunctionalException(messages.getString("bookDetailsManagerImpl.bookInformations.bookIdNull"));
    }

    try {
      return this.getDaoFactory().getBookDao().getBook(bookId);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
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

      /* Check if the all books of the prescription are checked. Change the prescription validation status. */
      List<BookWithStatusDto> booksListPrescription = this.getDaoFactory().getBookDao().getBookWithStatusListPrescription(book.getPrescriptionId());

      boolean prescriptionFullCheck = true;
      for(Book bookPrescription : booksListPrescription) {
        if(bookPrescription.getBookStatusId().equals(BOOK_STATUS_NOT_CHECK)) {
          prescriptionFullCheck = false;
        }
      }

      Prescription prescription = this.getDaoFactory().getPrescriptionDao().getPrescription(book.getPrescriptionId());
      prescription.setValidationStatus(prescriptionFullCheck);
      this.getDaoFactory().getPrescriptionDao().updatePrescription(prescription);

      return true;

    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean bookProcessed(
      final Integer bookId,
      final Integer userId,
      final Boolean bookProcessed,
      final Integer prescriptionId)
      throws TechnicalException, FunctionalException {

    if (bookId == null || userId == null || bookProcessed == null || prescriptionId == null) {
      LOG.error(
          messages.getString(
              "bookDetailsManagerImpl.bookProcessed.bookIdOrUserIdOrBookProcessedNull"));
      throw new FunctionalException(
          messages.getString(
              "bookDetailsManagerImpl.bookProcessed.bookIdOrUserIdOrBookProcessedNull"));
    }

    ProcessingBook processingBook;

    try {
      processingBook =
          this.getDaoFactory().getProcessingBookDao().getProcessingBook(userId, bookId);
      processingBook.setProcessingStatus(bookProcessed);
      this.getDaoFactory().getProcessingBookDao().updateProcessingBook(processingBook);
    } catch (NotFoundException exception) {
      processingBook = new ProcessingBook();
      processingBook.setUserId(userId);
      processingBook.setBookId(bookId);
      processingBook.setProcessingStatus(bookProcessed);
      this.getDaoFactory().getProcessingBookDao().insertProcessingBook(processingBook);
    }

    List<BookWithStatusDto> books =
        this.getDaoFactory().getBookDao().getBookWithStatusListPrescription(prescriptionId);
    if (!books.isEmpty()) {
      Boolean prescriptionProcessed = true;
      for (BookWithStatusDto book : books) {
        try {
          if (!this.getDaoFactory()
              .getProcessingBookDao()
              .getProcessingBook(userId, book.getBookId())
              .getProcessingStatus()) {
            prescriptionProcessed = false;
          }
        } catch (NotFoundException e) {
          prescriptionProcessed = false;
        }
      }

      ProcessingPrescription processingPrescription;

      try {
        processingPrescription =
            this.getDaoFactory()
                .getProcessingPrescriptionDao()
                .getProcessingPrescription(userId, prescriptionId);
        processingPrescription.setProcessingStatus(prescriptionProcessed);
        this.getDaoFactory()
            .getProcessingPrescriptionDao()
            .updateProcessingPrescription(processingPrescription);
      } catch (NotFoundException exception) {
        processingPrescription = new ProcessingPrescription();
        processingPrescription.setUserId(userId);
        processingPrescription.setPrescriptionId(prescriptionId);
        processingPrescription.setProcessingStatus(prescriptionProcessed);
        this.getDaoFactory()
            .getProcessingPrescriptionDao()
            .insertProcessingPrescription(processingPrescription);
      }

    }
    return true;
  }
}
