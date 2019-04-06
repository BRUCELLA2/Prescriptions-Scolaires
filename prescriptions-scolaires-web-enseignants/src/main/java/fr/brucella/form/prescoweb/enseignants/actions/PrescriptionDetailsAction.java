package fr.brucella.form.prescoweb.enseignants.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.Eple;
import generated.authentificationserviceclient.UserDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.BookWithStatusDto;
import generated.prescriptionserviceclient.PrescoWsException_Exception;
import generated.prescriptionserviceclient.Prescription;
import generated.prescriptionserviceclient.PrescriptionService;
import generated.prescriptionserviceclient.PrescriptionService_Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
 * Prescription details action.
 *
 * @author BRUCELLA2
 */
public class PrescriptionDetailsAction extends ActionSupport implements SessionAware, ServletRequestAware {

  /** User Action logger. */
  private static final Log LOG = LogFactory.getLog(UserAction.class);

  /** The id of the prescription. */
  private Integer prescriptionId;

  /** The prescription. */
  private Prescription prescription;

  /** The list of books for the prescription. */
  private List<BookWithStatusDto> booksList;

  /** The prescription name. */
  private String prescriptionName;

  /** The list of eple for the user. */
  private List<Eple> epleList;

  /** The id of the eple for the prescription. */
  private Integer epleId;

  /** The headcount of the prescription. */
  private Integer headcount;

  /** The purchase deadline of the prescription. */
  private String purchaseDeadline;

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;


  // ----- Constructors

