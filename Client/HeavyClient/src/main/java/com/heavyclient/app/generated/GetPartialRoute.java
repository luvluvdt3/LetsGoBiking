
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="originLat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="originLon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="destLat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="destLon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="guiId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
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
    "originLat",
    "originLon",
    "destLat",
    "destLon",
    "guiId",
    "step"
})
@XmlRootElement(name = "GetPartialRoute", namespace = "http://tempuri.org/")
public class GetPartialRoute {

    @XmlElement(namespace = "http://tempuri.org/")
    protected Double originLat;
    @XmlElement(namespace = "http://tempuri.org/")
    protected Double originLon;
    @XmlElement(namespace = "http://tempuri.org/")
    protected Double destLat;
    @XmlElement(namespace = "http://tempuri.org/")
    protected Double destLon;
    @XmlElementRef(name = "guiId", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guiId;
    @XmlElement(namespace = "http://tempuri.org/")
    protected Integer step;

    /**
     * Gets the value of the originLat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOriginLat() {
        return originLat;
    }

    /**
     * Sets the value of the originLat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOriginLat(Double value) {
        this.originLat = value;
    }

    /**
     * Gets the value of the originLon property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOriginLon() {
        return originLon;
    }

    /**
     * Sets the value of the originLon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOriginLon(Double value) {
        this.originLon = value;
    }

    /**
     * Gets the value of the destLat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDestLat() {
        return destLat;
    }

    /**
     * Sets the value of the destLat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDestLat(Double value) {
        this.destLat = value;
    }

    /**
     * Gets the value of the destLon property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDestLon() {
        return destLon;
    }

    /**
     * Sets the value of the destLon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDestLon(Double value) {
        this.destLon = value;
    }

    /**
     * Gets the value of the guiId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuiId() {
        return guiId;
    }

    /**
     * Sets the value of the guiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuiId(JAXBElement<String> value) {
        this.guiId = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStep(Integer value) {
        this.step = value;
    }

}
