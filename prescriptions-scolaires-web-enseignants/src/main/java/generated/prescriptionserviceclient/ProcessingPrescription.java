
package generated.prescriptionserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour processingPrescription complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="processingPrescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prescriptionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="processingStatus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "processingPrescription", propOrder = {
    "prescriptionId",
    "processingStatus",
    "userId"
})
public class ProcessingPrescription {

    protected Integer prescriptionId;
    protected Boolean processingStatus;
    protected Integer userId;

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
     * Obtient la valeur de la propriété processingStatus.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProcessingStatus() {
        return processingStatus;
    }

    /**
     * Définit la valeur de la propriété processingStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProcessingStatus(Boolean value) {
        this.processingStatus = value;
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
