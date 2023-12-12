
package com.heavyclient.app.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Station complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Station"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Banking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Bonus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Cities" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
 *         &lt;element name="ContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Position" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models}Location" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models}StationStatus" minOccurs="0"/&gt;
 *         &lt;element name="TotalStands" type="{http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels}Stand" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Station", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", propOrder = {
    "banking",
    "bonus",
    "cities",
    "contractName",
    "number",
    "position",
    "status",
    "totalStands"
})
public class Station {

    @XmlElement(name = "Banking")
    protected Boolean banking;
    @XmlElement(name = "Bonus")
    protected Boolean bonus;
    @XmlElementRef(name = "Cities", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> cities;
    @XmlElementRef(name = "ContractName", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contractName;
    @XmlElement(name = "Number")
    protected Integer number;
    @XmlElementRef(name = "Position", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<Location> position;
    @XmlElement(name = "Status")
    @XmlSchemaType(name = "string")
    protected StationStatus status;
    @XmlElementRef(name = "TotalStands", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", type = JAXBElement.class, required = false)
    protected JAXBElement<Stand> totalStands;

    /**
     * Gets the value of the banking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBanking() {
        return banking;
    }

    /**
     * Sets the value of the banking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBanking(Boolean value) {
        this.banking = value;
    }

    /**
     * Gets the value of the bonus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBonus() {
        return bonus;
    }

    /**
     * Sets the value of the bonus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBonus(Boolean value) {
        this.bonus = value;
    }

    /**
     * Gets the value of the cities property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCities(JAXBElement<ArrayOfstring> value) {
        this.cities = value;
    }

    /**
     * Gets the value of the contractName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContractName() {
        return contractName;
    }

    /**
     * Sets the value of the contractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContractName(JAXBElement<String> value) {
        this.contractName = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Location }{@code >}
     *     
     */
    public JAXBElement<Location> getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Location }{@code >}
     *     
     */
    public void setPosition(JAXBElement<Location> value) {
        this.position = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StationStatus }
     *     
     */
    public StationStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StationStatus }
     *     
     */
    public void setStatus(StationStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the totalStands property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Stand }{@code >}
     *     
     */
    public JAXBElement<Stand> getTotalStands() {
        return totalStands;
    }

    /**
     * Sets the value of the totalStands property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Stand }{@code >}
     *     
     */
    public void setTotalStands(JAXBElement<Stand> value) {
        this.totalStands = value;
    }

}
