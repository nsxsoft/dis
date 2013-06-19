//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.26 at 07:40:13 PM MESZ 
//


package com.setantamedia.fulcrum.microsoft.office.onenote;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 				A single outline element.
 * 			
 * 
 * <p>Java class for OE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MediaIndex" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}MediaIndex" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Tag" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Tag" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element name="OutlookTask" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}OutlookTask"/>
 *           &lt;element name="Tag" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Tag" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="Meta" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Meta" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="List" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}List" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Image" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Image"/>
 *           &lt;element name="Table" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Table"/>
 *           &lt;element name="InkDrawing" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}InkDrawing"/>
 *           &lt;element name="InsertedFile" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}InsertedFile"/>
 *           &lt;element name="MediaFile" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}MediaFile"/>
 *           &lt;element name="InkParagraph" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}InkParagraph"/>
 *           &lt;element name="FutureObject" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}FutureObject"/>
 *           &lt;sequence maxOccurs="unbounded">
 *             &lt;element name="T" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}TextRange" minOccurs="0"/>
 *             &lt;element name="InkWord" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}InkWord" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="OEChildren" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}OEChildren" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinkedNote" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}LinkedNote" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://schemas.microsoft.com/office/onenote/2010/onenote}CascadedTextAttributes"/>
 *       &lt;attGroup ref="{http://schemas.microsoft.com/office/onenote/2010/onenote}EditedByAttributes"/>
 *       &lt;attribute name="RTL" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="bodyText" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="collapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="collapsedBodyText" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="alignment" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Alignment" default="left" />
 *       &lt;attribute name="selected" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Selection" default="none" />
 *       &lt;attribute name="objectID" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}ObjectID" />
 *       &lt;attribute name="spaceBefore" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PositiveDecimal" />
 *       &lt;attribute name="spaceBetween" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PositiveDecimal" />
 *       &lt;attribute name="spaceAfter" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PositiveDecimal" />
 *       &lt;attribute name="lastModifiedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="preserveTextContent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OE", propOrder = {
    "content"
})
public class OE {

