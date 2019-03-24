package fr.brucella.form.prescows.business.impl.manager.prescription;


import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionListingManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Prescription Listing Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class PrescriptionListingManagerImpl extends AbstractManager implements PrescriptionListingManager {

  /** Prescription Listing Manager logger. */
  private static final Log LOG = LogFactory.getLog(PrescriptionListingManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public PrescriptionListingManagerImpl() {
    super();
  }


  // ===== Methods =====
  /** {@inheritDoc} */
  @Override
  public List<PrescriptionWithEpleNameDto> getPrescriptionWithEpleNameListForUser(final Integer userId)
      throws TechnicalException, FunctionalException {

    if(userId == null) {
      LOG.error(messages.getString("PrescriptionListingManager.getPrescriptionWithEpleNameListForUser.userIdNull"));;
      throw new FunctionalException(messages.getString("PrescriptionListingManager.getPrescriptionWithEpleNameListForUser.userIdNull"));
    }

    return this.getDaoFactory().getPrescriptionDao().getPrescriptionWithEpleNameDtoList(userId);
  }

  /** {@inheritDoc} */
  @Override
  public List<PrescriptionFullDetailsDto> getPrescriptionSearching(SearchCriteriaDto searchCriteriaDto)
      throws TechnicalException, FunctionalException {

    if(searchCriteriaDto == null) {
      LOG.error(messages.getString("PrescriptionListingManager.getPrescriptionSearching.searchCriteriaDtoNull"));;
      throw new FunctionalException(messages.getString("PrescriptionListingManager.getPrescriptionSearching.searchCriteriaDtoNull"));
    }

    return this.getDaoFactory().getPrescriptionDao().getSearchPrescriptionFullDetailsList(searchCriteriaDto);
  }
}
