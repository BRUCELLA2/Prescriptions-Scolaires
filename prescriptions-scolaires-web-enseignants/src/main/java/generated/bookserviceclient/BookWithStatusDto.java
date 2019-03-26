
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookWithStatusDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookWithStatusDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.prescows.form.brucella.fr/}book">
 *       &lt;sequence>
 *         &lt;element name="nameStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookWithStatusDto", propOrder = {
    "nameStatus"
})
public class BookWithStatusDto
    extends Book
{

    protected String nameStatus;

    /**
     * Obtient la valeur de la propriété nameStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameStatus() {
        return nameStatus;
    }

    /**
     * Définit la valeur de la propriété nameStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameStatus(String value) {
        this.nameStatus = value;
    }

}
