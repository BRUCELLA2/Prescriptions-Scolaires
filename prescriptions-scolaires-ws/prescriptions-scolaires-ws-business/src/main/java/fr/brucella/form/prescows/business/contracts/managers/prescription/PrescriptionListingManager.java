package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
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

  /**
   * Return the list of prescription corresponding to the search criteria.
   *
   * @param searchCriteriaDto the search criteria.
   * @return the list of prescription corresponding to the search criteria. If no prescription is found, return empty list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the searchCriteriaDto is null.
   */
  List<PrescriptionFullDetailsDto> getPrescriptionSearching(final SearchCriteriaDto searchCriteriaDto) throws TechnicalException, FunctionalException;
}
