package fr.brucella.form.prescows.dao.contracts.dao.eples;

import fr.brucella.form.prescows.entity.eples.model.City;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;

/**
 * Interface for City Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface CityDao {

  /**
   * Gives the city with the specified id from the datastore.
   *
   * @param cityId id of the city.
   * @return the city with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the city is not found.
   */
  City getCity(final Integer cityId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing city in the datastore.
   *
   * @param city the city with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the city is not found.
   */
  void updateCity(final City city) throws TechnicalException, NotFoundException;

  /**
   * Insert a new city in the datastore.
   *
   * @param city the city to insert in datastore.
   * @return the id of the new city.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertCity(final City city) throws TechnicalException;

  /**
   * Delete the city with the specified id in the datastore.
   *
   * @param cityId id of the city.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the city is not found.
   */
  void deleteCity(final Integer cityId) throws TechnicalException, NotFoundException;
}
