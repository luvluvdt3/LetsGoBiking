
package com.heavyclient.app.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WayOfTransport.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WayOfTransport"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="WALK"/&gt;
 *     &lt;enumeration value="CYCLING"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WayOfTransport")
@XmlEnum
public enum WayOfTransport {

    WALK,
    CYCLING;

    public String value() {
        return name();
    }

    public static WayOfTransport fromValue(String v) {
        return valueOf(v);
    }

}
