package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model;

import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a ProcessingPrescription object.
 *
 * @author BRUCELLA2
 */
public class ProcessingPrescriptionRM implements RowMapper<ProcessingPrescription> {

  /** Default Constructor */
  public ProcessingPrescriptionRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public ProcessingPrescription mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final ProcessingPrescription processingPrescription = new ProcessingPrescription();

    processingPrescription.setUserId(resultSet.getInt("user_id"));
    processingPrescription.setPrescriptionId(resultSet.getInt("prescription_id"));
    processingPrescription.setProcessingStatus(resultSet.getBoolean("processing_status"));

    return processingPrescription;
  }
}
