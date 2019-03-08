package fr.brucella.form.prescows.entity.prescriptions.model;

import fr.brucella.form.prescows.entity.adapters.LocalDateWithTimeAdapter;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents a Book.
 *
 * @author BRUCELLA2
 */
public class Book {

  /** id of the book. */
  private Integer bookId;

  /** ean of the book. Can't be empty. */
  @NotEmpty(message = "{book.ean.empty}")
  @Size(min = 13, max = 13, message = "{book.ean.size}")
  private String ean;

  /** title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  /** author of the book. Can't be empty. */
  @NotEmpty(message = "{book.author.empty}")
  @Size(min = 1, max = 150, message = "{book.author.size}")
  private String author;

  /** Comments of the book. Can be empty. */
  @Size(min = 0, max = 2000, message = "{book.comments.size}")
  private String comments;

  /** Indicate if an email has been sent to the teacher. Can be empty. */
  private Boolean emailTeacherSend;

  /** email to teacher send date. Can be empty. */
  private LocalDateTime emailSendDate;

  /** id of the book status. Can't be null. */
  @NotNull(message = "{book.bookStatusId.null}")
  private Integer bookStatusId;

  /** id of the prescription. Can't be null. */
  @NotNull(message = "{book.prescriptionId.null}")
  private Integer prescriptionId;


  // ===== Constructor =====

  /** Default Constructor */
  public Book() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Gives the id of the book.
   *
   * @return the id of the book.
   */
  public Integer getBookId() {
    return bookId;
  }

  /**
   * Set the id of the book.
   *
   * @param bookId the id of the book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
  }

  /**
   * Gives the ean of the book.
   *
   * @return the ean of the book.
   */
  public String getEan() {
    return ean;
  }

  /**
   * Set the ean of the book.
   *
   * @param ean the ean of the book.
   */
  public void setEan(final String ean) {
    this.ean = ean;
  }

  /**
   * Gives the title of the book.
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
   * Gives the author of the book.
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
   * Gives the comments of the book.
   *
   * @return the comments of the book.
   */
  public String getComments() {
    return comments;
  }

  /**
   * Set the comments of the book.
   *
   * @param comments the comments of the book.
   */
  public void setComments(final String comments) {
    this.comments = comments;
  }

  /**
   * returns if an email has been sent to the teacher.
   *
   * @return true if an email has been sent to the teacher, false else.
   */
  public Boolean getEmailTeacherSend() {
    return emailTeacherSend;
  }

  /**
   * Set if an email has been sent to the teacher.
   *
   * @param emailTeacherSend true if an email has been sent to the teacher, false else.
   */
  public void setEmailTeacherSend(final Boolean emailTeacherSend) {
    this.emailTeacherSend = emailTeacherSend;
  }

  /**
   * Gives the date of sending the email.
   *
   * @return the date of sending the email.
   */
  @XmlJavaTypeAdapter(value = LocalDateWithTimeAdapter.class)
  public LocalDateTime getEmailSendDate() {
    return emailSendDate;
  }

  /**
   * Set the date of sending the email.
   *
   * @param emailSendDate the date of sending the email.
   */
  public void setEmailSendDate(final LocalDateTime emailSendDate) {
    this.emailSendDate = emailSendDate;
  }

  /**
   * Gives the id of book's status.
   *
   * @return the id of book's status.
   */
  public Integer getBookStatusId() {
    return bookStatusId;
  }

  /**
   * Set the id of book's status.
   *
   * @param bookStatusId the id of book's status.
   */
  public void setBookStatusId(final Integer bookStatusId) {
    this.bookStatusId = bookStatusId;
  }

  /**
   * Gives the id of the prescription.
   *
   * @return the id of the prescription.
   */
  public Integer getPrescriptionId() {
    return prescriptionId;
  }

  /**
   * Set the id of the prescription.
   *
   * @param prescriptionId the id of the prescription.
   */
  public void setPrescriptionId(final Integer prescriptionId) {
    this.prescriptionId = prescriptionId;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Book{");
    sb.append("bookId=").append(bookId);
    sb.append(", ean='").append(ean).append('\'');
    sb.append(", title='").append(title).append('\'');
    sb.append(", author='").append(author).append('\'');
    sb.append(", comments='").append(comments).append('\'');
    sb.append(", emailTeacherSend=").append(emailTeacherSend);
    sb.append(", emailSendDate=").append(emailSendDate);
    sb.append(", bookStatusId=").append(bookStatusId);
    sb.append(", prescriptionId=").append(prescriptionId);
    sb.append('}');
    return sb.toString();
  }
}
