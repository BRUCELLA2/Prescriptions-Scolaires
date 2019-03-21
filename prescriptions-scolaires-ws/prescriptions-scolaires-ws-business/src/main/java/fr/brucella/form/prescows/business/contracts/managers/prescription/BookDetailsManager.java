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
   * Modify a book.
   *
   * @param book the book with the updated informations to save in datastore.
   * @return true if modification is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the book is null or not valid or if the book is not found.
   */
  Boolean modifyBook(final Book book) throws TechnicalException, FunctionalException;
}
