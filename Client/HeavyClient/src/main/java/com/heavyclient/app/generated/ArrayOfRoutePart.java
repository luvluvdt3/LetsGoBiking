
package com.heavyclient.app.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRoutePart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRoutePart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RoutePart" type="{http://schemas.datacontract.org/2004/07/RoutingServer.Model}RoutePart" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRoutePart", propOrder = {
    "routePart"
})
public class ArrayOfRoutePart {

    @XmlElement(name = "RoutePart", nillable = true)
    protected List<RoutePart> routePart;

    /**
     * Gets the value of the routePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoutePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoutePart }
     * 
     * 
     */
    public List<RoutePart> getRoutePart() {
        if (routePart == null) {
            routePart = new ArrayList<RoutePart>();
        }
        return this.routePart;
    }

}
