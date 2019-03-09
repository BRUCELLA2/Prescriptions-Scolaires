package fr.brucella.form.prescows.dao.impl.rowmapper.users.model;

import fr.brucella.form.prescows.entity.users.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Role object.
 *
 * @author BRUCELLA2
 */
public class UserRM implements RowMapper<User> {

  /** Default Constructor */
  public UserRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public User mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final User user = new User();

    user.setUserId(resultSet.getInt("user_id"));
    user.setLogin(resultSet.getString("login"));
    user.setPassword(resultSet.getString("password"));
    user.setLastName(resultSet.getString("last_name"));
    user.setFirstName(resultSet.getString("first_name"));
    user.setEmail(resultSet.getString("email"));
    user.setRoleId(resultSet.getInt("role_id"));

    return user;
  }
}
