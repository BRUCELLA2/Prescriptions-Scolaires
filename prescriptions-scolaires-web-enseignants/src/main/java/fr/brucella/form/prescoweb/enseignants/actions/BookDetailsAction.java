package fr.brucella.form.prescoweb.enseignants.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.bookserviceclient.Book;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.PrescoWsException_Exception;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Book details action.
 *
 * @author BRUCELLA2
 */
public class BookDetailsAction extends ActionSupport implements SessionAware, ServletRequestAware {

  /** User Action logger. */
  private static final Log LOG = LogFactory.getLog(BookDetailsAction.class);

  /** Integer for the book status "disponibilité non vérifié". */
  private static final Integer BOOK_STATUS_DISPO_NON_VERIFIE = 1;

  /** The id of the prescription. */
  private Integer prescriptionId;

  /** The id of the book. */
  private Integer bookId;

  /** The prescription. */
  private Book book;

  /** Ean of the book. */
  private String ean;

  /** Title of the book. */
  private String title;

  /** Author of the book. */
  private String author;

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;


  // ----- Constructors

  /** Default constructor. */
  public BookDetailsAction() {
    super();
  }


  // ----- Getters and Setters


  /**
   * Give the id of the prescription.
   *
   * @return the id of the prescription.
   */
  public Integer getPrescriptionId() {
    return this.prescriptionId;
  }

  /**
   * Set the id of the prescription.
   *
   * @param prescriptionId the id of the prescription.
   */
  public void setPrescriptionId(final Integer prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  /**
   * Give the id of book.
   *
   * @return the id of book.
   */
  public Integer getBookId() {
    return this.bookId;
  }

  /**
   * Set the id of book.
   *
   * @param bookId the id of book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
  }

  /**
   * Give the book.
   *
   * @return the book.
   */
  public Book getBook() {
    return book;
  }

  /**
   * Set the book.
   *
   * @param book the book.
   */
  public void setBook(final Book book) {
    this.book = book;
  }

  /**
   * Give the ean of book.
   *
   * @return the ean of book.
   */
  public String getEan() {
    return ean;
  }

  /**
   * Set the ean of book.
   *
   * @param ean the ean of book.
   */
  public void setEan(final String ean) {
    this.ean = ean;
  }

  /**
   * Give the title of the book.
   *
   * @return the title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book.
   *
   * @param title the title of the book.
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Give the author of the book.
   *
   * @return the author of the book.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Set the author of the book.
   *
   * @param author the author of the book.
   */
  public void setAuthor(final String author) {
    this.author = author;
  }

  /**
   * Give the Http Servlet Request.
   *
   * @return the Http Servlet Request.
   */
  public HttpServletRequest getServletRequest() {
    return this.servletRequest;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /**
   * Give the user's HTTP session attributes.
   *
   * @return the user's HTTP session attributes.
   */
  public Map<String, Object> getSession() {
    return session;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }



  // ===== Methods =====

  /**
   * Display details of book.
   *
   * @return ERROR if error occurred.
   *         SUCCESS otherwise.
   */
  public String doBookDetails() {

    if(this.bookId == null) {
      this.addActionError("L'identifiant du livre est absent.");
      return Action.ERROR;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      this.book = bookServicePort.bookInformations(bookId);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return SUCCESS;
  }

  /**
   * Modify book.
   *
   * @return ERROR if error occurred.
   *         INPUT if the input information needed are empty or null.
   *         SUCCESS otherwise.
   */
  public String doBookModification() {

    if(StringUtils.isAllEmpty(this.ean, this.title, this.author) && this.prescriptionId == null && this.bookId == null) {
      if(LOG.isDebugEnabled()) {
        LOG.debug("ean, title, author, prescriptionId = null");
      }
      return Action.INPUT;
    }

    if(StringUtils.isEmpty(this.ean)) {
      this.addFieldError("ean", "Un livre doit avoir un EAN.");
    }
    if(StringUtils.isEmpty(this.title)) {
      this.addFieldError("title", "Un livre doit avoir un titre.");
    }
    if(StringUtils.isEmpty(this.author)) {
      this.addFieldError("author", "Un livre doit avoir un auteur.");
    }

    if(this.bookId == null) {
      this.addActionError("L'identifiant du livre n'a pas été transmis, action abandonnée");
    }

    if(this.hasFieldErrors()) {
      return Action.INPUT;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {

      this.book = bookServicePort.bookInformations(bookId);
      this.book.setEan(this.ean);
      this.book.setTitle(this.title);
      this.book.setAuthor(this.author);
      this.prescriptionId = this.book.getPrescriptionId();
      bookServicePort.modifyBook(this.book);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Create a new book.
   *
   * @return ERROR if error occurred.
   *         INPUT if the input information needed are empty or null.
   *         SUCCESS otherwise
   */
  public String doNewBook() {

    if(StringUtils.isAllEmpty(this.ean, this.title, this.author) && this.prescriptionId == null && this.bookId == null) {
      if(LOG.isDebugEnabled()) {
        LOG.debug("ean, title, author, prescriptionId = null");
      }
      return Action.INPUT;
    }

    if(StringUtils.isEmpty(this.ean)) {
      this.addFieldError("ean", "Un livre doit avoir un EAN.");
    }
    if(StringUtils.isEmpty(this.title)) {
      this.addFieldError("title", "Un livre doit avoir un titre.");
    }
    if(StringUtils.isEmpty(this.author)) {
      this.addFieldError("author", "Un livre doit avoir un auteur.");
    }

    if(this.prescriptionId == null) {
      this.addActionError("L'identifiant de la prescription n'a pas été transmis, action abandonnée");
    }

    if(this.hasFieldErrors()) {
      return Action.INPUT;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {

      this.book = new Book();
      this.book.setEan(this.ean);
      this.book.setTitle(this.title);
      this.book.setAuthor(this.author);
      this.book.setPrescriptionId(this.prescriptionId);
      this.book.setBookStatusId(BOOK_STATUS_DISPO_NON_VERIFIE);
      this.bookId = bookServicePort.makeBook(this.book);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Delete book.
   *
   * @return delete book.
   */
  public String doDeleteBook() {

    if(this.bookId == null) {
      LOG.error("L'identifiant du livre est absent. Echec de la suppression.");
      this.addActionError("L'identifiant du livre est absent. Echec de la suppression.");
      return Action.ERROR;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      bookServicePort.deleteBook(this.bookId);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }
}
