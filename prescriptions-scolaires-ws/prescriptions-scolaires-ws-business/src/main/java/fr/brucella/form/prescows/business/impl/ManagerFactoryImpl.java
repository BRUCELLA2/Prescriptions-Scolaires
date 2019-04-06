package fr.brucella.form.prescows.business.impl;

import fr.brucella.form.prescows.business.contracts.ManagerFactory;
import fr.brucella.form.prescows.business.contracts.managers.alert.AlertManager;
import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.BookListingManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionDetailsManager;
import fr.brucella.form.prescows.business.contracts.managers.prescription.PrescriptionListingManager;
import fr.brucella.form.prescows.business.contracts.managers.utility.UtilityManager;
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

  /** Utility Manager. */
  @Autowired private UtilityManager utilityManager;


  // ===== Constructor =====

  /** Defaut constructor */
  public ManagerFactoryImpl() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /** {@inheritDoc} */
  @Override
  public AuthentificationManager getAuthentificationManager() {
    return this.authentificationManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setAuthentificationManager(final AuthentificationManager authentificationManager) {
    this.authentificationManager = authentificationManager;
  }

  /** {@inheritDoc} */
  @Override
  public BookDetailsManager getBookDetailsManager() {
    return this.bookDetailsManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setBookDetailsManager(final BookDetailsManager bookDetailsManager) {
    this.bookDetailsManager = bookDetailsManager;
  }

  /** {@inheritDoc} */
  @Override
  public BookListingManager getBookListingManager() {
    return this.bookListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setBookListingManager(final BookListingManager bookListingManager) {
    this.bookListingManager = bookListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public PrescriptionDetailsManager getPrescriptionDetailsManager() {
    return this.prescriptionDetailsManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setPrescriptionDetailsManager(final PrescriptionDetailsManager prescriptionDetailsManager) {
    this.prescriptionDetailsManager = prescriptionDetailsManager;
  }

  /** {@inheritDoc} */
  @Override
  public PrescriptionListingManager getPrescriptionListingManager() {
    return this.prescriptionListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setPrescriptionListingManager(final PrescriptionListingManager prescriptionListingManager) {
    this.prescriptionListingManager = prescriptionListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public AlertManager getAlertManager() {
    return this.alertManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setAlertManager(final AlertManager alertManager) {
    this.alertManager = alertManager;
  }

  /** {@inheritDoc} */
  @Override
  public UtilityManager getUtilityManager() {
    return this.utilityManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setUtilityManager(final UtilityManager utilityManager) {
    this.utilityManager = utilityManager;
  }
}
