package fr.brucella.form.prescows.business.contracts;

import fr.brucella.form.prescows.business.contracts.managers.alert.AlertManager;
import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookListingManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionListingManager;

/**
 * Interface for Manager Factory.
 * Manager Factory allow to get and set business mangers.
 *
 * @author BRUCELLA2
 */
public interface ManagerFactory {

  /**
   * Gives the AuthentificationManager.
   *
   * @return the AuthentificationManager.
   */
  AuthentificationManager getAuthentificationManager();

  /**
   * Set the AuthentificationManager.
   *
   * @param authentificationManager the AuthentificationManager.
   */
  void setAuthentificationManager(final AuthentificationManager authentificationManager);

  /**
   * Gives the BookDetailsManager.
   *
   * @return the BookDetailsManager.
   */
  BookDetailsManager getBookDetailsManager();

  /**
   * Set the BookDetailsManager.
   *
   * @param bookDetailsManager the BookDetailsManager.
   */
  void setBookDetailsManager(final BookDetailsManager bookDetailsManager);

  /**
   * Gives the BookListingManager.
   *
   * @return the BookListingManager.
   */
  BookListingManager getBookListingManager();

  /**
   * Set the BookListingManager.
   *
   * @param bookListingManager the BookListingManager.
   */
  void setBookListingManager(final BookListingManager bookListingManager);

  /**
   * Gives the PrescriptionDetailsManager.
   *
   * @return the PrescriptionDetailsManager.
   */
  PrescriptionDetailsManager getPrescriptionDetailsManager();

  /**
   * Set the PrescriptionDetailsManager.
   *
   * @param prescriptionDetailsManager the PrescriptionDetailsManager.
   */
  void setPrescriptionDetailsManager(final PrescriptionDetailsManager prescriptionDetailsManager);

  /**
   * Gives the PrescriptionListingManager.
   *
   * @return the PrescriptionListingManager.
   */
  PrescriptionListingManager getPrescriptionListingManager();

  /**
   * Set the PrescriptionListingManager.
   *
   * @param prescriptionListingManager the PrescriptionListingManager.
   */
  void setPrescriptionListingManager(final PrescriptionListingManager prescriptionListingManager);

  /**
   * Gives the AlertManager.
   *
   * @return the AlertManager.
   */
  AlertManager getAlertManager();

  /**
   * Set the AlertManager.
   *
   * @param alertManager the AlertManager.
   */
  void setAlertManager(final AlertManager alertManager);
}
