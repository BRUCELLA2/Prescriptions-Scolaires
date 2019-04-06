
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour searchCriteriaDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="searchCriteriaDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cityId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="processing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="purchaseDeadline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCriteriaDto", propOrder = {
    "cityId",
    "departmentId",
    "processing",
    "purchaseDeadline",
    "rne",
    "userId"
})
public class SearchCriteriaDto {

    protected Integer cityId;
    protected Integer departmentId;
    protected Boolean processing;
    protected String purchaseDeadline;
    protected String rne;
    protected Integer userId;

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
     * Obtient la valeur de la propriété processing.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProcessing() {
        return processing;
    }

    /**
     * Définit la valeur de la propriété processing.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProcessing(Boolean value) {
        this.processing = value;
    }

    /**
     * Obtient la valeur de la propriété purchaseDeadline.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseDeadline() {
        return purchaseDeadline;
    }

    /**
     * Définit la valeur de la propriété purchaseDeadline.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseDeadline(String value) {
        this.purchaseDeadline = value;
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

    /**
     * Obtient la valeur de la propriété userId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }

}
