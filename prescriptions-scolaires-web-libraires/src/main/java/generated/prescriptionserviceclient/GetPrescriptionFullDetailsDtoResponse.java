
package generated.prescriptionserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getPrescriptionFullDetailsDtoResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getPrescriptionFullDetailsDtoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://services.prescows.form.brucella.fr/}prescriptionFullDetailsDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPrescriptionFullDetailsDtoResponse", propOrder = {
    "_return"
})
public class GetPrescriptionFullDetailsDtoResponse {

    @XmlElement(name = "return")
    protected PrescriptionFullDetailsDto _return;

    /**
     * Obtient la valeur de la propriété return.
     * 
     * @return
     *     possible object is
     *     {@link PrescriptionFullDetailsDto }
     *     
     */
    public PrescriptionFullDetailsDto getReturn() {
        return _return;
    }

    /**
     * Définit la valeur de la propriété return.
     * 
     * @param value
     *     allowed object is
     *     {@link PrescriptionFullDetailsDto }
     *     
     */
    public void setReturn(PrescriptionFullDetailsDto value) {
        this._return = value;
    }

}
