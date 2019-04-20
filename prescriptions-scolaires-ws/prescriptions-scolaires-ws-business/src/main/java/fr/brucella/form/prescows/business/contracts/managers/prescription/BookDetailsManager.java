package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;

/**
 * Interface for BookDetails Manager
 *
 * @author BRUCELLA2
 */
public interface BookDetailsManager {

  /**
   * Make a book.
   * Save in datastore the book in parameter and return the id of the new book.
   *
   * @param book the book to save in datastore.
   * @return the id of the new book saved in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the book is null or not valid.
   */
  Integer addBook(final Book book) throws TechnicalException, FunctionalException;

  /**
   * Return the book with the id corresponding.
   *
   * @param bookId id of the book.
   * @return the book with the id corresponding.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the bookId is null or if the book is not found.
   */
  Book bookInformations(final Integer bookId) throws TechnicalException, FunctionalException;

  /**
   * Modify a book.
   *
   * @param book the book with the updated informations to save in datastore.
   * @return true if modification is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the book is null or not valid or if the book is not found.
   */
  Boolean modifyBook(final Book book) throws TechnicalException, FunctionalException;

  /**
   * Delete a book
   *
   * @param bookId id of the book to delete.
   * @return true if delete is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the bookId is null or if the book is not found.
   */
  Boolean deleteBook(final Integer bookId) throws TechnicalException, FunctionalException;

  /**
   * Change the status of a book.
   *
   * @param bookId id of the book.
   * @param bookStatusId id of the status.
   * @return true if change is ok. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - Throws this exception if the bookId is null or the book is not found.
   *                             - Throws this exception if bookStatusId is null.
   */
  Boolean changeBookStatus(final Integer bookId, final Integer bookStatusId)
      throws TechnicalException, FunctionalException;

  /**
   * Change the book processed status for the book and the user. If all books of the prescription related to the book are processed, processed prescription for the user is set to true, else to false.
   *
   * @param bookId id of the book.
   * @param userId id of the user.
   * @param bookProcessed true if the book is processed, false otherwise.
   * @param prescriptionId id of the prescription.
   * @return true if the update is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - Throws this exception if the userId or the bookId or the bookProcessed are null.
   */
  Boolean bookProcessed(final Integer bookId, final Integer userId, final Boolean bookProcessed, final Integer prescriptionId) throws TechnicalException, FunctionalException;
}
