package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Prescription Web Service
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "PrescriptionService")
@Component
public class PrescriptionService extends SpringBeanAutowiringSupport {


  /** Book Service Logger */
  private static final Log LOG = LogFactory.getLog(BookService.class);

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired
  private ManagerFactory managerFactory;


  // ===== Constructor =====

  /** Default constructor. */
  public PrescriptionService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //

  /**
   * Make a prescription.
   * Save in datastore the prescription in parameter and return the id of the new prescription.
   *
   * @param prescription the prescription to save in datastore.
   * @return the id of the new prescription saved in datastore.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the prescription is null or invalid.
   */
  @WebMethod
  public Integer makePrescription(final Prescription prescription) throws PrescoWsException {

    if(prescription == null) {
      LOG.error("Prescription null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "La prescription est vide. Création impossible"));
    }

    try {
      return this.managerFactory.getPrescriptionDetailsManager().addPrescription(prescription);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Modify a prescription.
   *
   * @param prescription the prescription with the updated informations to save in datastore.
   * @return true if modification is a success. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem, if the prescription is null or invalid or if the prescription is not found.
   */
  @WebMethod
  public boolean modifyPrescription(final Prescription prescription) throws PrescoWsException {

    if(prescription == null) {
      LOG.error("Prescription null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "La prescription est vide. Modification impossible"));
    }

    try {
      return this.managerFactory.getPrescriptionDetailsManager().modifyPrescription(prescription);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Delete a prescription
   *
   * @param prescriptionId id of the prescription to delete.
   * @return true if delete is a success. Throws exception if not.
   * @throws PrescoWsException - Throws this exception if there is a technical problem, if the prescriptionId is null or if the prescription is not found.
   */
  @WebMethod
  public boolean deletePrescription(final Integer prescriptionId) throws PrescoWsException {

    if(prescriptionId == null) {
      LOG.error("PrescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de la prescription est vide. Suppression impossible."));
    }

    try {
      return this.managerFactory.getPrescriptionDetailsManager().deletePrescription(prescriptionId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Declare prescription processed for an user.
   *
   * @param prescriptionId id of the prescription.
   * @param userId id of the user.
   * @return true if delete is a success. Throws exception if not.
   * @throws PrescoWsException Throws this exception if there is a technical problem and if the ProcessingPrescription is not found.
   */
  @WebMethod
  public boolean prescriptionProcessed(final Integer prescriptionId, final Integer userId) throws PrescoWsException {

    if(prescriptionId == null && userId == null) {
      LOG.error("PrescriptionId and userId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de la prescription et de l'utilisateur sont vides. La prescription ne peut être déclarée traitée."));
    }
    else if(prescriptionId == null) {
      LOG.error("PrescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de la prescription est vide. La prescription ne peut être déclarée traitée."));
    }
    else if(prescriptionId == null) {
      LOG.error("UserId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de l'ustilisateur est vide. La prescription ne peut être déclarée traitée."));
    }

    try {
      return this.managerFactory.getPrescriptionDetailsManager().prescriptionProcessed(prescriptionId, userId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          FUNC_ERROR, exception, new PrescoWsFault(CLIENT, exception.getMessage()));
    }
  }
}
