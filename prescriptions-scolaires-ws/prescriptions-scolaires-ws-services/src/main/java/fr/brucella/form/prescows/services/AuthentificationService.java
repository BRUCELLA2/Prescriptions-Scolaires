package fr.brucella.form.prescows.services;

import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Authentification Management Service.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AuthentificationService")
@Component
public class AuthentificationService extends SpringBeanAutowiringSupport {

  /** Authentification Management logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationService.class);

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";


  /** Default constructor. */
  public AuthentificationService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //
}
