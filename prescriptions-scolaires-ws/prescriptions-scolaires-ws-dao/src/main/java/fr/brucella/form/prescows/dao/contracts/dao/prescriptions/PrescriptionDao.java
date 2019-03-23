package fr.brucella.form.prescows.dao.contracts.dao.prescriptions;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.List;

/**
 * Interface for Prescription Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface PrescriptionDao {

  /**
   * Gives the prescription with the specified id from the datastore.
   *
   * @param prescriptionId id of the prescription.
   * @return the prescription with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the prescription is not found.
   */
  Prescription getPrescription(final Integer prescriptionId) throws TechnicalException, NotFoundException;

  /**
   * Gives the PrescriptionFullDetailsDto with the specified id from the datastore.
   *
   * @param prescriptionId id of the prescription.
   * @return the PrescriptionFullDetailsDto with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the prescription is not found.
   */
  PrescriptionFullDetailsDto getPrescriptionFullDetailsDto(final Integer prescriptionId) throws TechnicalException, NotFoundException;

  /**
   * Gives the list of PrescriptionWithEpleNameDto for the user with the specified id from the datastore.
   *
   * @param userId id of the user.
   * @return the list of PrescriptionWithEpleNameDto for the user with the specified id
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<PrescriptionWithEpleNameDto> getPrescriptionWithEpleNameDtoList(final Integer userId) throws TechnicalException;

  /**
   * Gives a list of prescription with full details (PrescriptionFullDetailsDto) corresponding to the search criteria.
   *
   * @param searchCriteriaDto search criteria.
   * @return a list of prescription with full details (PrescriptionFullDetailsDto) corresponding to the search criteria.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<PrescriptionFullDetailsDto> getSearchPrescriptionFullDetailsList(final SearchCriteriaDto searchCriteriaDto) throws TechnicalException;

  /**
   * Update an existing prescription in the datastore.
   *
   * @param prescription the prescription with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the prescription is not found.
   */
  void updatePrescription(final Prescription prescription) throws TechnicalException, NotFoundException;

  /**
   * Insert a new prescription in the datastore.
   *
   * @param prescription the prescription to insert in datastore.
   * @return the id of the new prescription.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertPrescription(final Prescription prescription) throws TechnicalException;

  /**
   * Delete the prescription with the specified id in the datastore.
   *
   * @param prescriptionId id of the prescription.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the prescription is not found.
   */
  void deletePrescription(final Integer prescriptionId) throws TechnicalException, NotFoundException;
}
