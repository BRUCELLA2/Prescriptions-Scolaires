package fr.brucella.form.prescows.services;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.entity.eples.model.City;
import fr.brucella.form.prescows.entity.eples.model.Department;
import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsException;
import fr.brucella.form.prescows.entity.exceptions.PrescoWsFault;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Utility web services
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "UtilityService")
@Component
public class UtilityService extends SpringBeanAutowiringSupport {

  /** Book Service Logger */
  private static final Log LOG = LogFactory.getLog(UtilityService.class);

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
  public UtilityService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //

  /**
   * Gives the list of Departments.
   *
   * @return the list of Departments.
   * @throws PrescoWsException - Throws this exception if there is a technical problem.
   */
  @WebMethod
  public List<Department> getDepartmentList() throws PrescoWsException {

    try {
      return this.managerFactory.getUtilityManager().getListDepartment();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Gives the list of cities.
   *
   * @return the list of cities.
   * @throws PrescoWsException - Throws this exception if there is a technical problem.
   */
  @WebMethod
  public List<City> getCityList() throws PrescoWsException {

    try {
      return this.managerFactory.getUtilityManager().getListCity();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Gives the list of eple.
   *
   * @return the list of eple.
   * @throws PrescoWsException - Throws this exception if there is a technical problem.
   */
  @WebMethod
  public List<Eple> getEpleList() throws PrescoWsException {

    try{
      return this.managerFactory.getUtilityManager().getListEple();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new PrescoWsException(
          TECH_ERROR, exception, new PrescoWsFault(SERVER, exception.getMessage()));
    }
  }
}
