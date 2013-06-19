//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.26 at 07:40:13 PM MESZ 
//


package com.setantamedia.fulcrum.microsoft.office.onenote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Settings for the page size.
 * 			
 * 
 * <p>Java class for PageSize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Automatic" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}Automatic"/>
 *         &lt;sequence>
 *           &lt;element name="Orientation" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PageOrientation"/>
 *           &lt;element name="Dimensions" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PageDimensions"/>
 *           &lt;element name="Margins" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}PageMargins"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageSize", propOrder = {
    "automatic",
    "orientation",
    "dimensions",
    "margins"
})
public class PageSize {

    @XmlElement(name = "Automatic")
    protected Automatic automatic;
    @XmlElement(name = "Orientation")
    protected PageOrientation orientation;
    @XmlElement(name = "Dimensions")
    protected PageDimensions dimensions;
    @XmlElement(name = "Margins")
    protected PageMargins margins;

    /**
     * Gets the value of the automatic property.
     * 
     * @return
     *     possible object is
     *     {@link Automatic }
     *     
     */
    public Automatic getAutomatic() {
        return automatic;
    }

    /**
     * Sets the value of the automatic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Automatic }
     *     
     */
    public void setAutomatic(Automatic value) {
        this.automatic = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link PageOrientation }
     *     
     */
    public PageOrientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageOrientation }
     *     
     */
    public void setOrientation(PageOrientation value) {
        this.orientation = value;
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link PageDimensions }
     *     
     */
    public PageDimensions getDimensions() {
        return dimensions;
    }

    /**
     * Sets the value of the dimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageDimensions }
     *     
     */
    public void setDimensions(PageDimensions value) {
        this.dimensions = value;
    }

    /**
     * Gets the value of the margins property.
     * 
     * @return
     *     possible object is
     *     {@link PageMargins }
     *     
     */
    public PageMargins getMargins() {
        return margins;
    }

    /**
     * Sets the value of the margins property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageMargins }
     *     
     */
    public void setMargins(PageMargins value) {
        this.margins = value;
    }

}