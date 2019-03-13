package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model;

import fr.brucella.form.prescows.entity.prescriptions.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Book object.
 *
 * @author BRUCELLA2
 */
public class BookRM implements RowMapper<Book> {

  /** Default Constructor */
  public BookRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Book mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Book book = new Book();

    book.setBookId(resultSet.getInt("book_id"));
    book.setEan(resultSet.getString("ean"));
    book.setTitle(resultSet.getString("title"));
    book.setAuthor(resultSet.getString("author"));
    book.setComments(resultSet.getString("comments"));
    book.setEmailTeacherSend(resultSet.getBoolean("email_teacher_send"));
    if(resultSet.getTimestamp("email_send_date") == null) {
      book.setEmailSendDate(null);
    } else {
      book.setEmailSendDate(resultSet.getTimestamp("email_send_date").toLocalDateTime());
    }
    book.setBookStatusId(resultSet.getInt("book_status_id"));
    book.setPrescriptionId(resultSet.getInt("prescription_id"));

    return book;
  }
}
