package fr.brucella.form.prescows.entity.prescriptions.model;

import javax.validation.constraints.NotNull;

/**
 * Represents the processing status of a book.
 *
 * @author BRUCELLA2
 */
public class ProcessingBook {

  /** id of the user. */
  @NotNull(message = "{processingBook.userId.null}")
  private Integer userId;

  /** id of the book. */
  @NotNull(message = "{processingBook.bookId.null}")
  private Integer bookId;

  /** Indicates if the book is process. */
  @NotNull(message = "{processingBook.processingStatus.null}")
  private Boolean processingStatus;


  // ===== Constructor =====

  /** Default Constructor */
  public ProcessingBook() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Gives the id of the user.
   *
   * @return the id of the user.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the id of the user.
   *
   * @param userId the id of the user.
   */
  public void setUserId(final Integer userId) {
    this.userId = userId;
  }

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
   * Gives the processing status.
   *
   * @return the processing status.
   */
  public Boolean getProcessingStatus() {
    return processingStatus;
  }

  /**
   * Set the processing status.
   *
   * @param processingStatus the processing status.
   */
  public void setProcessingStatus(final Boolean processingStatus) {
    this.processingStatus = processingStatus;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ProcessingBook{");
    sb.append("userId=").append(userId);
    sb.append(", bookId=").append(bookId);
    sb.append(", processingStatus=").append(processingStatus);
    sb.append('}');
    return sb.toString();
  }
}
