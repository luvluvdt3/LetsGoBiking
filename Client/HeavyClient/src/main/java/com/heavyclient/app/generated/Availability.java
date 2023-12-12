
package com.heavyclient.app.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Availability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Availability"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Bikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ElectricalBikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ElectricalInternalBatteryBikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ElectricalRemovableBatteryBikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="MechanicalBikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Stands" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Availability", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", propOrder = {
    "bikes",
    "electricalBikes",
    "electricalInternalBatteryBikes",
    "electricalRemovableBatteryBikes",
    "mechanicalBikes",
    "stands"
})
public class Availability {

    @XmlElement(name = "Bikes")
    protected Integer bikes;
    @XmlElement(name = "ElectricalBikes")
    protected Integer electricalBikes;
    @XmlElement(name = "ElectricalInternalBatteryBikes")
    protected Integer electricalInternalBatteryBikes;
    @XmlElement(name = "ElectricalRemovableBatteryBikes")
    protected Integer electricalRemovableBatteryBikes;
    @XmlElement(name = "MechanicalBikes")
    protected Integer mechanicalBikes;
    @XmlElement(name = "Stands")
    protected Integer stands;

    /**
     * Gets the value of the bikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBikes() {
        return bikes;
    }

    /**
     * Sets the value of the bikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBikes(Integer value) {
        this.bikes = value;
    }

    /**
     * Gets the value of the electricalBikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getElectricalBikes() {
        return electricalBikes;
    }

    /**
     * Sets the value of the electricalBikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setElectricalBikes(Integer value) {
        this.electricalBikes = value;
    }

    /**
     * Gets the value of the electricalInternalBatteryBikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getElectricalInternalBatteryBikes() {
        return electricalInternalBatteryBikes;
    }

    /**
     * Sets the value of the electricalInternalBatteryBikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setElectricalInternalBatteryBikes(Integer value) {
        this.electricalInternalBatteryBikes = value;
    }

    /**
     * Gets the value of the electricalRemovableBatteryBikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getElectricalRemovableBatteryBikes() {
        return electricalRemovableBatteryBikes;
    }

    /**
     * Sets the value of the electricalRemovableBatteryBikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setElectricalRemovableBatteryBikes(Integer value) {
        this.electricalRemovableBatteryBikes = value;
    }

    /**
     * Gets the value of the mechanicalBikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMechanicalBikes() {
        return mechanicalBikes;
    }

    /**
     * Sets the value of the mechanicalBikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMechanicalBikes(Integer value) {
        this.mechanicalBikes = value;
    }

    /**
     * Gets the value of the stands property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStands() {
        return stands;
    }

    /**
     * Sets the value of the stands property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStands(Integer value) {
        this.stands = value;
    }

}
