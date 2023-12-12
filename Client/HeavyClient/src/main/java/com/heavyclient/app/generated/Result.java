
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Result"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorResult" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}ErrorResult" minOccurs="0"/&gt;
 *         &lt;element name="SuccessfullResult" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}SuccessfullResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Result", propOrder = {
    "errorResult",
    "successfullResult"
})
public class Result {

    @XmlElementRef(name = "ErrorResult", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ErrorResult> errorResult;
    @XmlElementRef(name = "SuccessfullResult", namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<SuccessfullResult> successfullResult;

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
     * Gets the value of the successfullResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     *     
     */
    public JAXBElement<SuccessfullResult> getSuccessfullResult() {
        return successfullResult;
    }

    /**
     * Sets the value of the successfullResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     *     
     */
    public void setSuccessfullResult(JAXBElement<SuccessfullResult> value) {
        this.successfullResult = value;
    }

}
