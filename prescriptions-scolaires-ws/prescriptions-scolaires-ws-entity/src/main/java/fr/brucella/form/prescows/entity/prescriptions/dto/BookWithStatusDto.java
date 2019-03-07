package fr.brucella.form.prescows.entity.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a BookWithStatus Data Transfert Object.
 * Includes all informations about the book.
 * Include the status name associated to the book.
 */
public class BookWithStatusDto extends Book {

  /** name of the bookStatus. */
  @NotEmpty(message = "{bookStatus.name.empty}")
  @Size(min = 1, max = 50, message = "{bookStatus.name.size}")
  private String nameStatus;


  // ===== Constructor =====

  /** Default Constructor */
  public BookWithStatusDto() {
    super();
  }


  // ===== Getters and Setters =====

  /**
   * Gives the name of the bookStatus.
   *
   * @return the name of the bookStatus.
   */
  public String getNameStatus() {
    return nameStatus;
  }

  /**
   * Set the name of the bookStatus.
   *
   * @param nameStatus the name of the bookStatus.
   */
  public void setNameStatus(final String nameStatus) {
    this.nameStatus = nameStatus;
  }


  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookWithStatusDto{");
    sb.append("nameStatus='").append(nameStatus).append('\'');
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }
}
