package fr.brucella.form.prescows.dao.impl.rowmapper.eples.model;

import fr.brucella.form.prescows.entity.eples.model.Eple;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Eple object.
 *
 * @author BRUCELLA2
 */
public class EpleRM implements RowMapper<Eple> {

  /** Default Constructor */
  public EpleRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Eple mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Eple eple = new Eple();

    eple.setEpleId(resultSet.getInt("eple_id"));
    eple.setRne(resultSet.getString("rne"));
    eple.setEpleName(resultSet.getString("eple_name"));
    eple.setCityId(resultSet.getInt("city_id"));
    eple.setDepartmentId(resultSet.getInt("department_id"));

    return eple;
  }
}
