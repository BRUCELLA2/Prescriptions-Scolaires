package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import java.util.List;

/**
 * Interface for PrescriptionListingManager
 *
 * @author BRUCELLA2
 */
public interface PrescriptionListingManager {

  /**
   * Return the list of prescription for the user.
   *
   * @param userId id of the user.
   * @return the list of prescription for the user. If no prescription is not found, return empty list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the userId is null.
   */
  List<PrescriptionWithEpleNameDto> getPrescriptionWithEpleNameListForUser(final Integer userId) throws TechnicalException, FunctionalException;

}
