package fr.brucella.form.prescows.business.contracts.managers.prescription;

import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookWithStatusDto;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.List;

/**
 * Interface for BookListing Manager
 *
 * @author BRUCELLA2
 */
public interface BookListingManager {

  /**
   * Return the list of book with full details for the prescription.
   *
   * @param prescriptionId id of the prescription
   * @return the list of book with full details for the prescription. If the prescription is not found, return empty list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the prescriptionId is null.
   */
  List<BookFullDetailsDto> getBookFullDetailsListPrescription(final Integer prescriptionId) throws TechnicalException, FunctionalException;

  /**
   * Return the list of book with book status for the prescription.
   *
   * @param prescriptionId id of the prescription.
   * @return the list of book with book status for the prescription. If no prescription is not found, return empty list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the prescriptionId is null.
   */
  List<BookWithStatusDto> getBookWithStatusListForPrescription(final Integer prescriptionId) throws TechnicalException, FunctionalException;

  /**
   * Return the list of book corresponding to the search criteria.
   *
   * @param searchCriteriaDto the search criteria.
   * @return the list of book corresponding to the search criteria. If no books is found, return empty list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException  - This exception is throw if the searchCriteriaDto is null.
   */
  List<BookFullDetailsDto> getBookSearching(final SearchCriteriaDto searchCriteriaDto) throws TechnicalException, FunctionalException;
}
