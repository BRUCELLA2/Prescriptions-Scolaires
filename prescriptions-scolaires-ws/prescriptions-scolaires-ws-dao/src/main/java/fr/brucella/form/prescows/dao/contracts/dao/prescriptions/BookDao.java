package fr.brucella.form.prescows.dao.contracts.dao.prescriptions;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import java.util.List;

/**
 * Interface for Book Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface BookDao {

  /**
   * Gives the book with the specified id from the datastore.
   *
   * @param bookId id of the book.
   * @return the book with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the book is not found.
   */
  Book getBook(final Integer bookId) throws TechnicalException, NotFoundException;

  /**
   * Gives a list of book with status (BookWithStatusDto) for the prescription with the specified id from the datastore.
   *
   *
   * @param prescriptionId id of the prescription.
   * @return list of book with status (BookWithStatusDto) for the prescription with the specified id
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BookWithStatusDto> getBookWithStatusListPrescription(final Integer prescriptionId) throws TechnicalException;

  /**
   * Update an existing book in the datastore.
   *
   * @param book the book with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the book is not found.
   */
  void updateBook(final Book book) throws TechnicalException, NotFoundException;

  /**
   * Insert a new book in the datastore.
   *
   * @param book the book to insert in datastore.
   * @return the id of the new book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertBook(final Book book) throws TechnicalException;

  /**
   * Delete the book with the specified id in the datastore.
   *
   * @param bookId id of the book.

   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the book is not found.
   */
  void deleteBook(final Integer bookId) throws TechnicalException, NotFoundException;
}
