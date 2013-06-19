//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.26 at 07:40:13 PM MESZ 
//


package com.setantamedia.fulcrum.microsoft.office.onenote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Linked note property of an OE.
 * 			
 * 
 * <p>Java class for LinkedNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkedNote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LinkedNoteUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LinkedNoteShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LinkedNoteFriendlyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LinkedNoteDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkedNoteThumbnail" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}LinkedNoteThumbnail" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="state" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkedNote", propOrder = {
    "linkedNoteUri",
    "linkedNoteShortName",
    "linkedNoteFriendlyName",
    "linkedNoteDescription",
    "linkedNoteThumbnail"
})
public class LinkedNote {

    @XmlElement(name = "LinkedNoteUri", required = true)
    protected String linkedNoteUri;
    @XmlElement(name = "LinkedNoteShortName", required = true)
    protected String linkedNoteShortName;
    @XmlElement(name = "LinkedNoteFriendlyName", required = true)
    protected String linkedNoteFriendlyName;
    @XmlElement(name = "LinkedNoteDescription")
    protected String linkedNoteDescription;
    @XmlElement(name = "LinkedNoteThumbnail")
    protected LinkedNoteThumbnail linkedNoteThumbnail;
    @XmlAttribute(required = true)
    protected int state;

    /**
     * Gets the value of the linkedNoteUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedNoteUri() {
        return linkedNoteUri;
    }

    /**
     * Sets the value of the linkedNoteUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedNoteUri(String value) {
        this.linkedNoteUri = value;
    }

    /**
     * Gets the value of the linkedNoteShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedNoteShortName() {
        return linkedNoteShortName;
    }

    /**
     * Sets the value of the linkedNoteShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedNoteShortName(String value) {
        this.linkedNoteShortName = value;
    }

    /**
     * Gets the value of the linkedNoteFriendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedNoteFriendlyName() {
        return linkedNoteFriendlyName;
    }

    /**
     * Sets the value of the linkedNoteFriendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedNoteFriendlyName(String value) {
        this.linkedNoteFriendlyName = value;
    }

    /**
     * Gets the value of the linkedNoteDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedNoteDescription() {
        return linkedNoteDescription;
    }

    /**
     * Sets the value of the linkedNoteDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedNoteDescription(String value) {
        this.linkedNoteDescription = value;
    }

    /**
     * Gets the value of the linkedNoteThumbnail property.
     * 
     * @return
     *     possible object is
     *     {@link LinkedNoteThumbnail }
     *     
     */
    public LinkedNoteThumbnail getLinkedNoteThumbnail() {
        return linkedNoteThumbnail;
    }

    /**
     * Sets the value of the linkedNoteThumbnail property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkedNoteThumbnail }
     *     
     */
    public void setLinkedNoteThumbnail(LinkedNoteThumbnail value) {
        this.linkedNoteThumbnail = value;
    }

    /**
     * Gets the value of the state property.
     * 
     */
    public int getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     */
    public void setState(int value) {
        this.state = value;
    }

}