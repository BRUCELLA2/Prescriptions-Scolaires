package fr.brucella.form.prescows.business.impl.manager.authentification;

import fr.brucella.form.prescows.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.form.prescows.business.impl.manager.AbstractManager;
import fr.brucella.form.prescows.entity.exceptions.FunctionalException;
import fr.brucella.form.prescows.entity.exceptions.NotFoundException;
import fr.brucella.form.prescows.entity.exceptions.TechnicalException;
import fr.brucella.form.prescows.entity.users.dto.UserDetailsDto;
import fr.brucella.form.prescows.entity.users.model.User;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
      throw new FunctionalException(messages.getString("authentificationManager.getConnectUser.loginPasswordNull"));
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

  /** {@inheritDoc} */
  @Override
  public Boolean userModification(UserDetailsDto userDetailsDto) throws TechnicalException, FunctionalException {

    if(userDetailsDto == null) {
      LOG.error(messages.getString("authentificationManager.userModification.userDetailsDtoNull"));
      throw new FunctionalException(messages.getString("authentificationManager.userModification.userDetailsDtoNull"));
    }

    final Set<ConstraintViolation<UserDetailsDto>> violations = this.getConstraintValidator().validate(userDetailsDto);
    if(!violations.isEmpty()) {
      if(LOG.isDebugEnabled()) {
        for(final ConstraintViolation<UserDetailsDto> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("authentificationManager.userModification.constraints"));
      throw new FunctionalException(messages.getString("authentificationManager.userModification.constraints"), new ConstraintViolationException(violations));
    }

    try {
      final User oldUser = this.getDaoFactory().getUserDao().getUser(userDetailsDto.getUserId());

      if(!this.checkedPassword(userDetailsDto.getPassword(), oldUser.getPassword())) {
        LOG.error("password incorrect");
        throw new FunctionalException(messages.getString("authentificationManager.userModification.passDontMatch"));
      }

      final User modifiedUser = new User();
      modifiedUser.setUserId(userDetailsDto.getUserId());
      modifiedUser.setLogin(userDetailsDto.getLogin());
      modifiedUser.setPassword(this.encodePassword(userDetailsDto.getPassword()));
      modifiedUser.setLastName(userDetailsDto.getLastName());
      modifiedUser.setFirstName(userDetailsDto.getFirstName());
      modifiedUser.setEmail(userDetailsDto.getEmail());
      modifiedUser.setRoleId(userDetailsDto.getRoleId());

      this.getDaoFactory().getUserDao().updateUser(modifiedUser);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }

    return true;
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

  /**
   * This method encrypt a raw password with the password encoder {@link #passwordEncoder}.
   *
   * @param rawPassword the raw password to encrypt.
   * @return the password encrypted.
   */
  private String encodePassword(final String rawPassword) {
    return this.passwordEncoder.encode(rawPassword);
  }
}