    @XmlElementRefs({
        @XmlElementRef(name = "FutureObject", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "MediaFile", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "InkWord", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "Table", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "OEChildren", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "Meta", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "InkDrawing", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "OutlookTask", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "Tag", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "MediaIndex", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "InsertedFile", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "List", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "InkParagraph", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "T", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "LinkedNote", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class),
        @XmlElementRef(name = "Image", namespace = "http://schemas.microsoft.com/office/onenote/2010/onenote", type = JAXBElement.class)
    })
    protected java.util.List<JAXBElement<?>> content;
    @XmlAttribute(name = "RTL")
    protected Boolean rtl;
    @XmlAttribute
    protected Boolean bodyText;
    @XmlAttribute
    protected Boolean collapsed;
    @XmlAttribute
    protected Boolean collapsedBodyText;
    @XmlAttribute
    protected String alignment;
    @XmlAttribute
    protected String selected;
    @XmlAttribute
    protected String objectID;
    @XmlAttribute
    protected Double spaceBefore;
    @XmlAttribute
    protected Double spaceBetween;
    @XmlAttribute
    protected Double spaceAfter;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModifiedTime;
    @XmlAttribute
    protected Boolean preserveTextContent;
    @XmlAttribute
    protected String style;
    @XmlAttribute
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger quickStyleIndex;
    @XmlAttribute
    protected String lang;
    @XmlAttribute
    protected String author;
    @XmlAttribute
    protected String authorInitials;
    @XmlAttribute
    protected String lastModifiedBy;
    @XmlAttribute
    protected String lastModifiedByInitials;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Tag" is used by two different parts of a schema. See: 
     * line 649 of file:/C:/Users/colin/git/fulcrum3/resources/xml/OneNote2010.xsd
     * line 646 of file:/C:/Users/colin/git/fulcrum3/resources/xml/OneNote2010.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FutureObject }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaFile }{@code >}
     * {@link JAXBElement }{@code <}{@link InkWord }{@code >}
     * {@link JAXBElement }{@code <}{@link Table }{@code >}
     * {@link JAXBElement }{@code <}{@link OEChildren }{@code >}
     * {@link JAXBElement }{@code <}{@link Meta }{@code >}
     * {@link JAXBElement }{@code <}{@link InkDrawing }{@code >}
     * {@link JAXBElement }{@code <}{@link OutlookTask }{@code >}
     * {@link JAXBElement }{@code <}{@link Tag }{@code >}
     * {@link JAXBElement }{@code <}{@link MediaIndex }{@code >}
     * {@link JAXBElement }{@code <}{@link InsertedFile }{@code >}
     * {@link JAXBElement }{@code <}{@link com.setantamedia.fulcrum.microsoft.office.onenote.List }{@code >}
     * {@link JAXBElement }{@code <}{@link InkParagraph }{@code >}
     * {@link JAXBElement }{@code <}{@link TextRange }{@code >}
     * {@link JAXBElement }{@code <}{@link LinkedNote }{@code >}
     * {@link JAXBElement }{@code <}{@link Image }{@code >}
     * 
     * 
     */
    public java.util.List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

    /**
     * Gets the value of the rtl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRTL() {
        return rtl;
    }

    /**
     * Sets the value of the rtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRTL(Boolean value) {
        this.rtl = value;
    }

    /**
     * Gets the value of the bodyText property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBodyText() {
        if (bodyText == null) {
            return false;
        } else {
            return bodyText;
        }
    }

    /**
     * Sets the value of the bodyText property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBodyText(Boolean value) {
        this.bodyText = value;
    }

    /**
     * Gets the value of the collapsed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCollapsed() {
        if (collapsed == null) {
            return false;
        } else {
            return collapsed;
        }
    }

    /**
     * Sets the value of the collapsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCollapsed(Boolean value) {
        this.collapsed = value;
    }

    /**
     * Gets the value of the collapsedBodyText property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCollapsedBodyText() {
        if (collapsedBodyText == null) {
            return false;
        } else {
            return collapsedBodyText;
        }
    }

    /**
     * Sets the value of the collapsedBodyText property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCollapsedBodyText(Boolean value) {
        this.collapsedBodyText = value;
    }

    /**
     * Gets the value of the alignment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlignment() {
        if (alignment == null) {
            return "left";
        } else {
            return alignment;
        }
    }

    /**
     * Sets the value of the alignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlignment(String value) {
        this.alignment = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelected() {
        if (selected == null) {
            return "none";
        } else {
            return selected;
        }
    }

    /**
     * Sets the value of the selected property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelected(String value) {
        this.selected = value;
    }

    /**
     * Gets the value of the objectID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectID() {
        return objectID;
    }

    /**
     * Sets the value of the objectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectID(String value) {
        this.objectID = value;
    }

    /**
     * Gets the value of the spaceBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSpaceBefore() {
        return spaceBefore;
    }

    /**
     * Sets the value of the spaceBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpaceBefore(Double value) {
        this.spaceBefore = value;
    }

    /**
     * Gets the value of the spaceBetween property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSpaceBetween() {
        return spaceBetween;
    }

    /**
     * Sets the value of the spaceBetween property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpaceBetween(Double value) {
        this.spaceBetween = value;
    }

    /**
     * Gets the value of the spaceAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSpaceAfter() {
        return spaceAfter;
    }

    /**
     * Sets the value of the spaceAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpaceAfter(Double value) {
        this.spaceAfter = value;
    }

    /**
     * Gets the value of the lastModifiedTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Sets the value of the lastModifiedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModifiedTime(XMLGregorianCalendar value) {
        this.lastModifiedTime = value;
    }

    /**
     * Gets the value of the preserveTextContent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreserveTextContent() {
        return preserveTextContent;
    }

    /**
     * Sets the value of the preserveTextContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreserveTextContent(Boolean value) {
        this.preserveTextContent = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Gets the value of the quickStyleIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuickStyleIndex() {
        return quickStyleIndex;
    }

    /**
     * Sets the value of the quickStyleIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuickStyleIndex(BigInteger value) {
        this.quickStyleIndex = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the author property.
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
     * Sets the value of the author property.
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
     * Gets the value of the authorInitials property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorInitials() {
        return authorInitials;
    }

    /**
     * Sets the value of the authorInitials property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorInitials(String value) {
        this.authorInitials = value;
    }

    /**
     * Gets the value of the lastModifiedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the value of the lastModifiedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifiedBy(String value) {
        this.lastModifiedBy = value;
    }

    /**
     * Gets the value of the lastModifiedByInitials property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifiedByInitials() {
        return lastModifiedByInitials;
    }

    /**
     * Sets the value of the lastModifiedByInitials property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifiedByInitials(String value) {
        this.lastModifiedByInitials = value;
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

}