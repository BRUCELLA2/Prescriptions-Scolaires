package fr.brucella.form.prescows.dao.contracts.dao.eples;

import fr.brucella.form.prescows.entity.eples.model.Eple;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;

/**
 * Interface for Eple Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface EpleDao {

  /**
   * Gives the eple with the specified id from the datastore.
   *
   * @param epleId id of the eple.
   * @return the eple with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the eple is not found.
   */
  Eple getEple(final Integer epleId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing eple in the datastore.
   *
   * @param eple the eple with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the eple is not found.
   */
  void updateEple(final Eple eple) throws TechnicalException, NotFoundException;

  /**
   * Insert a new eple in the datastore.
   *
   * @param eple the eple to insert in datastore.
   * @return the id of the new eple.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertEple(final Eple eple) throws TechnicalException;

  /**
   * Delete the eple with the specified id in the datastore.
   *
   * @param epleId id of the eple.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the eple is not found.
   */
  void deleteEple(final Integer epleId) throws TechnicalException, NotFoundException;
}
