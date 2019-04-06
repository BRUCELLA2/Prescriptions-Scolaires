package fr.brucella.form.prescows.dao.contracts.dao.eples;

import fr.brucella.form.prescows.entity.eples.model.Department;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for Department Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface DepartmentDao {

  /**
   * Gives the department with the specified id from the datastore.
   *
   * @param departmentId id of the department.
   * @return the department with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the department is not found.
   */
  Department getDepartment(final Integer departmentId) throws TechnicalException, NotFoundException;

  /**
   * Gives the list of department from the datastore.
   *
   * @return departments list.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<Department> getDepartmentList() throws TechnicalException;

  /**
   * Update an existing department in the datastore.
   *
   * @param department the department with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the department is not found.
   */
  void updateDepartment(final Department department) throws TechnicalException, NotFoundException;

  /**
   * Insert a new department in the datastore.
   *
   * @param department the department to insert in datastore.
   * @return the id of the new department.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertDepartment(final Department department) throws TechnicalException;

  /**
   * Delete the department with the specified id in the datastore.
   *
   * @param departmentId id of the department.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the department is not found.
   */
  void deleteDepartment(final Integer departmentId) throws TechnicalException, NotFoundException;
}
