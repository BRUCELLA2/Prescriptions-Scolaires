package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookListingManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.BookFullDetailsDto;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Book Listing Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BookListingManagerImpl extends AbstractManager implements BookListingManager {

  /** Book Listing Manager logger. */
  private static final Log LOG = LogFactory.getLog(BookListingManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public BookListingManagerImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public List<BookFullDetailsDto> getBookFullDetailsListPrescription(Integer prescriptionId)
      throws TechnicalException, FunctionalException {

    if(prescriptionId == null) {
      LOG.error(messages.getString("BookListingManager.getBookFullDetailsListPrescription.prescriptionIdNull"));;
      throw new FunctionalException(messages.getString("BookListingManager.getBookFullDetailsListPrescription.prescriptionIdNull"));
    }

    return this.getDaoFactory().getBookDao().getBookFullDetailsListPrescription(prescriptionId);
  }

}
