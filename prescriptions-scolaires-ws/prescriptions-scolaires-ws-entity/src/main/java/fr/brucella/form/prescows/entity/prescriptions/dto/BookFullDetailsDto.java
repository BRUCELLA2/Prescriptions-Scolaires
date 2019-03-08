package fr.brucella.form.prescows.entity.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a BookFullDetails Data Transfert Object.
 * Includes all informations about the Book.
 * Includes the name of the BookStatus for the book.
 * Includes the list of all the ProcessingBook associated to the book.
 *
 * @author BRUCELLA2
 */
public class BookFullDetailsDto extends Book {

  /** name of the bookStatus. */
  @NotEmpty(message = "{bookStatus.name.empty}")
  @Size(min = 1, max = 50, message = "{bookStatus.name.size}")
  private String bookStatusName;

  /**
   * List of the ProcessingBook associated to the book.
   */
  private List<ProcessingBook> processingBookList;


  // ===== Constructor =====

  /** Default Constructor */
  public BookFullDetailsDto() {
    super();
  }


  // ===== Getters and Setters =====

  /**
   * Gives the name of the bookStatus.
   *
   * @return the name of the bookStatus.
   */
  public String getBookStatusName() {
    return bookStatusName;
  }

  /**
   * Set the name of the bookStatus.
   *
   * @param bookStatusName the name of the bookStatus.
   */
  public void setBookStatusName(String bookStatusName) {
    this.bookStatusName = bookStatusName;
  }

  /**
   * Gives the list of processingBook associated to the book.
   *
   * @return the list of processingBook associated to the book.
   */
  public List<ProcessingBook> getProcessingBookList() {
    return processingBookList;
  }

  /**
   * Set the list of processingBook associated to the book.
   *
   * @param processingBookList the list of processingBook associated to the book.
   */
  public void setProcessingBookList(List<ProcessingBook> processingBookList) {
    this.processingBookList = processingBookList;
  }


  // ===== Methods =====


  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookFullDetailsDto{");
    sb.append("bookStatusName='").append(bookStatusName).append('\'');
    sb.append(", processingBookList=").append(processingBookList);
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }
}
