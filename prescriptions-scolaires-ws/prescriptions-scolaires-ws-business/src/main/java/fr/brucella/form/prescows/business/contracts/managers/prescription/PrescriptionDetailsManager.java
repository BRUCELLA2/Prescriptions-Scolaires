package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
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
   * @throws FunctionalException - This exception is throw if the prescription is not valid.
   */
  Boolean modifyPrescription(final Prescription prescription) throws TechnicalException, FunctionalException;
}
