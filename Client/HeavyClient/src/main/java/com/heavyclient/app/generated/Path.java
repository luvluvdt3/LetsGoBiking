
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Path complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Path"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Features" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}ArrayOfFeature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Path", propOrder = {
    "features"
})
public class Path {

    @XmlElementRef(name = "Features", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFeature> features;

    /**
     * Gets the value of the features property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFeature> getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     *     
     */
    public void setFeatures(JAXBElement<ArrayOfFeature> value) {
        this.features = value;
    }

}
