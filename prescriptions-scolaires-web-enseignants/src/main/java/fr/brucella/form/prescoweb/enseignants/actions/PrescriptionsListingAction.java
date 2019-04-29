package fr.brucella.form.prescoweb.enseignants.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.PrescoWsException_Exception;
import generated.authentificationserviceclient.UserDetailsDto;
import generated.prescriptionserviceclient.PrescriptionService;
import generated.prescriptionserviceclient.PrescriptionService_Service;
import generated.prescriptionserviceclient.PrescriptionWithEpleNameDto;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Prescriptions Listing action.
 *
 * @author BRUCELLA2
 */
public class PrescriptionsListingAction extends ActionSupport implements SessionAware, ServletRequestAware {

  /** User Action logger */
  private static final Log LOG = LogFactory.getLog(PrescriptionsListingAction.class);

  /** The list of prescriptions with eple name. */
  private List<PrescriptionWithEpleNameDto> prescriptionsList;

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;


  // ----- Constructors

  /** Default constructor. */
  public PrescriptionsListingAction() {
    super();
  }


  // ----- Getters and Setters

  /**
   * Give the list of prescriptions with eple name.
   *
   * @return the list of prescriptions with eple name.
   */
  public List<PrescriptionWithEpleNameDto> getPrescriptionsList() {
    return this.prescriptionsList;
  }

  /**
   * Set the list of prescriptions with eple name.
   *
   * @param prescriptionsList the list of prescriptions with eple name.
   */
  public void setPrescriptionsList(final List<PrescriptionWithEpleNameDto> prescriptionsList) {
    this.prescriptionsList = prescriptionsList;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /**
   * Give the user's HTTP session attributes.
   *
   * @return the user's HTTP session attributes.
   */
  public Map<String, Object> getSession() {
    return session;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }

  // ===== Methods =====

  /**
   * Display the list of prescriptions.
   *
   * @return ERROR if error occured.
   *         SUCCESS otherwise.
   */
  public String doPrescriptionsListing() {

    final PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
    final PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();

    final UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");

    try {
      prescriptionsList = prescriptionServicePort.prescriptionWithEpleNameListForUser(userDetailsDto.getUserId());
    } catch (generated.prescriptionserviceclient.PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }
}
