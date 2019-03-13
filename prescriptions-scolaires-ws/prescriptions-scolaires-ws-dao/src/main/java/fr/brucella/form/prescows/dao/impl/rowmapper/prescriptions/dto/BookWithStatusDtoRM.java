package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a BookWithStatusDto object.
 *
 * @author BRUCELLA2
 */
public class BookWithStatusDtoRM implements RowMapper<BookWithStatusDto> {

  /** Default Constructor */
  public BookWithStatusDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  @Override
  public BookWithStatusDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookWithStatusDto bookWithStatusDto = new BookWithStatusDto();

    bookWithStatusDto.setBookId(resultSet.getInt("book_id"));
    bookWithStatusDto.setEan(resultSet.getString("ean"));
    bookWithStatusDto.setTitle(resultSet.getString("title"));
    bookWithStatusDto.setAuthor(resultSet.getString("author"));
    bookWithStatusDto.setComments(resultSet.getString("comments"));
    bookWithStatusDto.setEmailTeacherSend(resultSet.getBoolean("email_teacher_send"));
    if(resultSet.getTimestamp("email_send_date") == null) {
      bookWithStatusDto.setEmailSendDate(null);
    } else {
      bookWithStatusDto.setEmailSendDate(resultSet.getTimestamp("email_send_date").toLocalDateTime());
    }
    bookWithStatusDto.setBookStatusId(resultSet.getInt("book_status_id"));
    bookWithStatusDto.setPrescriptionId(resultSet.getInt("prescription_id"));
    bookWithStatusDto.setNameStatus(resultSet.getString("book_status_name"));

    return bookWithStatusDto;
  }
}
