package fr.brucella.form.prescows.dao.impl.rowmapper.eples.model;

import fr.brucella.form.prescows.entity.eples.model.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to City object.
 *
 * @author BRUCELLA2
 */
public class CityRM implements RowMapper<City> {

  /** Default Constructor */
  public CityRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} **/
  @Override
  public City mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final City city = new City();

    city.setCityId(resultSet.getInt("city_id"));
    city.setCityName(resultSet.getString("city_name"));
    city.setDepartmentId(resultSet.getInt("department_id"));
    city.setZipCode(resultSet.getString("zip_code"));

    return city;
  }
}
