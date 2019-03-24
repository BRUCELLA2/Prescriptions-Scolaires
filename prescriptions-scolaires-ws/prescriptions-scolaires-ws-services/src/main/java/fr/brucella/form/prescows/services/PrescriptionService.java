package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionFullDetailsDto;
import fr.brucella.form.prescows.entity.prescriptions.dto.PrescriptionWithEpleNameDto;
import fr.brucella.form.prescows.entity.prescriptions.model.Prescription;
import fr.brucella.form.prescows.entity.searchcriteria.dto.SearchCriteriaDto;
import java.util.List;
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
   * @throws PrescoWsException - Throws this exception if there is a technical problem and if the ProcessingPrescription is not found.
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
    else if(userId == null) {
      LOG.error("UserId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "L'identifiant de l'utilisateur est vide. La prescription ne peut être déclarée traitée."));
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

  /**
   * Return the list of prescription for the user.
   *
   * @param userId id of the user.
   * @return the list of prescription for the user. If no prescription is not found, return empty list.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if userId is null.
   */
  @WebMethod
  public List<PrescriptionWithEpleNameDto> prescriptionWithEpleNameListForUser(final Integer userId) throws PrescoWsException {

    if(userId == null) {
      LOG.error("UserId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. L'identifiant de l'utilisateur ne peut être vide."));
    }

    try {
      return this.managerFactory.getPrescriptionListingManager().getPrescriptionWithEpleNameListForUser(userId);
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
   * Return the prescription with the full details with the specified id.
   *
   * @param prescriptionId id of the prescription.
   * @return the prescription with the full details with the specified id.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if prescriptionId is null or if the prescription is not found.
   */
  @WebMethod
  public PrescriptionFullDetailsDto getPrescriptionFullDetailsDto(final Integer prescriptionId) throws PrescoWsException {

    if(prescriptionId == null) {
      LOG.error("PrescriptionId null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. L'identifiant de la prescription ne peut être vide."));
    }

    try {
      return this.managerFactory.getPrescriptionDetailsManager().getPrescriptionFullDetailsDto(prescriptionId);
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
   * Return the list of prescription corresponding to the search criteria.
   *
   * @param searchCriteriaDto the search criteria.
   * @return the list of prescription corresponding to the search criteria. If no prescription is found, return empty list.
   * @throws PrescoWsException - Throws this exception if there is a technical problem or if the searchCriteriaDto is null.
   */
  @WebMethod
  public List<PrescriptionFullDetailsDto> searchPrescription(final SearchCriteriaDto searchCriteriaDto) throws PrescoWsException {

    if(searchCriteriaDto == null) {
      LOG.error("searchCriteriaDto null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "Paramètre incorrect. Les critères de recherche sont vide"));
    }

    try {
      return this.managerFactory.getPrescriptionListingManager().getPrescriptionSearching(searchCriteriaDto);
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
