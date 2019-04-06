package fr.brucella.form.prescoweb.libraires.actions;

import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.Eple;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Search actions.
 *
 * @author BRUCELLA2
 */
public class SearchAction extends ActionSupport implements SessionAware, ServletRequestAware {

  /** Search Action logger */
  private static final Log LOG = LogFactory.getLog(SearchAction.class);

  /** Id of the department. */
  private Integer departmentId;

  /** Id of the city. */
  private Integer cityId;

  /** Id of the eple. */
  private Integer epleId;

  /** List of the departments. */
  private List<Department> departmentList;

  /** List of the city. */
  private List<City> cityList;

  /** List of the eple. */
  private List<Eple> epleList;

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;


  // ----- Constructors

  /** Default constructor. */
  public SearchAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ----- Getters and Setters


}
