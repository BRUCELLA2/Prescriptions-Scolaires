package fr.brucella.form.prescoweb.enseignants.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.UserDetailsDto;
import generated.bookserviceclient.Book;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.prescriptionserviceclient.PrescriptionService;
import generated.prescriptionserviceclient.PrescriptionService_Service;
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
    // This constructor is intentionally empty. Nothing special is needed here.
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

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }



  // ===== Methods =====

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

    if(this.prescriptionId == null) {
      this.addActionError("L'identifiant de la prescription n'a pas été transmis, action abandonnée.");
      return Action.ERROR;
    }

    if(this.hasFieldErrors()) {
      return Action.INPUT;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      
      this.book = bookServicePort.modifyBook(this.book);
    }
  }
}
