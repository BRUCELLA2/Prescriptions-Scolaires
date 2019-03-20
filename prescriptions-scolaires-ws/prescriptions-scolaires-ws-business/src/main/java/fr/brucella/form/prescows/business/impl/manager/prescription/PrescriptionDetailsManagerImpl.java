package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Prescription Details Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class PrescriptionDetailsManagerImpl extends AbstractManager implements PrescriptionDetailsManager {

  /** Prescription Details Manager logger. */
  private static final Log LOG = LogFactory.getLog(PrescriptionDetailsManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public PrescriptionDetailsManagerImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Integer addPrescription(Prescription prescription) throws TechnicalException, FunctionalException {

    if(prescription == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.createPrescription.prescriptionNull"));
    }

    final Set<ConstraintViolation<Prescription>> violations = this.getConstraintValidator().validate(prescription);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Prescription> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("PrescriptionDetailsManager.createPrescription.constraints"));
      throw new FunctionalException(
          messages.getString("PrescriptionDetailsManager.createPrescription.constraints"));
    }

    return this.getDaoFactory().getPrescriptionDao().insertPrescription(prescription);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyPrescription(Prescription prescription) throws TechnicalException, FunctionalException {

    if(prescription == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.modifyPrescription.prescriptionNull"));
    }

    final Set<ConstraintViolation<Prescription>> violations = this.getConstraintValidator().validate(prescription);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Prescription> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("PrescriptionDetailsManager.modifyPrescription.constraints"));
      throw new FunctionalException(
          messages.getString("PrescriptionDetailsManager.modifyPrescription.constraints"));
    }

    try {
      this.getDaoFactory().getPrescriptionDao().updatePrescription(prescription);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }


}
