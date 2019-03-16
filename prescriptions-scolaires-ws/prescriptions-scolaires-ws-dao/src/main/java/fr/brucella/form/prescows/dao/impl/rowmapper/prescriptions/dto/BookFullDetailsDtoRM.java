package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a BookFullDetailsDto object.
 * The list of ProcessingBook is set to null. An update of the BookFullDetailsDto is needed after row mapping to set the list of ProcessingBook.
 *
 * @author BRUCELLA2
 */
public class BookFullDetailsDtoRM implements RowMapper<BookFullDetailsDto> {

  /** Default Constructor */
  public BookFullDetailsDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public BookFullDetailsDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookFullDetailsDto bookFullDetailsDto = new BookFullDetailsDto();

    bookFullDetailsDto.setBookId(resultSet.getInt("book_id"));
    bookFullDetailsDto.setEan(resultSet.getString("ean"));
    bookFullDetailsDto.setTitle(resultSet.getString("title"));
    bookFullDetailsDto.setAuthor(resultSet.getString("author"));
    bookFullDetailsDto.setComments(resultSet.getString("comments"));
    bookFullDetailsDto.setEmailTeacherSend(resultSet.getBoolean("email_teacher_send"));
    if(resultSet.getTimestamp("email_send_date") == null) {
      bookFullDetailsDto.setEmailSendDate(null);
    } else {
      bookFullDetailsDto.setEmailSendDate(resultSet.getTimestamp("email_send_date").toLocalDateTime());
    }
    bookFullDetailsDto.setBookStatusId(resultSet.getInt("book_status_id"));
    bookFullDetailsDto.setPrescriptionId(resultSet.getInt("prescription_id"));
    bookFullDetailsDto.setBookStatusName(resultSet.getString("book_status_name"));
    bookFullDetailsDto.setProcessingBookList(null);

    return bookFullDetailsDto;
  }
}
