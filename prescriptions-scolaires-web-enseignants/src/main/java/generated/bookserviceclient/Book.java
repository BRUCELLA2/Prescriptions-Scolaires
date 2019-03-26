
package generated.bookserviceclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bookStatusId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ean" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailSendDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailTeacherSend" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="prescriptionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "author",
    "bookId",
    "bookStatusId",
    "comments",
    "ean",
    "emailSendDate",
    "emailTeacherSend",
    "prescriptionId",
    "title"
})
@XmlSeeAlso({
    BookFullDetailsDto.class,
    BookWithStatusDto.class
})
public class Book {

    protected String author;
    protected Integer bookId;
    protected Integer bookStatusId;
    protected String comments;
    protected String ean;
    protected String emailSendDate;
    protected Boolean emailTeacherSend;
    protected Integer prescriptionId;
    protected String title;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété bookId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * Définit la valeur de la propriété bookId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookId(Integer value) {
        this.bookId = value;
    }

    /**
     * Obtient la valeur de la propriété bookStatusId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBookStatusId() {
        return bookStatusId;
    }

    /**
     * Définit la valeur de la propriété bookStatusId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBookStatusId(Integer value) {
        this.bookStatusId = value;
    }

    /**
     * Obtient la valeur de la propriété comments.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Définit la valeur de la propriété comments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Obtient la valeur de la propriété ean.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEan() {
        return ean;
    }

    /**
     * Définit la valeur de la propriété ean.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEan(String value) {
        this.ean = value;
    }

    /**
     * Obtient la valeur de la propriété emailSendDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailSendDate() {
        return emailSendDate;
    }

    /**
     * Définit la valeur de la propriété emailSendDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailSendDate(String value) {
        this.emailSendDate = value;
    }

    /**
     * Obtient la valeur de la propriété emailTeacherSend.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEmailTeacherSend() {
        return emailTeacherSend;
    }

    /**
     * Définit la valeur de la propriété emailTeacherSend.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEmailTeacherSend(Boolean value) {
        this.emailTeacherSend = value;
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
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
