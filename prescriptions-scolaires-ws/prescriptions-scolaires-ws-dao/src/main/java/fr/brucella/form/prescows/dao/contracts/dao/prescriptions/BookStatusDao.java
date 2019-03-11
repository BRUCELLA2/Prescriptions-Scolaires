package fr.brucella.form.prescows.dao.contracts.dao.prescriptions;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.BookStatus;

/**
 * Interface for BookStatus Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface BookStatusDao {

  /**
   * Gives the bookStatus with the specified id from the datastore.
   *
   * @param bookStatusId id of the bookStatus.
   * @return the bookStatus with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the bookStatus is not found.
   */
  BookStatus getBookStatus(final Integer bookStatusId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing bookStatus in the datastore.
   *
   * @param bookStatus the bookStatus with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the bookStatus is not found.
   */
  void updateBookStatus(final BookStatus bookStatus) throws TechnicalException, NotFoundException;

  /**
   * Insert a new bookStatus in the datastore.
   *
   * @param bookStatus the bookStatus to insert in datastore.
   * @return the id of the new bookStatus.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertBookStatus(final BookStatus bookStatus) throws TechnicalException;

  /**
   * Delete the bookStatus with the specified id in the datastore.
   *
   * @param bookStatusId id of the bookStatus.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the bookStatus is not found.
   */
  void deleteBookStatus(final Integer bookStatusId) throws TechnicalException, NotFoundException;
}
