
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Feature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Feature"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Geometry" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}Geometry" minOccurs="0"/&gt;
 *         &lt;element name="Properties" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}Properties" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Feature", propOrder = {
    "geometry",
    "properties"
})
public class Feature {

    @XmlElementRef(name = "Geometry", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Geometry> geometry;
    @XmlElementRef(name = "Properties", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Properties> properties;

    /**
     * Gets the value of the geometry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     *     
     */
    public JAXBElement<Geometry> getGeometry() {
        return geometry;
    }

    /**
     * Sets the value of the geometry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     *     
     */
    public void setGeometry(JAXBElement<Geometry> value) {
        this.geometry = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Properties }{@code >}
     *     
     */
    public JAXBElement<Properties> getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Properties }{@code >}
     *     
     */
    public void setProperties(JAXBElement<Properties> value) {
        this.properties = value;
    }

}
