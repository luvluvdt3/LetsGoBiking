
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartialRoutingResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartialRoutingResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorResult" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}ErrorResult" minOccurs="0"/&gt;
 *         &lt;element name="PartialRoutingSuccessfulResult" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing}PartialRoutingSuccessfulResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartialRoutingResult", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", propOrder = {
    "errorResult",
    "partialRoutingSuccessfulResult"
})
public class PartialRoutingResult {

    @XmlElementRef(name = "ErrorResult", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", type = JAXBElement.class, required = false)
    protected JAXBElement<ErrorResult> errorResult;
    @XmlElementRef(name = "PartialRoutingSuccessfulResult", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", type = JAXBElement.class, required = false)
    protected JAXBElement<PartialRoutingSuccessfulResult> partialRoutingSuccessfulResult;

    /**
     * Gets the value of the errorResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     *     
     */
    public JAXBElement<ErrorResult> getErrorResult() {
        return errorResult;
    }

    /**
     * Sets the value of the errorResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     *     
     */
    public void setErrorResult(JAXBElement<ErrorResult> value) {
        this.errorResult = value;
    }

    /**
     * Gets the value of the partialRoutingSuccessfulResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     *     
     */
    public JAXBElement<PartialRoutingSuccessfulResult> getPartialRoutingSuccessfulResult() {
        return partialRoutingSuccessfulResult;
    }

    /**
     * Sets the value of the partialRoutingSuccessfulResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     *     
     */
    public void setPartialRoutingSuccessfulResult(JAXBElement<PartialRoutingSuccessfulResult> value) {
        this.partialRoutingSuccessfulResult = value;
    }

}
