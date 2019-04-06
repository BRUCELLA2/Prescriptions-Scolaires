
package generated.prescriptionserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prescriptionFullDetailsDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prescriptionFullDetailsDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.prescows.form.brucella.fr/}prescription">
 *       &lt;sequence>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processingPrescriptionList" type="{http://services.prescows.form.brucella.fr/}processingPrescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prescriptionFullDetailsDto", propOrder = {
    "cityName",
    "departmentName",
    "epleName",
    "processingPrescriptionList"
})
public class PrescriptionFullDetailsDto
    extends Prescription
{

    protected String cityName;
    protected String departmentName;
    protected String epleName;
    @XmlElement(nillable = true)
    protected List<ProcessingPrescription> processingPrescriptionList;

    /**
     * Obtient la valeur de la propriété cityName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Définit la valeur de la propriété cityName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Obtient la valeur de la propriété departmentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Définit la valeur de la propriété departmentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentName(String value) {
        this.departmentName = value;
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
     * Gets the value of the processingPrescriptionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processingPrescriptionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingPrescriptionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessingPrescription }
     * 
     * 
     */
    public List<ProcessingPrescription> getProcessingPrescriptionList() {
        if (processingPrescriptionList == null) {
            processingPrescriptionList = new ArrayList<ProcessingPrescription>();
        }
        return this.processingPrescriptionList;
    }

}
