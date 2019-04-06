package fr.brucella.form.prescows.business.contracts.managers.utility;

import fr.brucella.form.prescows.entity.eples.model.City;
import fr.brucella.form.prescows.entity.eples.model.Department;
import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for Utility Manager
 *
 * @author BRUCELLA2
 */
public interface UtilityManager {

  /**
   * Gives the list of Department.
   *
   * @return the list of Department.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<Department> getListDepartment() throws TechnicalException;

  /**
   * Gives the list of City.
   *
   * @return the list of City.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<City> getListCity() throws TechnicalException;

  /**
   * Gives the list of Eple.
   *
   * @return the list of Eple.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<Eple> getListEple() throws TechnicalException;
}
