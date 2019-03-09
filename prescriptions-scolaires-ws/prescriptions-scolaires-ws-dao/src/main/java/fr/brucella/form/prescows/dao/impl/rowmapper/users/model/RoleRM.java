package fr.brucella.form.prescows.dao.impl.rowmapper.users.model;

import fr.brucella.form.prescows.entity.users.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Role object.
 *
 * @author BRUCELLA2
 */
public class RoleRM implements RowMapper<Role> {

  /** Default Constructor */
  public RoleRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Role mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Role role = new Role();

    role.setRoleId(resultSet.getInt("role_id"));
    role.setRoleName(resultSet.getString("role_name"));

    return role;
  }
}
