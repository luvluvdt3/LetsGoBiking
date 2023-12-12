
package com.heavyclient.app.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StationStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OPEN"/&gt;
 *     &lt;enumeration value="CLOSED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StationStatus", namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models")
@XmlEnum
public enum StationStatus {

    OPEN,
    CLOSED;

    public String value() {
        return name();
    }

    public static StationStatus fromValue(String v) {
        return valueOf(v);
    }

}
