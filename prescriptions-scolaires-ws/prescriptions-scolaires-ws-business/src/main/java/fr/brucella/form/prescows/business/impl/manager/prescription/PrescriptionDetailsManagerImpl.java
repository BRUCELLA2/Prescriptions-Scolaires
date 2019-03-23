package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import fr.brucella.form.prescows.entity.prescriptions.model.ProcessingPrescription;
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
  public Integer addPrescription(final Prescription prescription) throws TechnicalException, FunctionalException {

    if(prescription == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.createPrescription.prescriptionNull"));
      throw new FunctionalException(messages.getString("PrescriptionDetailsManager.createPrescription.prescriptionNull"));
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
  public Boolean modifyPrescription(final Prescription prescription) throws TechnicalException, FunctionalException {

    if(prescription == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.modifyPrescription.prescriptionNull"));
      throw new FunctionalException(messages.getString("PrescriptionDetailsManager.modifyPrescription.prescriptionNull"));
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

  /** {@inheritDoc} */
  @Override
  public Boolean deletePrescription(final Integer prescriptionId) throws TechnicalException, FunctionalException {

    if(prescriptionId == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.deletePrescription.prescriptionIdNull"));
      throw new FunctionalException(messages.getString("PrescriptionDetailsManager.deletePrescription.prescriptionIdNull"));
    }

    try {
      this.getDaoFactory().getPrescriptionDao().deletePrescription(prescriptionId);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean prescriptionProcessed(final Integer prescriptionId, Integer userId)
      throws TechnicalException, FunctionalException {

    if(prescriptionId == null || userId == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.prescriptionProcessed.prescriptionIdOrUserIdNull"));
      throw new FunctionalException(messages.getString("PrescriptionDetailsManager.prescriptionProcessed.prescriptionIdOrUserIdNull"));
    }

    try {
      final ProcessingPrescription processingPrescription = new ProcessingPrescription();
      processingPrescription.setUserId(userId);
      processingPrescription.setPrescriptionId(prescriptionId);
      processingPrescription.setProcessingStatus(true);
      this.getDaoFactory().getProcessingPrescriptionDao().updateProcessingPrescription(processingPrescription);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public PrescriptionFullDetailsDto getPrescriptionFullDetailsDto(Integer prescriptionId)
      throws TechnicalException, FunctionalException {

    if(prescriptionId == null) {
      LOG.error(messages.getString("PrescriptionDetailsManager.getPrescriptionFullDetailsDto.prescriptionIdNull"));
      throw new FunctionalException(messages.getString("PrescriptionDetailsManager.getPrescriptionFullDetailsDto.prescriptionIdNull"));
    }

    try {
      return this.getDaoFactory().getPrescriptionDao().getPrescriptionFullDetailsDto(prescriptionId);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }
}
