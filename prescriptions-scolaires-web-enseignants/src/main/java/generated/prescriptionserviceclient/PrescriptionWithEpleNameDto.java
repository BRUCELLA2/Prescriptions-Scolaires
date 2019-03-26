
package generated.prescriptionserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour prescriptionWithEpleNameDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="prescriptionWithEpleNameDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.prescows.form.brucella.fr/}prescription">
 *       &lt;sequence>
 *         &lt;element name="epleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prescriptionWithEpleNameDto", propOrder = {
    "epleName"
})
public class PrescriptionWithEpleNameDto
    extends Prescription
{

    protected String epleName;

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

}
