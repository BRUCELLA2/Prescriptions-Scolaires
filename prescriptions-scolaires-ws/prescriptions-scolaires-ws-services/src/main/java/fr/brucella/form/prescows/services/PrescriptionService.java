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
   * @throws PrescoWsException Throw this exception if there is a technical problem or if the prescription is null or invalid.
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
   * @return true if modification is a success. Throw exception if not.
   * @throws PrescoWsException Throw this exception if there is a technical problem or if the prescription is null or invalid.
   */
  @WebMethod
  public boolean modifyPrescription(final Prescription prescription) throws PrescoWsException {

    if(prescription == null) {
      LOG.error("Prescription null");
      throw new PrescoWsException(FUNC_ERROR, new PrescoWsFault(CLIENT, "La prescription est vide. Création impossible"));
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
}
