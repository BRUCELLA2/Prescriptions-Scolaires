package fr.brucella.form.prescows.business.impl;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.business.contracts.managers.alert.AlertManager;
import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookListingManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionListingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manager Factory allow to get and set business managers.
 *
 * @author BRUCELLA2
 */
@Component
public class ManagerFactoryImpl implements ManagerFactory {

  /** Authentification Manager. */
  @Autowired private AuthentificationManager authentificationManager;

  /** Book Details Manager. */
  @Autowired private BookDetailsManager bookDetailsManager;

  /** Book Listing Manager. */
  @Autowired private BookListingManager bookListingManager;

  /** Prescription Details Manager. */
  @Autowired private PrescriptionDetailsManager prescriptionDetailsManager;

  /** Prescription Listing Manager. */
  @Autowired private PrescriptionListingManager prescriptionListingManager;

  /** Alert Manager. */
  @Autowired private AlertManager alertManager;


  // ===== Constructor =====

  /** Defaut constructor */
  public ManagerFactoryImpl() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /** Defaut constructor */
  @Override
  public AuthentificationManager getAuthentificationManager() {
    return authentificationManager;
  }

  /** Defaut constructor */
  @Override
  public void setAuthentificationManager(final AuthentificationManager authentificationManager) {

  }

  /** Defaut constructor */
  @Override
  public BookDetailsManager getBookDetailsManager() {
    return bookDetailsManager;
  }

  /** Defaut constructor */
  @Override
  public void setBookDetailsManager(final BookDetailsManager bookDetailsManager) {

  }

  /** Defaut constructor */
  @Override
  public BookListingManager getBookListingManager() {
    return bookListingManager;
  }

  /** Defaut constructor */
  @Override
  public void setBookListingManager(final BookListingManager bookListingManager) {

  }

  /** Defaut constructor */
  @Override
  public PrescriptionDetailsManager getPrescriptionDetailsManager() {
    return prescriptionDetailsManager;
  }

  /** Defaut constructor */
  @Override
  public void setPrescriptionDetailsManager(final PrescriptionDetailsManager prescriptionDetailsManager) {

  }

  /** Defaut constructor */
  @Override
  public PrescriptionListingManager getPrescriptionListingManager() {
    return prescriptionListingManager;
  }

  /** Defaut constructor */
  @Override
  public void setPrescriptionListingManager(final PrescriptionListingManager prescriptionListingManager) {

  }

  /** Defaut constructor */
  @Override
  public AlertManager getAlertManager() {
    return alertManager;
  }

  /** Defaut constructor */
  @Override
  public void setAlertManager(final AlertManager alertManager) {

  }
}
