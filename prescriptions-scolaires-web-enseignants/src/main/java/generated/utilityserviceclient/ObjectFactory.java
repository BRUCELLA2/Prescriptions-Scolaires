
package generated.utilityserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.utilityserviceclient package. 
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

    private final static QName _GetCityList_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getCityList");
    private final static QName _GetDepartmentListResponse_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getDepartmentListResponse");
    private final static QName _GetDepartmentList_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getDepartmentList");
    private final static QName _GetEpleList_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getEpleList");
    private final static QName _PrescoWsException_QNAME = new QName("http://services.prescows.form.brucella.fr/", "PrescoWsException");
    private final static QName _GetEpleListResponse_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getEpleListResponse");
    private final static QName _GetCityListResponse_QNAME = new QName("http://services.prescows.form.brucella.fr/", "getCityListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.utilityserviceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrescoWsException }
     * 
     */
    public PrescoWsException createPrescoWsException() {
        return new PrescoWsException();
    }

    /**
     * Create an instance of {@link GetEpleList }
     * 
     */
    public GetEpleList createGetEpleList() {
        return new GetEpleList();
    }

    /**
     * Create an instance of {@link GetDepartmentList }
     * 
     */
    public GetDepartmentList createGetDepartmentList() {
        return new GetDepartmentList();
    }

    /**
     * Create an instance of {@link GetCityList }
     * 
     */
    public GetCityList createGetCityList() {
        return new GetCityList();
    }

    /**
     * Create an instance of {@link GetDepartmentListResponse }
     * 
     */
    public GetDepartmentListResponse createGetDepartmentListResponse() {
        return new GetDepartmentListResponse();
    }

    /**
     * Create an instance of {@link GetCityListResponse }
     * 
     */
    public GetCityListResponse createGetCityListResponse() {
        return new GetCityListResponse();
    }

    /**
     * Create an instance of {@link GetEpleListResponse }
     * 
     */
    public GetEpleListResponse createGetEpleListResponse() {
        return new GetEpleListResponse();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
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
     * Create an instance of {@link Department }
     * 
     */
    public Department createDepartment() {
        return new Department();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getCityList")
    public JAXBElement<GetCityList> createGetCityList(GetCityList value) {
        return new JAXBElement<GetCityList>(_GetCityList_QNAME, GetCityList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepartmentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getDepartmentListResponse")
    public JAXBElement<GetDepartmentListResponse> createGetDepartmentListResponse(GetDepartmentListResponse value) {
        return new JAXBElement<GetDepartmentListResponse>(_GetDepartmentListResponse_QNAME, GetDepartmentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDepartmentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getDepartmentList")
    public JAXBElement<GetDepartmentList> createGetDepartmentList(GetDepartmentList value) {
        return new JAXBElement<GetDepartmentList>(_GetDepartmentList_QNAME, GetDepartmentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEpleList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getEpleList")
    public JAXBElement<GetEpleList> createGetEpleList(GetEpleList value) {
        return new JAXBElement<GetEpleList>(_GetEpleList_QNAME, GetEpleList.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEpleListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getEpleListResponse")
    public JAXBElement<GetEpleListResponse> createGetEpleListResponse(GetEpleListResponse value) {
        return new JAXBElement<GetEpleListResponse>(_GetEpleListResponse_QNAME, GetEpleListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCityListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.prescows.form.brucella.fr/", name = "getCityListResponse")
    public JAXBElement<GetCityListResponse> createGetCityListResponse(GetCityListResponse value) {
        return new JAXBElement<GetCityListResponse>(_GetCityListResponse_QNAME, GetCityListResponse.class, null, value);
    }

}
