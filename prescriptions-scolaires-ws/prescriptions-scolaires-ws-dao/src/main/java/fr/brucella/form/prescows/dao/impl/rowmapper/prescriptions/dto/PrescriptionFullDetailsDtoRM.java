package fr.brucella.form.prescows.dao.impl.rowmapper.prescriptions.dto;

import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a PrescriptionFullDetailsDto object.
 * The list of ProcessingPrescription is set to null. An update of the PrescriptionFullDetailsDto is needed after row mapping to set the list of ProcessingPrescription.
 *
 * @author BRUCELLA2
 */
public class PrescriptionFullDetailsDtoRM implements RowMapper<PrescriptionFullDetailsDto> {

  /** Default Constructor */
  public PrescriptionFullDetailsDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public PrescriptionFullDetailsDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final PrescriptionFullDetailsDto prescriptionFullDetailsDto = new PrescriptionFullDetailsDto();

    prescriptionFullDetailsDto.setPrescriptionId(resultSet.getInt("prescription_id"));
    prescriptionFullDetailsDto.setPrescriptionName(resultSet.getString("prescription_name"));
    if(resultSet.getTimestamp("creation_date") == null) {
      prescriptionFullDetailsDto.setCreationDate(null);
    } else {
      prescriptionFullDetailsDto.setCreationDate(resultSet.getTimestamp("creation_date").toLocalDateTime());
    }
    prescriptionFullDetailsDto.setUserId(resultSet.getInt("user_id"));
    if(resultSet.getTimestamp("purchase_deadline") == null) {
      prescriptionFullDetailsDto.setPurchaseDeadline(null);
    } else {
      prescriptionFullDetailsDto.setPurchaseDeadline(resultSet.getTimestamp("purchase_deadline").toLocalDateTime());
    }
    prescriptionFullDetailsDto.setValidationStatus(resultSet.getBoolean("validation_status"));
    prescriptionFullDetailsDto.setEpleId(resultSet.getInt("eple_id"));
    prescriptionFullDetailsDto.setEpleName(resultSet.getString("eple_name"));
    prescriptionFullDetailsDto.setCityName(resultSet.getString("city_name"));
    prescriptionFullDetailsDto.setDepartmentName(resultSet.getString("department_name"));
    prescriptionFullDetailsDto.setProcessingPrescriptionList(null);
    prescriptionFullDetailsDto.setHeadcount(resultSet.getInt("headcount"));

    return prescriptionFullDetailsDto;
  }
}
