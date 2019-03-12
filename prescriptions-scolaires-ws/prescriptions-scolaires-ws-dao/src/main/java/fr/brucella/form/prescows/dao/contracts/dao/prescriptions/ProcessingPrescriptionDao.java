package fr.brucella.form.prescows.dao.contracts.dao.prescriptions;

import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;

/**
 * Interface for ProcessingPrescription Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface ProcessingPrescriptionDao {

  /**
   * Gives the processingPrescriptions with the specified user id and prescription id from the datastore.
   *
   * @param userId id of the user.
   * @param prescriptionId id of the prescription.
   * @return the processingPrescriptions with the specified user id and prescription id
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingPrescription is not found.
   */
  ProcessingPrescription getProcessingPrescription(final Integer userId, final Integer prescriptionId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing processingPrescription in the datastore.
   *
   * @param processingPrescription the processingPrescription with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingPrescription is not found.
   */
  void updateProcessingPrescription(final ProcessingPrescription processingPrescription) throws TechnicalException, NotFoundException;

  /**
   * Insert a new processingPrescription in the datastore.
   *
   * @param processingPrescription the processingPrescription to insert in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  void insertProcessingPrescription(final ProcessingPrescription processingPrescription) throws TechnicalException;

  /**
   * Delete the processingPrescription with the specified user id and prescription id from the datastore.
   *
   * @param userId id of the user.
   * @param prescriptionId id of the prescription.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the processingPrescription is not found.
   */
  void deleteProcessingPrescription(final Integer userId, final Integer prescriptionId) throws TechnicalException, NotFoundException;
}
