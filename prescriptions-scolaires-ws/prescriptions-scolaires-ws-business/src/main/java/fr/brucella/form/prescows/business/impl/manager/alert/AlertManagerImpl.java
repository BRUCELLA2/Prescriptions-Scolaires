package fr.brucella.form.prescows.business.impl.manager.alert;

import fr.brucella.form.prescows.business.contracts.managers.alert.AlertManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Alert Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class AlertManagerImpl extends AbstractManager implements AlertManager {

  /** Alert Manager logger. */
  private static final Log LOG = LogFactory.getLog(AlertManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public AlertManagerImpl() {
    super();
  }


  // ===== Methods =====
}
