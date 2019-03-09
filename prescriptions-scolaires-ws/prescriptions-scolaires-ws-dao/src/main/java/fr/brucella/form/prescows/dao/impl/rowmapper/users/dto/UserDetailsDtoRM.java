package fr.brucella.form.prescows.dao.impl.rowmapper.users.dto;

import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a UserDetailsDto object.
 * The list of eple is set to null. An update of the UserDetailsDto is needed after row mapping to set the list of eple.
 *
 * @author BRUCELLA2
 */
public class UserDetailsDtoRM implements RowMapper<UserDetailsDto> {

  /** Default Constructor */
  public UserDetailsDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  @Override
  public UserDetailsDto mapRow(ResultSet resultSet, int i) throws SQLException {

    final UserDetailsDto userDetailsDto = new UserDetailsDto();

    userDetailsDto.setUserId(resultSet.getInt("user_id"));
    userDetailsDto.setLogin(resultSet.getString("login"));
    userDetailsDto.setPassword(resultSet.getString("password"));
    userDetailsDto.setLastName(resultSet.getString("last_name"));
    userDetailsDto.setFirstName(resultSet.getString("first_name"));
    userDetailsDto.setEmail(resultSet.getString("email"));
    userDetailsDto.setRoleId(resultSet.getInt("role_id"));
    userDetailsDto.setRoleName(resultSet.getString("role_name"));
    userDetailsDto.setEpleList(null);

    return userDetailsDto;
  }
}
