package fr.brucella.form.prescows.business.impl.manager.authentification;

import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The Authentification Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class AuthentificationManagerImpl extends AbstractManager implements AuthentificationManager {

  /** Authentification Manager Logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationManagerImpl.class);

  /** Password encoder. */
  private final transient BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


  // ===== Constructor =====

  /** Default Constructor. */
  public AuthentificationManagerImpl() {
    super();
  }


  // ===== Methods =====
  /** {@inheritDoc} */
  @Override
  public UserDetailsDto getConnectUser(String login, String password)
      throws TechnicalException, FunctionalException {

    if(StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
      LOG.error(messages.getString("authentificationManager.getConnectUser.loginPasswordNull"));
    }

    UserDetailsDto userDetailsDto = null;
    try {
      userDetailsDto = this.getDaoFactory().getUserDao().getUserByLogin(login);
      if(!this.checkedPassword(password, userDetailsDto.getPassword())) {
        if(LOG.isDebugEnabled()) {
          LOG.debug("login : " + login);
          LOG.debug("password = wrong");
        }
        throw new FunctionalException(messages.getString("authentificationManager.getConnectUser.passDontMatch"));
      }
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
    }

    return userDetailsDto;
  }


  /**
   * This method check if a a raw password is the same than the encrypted password. This methode use the password encoder {@link #passwordEncoder}.
   *
   * @param rawPassword the raw password.
   * @param encodePassword the encrypted password.
   * @return true if the passwords match and false otherwise.
   */
  private boolean checkedPassword(final String rawPassword, final String encodePassword) {

    return this.passwordEncoder.matches(rawPassword, encodePassword);
  }
}
