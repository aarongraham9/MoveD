//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.30 at 11:25:16 AM AST 
//


package com.Kronius.moved;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RunningFlag" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="DoneFlag" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "source",
    "destination",
    "runningFlag",
    "doneFlag"
})
@XmlRootElement(name = "MoveDConfig")
public class MoveDConfig {

    @XmlElement(name = "Source", required = true)
    protected String source;
    @XmlElement(name = "Destination", required = true)
    protected String destination;
    @XmlElement(name = "RunningFlag")
    protected byte runningFlag;
    @XmlElement(name = "DoneFlag")
    protected byte doneFlag;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the runningFlag property.
     * 
     */
    public byte getRunningFlag() {
        return runningFlag;
    }

    /**
     * Sets the value of the runningFlag property.
     * 
     */
    public void setRunningFlag(byte value) {
        this.runningFlag = value;
    }

    /**
     * Gets the value of the doneFlag property.
     * 
     */
    public byte getDoneFlag() {
        return doneFlag;
    }

    /**
     * Sets the value of the doneFlag property.
     * 
     */
    public void setDoneFlag(byte value) {
        this.doneFlag = value;
    }

}
