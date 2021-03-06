package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;

/**
 * Interface for PrescriptionDetailsManager
 *
 * @author BRUCELLA2
 */
public interface PrescriptionDetailsManager {

  /**
   * Make a prescription.
   * Save in datastore the prescription in parameter and return the id of the new prescription.
   *
   * @param prescription prescription the prescription to save in datastore.
   * @return the id of the new prescription saved in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the prescription is not valid.
   */
  Integer addPrescription(final Prescription prescription) throws TechnicalException, FunctionalException;

  /**
   * Modify a prescription.
   *
   * @param prescription the prescription with the updated informations to save in datastore.
   * @return true if modification is a success. Throw exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the prescription is null or invalid or if the prescription is not found.
   */
  Boolean modifyPrescription(final Prescription prescription) throws TechnicalException, FunctionalException;

  /**
   * Delete a prescription
   *
   * @param prescriptionId id of the prescription to delete.
   * @return true if delete is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - Throws this exception if the prescriptionId is null or if the prescription is not found.
   */
  Boolean deletePrescription(final Integer prescriptionId) throws TechnicalException, FunctionalException;

  /**
   * Declare prescription processed for an user.
   *
   * @param prescriptionId id of the prescription.
   * @param userId id of the user.
   * @param prescriptionProcessed true if the prescription is processed, false otherwise.
   * @return true if update is a success. Throws exception if not.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - Throws this exception if the userId or the prescriptionId are null.
   */
  Boolean prescriptionProcessed(final Integer prescriptionId, final Integer userId, final Boolean prescriptionProcessed) throws TechnicalException, FunctionalException;

  /**
   * Return the prescription with the full details with the specified id.
   *
   * @param prescriptionId id of the prescription.
   * @return the prescription with the full details with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - Throws this exception if the prescriptionId is null or if the prescription is not found.
   */
  PrescriptionFullDetailsDto getPrescriptionFullDetailsDto(final Integer prescriptionId) throws TechnicalException, FunctionalException;
}
