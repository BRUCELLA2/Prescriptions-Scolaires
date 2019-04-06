
package generated.authentificationserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.authentificationserviceclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginResponse_QNAME = new QName("http://services.prescows.form.brucella.fr/", "loginResponse");
    private final static QName _ModifyUser_QNAME = new QName("http://services.prescows.form.brucella.fr/", "modifyUser");
    private final static QName _ModifyUserResponse_QNAME = new QName("http://services.prescows.form.brucella.fr/", "modifyUserResponse");
    private final static QName _PrescoWsException_QNAME = new QName("http://services.prescows.form.brucella.fr/", "PrescoWsException");
    private final static QName _Login_QNAME = new QName("http://services.prescows.form.brucella.fr/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.authentificationserviceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifyUserResponse }
     * 
     */
    public ModifyUserResponse createModifyUserResponse() {
        return new ModifyUserResponse();
    }

    /**
     * Create an instance of {@link PrescoWsException }
     * 
     */
    public PrescoWsException createPrescoWsException() {
        return new PrescoWsException();
    }

    /**
     * Create an instance of {@link ModifyUser }
     * 
     */
    public ModifyUser createModifyUser() {
        return new ModifyUser();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link UserDetailsDto }
     * 
     */
    public UserDetailsDto createUserDetailsDto() {
        return new UserDetailsDto();
    }

    /**
     * Create an instance of {@link PrescoWsFault }
     * 
     */
    public PrescoWsFault createPrescoWsFault() {
        return new PrescoWsFault();
    }

    /**
     * Create an instance of {@link Eple }
     * 
     */
    public Eple createEple() {
        return new Eple();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "modifyUser")
    public JAXBElement<ModifyUser> createModifyUser(ModifyUser value) {
        return new JAXBElement<ModifyUser>(_ModifyUser_QNAME, ModifyUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "modifyUserResponse")
    public JAXBElement<ModifyUserResponse> createModifyUserResponse(ModifyUserResponse value) {
        return new JAXBElement<ModifyUserResponse>(_ModifyUserResponse_QNAME, ModifyUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrescoWsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "PrescoWsException")
    public JAXBElement<PrescoWsException> createPrescoWsException(PrescoWsException value) {
        return new JAXBElement<PrescoWsException>(_PrescoWsException_QNAME, PrescoWsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

}
