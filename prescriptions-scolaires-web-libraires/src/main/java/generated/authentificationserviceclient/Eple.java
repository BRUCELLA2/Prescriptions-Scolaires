
package generated.authentificationserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour eple complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="eple">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cityId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="epleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="epleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eple", propOrder = {
    "cityId",
    "departmentId",
    "epleId",
    "epleName",
    "rne"
})
public class Eple {

    protected Integer cityId;
    protected Integer departmentId;
    protected Integer epleId;
    protected String epleName;
    protected String rne;

    /**
     * Obtient la valeur de la propriété cityId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Définit la valeur de la propriété cityId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCityId(Integer value) {
        this.cityId = value;
    }

    /**
     * Obtient la valeur de la propriété departmentId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Définit la valeur de la propriété departmentId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepartmentId(Integer value) {
        this.departmentId = value;
    }

    /**
     * Obtient la valeur de la propriété epleId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEpleId() {
        return epleId;
    }

    /**
     * Définit la valeur de la propriété epleId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEpleId(Integer value) {
        this.epleId = value;
    }

    /**
     * Obtient la valeur de la propriété epleName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpleName() {
        return epleName;
    }

    /**
     * Définit la valeur de la propriété epleName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpleName(String value) {
        this.epleName = value;
    }

    /**
     * Obtient la valeur de la propriété rne.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRne() {
        return rne;
    }

    /**
     * Définit la valeur de la propriété rne.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRne(String value) {
        this.rne = value;
    }

}
