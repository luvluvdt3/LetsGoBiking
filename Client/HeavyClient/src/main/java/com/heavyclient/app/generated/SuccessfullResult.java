
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuccessfullResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuccessfullResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EndStation" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models}Station" minOccurs="0"/&gt;
 *         &lt;element name="FullRoute" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}ArrayOfRoutePart" minOccurs="0"/&gt;
 *         &lt;element name="StartStation" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models}Station" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuccessfullResult", propOrder = {
    "endStation",
    "fullRoute",
    "startStation"
})
public class SuccessfullResult {

    @XmlElementRef(name = "EndStation", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Station> endStation;
    @XmlElementRef(name = "FullRoute", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRoutePart> fullRoute;
    @XmlElementRef(name = "StartStation", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Station> startStation;

    /**
     * Gets the value of the endStation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Station }{@code >}
     *     
     */
    public JAXBElement<Station> getEndStation() {
        return endStation;
    }

    /**
     * Sets the value of the endStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Station }{@code >}
     *     
     */
    public void setEndStation(JAXBElement<Station> value) {
        this.endStation = value;
    }

    /**
     * Gets the value of the fullRoute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRoutePart> getFullRoute() {
        return fullRoute;
    }

    /**
     * Sets the value of the fullRoute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     *     
     */
    public void setFullRoute(JAXBElement<ArrayOfRoutePart> value) {
        this.fullRoute = value;
    }

    /**
     * Gets the value of the startStation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Station }{@code >}
     *     
     */
    public JAXBElement<Station> getStartStation() {
        return startStation;
    }

    /**
     * Sets the value of the startStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Station }{@code >}
     *     
     */
    public void setStartStation(JAXBElement<Station> value) {
        this.startStation = value;
    }

}
