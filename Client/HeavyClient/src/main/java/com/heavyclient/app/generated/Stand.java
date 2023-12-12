
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Stand complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Stand"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Availability" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels}Availability" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stand", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", propOrder = {
    "availability"
})
public class Stand {

    @XmlElementRef(name = "Availability", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", type = JAXBElement.class, required = false)
    protected JAXBElement<Availability> availability;

    /**
     * Gets the value of the availability property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Availability }{@code >}
     *     
     */
    public JAXBElement<Availability> getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Availability }{@code >}
     *     
     */
    public void setAvailability(JAXBElement<Availability> value) {
        this.availability = value;
    }

}
