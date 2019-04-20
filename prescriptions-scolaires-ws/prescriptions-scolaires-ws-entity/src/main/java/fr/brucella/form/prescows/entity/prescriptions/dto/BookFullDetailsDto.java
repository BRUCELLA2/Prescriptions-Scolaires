package fr.brucella.form.prescows.entity.prescriptions.dto;

import fr.brucella.form.prescows.entity.adapters.LocalDateWithTimeAdapter;
import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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

  /** Deadline date for book purchase. Can't be null. */
  @NotNull(message = "{prescription.purchaseDeadline.null}")
  private LocalDateTime purchaseDeadline;

  /** Name of eple. Can't be null */
  @NotEmpty(message = "{eple.epleName.empty}")
  @Size(min = 1, max = 100, message = "{eple.epleName.size}")
  private String epleName;

  /** headcount of the prescription. Can't be null. */
  @NotNull(message = "{prescription.headcount.null")
  private Integer headcount;

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
  public void setBookStatusName(final String bookStatusName) {
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
  public void setProcessingBookList(final List<ProcessingBook> processingBookList) {
    this.processingBookList = processingBookList;
  }

  /**
   * Gives the books purchase deadline.
   *
   * @return the books purchase deadline.
   */
  @XmlJavaTypeAdapter(value = LocalDateWithTimeAdapter.class)
  public LocalDateTime getPurchaseDeadline() {
    return purchaseDeadline;
  }

  /**
   * Set the books purchase deadline.
   *
   * @param purchaseDeadline the books purchase deadline.
   */
  public void setPurchaseDeadline(LocalDateTime purchaseDeadline) {
    this.purchaseDeadline = purchaseDeadline;
  }

  /**
   * Give the name of eple.
   *
   * @return the name of eple.
   */
  public String getEpleName() {
    return epleName;
  }

  /**
   * Set the name of eple.
   *
   * @param epleName the name of eple.
   */
  public void setEpleName(final String epleName) {
    this.epleName = epleName;
  }

  /**
   * Give the headcount of the prescription.
   *
   * @return the headcount of the prescription.
   */
  public Integer getHeadcount() {
    return headcount;
  }

  /**
   * Set the headcount of the prescription.
   *
   * @param headcount the headcount of the prescription.
   */
  public void setHeadcount(final Integer headcount) {
    this.headcount = headcount;
  }

  // ===== Methods =====

  /** {@inheritDoc} **/
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookFullDetailsDto{");
    sb.append("bookStatusName='").append(bookStatusName).append('\'');
    sb.append(", purchaseDeadline=").append(purchaseDeadline);
    sb.append(", epleName=").append(epleName);
    sb.append(", headcount=").append(headcount);
    sb.append(", processingBookList=").append(processingBookList);
    sb.append(super.toString());
    sb.append('}');
    return sb.toString();
  }
}
