package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a PrescriptionWithEpleNameDto object.
 *
 * @author BRUCELLA2
 */
public class PrescriptionWithEpleNameDtoRM implements RowMapper<PrescriptionWithEpleNameDto> {

  /** Default Constructor */
  public PrescriptionWithEpleNameDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public PrescriptionWithEpleNameDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final PrescriptionWithEpleNameDto prescriptionWithEpleNameDto = new PrescriptionWithEpleNameDto();

    prescriptionWithEpleNameDto.setPrescriptionId(resultSet.getInt("prescription_id"));
    prescriptionWithEpleNameDto.setPrescriptionName(resultSet.getString("prescription_name"));
    if(resultSet.getTimestamp("creation_date") == null) {
      prescriptionWithEpleNameDto.setCreationDate(null);
    } else {
      prescriptionWithEpleNameDto.setCreationDate(resultSet.getTimestamp("creation_date").toLocalDateTime());
    }
    prescriptionWithEpleNameDto.setUserId(resultSet.getInt("user_id"));
    if(resultSet.getTimestamp("purchase_deadline") == null) {
      prescriptionWithEpleNameDto.setPurchaseDeadline(null);
    } else {
      prescriptionWithEpleNameDto.setPurchaseDeadline(resultSet.getTimestamp("purchase_deadline").toLocalDateTime());
    }
    prescriptionWithEpleNameDto.setValidationStatus(resultSet.getBoolean("validation_status"));
    prescriptionWithEpleNameDto.setEpleId(resultSet.getInt("eple_id"));
    prescriptionWithEpleNameDto.setEpleName(resultSet.getString("eple_name"));

    return prescriptionWithEpleNameDto;
  }
}
