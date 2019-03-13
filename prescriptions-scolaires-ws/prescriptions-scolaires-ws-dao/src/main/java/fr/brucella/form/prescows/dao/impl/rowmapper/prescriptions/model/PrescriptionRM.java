package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.model;

import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Prescription object.
 *
 * @author BRUCELLA2
 */
public class PrescriptionRM implements RowMapper<Prescription> {

  /** Default Constructor */
  public PrescriptionRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Prescription mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Prescription prescription = new Prescription();

    prescription.setPrescriptionId(resultSet.getInt("prescription_id"));
    prescription.setPrescriptionName(resultSet.getString("prescription_name"));
    if(resultSet.getTimestamp("creation_date") == null) {
      prescription.setCreationDate(null);
    } else {
      prescription.setCreationDate(resultSet.getTimestamp("creation_date").toLocalDateTime());
    }
    prescription.setUserId(resultSet.getInt("user_id"));
    if(resultSet.getTimestamp("purchase_deadline") == null) {
      prescription.setPurchaseDeadline(null);
    } else {
      prescription.setPurchaseDeadline(resultSet.getTimestamp("purchase_deadline").toLocalDateTime());
    }
    prescription.setValidationStatus(resultSet.getBoolean("validation_status"));
    prescription.setEpleId(resultSet.getInt("eple_id"));

    return prescription;
  }
}
