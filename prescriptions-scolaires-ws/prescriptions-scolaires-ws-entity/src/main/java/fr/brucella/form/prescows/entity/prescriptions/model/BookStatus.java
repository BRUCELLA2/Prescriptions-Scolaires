package fr.brucella.form.prescows.entity.prescriptions.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents the status of a book.
 *
 * @author BRUCELLA2
 */
public class BookStatus {

  /** id of the bookStatus. */
  private Integer bookStatusId;

  /** name of the bookStatus. */
  @NotEmpty(message = "{bookStatus.name.empty}")
  @Size(min = 1, max = 50, message = "{bookStatus.name.size}")
  private String name;


  // ===== Constructor =====

  /** Default Constructor */
  public BookStatus() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ===== Getters and Setters =====

  /**
   * Gives the id of the bookStatus.
   *
   * @return the id of the bookStatus.
   */
  public Integer getBookStatusId() {
    return bookStatusId;
  }

  /**
   * Set the id of the bookStatus.
   *
   * @param bookStatusId the id of the bookStatus.
   */
  public void setBookStatusId(final Integer bookStatusId) {
    this.bookStatusId = bookStatusId;
  }

  /**
   * Gives the name of the bookStatus.
   *
   * @return the name of the bookStatus.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the bookStatus.
   *
   * @param name the name of the bookStatus.
   */
  public void setName(final String name) {
    this.name = name;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookStatus{");
    sb.append("bookStatusId=").append(bookStatusId);
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