  /** Default constructor. */
  public PrescriptionDetailsAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }


  // ----- Getters and Setters

  /**
   * Give the id of the prescription.
   *
   * @return the id of the prescription.
   */
  public Integer getPrescriptionId() {
    return this.prescriptionId;
  }

  /**
   * Set the id of the prescription.
   *
   * @param prescriptionId the id of the prescription.
   */
  public void setPrescriptionId(final Integer prescriptionId) {
    this.prescriptionId = prescriptionId;
  }

  /**
   * Give the prescription with full details.
   *
   * @return the prescription with full details.
   */
  public Prescription getPrescription() {
    return this.prescription;
  }

  /**
   * Set the prescription with full details.
   *
   * @param prescription the prescription with full details.
   */
  public void setPrescription(Prescription prescription) {
    this.prescription = prescription;
  }

  /**
   * Give the list of books for the prescription.
   *
   * @return the list of books for the prescription.
   */
  public List<BookWithStatusDto> getBooksList() {
    return this.booksList;
  }

  /**
   * Give the prescription name.
   *
   * @return the prescription name.
   */
  public String getPrescriptionName() {
    return prescriptionName;
  }

  /**
   * Set the prescription name.
   *
   * @param prescriptionName the prescription name.
   */
  public void setPrescriptionName(final String prescriptionName) {
    this.prescriptionName = prescriptionName;
  }

  /**
   * Give the list of eple for the user.
   *
   * @return the list of eple for the user.
   */
  public List<Eple> getEpleList() {
    return this.epleList;
  }

  /**
   * Set the list of eple for the user.
   *
   * @param epleList the list of eple for the user.
   */
  public void setEpleList(final List<Eple> epleList) {
    this.epleList = epleList;
  }

  /**
   * Give the id of the eple for the prescription.
   *
   * @return the id of the eple for the prescription.
   */
  public Integer getEpleId() {
    return this.epleId;
  }

  /**
   * Set the id of the eple for the prescription.
   *
   * @param epleId the id of the eple for the prescription.
   */
  public void setEpleId(final Integer epleId) {
    this.epleId = epleId;
  }

  /**
   * Give the headcount of the prescription.
   *
   * @return the headcount of the prescription.
   */
  public Integer getHeadcount() {
    return this.headcount;
  }

  /**
   * Set the headcount of the prescription.
   *
   * @param headcount the headcount of the prescription.
   */
  public void setHeadcount(final Integer headcount) {
    this.headcount = headcount;
  }

  /**
   * Give the purchase deadline of the prescription.
   *
   * @return the purchase deadline of the prescription.
   */
  public String getPurchaseDeadline() {
    return this.purchaseDeadline;
  }

  /**
   * Set the purchase deadline of the prescription.
   *
   * @param purchaseDeadline the purchase deadline of the prescription.
   */
  public void setPurchaseDeadline(final String purchaseDeadline) {
    this.purchaseDeadline = purchaseDeadline;
  }

  /**
   * Set the list of books for the prescription.
   *
   * @param booksList the list of books for the prescription.
   */
  public void setBooksList(List<BookWithStatusDto> booksList) {
    this.booksList = booksList;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }


  // ===== Methods =====

  /**
   * Display details of prescriptions.
   *
   * @return ERROR if error occured.
   *         SUCCESS otherwise.
   */
  public String doPrescriptionsDetails() {

    final UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");
    this.epleList = userDetailsDto.getEpleList();

    if (this.prescriptionId == null) {
      return Action.SUCCESS;
    }

    final PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
    final PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();
    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      this.setPrescription(prescriptionServicePort.getPrescriptionFullDetailsDto(this.prescriptionId));
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    this.purchaseDeadline = dateStringConversionToEnglishDate(prescription.getPurchaseDeadline());

    try {
      this.setBooksList(bookServicePort.bookWithStatusListForPrescription(this.prescriptionId));
    }catch (generated.bookserviceclient.PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Create a new prescription.
   *
   * @return ERROR if error occurred.
   *         INPUT if the input information needed are empty or null.
   *         SUCCESS otherwise
   */
  public String doNewPrescription() {

    final UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");
    this.epleList = userDetailsDto.getEpleList();

    if(StringUtils.isAllEmpty(this.prescriptionName, this.purchaseDeadline) && this.epleId == null && this.prescriptionId == null && this.headcount == null) {
      if(LOG.isDebugEnabled()) {
        LOG.debug("PrescriptionName, epleName, purchaseDeadline, prescriptionId, headcount = null");
      }
      return Action.INPUT;
    }

    if(StringUtils.isEmpty(this.prescriptionName)) {
      this.addFieldError("prescriptionName", "Vous devez donner un nom à la prescription.");
    }
    if(StringUtils.isEmpty(this.purchaseDeadline)) {
      this.addFieldError("purchaseDeadline", "La date d'effet de la prescription doit être renseignée.");
    }
    if(this.headcount == null) {
      this.addFieldError("headcount", "L'effectif de la prescription doit être renseignée.");
    }
    if(this.epleId == null) {
      this.addFieldError("epleId", "L'EPLE doit être renseigné.");
    }

    if(this.hasFieldErrors()) {
      return Action.INPUT;
    }

    this.prescription = new Prescription();
    this.prescription.setPrescriptionName(this.prescriptionName);
    this.prescription.setEpleId(this.epleId);
    this.prescription.setPurchaseDeadline(dateStringConversionToFrenchDate(this.purchaseDeadline));
    this.prescription.setUserId(userDetailsDto.getUserId());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    this.prescription.setCreationDate(formatter.format(LocalDateTime.now()));
    this.prescription.setValidationStatus(false);
    this.prescription.setHeadcount(this.headcount);


    final PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
    final PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();

    try{
      this.prescriptionId = prescriptionServicePort.makePrescription(this.prescription);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Modify a prescription.
   *
   * @return ERROR if error occured.
   *         INPUT if the input information needed are empty or null.
   *         SUCCESS otherwise.
   */
  public String doPrescriptionModification() {

    final UserDetailsDto userDetailsDto = (UserDetailsDto) this.session.get("userLog");
    this.epleList = userDetailsDto.getEpleList();

    if(StringUtils.isAllEmpty(this.prescriptionName, this.purchaseDeadline) && this.epleId == null && this.prescriptionId == null && this.headcount == null) {
      if(LOG.isDebugEnabled()) {
        LOG.debug("PrescriptionName, epleName, purchaseDeadline, prescriptionId, headcount = null");
      }
      return Action.INPUT;
    }

    if(StringUtils.isEmpty(this.prescriptionName)) {
      this.addFieldError("prescriptionName", "Vous devez donner un nom à la prescription.");
    }
    if(StringUtils.isEmpty(this.purchaseDeadline)) {
      this.addFieldError("purchaseDeadline", "La date d'effet de la prescription doit être renseignée.");
    }
    if(this.headcount == null) {
      this.addFieldError("headcount", "L'effectif de la prescription doit être renseignée.");
    }
    if(this.epleId == null) {
      this.addFieldError("epleId", "L'EPLE doit être renseigné.");
    }

    if(this.hasFieldErrors()) {
      return Action.INPUT;
    }

    final PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
    final PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();

    try {
      this.prescription = prescriptionServicePort.getPrescriptionFullDetailsDto(this.prescriptionId);
      this.prescription.setPrescriptionName(this.prescriptionName);
      this.prescription.setEpleId(this.epleId);
      this.prescription.setPurchaseDeadline(dateStringConversionToFrenchDate(this.purchaseDeadline));
      this.prescription.setHeadcount(this.headcount);

      prescriptionServicePort.modifyPrescription(this.prescription);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Delete a prescription.
   *
   * @return ERROR if error occured.
   *         SUCCESS otherwise.
   */
  public String doDeletePrescription() {

    if (this.prescriptionId == null) {
      LOG.error("L'identifiant de la prescription est absent. Echec de la suppression");
      this.addActionError("L'identifiant de la prescription est absent. Echec de la suppression");
      return Action.ERROR;
    }

    final PrescriptionService_Service prescriptionService = new PrescriptionService_Service();
    final PrescriptionService prescriptionServicePort = prescriptionService.getPrescriptionServicePort();

    try {
      prescriptionServicePort.deletePrescription(prescriptionId);
    } catch (PrescoWsException_Exception exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFault().getFaultString());
      this.addActionError(exception.getFaultInfo().getFault().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
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
