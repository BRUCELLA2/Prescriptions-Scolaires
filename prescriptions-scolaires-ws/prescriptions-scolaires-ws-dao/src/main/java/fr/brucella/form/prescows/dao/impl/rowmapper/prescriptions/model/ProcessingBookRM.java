package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model;

import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a ProcessingBook object.
 *
 * @author BRUCELLA2
 */
public class ProcessingBookRM implements RowMapper<ProcessingBook> {

  /** Default Constructor */
  public ProcessingBookRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public ProcessingBook mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final ProcessingBook processingBook = new ProcessingBook();

    processingBook.setUserId(resultSet.getInt("user_id"));
    processingBook.setBookId(resultSet.getInt("book_id"));
    processingBook.setProcessingStatus(resultSet.getBoolean("processing_status"));

    return processingBook;
  }
}
