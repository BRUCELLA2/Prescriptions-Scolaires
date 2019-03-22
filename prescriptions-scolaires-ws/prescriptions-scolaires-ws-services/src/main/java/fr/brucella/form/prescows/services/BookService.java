package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Book Web Service
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BookService")
@Component
public class BookService extends SpringBeanAutowiringSupport {

  /** Book Service Logger */
  private static final Log LOG = LogFactory.getLog(BookService.class);

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired
  private ManagerFactory managerFactory;


  // ===== Constructor =====

  /** Default constructor. */
  public BookService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //

  /**
   * Make a book.
   * Save in datastore the book in parameter and return the id of the new book.
   *
   * @param book the book to save in datastore.
   * @return the id of the new book saved in datastore.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the book is null or invalid.
   */
  @WebMethod
  public Integer makeBook(final Book book) throws PrescoWsException {

    if(book == null) {
      LOG.error("book null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Le livre est vide. Création impossible"));
    }

    try {
      return this.managerFactory.getBookDetailsManager().addBook(book);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Modify a book.
   *
   * @param book the book with the updated informations to save in datastore.
   * @return true if modification is a success. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem, if the book is null or invalid or if the book is not found.
   */
  @WebMethod
  public boolean modifyBook(final Book book) throws PrescoWsException {

    if(book == null) {
      LOG.error("book null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Le livre est vide. Modification impossible"));
    }

    try {
      return this.managerFactory.getBookDetailsManager().modifyBook(book);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Delete a book
   *
   * @param bookId id of the book to delete.
   * @return true if delete is a success. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the bookId is null or the book is not found.
   */
  @WebMethod
  public boolean deleteBook(final Integer bookId) throws PrescoWsException {

    if(bookId == null) {
      LOG.error("bookId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du livre est vide. Suppression impossible."));
    }

    try {
      return this.managerFactory.getBookDetailsManager().deleteBook(bookId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Change the status of a book.
   *
   * @param bookId id of the book.
   * @param bookStatusId id of the status.
   * @return true if change is ok. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem.
   *                             Throws this exception if the bookId is null or the book is not found.
   *                             Throws this exception if bookStatusId is null.
   */
  @WebMethod
  public boolean changeBookStatus(final Integer bookId, final Integer bookStatusId) throws PrescoWsException {

    if(bookId == null && bookStatusId == null) {
      LOG.error("bookId null and bookStatusId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du statut du livre et l'identifiant du livre sont vides. Changement de statut impossible."));
    }

    if(bookId == null) {
      LOG.error("bookId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du livre est vide. Changement de statut impossible."));
    }

    if(bookStatusId == null) {
      LOG.error("bookStatusId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du statut du livre est vide. Changement de statut impossible."));
    }

    try {
      return this.managerFactory.getBookDetailsManager().changeBookStatus(bookId, bookStatusId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }
}
