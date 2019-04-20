
package generated.bookserviceclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookFullDetailsDto complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="bookFullDetailsDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.prescows.form.brucella.fr/}book">
 *       &lt;sequence>
 *         &lt;element name="bookStatusName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headcount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="processingBookList" type="{http://services.prescows.form.brucella.fr/}processingBook" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="purchaseDeadline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookFullDetailsDto", propOrder = {
    "bookStatusName",
    "epleName",
    "headcount",
    "processingBookList",
    "purchaseDeadline"
})
public class BookFullDetailsDto
    extends Book
{

    protected String bookStatusName;
    protected String epleName;
    protected Integer headcount;
    @XmlElement(nillable = true)
    protected List<ProcessingBook> processingBookList;
    protected String purchaseDeadline;

    /**
     * Obtient la valeur de la propriété bookStatusName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookStatusName() {
        return bookStatusName;
    }

    /**
     * Définit la valeur de la propriété bookStatusName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookStatusName(String value) {
        this.bookStatusName = value;
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
     * Gets the value of the processingBookList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processingBookList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingBookList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessingBook }
     * 
     * 
     */
    public List<ProcessingBook> getProcessingBookList() {
        if (processingBookList == null) {
            processingBookList = new ArrayList<ProcessingBook>();
        }
        return this.processingBookList;
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

}
