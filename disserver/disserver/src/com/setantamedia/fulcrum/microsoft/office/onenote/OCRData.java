//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.26 at 07:40:13 PM MESZ 
//


package com.setantamedia.fulcrum.microsoft.office.onenote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				lang is in ISO 639 format
 * 			
 * 
 * <p>Java class for OCRData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OCRData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OCRText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OCRToken" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}OCRToken" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}string" default="EN-US" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OCRData", propOrder = {
    "ocrText",
    "ocrToken"
})
public class OCRData {

    @XmlElement(name = "OCRText", required = true)
    protected String ocrText;
    @XmlElement(name = "OCRToken", required = true)
    protected List<OCRToken> ocrToken;
    @XmlAttribute
    protected String lang;

    /**
     * Gets the value of the ocrText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCRText() {
        return ocrText;
    }

    /**
     * Sets the value of the ocrText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCRText(String value) {
        this.ocrText = value;
    }

    /**
     * Gets the value of the ocrToken property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ocrToken property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOCRToken().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OCRToken }
     * 
     * 
     */
    public List<OCRToken> getOCRToken() {
        if (ocrToken == null) {
            ocrToken = new ArrayList<OCRToken>();
        }
        return this.ocrToken;
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
        if (lang == null) {
            return "EN-US";
        } else {
            return lang;
        }
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

}
