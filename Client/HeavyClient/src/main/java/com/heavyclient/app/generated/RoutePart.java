
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoutePart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoutePart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Path" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}Path" minOccurs="0"/&gt;
 *         &lt;element name="WayOfTransport" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}WayOfTransport" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoutePart", propOrder = {
    "path",
    "wayOfTransport"
})
public class RoutePart {

    @XmlElementRef(name = "Path", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Path> path;
    @XmlElement(name = "WayOfTransport")
    @XmlSchemaType(name = "string")
    protected WayOfTransport wayOfTransport;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Path }{@code >}
     *     
     */
    public JAXBElement<Path> getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Path }{@code >}
     *     
     */
    public void setPath(JAXBElement<Path> value) {
        this.path = value;
    }

    /**
     * Gets the value of the wayOfTransport property.
     * 
     * @return
     *     possible object is
     *     {@link WayOfTransport }
     *     
     */
    public WayOfTransport getWayOfTransport() {
        return wayOfTransport;
    }

    /**
     * Sets the value of the wayOfTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayOfTransport }
     *     
     */
    public void setWayOfTransport(WayOfTransport value) {
        this.wayOfTransport = value;
    }

}
