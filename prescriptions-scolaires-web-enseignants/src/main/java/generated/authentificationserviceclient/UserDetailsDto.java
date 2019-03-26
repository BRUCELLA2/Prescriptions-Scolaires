
package generated.authentificationserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour userDetailsDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="userDetailsDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.prescows.form.brucella.fr/}user">
 *       &lt;sequence>
 *         &lt;element name="epleList" type="{http://services.prescows.form.brucella.fr/}eple" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="roleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDetailsDto", propOrder = {
    "epleList",
    "roleName"
})
public class UserDetailsDto
    extends User
{

    @XmlElement(nillable = true)
    protected List<Eple> epleList;
    protected String roleName;

    /**
     * Gets the value of the epleList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epleList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpleList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Eple }
     * 
     * 
     */
    public List<Eple> getEpleList() {
        if (epleList == null) {
            epleList = new ArrayList<Eple>();
        }
        return this.epleList;
    }

    /**
     * Obtient la valeur de la propriété roleName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Définit la valeur de la propriété roleName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

}
