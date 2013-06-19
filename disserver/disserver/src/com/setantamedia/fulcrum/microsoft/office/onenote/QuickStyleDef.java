//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.26 at 07:40:13 PM MESZ 
//


package com.setantamedia.fulcrum.microsoft.office.onenote;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Defines styles.
 * 			
 * 
 * <p>Java class for QuickStyleDef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuickStyleDef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fontColor" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}COLOR" default="automatic" />
 *       &lt;attribute name="highlightColor" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}COLOR" default="automatic" />
 *       &lt;attribute name="font" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fontSize" use="required" type="{http://schemas.microsoft.com/office/onenote/2010/onenote}FontSize" />
 *       &lt;attribute name="bold" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="italic" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="underline" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="strikethrough" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="superscript" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="subscript" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="spaceBefore" type="{http://www.w3.org/2001/XMLSchema}float" default="0" />
 *       &lt;attribute name="spaceAfter" type="{http://www.w3.org/2001/XMLSchema}float" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuickStyleDef")
public class QuickStyleDef {

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger index;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected String fontColor;
    @XmlAttribute
    protected String highlightColor;
    @XmlAttribute(required = true)
    protected String font;
    @XmlAttribute(required = true)
    protected double fontSize;
    @XmlAttribute
    protected Boolean bold;
    @XmlAttribute
    protected Boolean italic;
    @XmlAttribute
    protected Boolean underline;
    @XmlAttribute
    protected Boolean strikethrough;
    @XmlAttribute
    protected Boolean superscript;
    @XmlAttribute
    protected Boolean subscript;
    @XmlAttribute
    protected Float spaceBefore;
    @XmlAttribute
    protected Float spaceAfter;

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndex(BigInteger value) {
        this.index = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the fontColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontColor() {
        if (fontColor == null) {
            return "automatic";
        } else {
            return fontColor;
        }
    }

    /**
     * Sets the value of the fontColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontColor(String value) {
        this.fontColor = value;
    }

    /**
     * Gets the value of the highlightColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighlightColor() {
        if (highlightColor == null) {
            return "automatic";
        } else {
            return highlightColor;
        }
    }

    /**
     * Sets the value of the highlightColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighlightColor(String value) {
        this.highlightColor = value;
    }

    /**
     * Gets the value of the font property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets the value of the font property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFont(String value) {
        this.font = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     */
    public double getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     */
    public void setFontSize(double value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the bold property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBold() {
        if (bold == null) {
            return false;
        } else {
            return bold;
        }
    }

    /**
     * Sets the value of the bold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBold(Boolean value) {
        this.bold = value;
    }

    /**
     * Gets the value of the italic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isItalic() {
        if (italic == null) {
            return false;
        } else {
            return italic;
        }
    }

    /**
     * Sets the value of the italic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setItalic(Boolean value) {
        this.italic = value;
    }

    /**
     * Gets the value of the underline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUnderline() {
        if (underline == null) {
            return false;
        } else {
            return underline;
        }
    }

    /**
     * Sets the value of the underline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnderline(Boolean value) {
        this.underline = value;
    }

    /**
     * Gets the value of the strikethrough property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStrikethrough() {
        if (strikethrough == null) {
            return false;
        } else {
            return strikethrough;
        }
    }

    /**
     * Sets the value of the strikethrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStrikethrough(Boolean value) {
        this.strikethrough = value;
    }

    /**
     * Gets the value of the superscript property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSuperscript() {
        if (superscript == null) {
            return false;
        } else {
            return superscript;
        }
    }

    /**
     * Sets the value of the superscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuperscript(Boolean value) {
        this.superscript = value;
    }

    /**
     * Gets the value of the subscript property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSubscript() {
        if (subscript == null) {
            return false;
        } else {
            return subscript;
        }
    }

    /**
     * Sets the value of the subscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubscript(Boolean value) {
        this.subscript = value;
    }

    /**
     * Gets the value of the spaceBefore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSpaceBefore() {
        if (spaceBefore == null) {
            return  0.0F;
        } else {
            return spaceBefore;
        }
    }

    /**
     * Sets the value of the spaceBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceBefore(Float value) {
        this.spaceBefore = value;
    }

    /**
     * Gets the value of the spaceAfter property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getSpaceAfter() {
        if (spaceAfter == null) {
            return  0.0F;
        } else {
            return spaceAfter;
        }
    }

    /**
     * Sets the value of the spaceAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSpaceAfter(Float value) {
        this.spaceAfter = value;
    }

}
