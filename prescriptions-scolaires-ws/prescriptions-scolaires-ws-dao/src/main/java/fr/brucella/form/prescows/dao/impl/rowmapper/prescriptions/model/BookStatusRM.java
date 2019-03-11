package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model;

import fr.brucella.form.prescows.entity.prescriptions.model.BookStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a BookStatus object.
 *
 * @author BRUCELLA2
 */
public class BookStatusRM implements RowMapper<BookStatus> {

  /** Default Constructor */
  public BookStatusRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public BookStatus mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookStatus bookStatus = new BookStatus();

    bookStatus.setBookStatusId(resultSet.getInt("book_status_id"));
    bookStatus.setName(resultSet.getString("book_status_name"));

    return bookStatus;
  }
}
