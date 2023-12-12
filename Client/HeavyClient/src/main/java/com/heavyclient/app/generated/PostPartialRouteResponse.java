
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PostPartialRouteResult" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing}PartialRoutingResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "postPartialRouteResult"
})
@XmlRootElement(name = "PostPartialRouteResponse", namespace = "http://tempuri.org/")
public class PostPartialRouteResponse {

    @XmlElementRef(name = "PostPartialRouteResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<PartialRoutingResult> postPartialRouteResult;

    /**
     * Gets the value of the postPartialRouteResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     *     
     */
    public JAXBElement<PartialRoutingResult> getPostPartialRouteResult() {
        return postPartialRouteResult;
    }

    /**
     * Sets the value of the postPartialRouteResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     *     
     */
    public void setPostPartialRouteResult(JAXBElement<PartialRoutingResult> value) {
        this.postPartialRouteResult = value;
    }

}
