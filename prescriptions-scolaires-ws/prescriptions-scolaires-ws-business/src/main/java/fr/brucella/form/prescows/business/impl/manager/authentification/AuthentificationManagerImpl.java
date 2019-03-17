package fr.brucella.form.prescows.business.impl.manager.authentification;

import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The Authentification Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class AuthentificationManagerImpl extends AbstractManager implements AuthentificationManager {

  /** Authentification Manager Logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationManagerImpl.class);

  /** Password encoder. */
  private final transient BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


  // ===== Constructor =====

  /** Default Constructor. */
  public AuthentificationManagerImpl() {
    super();
  }


  // ===== Methods =====
}
