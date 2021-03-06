
package generated.authentificationserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour PrescoWsException complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="PrescoWsException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fault" type="{http://services.prescows.form.brucella.fr/}prescoWsFault" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrescoWsException", propOrder = {
    "fault",
    "message"
})
public class PrescoWsException {

    protected PrescoWsFault fault;
    protected String message;

    /**
     * Obtient la valeur de la propriété fault.
     * 
     * @return
     *     possible object is
     *     {@link PrescoWsFault }
     *     
     */
    public PrescoWsFault getFault() {
        return fault;
    }

    /**
     * Définit la valeur de la propriété fault.
     * 
     * @param value
     *     allowed object is
     *     {@link PrescoWsFault }
     *     
     */
    public void setFault(PrescoWsFault value) {
        this.fault = value;
    }

    /**
     * Obtient la valeur de la propriété message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Définit la valeur de la propriété message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
