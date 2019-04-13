package fr.brucella.form.prescoweb.libraires.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.UserDetailsDto;
import generated.bookserviceclient.BookFullDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.ProcessingBook;
import generated.bookserviceclient.SearchCriteriaDto;
import generated.prescriptionserviceclient.PrescriptionFullDetailsDto;
import generated.prescriptionserviceclient.PrescriptionService;
import generated.prescriptionserviceclient.PrescriptionService_Service;
import generated.prescriptionserviceclient.ProcessingPrescription;
import generated.utilityserviceclient.Eple;
import generated.utilityserviceclient.City;
import generated.utilityserviceclient.Department;
import generated.utilityserviceclient.PrescoWsException_Exception;
import generated.utilityserviceclient.UtilityService;
import generated.utilityserviceclient.UtilityService_Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
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

  /** Rne of the eple. */
  private String epleRne;

  /** The purchase deadline of the prescription. */
  private String deadline;

  /** String indicating if the option "processed" is active. */
  private String processed;

  /** String indicating if the view show prescription or books of prescriptions. */
  private String bookView;

  /** Id of the book. */
  private Integer bookId;

  /** List of prescriptions with full details. */
  private List<PrescriptionFullDetailsDto> prescriptionsList;

  /** List of books with full details. */
  private List<BookFullDetailsDto> booksList;

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

    final UtilityService_Service utilityService = new UtilityService_Service();
    final UtilityService utilityServicePort = utilityService.getUtilityServicePort();

    try {
      this.departmentList = utilityServicePort.getDepartmentList();
      this.cityList = utilityServicePort.getCityList();
      this.epleList = utilityServicePort.getEpleList();
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
    }
  }

  // ----- Getters and Setters

  /**
   * Give the id of the department.
   *
   * @return the id of the department.
   */
  public Integer getDepartmentId() {
    return this.departmentId;
  }

  /**
   * Set the id of the department.
   *
   * @param departmentId the id of the department.
   */
  public void setDepartmentId(final Integer departmentId) {
    this.departmentId = departmentId;
  }

  /**
   * Give the id of the city.
   *
   * @return the id of the city.
   */
  public Integer getCityId() {
    return cityId;
  }

  /**
   * Set the id of the city.
   *
   * @param cityId the id of the city.
   */
  public void setCityId(final Integer cityId) {
    this.cityId = cityId;
  }

  /**
   * Give the rne of the eple.
   *
   * @return the rne of the eple.
   */
  public String getEpleRne() {
    return this.epleRne;
  }

  /**
   * Set the rne of the eple.
   *
   * @param epleRne the rne of the eple.
   */
  public void setEpleRne(final String epleRne) {
    this.epleRne = epleRne;
  }

  /**
   * Give the purchase deadline of the prescription.
   *
   * @return the purchase deadline of the prescription.
   */
  public String getDeadline() {
    return this.deadline;
  }

  /**
   * Set the purchase deadline of the prescription.
   *
   * @param deadline the purchase deadline of the prescription.
   */
  public void setDeadline(final String deadline) {
    this.deadline = deadline;
  }

  /**
   * Indicate if the option "processed" is active. "true" or "false".
   *
   * @return the string "true" if the option "processed" is active, "false" otherwise.
   */
  public String getProcessed() {
    return this.processed;
  }

  /**
   * Indicate if the option "processed" is active. "true" or "false".
   *
   * @param processed the string "true" if the option "processed" is active, "false" otherwise.
   */
  public void setProcessed(final String processed) {
    this.processed = processed;
  }

  /**
   * Indicate if the view needs to show prescription or books of prescriptions. "true" or "false".
   *
   * @return the string "true" if the view needs to show prescription or books of prescriptions, false otherwise.
   */
  public String getBookView() {
    return this.bookView;
  }

  /**
   * Indicate if the view needs to show prescription or books of prescriptions. "true" or "false".
   *
   * @param bookView the string "true" if the view needs to show prescription or books of prescriptions, false otherwise.
   */
  public void setBookView(final String bookView) {
    this.bookView = bookView;
  }

  /**
   * Give the id of the book.
   *
   * @return id of the book.
   */
  public Integer getBookId() {
    return this.bookId;
  }

  /**
   * Set the id of the book.
   *
   * @param bookId the id of the book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
  }

  /**
   * Give the list of prescriptions with full details.
   *
   * @return the list of prescriptions with full details.
   */
  public List<PrescriptionFullDetailsDto> getPrescriptionsList() {
    return this.prescriptionsList;
  }

  /**
   * Set the list of prescriptions with full details.
   *
   * @param prescriptionsList the list of prescriptions with full details.
   */
  public void setPrescriptionsList(final List<PrescriptionFullDetailsDto> prescriptionsList) {
    this.prescriptionsList = prescriptionsList;
  }

  /**
   * Give the list of books with full details.
   *
   * @return the list of books with full details.
   */
  public List<BookFullDetailsDto> getBooksList() {
    return this.booksList;
  }

  /**
   * Set the list of books with full details.
   *
   * @param booksList the list of books with full details.
   */
  public void setBooksList(final List<BookFullDetailsDto> booksList) {
    this.booksList = booksList;
  }

  /**
   * Give the list of the department.
   *
   * @return the list of the department.
   */
  public List<Department> getDepartmentList() {
    return this.departmentList;
  }

  /**
   * Set the list of the department.
   *
   * @param departmentList the list of the department.
   */
  public void setDepartmentList(final List<Department> departmentList) {
    this.departmentList = departmentList;
  }

  /**
   * Give the list of the city.
   *
   * @return the list of the city.
   */
  public List<City> getCityList() {
    return this.cityList;
  }

  /**
   * Set the list of the city.
   *
   * @param cityList the list of the city.
   */
  public void setCityList(final List<City> cityList) {
    this.cityList = cityList;
  }

  /**
   * Give the list of the eple.
   *
   * @return the list of the eple.
   */
  public List<Eple> getEpleList() {
    return this.epleList;
  }

  /**
   * Set the list of the eple.
   *
   * @param epleList
   */
  public void setEpleList(final List<Eple> epleList) {
    this.epleList = epleList;
  }

  /** Give the user's HTTP session attributes. */
  public Map<String, Object> getSession() {
    return this.session;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }

  /** Give the Http Servlet Request. */
  public HttpServletRequest getServletRequest() {
    return this.servletRequest;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest servletRequest) {
    this.servletRequest = servletRequest;
  }


  // ===== Methods =====

  /**
   * Search action used to search prescriptions or books.
   *
   * @return ERROR if error occurred. INPUT if the login and password are null or empty or if the
   *     login and password don't match. SUCCESS otherwise.
   */
  public String doSearch() {

    if(this.departmentId == null && this.cityId == null && StringUtils.isAllEmpty(this.epleRne, this.deadline)) {
      return Action.INPUT;
    }

    LOG.error("purchase : " + this.deadline);

    UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");

    LOG.error("eple : " + this.epleRne);
    if(StringUtils.equals(this.bookView, "true")) {
      final generated.bookserviceclient.SearchCriteriaDto searchCriteriaDtoBook = new SearchCriteriaDto();

      searchCriteriaDtoBook.setDepartmentId(this.departmentId);
      searchCriteriaDtoBook.setCityId(this.cityId);
      if(!StringUtils.isEmpty(this.epleRne)){
        searchCriteriaDtoBook.setRne(this.epleRne);
      } else {
        searchCriteriaDtoBook.setRne(null);
      }
      if(StringUtils.equals(this.processed, "false")) {
        searchCriteriaDtoBook.setProcessing(false);
      } else {
        searchCriteriaDtoBook.setProcessing(true);
      }
      if(!StringUtils.isEmpty(this.deadline)) {
        searchCriteriaDtoBook.setPurchaseDeadline(dateStringConversionToFrenchDate(this.deadline));
      } else {
        searchCriteriaDtoBook.setPurchaseDeadline(null);
      }
      searchCriteriaDtoBook.setUserId(userDetailsDto.getUserId());

      try {
        BookService_Service bookService = new BookService_Service();
        BookService bookServicePort = bookService.getBookServicePort();
        this.booksList = bookServicePort.bookSearching(searchCriteriaDtoBook);
      } catch (generated.bookserviceclient.PrescoWsException_Exception exception) {
        LOG.error(exception.getMessage());
        LOG.error(exception.getFaultInfo().getFault().getFaultString());
        this.addActionError(exception.getFaultInfo().getFault().getFaultString());
        return Action.ERROR;
      }
    } else {

      final generated.prescriptionserviceclient.SearchCriteriaDto searchCriteriaDtoPrescription = new generated.prescriptionserviceclient.SearchCriteriaDto();

      searchCriteriaDtoPrescription.setDepartmentId(this.departmentId);
      searchCriteriaDtoPrescription.setCityId(this.cityId);
      if(!StringUtils.isEmpty(this.epleRne)) {
        searchCriteriaDtoPrescription.setRne(this.epleRne);
      } else {
        searchCriteriaDtoPrescription.setRne(null);
      }

      if(StringUtils.equals(this.processed, "false")) {
        searchCriteriaDtoPrescription.setProcessing(false);
      } else {
        searchCriteriaDtoPrescription.setProcessing(true);
      }
      if(!StringUtils.isEmpty(this.deadline)) {
        searchCriteriaDtoPrescription.setPurchaseDeadline(dateStringConversionToFrenchDate(this.deadline));
      } else {
        searchCriteriaDtoPrescription.setPurchaseDeadline(null);
      }
      searchCriteriaDtoPrescription.setUserId(userDetailsDto.getUserId());

      try {
        PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
        PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();
        this.prescriptionsList = prescriptionServicePort.searchPrescription(searchCriteriaDtoPrescription);
      } catch (generated.prescriptionserviceclient.PrescoWsException_Exception exception) {
        LOG.error(exception.getMessage());
        LOG.error(exception.getFaultInfo().getFault().getFaultString());
        this.addActionError(exception.getFaultInfo().getFault().getFaultString());
        return Action.ERROR;
      }
    }

    return Action.SUCCESS;
  }

  public String doSetAvailable() {

    if(this.bookId == null) {
      LOG.error("L'identifiant du livre est absent");
      this.addActionError("L'identifiant du livre est absent. Echec du changement de status");
      return Action.ERROR;
    }

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();
    try {
      bookServicePort.changeBookStatus(this.bookId, 2);
    } catch (generated.bookserviceclient.PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  public String doSetNotAvailable() {

    if(this.bookId == null) {
      LOG.error("L'identifiant du livre est absent");
      this.addActionError("L'identifiant du livre est absent. Echec du changement de status");
      return Action.ERROR;
    }

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();
    try {
      bookServicePort.changeBookStatus(this.bookId, 3);
    } catch (generated.bookserviceclient.PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  public String doSetDepleted() {

    if(this.bookId == null) {
      LOG.error("L'identifiant du livre est absent");
      this.addActionError("L'identifiant du livre est absent. Echec du changement de status");
      return Action.ERROR;
    }

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();
    try {
      bookServicePort.changeBookStatus(this.bookId, 4);
    } catch (generated.bookserviceclient.PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  public String doSetProcessedBook() {
    // @TODO
    return Action.ERROR;
  }

  /**
   * Check if the book is processed by the current user.
   *
   * @param book the book to check.
   * @return true if already processed, false otherwise.
   */
  public String checkBookProcessedForUser(final BookFullDetailsDto book) {

    UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");

    for(ProcessingBook processingBook : book.getProcessingBookList()) {
      if(userDetailsDto.getUserId().equals(processingBook.getUserId()) && processingBook.isProcessingStatus()){
        return "true";
      }
    }
    return "false";
  }

  /**
   * Check if the prescription is processed by the current user.
   *
   * @param prescription the prescription to check.
   * @return true if the already processed, false otherwise.
   */
  public String checkPrescriptionProcessedForUser(final PrescriptionFullDetailsDto prescription) {

    UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");

    for(ProcessingPrescription processingPrescription : prescription.getProcessingPrescriptionList()) {
      if(userDetailsDto.getUserId().equals(processingPrescription.getUserId()) && processingPrescription.isProcessingStatus()) {
        return "true";
      }
    }
    return "false";
  }

  /**
   * Get the department name with the departmentId set in the action.
   *
   * @return the department name.
   */
  public String getDepartmentName() {

    for(Department department : departmentList) {
      if(department.getDepartmentId().equals(this.departmentId)) {
        return department.getDepartmentName();
      }
    }
    return StringUtils.EMPTY;
  }

  /**
   * Get the city name with the cityId set in the action.
   *
   * @return the city name.
   */
  public String getCityName() {

    for(City city : cityList) {
      if(city.getCityId().equals(this.cityId)) {
        return city.getCityName();
      }
    }
    return StringUtils.EMPTY;
  }

  /**
   * Get the eple name with the epleRne set in the action.
   *
   * @return the eple name.
   */
  public String getEpleName() {

    for(Eple eple : epleList) {
      if(StringUtils.equals(eple.getRne(), this.epleRne)) {
        return eple.getEpleName();
      }
    }
    return StringUtils.EMPTY;
  }

  /**
   * Change date string with the format "yyyy-MM-dd" to string with the format : "dd-MM-yyyy HH:mm:ss".
   *
   * @param stringDate date string with the format "yyyy-MM-dd"
   * @return string with the format : "dd-MM-yyyy HH:mm:ss"
   */
  private String dateStringConversionToFrenchDate(final String stringDate) {

    DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String inputDateStr = stringDate + " 00:00:00";
    Date date = null;
    try {
      date = inputFormat.parse(inputDateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String outputDateStr = outputFormat.format(date);

    return outputDateStr;
  }

  /**
   * Change date string with the format "dd-MM-yyyy HH:mm:ss" to string with the format : "yyyy-MM-dd".
   *
   * @param stringDate date string with the format "dd-MM-yyyy HH:mm:ss"
   * @return string with the format : "yyyy-MM-dd"
   */
  private String dateStringConversionToEnglishDate(final String stringDate) {

    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String inputDateStr = stringDate;
    Date date = null;
    try {
      date = inputFormat.parse(inputDateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String outputDateStr = outputFormat.format(date);

    return outputDateStr;
  }
}
