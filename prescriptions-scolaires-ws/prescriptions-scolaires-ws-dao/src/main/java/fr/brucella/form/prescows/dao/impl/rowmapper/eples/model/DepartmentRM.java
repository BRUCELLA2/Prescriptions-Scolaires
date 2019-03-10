package fr.brucella.form.prescows.dao.impl.rowmapper.eples.model;

import fr.brucella.form.prescows.entity.eples.model.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Department object.
 *
 * @author BRUCELLA2
 */
public class DepartmentRM implements RowMapper<Department> {

  /** Default Constructor */
  public DepartmentRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Department mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Department department = new Department();

    department.setDepartmentId(resultSet.getInt("department_id"));
    department.setCode(resultSet.getString("code"));
    department.setDepartmentName(resultSet.getString("department_name"));

    return department;
  }
}
