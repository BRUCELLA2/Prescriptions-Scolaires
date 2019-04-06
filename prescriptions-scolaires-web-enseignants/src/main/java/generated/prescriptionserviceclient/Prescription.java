
package generated.prescriptionserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prescription complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="headcount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prescriptionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prescriptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseDeadline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="validationStatus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prescription", propOrder = {
    "creationDate",
    "epleId",
    "headcount",
    "prescriptionId",
    "prescriptionName",
    "purchaseDeadline",
    "userId",
    "validationStatus"
})
@XmlSeeAlso({
    PrescriptionWithEpleNameDto.class,
    PrescriptionFullDetailsDto.class
})
public class Prescription {

    protected String creationDate;
    protected Integer epleId;
    protected Integer headcount;
    protected Integer prescriptionId;
    protected String prescriptionName;
    protected String purchaseDeadline;
    protected Integer userId;
    protected Boolean validationStatus;

    /**
     * Obtient la valeur de la propriété creationDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Définit la valeur de la propriété creationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
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
     * Obtient la valeur de la propriété headcount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHeadcount() {
        return headcount;
    }

    /**
     * Définit la valeur de la propriété headcount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHeadcount(Integer value) {
        this.headcount = value;
    }

    /**
     * Obtient la valeur de la propriété prescriptionId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    /**
     * Définit la valeur de la propriété prescriptionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrescriptionId(Integer value) {
        this.prescriptionId = value;
    }

    /**
     * Obtient la valeur de la propriété prescriptionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrescriptionName() {
        return prescriptionName;
    }

    /**
     * Définit la valeur de la propriété prescriptionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrescriptionName(String value) {
        this.prescriptionName = value;
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

    /**
     * Obtient la valeur de la propriété validationStatus.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidationStatus() {
        return validationStatus;
    }

    /**
     * Définit la valeur de la propriété validationStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidationStatus(Boolean value) {
        this.validationStatus = value;
    }

}
