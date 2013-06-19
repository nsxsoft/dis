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
 * 				Thumbnail in a linked note.
 *       
 * 
 * <p>Java class for LinkedNoteThumbnail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkedNoteThumbnail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *           &lt;element name="CallbackID" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}CallbackID"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkedNoteThumbnail", propOrder = {
    "data",
    "callbackID"
})
public class LinkedNoteThumbnail {

    @XmlElement(name = "Data")
    protected byte[] data;
    @XmlElement(name = "CallbackID")
    protected CallbackID callbackID;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = ((byte[]) value);
    }

    /**
     * Gets the value of the callbackID property.
     * 
     * @return
     *     possible object is
     *     {@link CallbackID }
     *     
     */
    public CallbackID getCallbackID() {
        return callbackID;
    }

    /**
     * Sets the value of the callbackID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallbackID }
     *     
     */
    public void setCallbackID(CallbackID value) {
        this.callbackID = value;
    }

}
