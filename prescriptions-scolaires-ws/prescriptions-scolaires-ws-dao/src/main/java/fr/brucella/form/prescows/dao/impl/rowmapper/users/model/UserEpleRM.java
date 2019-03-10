package fr.brucella.form.prescows.dao.impl.rowmapper.users.model;

import fr.brucella.form.prescows.entity.users.model.UserEple;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an UserEple object.
 *
 * @author BRUCELLA2
 */
public class UserEpleRM implements RowMapper<UserEple> {

  /** Default Constructor */
  public UserEpleRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public UserEple mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final UserEple userEple = new UserEple();

    userEple.setUserId(resultSet.getInt("user_id"));
    userEple.setEpleId(resultSet.getInt("eple_id"));

    return userEple;
  }
}
