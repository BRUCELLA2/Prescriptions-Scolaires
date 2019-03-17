package fr.brucella.form.prescows.business.impl.manager.prescription;

import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Book Details Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BookDetailsManagerImpl extends AbstractManager implements BookDetailsManager {

  /** Book Detail Manager logger. */
  private static final Log LOG = LogFactory.getLog(BookDetailsManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public BookDetailsManagerImpl() {
    super();
  }


  // ===== Methods =====
}
