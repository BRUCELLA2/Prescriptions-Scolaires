package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.List;
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
   * Return the book with the id corresponding.
   *
   * @param bookId id of the book.
   * @return the book with the id corresponding.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the book id is null or if the book is not found.
   */
  @WebMethod
  public Book bookInformations(final Integer bookId) throws PrescoWsException {

    if(bookId == null) {
      LOG.error("bookId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du livre est vide. Impossible d'obtenir les informations du livre."));
    }

    try {
      return this.managerFactory.getBookDetailsManager().bookInformations(bookId);
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
   * Delete a book.
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

  /**
   * Return the list of book with full details for the prescription.
   *
   * @param prescriptionId id of the prescription.
   * @return the list of book with full details for the prescription. If the prescription is not found, return empty list.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the prescriptionId is null.
   *
   */
  @WebMethod
  public List<BookFullDetailsDto> bookFullDetailsListForPrescription(final Integer prescriptionId) throws PrescoWsException {

    if(prescriptionId == null) {
      LOG.error("prescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. L'identifiant de la prescription ne peut être vide."));
    }

    try {
      return this.managerFactory.getBookListingManager().getBookFullDetailsListPrescription(prescriptionId);
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
   * Return the list of book with book status for the prescription.
   *
   * @param prescriptionId id of the prescription.
   * @return the list of book with book status for the prescription. If the prescription is not found, return empty list.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the prescriptionId is null.
   */
  @WebMethod
  public List<BookWithStatusDto> bookWithStatusListForPrescription(final Integer prescriptionId) throws PrescoWsException {

    if(prescriptionId == null) {
      LOG.error("prescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. L'identifiant de la prescription ne peut être vide."));
    }

    try {
      return this.managerFactory.getBookListingManager().getBookWithStatusListForPrescription(prescriptionId);
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
   * Return the list of book corresponding to the search criteria.
   *
   * @param searchCriteriaDto the search criteria.
   * @return the list of book corresponding to the search criteria. If no books is found, return empty list.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the searchCriteriaDto is null.
   */
  @WebMethod
  public List<BookFullDetailsDto> bookSearching(final SearchCriteriaDto searchCriteriaDto) throws PrescoWsException {

    if(searchCriteriaDto == null) {
      LOG.error("searchCriteriaDto null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. Les critères de recherche sont vide"));
    }

    try {
      return this.managerFactory.getBookListingManager().getBookSearching(searchCriteriaDto);
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
   * Change the processed status for the book for the user.
   * If all book of the prescription are processed for the user, prescription is set processed for the user too otherwise set to false.
   *
   * @param userId id of the user.
   * @param bookId id of the book.
   * @param bookProcessed true if the book is processed.
   * @param prescriptionId  id of the prescriptionId
   * @return true if change is ok. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem.
   *                             Throws this exception if the bookId is null.
   *                             Throws this exception if the userId is null.
   *                             Throws this exception if the bookProcessed is null.
   *                             Throws this exception if the prescriptionId is null.
   */
  @WebMethod
  public boolean setBookProcessed(final Integer userId, final Integer bookId, final Boolean bookProcessed, final Integer prescriptionId) throws PrescoWsException {

    if(userId == null && bookId == null && prescriptionId == null && bookProcessed == null) {
      LOG.error("userId null and bookId and prescriptionId and bookProcessed null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du livre, l'identifiant de l'utilisateur, l'identifiant de la prescription et le statut de traitement sont vides. Mise à jour du statut de traitement du livre impossible."));
    }

    if(bookId == null) {
      LOG.error("bookId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant du livre est vide. Mise à jour du statut de traitement du livre impossible."));
    }

    if(userId == null) {
      LOG.error("userId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de l'utilisateur est vide. Mise à jour du statut de traitement du livre impossible."));
    }

    if(prescriptionId == null) {
      LOG.error("prescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de la prescription est vide. Mise à jour du statut de traitement du livre impossible."));
    }

    if(bookProcessed == null) {
      LOG.error("bookProcessed null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Le statut de traitement est vide. Mise à jour du statut de traitement du livre impossible."));
    }

    try {
      return this.managerFactory.getBookDetailsManager().bookProcessed(bookId, userId, bookProcessed, prescriptionId);
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
