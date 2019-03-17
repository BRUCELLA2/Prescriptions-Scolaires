package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Prescription Details Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class PrescriptionDetailsManagerImpl extends AbstractManager implements PrescriptionDetailsManager {

  /** Prescription Details Manager logger. */
  private static final Log LOG = LogFactory.getLog(PrescriptionDetailsManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public PrescriptionDetailsManagerImpl() {
    super();
  }


  // ===== Methods =====
}
