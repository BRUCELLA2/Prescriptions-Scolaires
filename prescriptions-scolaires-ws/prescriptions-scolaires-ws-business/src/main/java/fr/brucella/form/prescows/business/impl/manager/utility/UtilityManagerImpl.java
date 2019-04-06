package fr.brucella.form.prescows.business.impl.manager.utility;

import fr.brucella.form.prescows.business.contracts.managers.utility.UtilityManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.eples.model.City;
import fr.brucella.form.prescows.entity.eples.model.Department;
import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Utility Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class UtilityManagerImpl extends AbstractManager implements UtilityManager {

  /** Book Detail Manager logger. */
  private static final Log LOG = LogFactory.getLog(UtilityManagerImpl.class);


  // ===== Constructor =====

  /** Default Constructor. */
  public UtilityManagerImpl() {
    super();
  }


  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public List<Department> getListDepartment() throws TechnicalException {

    return this.getDaoFactory().getDepartmentDao().getDepartmentList();
  }

  /** {@inheritDoc} */
  @Override
  public List<City> getListCity() throws TechnicalException {

    return this.getDaoFactory().getCityDao().getCityList();
  }

  /** {@inheritDoc} */
  @Override
  public List<Eple> getListEple() throws TechnicalException {

    return this.getDaoFactory().getEpleDao().getEpleList();
  }
}
