package fr.brucella.form.prescows.dao.contracts.dao.prescriptions;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;

/**
 * Interface for ProcessingBook Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface ProcessingBookDao {

  /**
   * Gives the processingBook with the specified user id and book id from the datastore.
   *
   * @param userId id of the user.
   * @param bookId id of the book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingBook is not found.
   */
  ProcessingBook getProcessingBook(final Integer userId, final Integer bookId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing processingBook in the datastore.
   *
   * @param processingBook the processingBook with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingBook is not found.
   */
  void updateProcessingBook(final ProcessingBook processingBook) throws TechnicalException, NotFoundException;

  /**
   * Insert a new processingBook in the datastore.
   *
   * @param processingBook the processingBook to insert in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  void insertProcessingBook(final ProcessingBook processingBook) throws TechnicalException;

  /**
   * Delete the processingBook with the specified user id and book id from the datastore.
   *
   * @param userId id of the user.
   * @param bookId id of the book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingBook is not found.
   */
  void deleteProcessingBook(final Integer userId, final Integer bookId) throws TechnicalException, NotFoundException;
}
