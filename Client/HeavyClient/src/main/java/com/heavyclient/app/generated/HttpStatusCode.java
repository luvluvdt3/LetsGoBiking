
package com.heavyclient.app.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HttpStatusCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HttpStatusCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Continue"/&gt;
 *     &lt;enumeration value="SwitchingProtocols"/&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="Created"/&gt;
 *     &lt;enumeration value="Accepted"/&gt;
 *     &lt;enumeration value="NonAuthoritativeInformation"/&gt;
 *     &lt;enumeration value="NoContent"/&gt;
 *     &lt;enumeration value="ResetContent"/&gt;
 *     &lt;enumeration value="PartialContent"/&gt;
 *     &lt;enumeration value="MultipleChoices"/&gt;
 *     &lt;enumeration value="Ambiguous"/&gt;
 *     &lt;enumeration value="MovedPermanently"/&gt;
 *     &lt;enumeration value="Moved"/&gt;
 *     &lt;enumeration value="Found"/&gt;
 *     &lt;enumeration value="Redirect"/&gt;
 *     &lt;enumeration value="SeeOther"/&gt;
 *     &lt;enumeration value="RedirectMethod"/&gt;
 *     &lt;enumeration value="NotModified"/&gt;
 *     &lt;enumeration value="UseProxy"/&gt;
 *     &lt;enumeration value="Unused"/&gt;
 *     &lt;enumeration value="TemporaryRedirect"/&gt;
 *     &lt;enumeration value="RedirectKeepVerb"/&gt;
 *     &lt;enumeration value="BadRequest"/&gt;
 *     &lt;enumeration value="Unauthorized"/&gt;
 *     &lt;enumeration value="PaymentRequired"/&gt;
 *     &lt;enumeration value="Forbidden"/&gt;
 *     &lt;enumeration value="NotFound"/&gt;
 *     &lt;enumeration value="MethodNotAllowed"/&gt;
 *     &lt;enumeration value="NotAcceptable"/&gt;
 *     &lt;enumeration value="ProxyAuthenticationRequired"/&gt;
 *     &lt;enumeration value="RequestTimeout"/&gt;
 *     &lt;enumeration value="Conflict"/&gt;
 *     &lt;enumeration value="Gone"/&gt;
 *     &lt;enumeration value="LengthRequired"/&gt;
 *     &lt;enumeration value="PreconditionFailed"/&gt;
 *     &lt;enumeration value="RequestEntityTooLarge"/&gt;
 *     &lt;enumeration value="RequestUriTooLong"/&gt;
 *     &lt;enumeration value="UnsupportedMediaType"/&gt;
 *     &lt;enumeration value="RequestedRangeNotSatisfiable"/&gt;
 *     &lt;enumeration value="ExpectationFailed"/&gt;
 *     &lt;enumeration value="UpgradeRequired"/&gt;
 *     &lt;enumeration value="InternalServerError"/&gt;
 *     &lt;enumeration value="NotImplemented"/&gt;
 *     &lt;enumeration value="BadGateway"/&gt;
 *     &lt;enumeration value="ServiceUnavailable"/&gt;
 *     &lt;enumeration value="GatewayTimeout"/&gt;
 *     &lt;enumeration value="HttpVersionNotSupported"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HttpStatusCode", namespace = "http://schemas.datacontract.org/2004/07/System.Net")
@XmlEnum
public enum HttpStatusCode {

    @XmlEnumValue("Continue")
    CONTINUE("Continue"),
    @XmlEnumValue("SwitchingProtocols")
    SWITCHING_PROTOCOLS("SwitchingProtocols"),
    OK("OK"),
    @XmlEnumValue("Created")
    CREATED("Created"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("NonAuthoritativeInformation")
    NON_AUTHORITATIVE_INFORMATION("NonAuthoritativeInformation"),
    @XmlEnumValue("NoContent")
    NO_CONTENT("NoContent"),
    @XmlEnumValue("ResetContent")
    RESET_CONTENT("ResetContent"),
    @XmlEnumValue("PartialContent")
    PARTIAL_CONTENT("PartialContent"),
    @XmlEnumValue("MultipleChoices")
    MULTIPLE_CHOICES("MultipleChoices"),
    @XmlEnumValue("Ambiguous")
    AMBIGUOUS("Ambiguous"),
    @XmlEnumValue("MovedPermanently")
    MOVED_PERMANENTLY("MovedPermanently"),
    @XmlEnumValue("Moved")
    MOVED("Moved"),
    @XmlEnumValue("Found")
    FOUND("Found"),
    @XmlEnumValue("Redirect")
    REDIRECT("Redirect"),
    @XmlEnumValue("SeeOther")
    SEE_OTHER("SeeOther"),
    @XmlEnumValue("RedirectMethod")
    REDIRECT_METHOD("RedirectMethod"),
    @XmlEnumValue("NotModified")
    NOT_MODIFIED("NotModified"),
    @XmlEnumValue("UseProxy")
    USE_PROXY("UseProxy"),
    @XmlEnumValue("Unused")
    UNUSED("Unused"),
    @XmlEnumValue("TemporaryRedirect")
    TEMPORARY_REDIRECT("TemporaryRedirect"),
    @XmlEnumValue("RedirectKeepVerb")
    REDIRECT_KEEP_VERB("RedirectKeepVerb"),
    @XmlEnumValue("BadRequest")
    BAD_REQUEST("BadRequest"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized"),
    @XmlEnumValue("PaymentRequired")
    PAYMENT_REQUIRED("PaymentRequired"),
    @XmlEnumValue("Forbidden")
    FORBIDDEN("Forbidden"),
    @XmlEnumValue("NotFound")
    NOT_FOUND("NotFound"),
    @XmlEnumValue("MethodNotAllowed")
    METHOD_NOT_ALLOWED("MethodNotAllowed"),
    @XmlEnumValue("NotAcceptable")
    NOT_ACCEPTABLE("NotAcceptable"),
    @XmlEnumValue("ProxyAuthenticationRequired")
    PROXY_AUTHENTICATION_REQUIRED("ProxyAuthenticationRequired"),
    @XmlEnumValue("RequestTimeout")
    REQUEST_TIMEOUT("RequestTimeout"),
    @XmlEnumValue("Conflict")
    CONFLICT("Conflict"),
    @XmlEnumValue("Gone")
    GONE("Gone"),
    @XmlEnumValue("LengthRequired")
    LENGTH_REQUIRED("LengthRequired"),
    @XmlEnumValue("PreconditionFailed")
    PRECONDITION_FAILED("PreconditionFailed"),
    @XmlEnumValue("RequestEntityTooLarge")
    REQUEST_ENTITY_TOO_LARGE("RequestEntityTooLarge"),
    @XmlEnumValue("RequestUriTooLong")
    REQUEST_URI_TOO_LONG("RequestUriTooLong"),
    @XmlEnumValue("UnsupportedMediaType")
    UNSUPPORTED_MEDIA_TYPE("UnsupportedMediaType"),
    @XmlEnumValue("RequestedRangeNotSatisfiable")
    REQUESTED_RANGE_NOT_SATISFIABLE("RequestedRangeNotSatisfiable"),
    @XmlEnumValue("ExpectationFailed")
    EXPECTATION_FAILED("ExpectationFailed"),
    @XmlEnumValue("UpgradeRequired")
    UPGRADE_REQUIRED("UpgradeRequired"),
    @XmlEnumValue("InternalServerError")
    INTERNAL_SERVER_ERROR("InternalServerError"),
    @XmlEnumValue("NotImplemented")
    NOT_IMPLEMENTED("NotImplemented"),
    @XmlEnumValue("BadGateway")
    BAD_GATEWAY("BadGateway"),
    @XmlEnumValue("ServiceUnavailable")
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    @XmlEnumValue("GatewayTimeout")
    GATEWAY_TIMEOUT("GatewayTimeout"),
    @XmlEnumValue("HttpVersionNotSupported")
    HTTP_VERSION_NOT_SUPPORTED("HttpVersionNotSupported");
    private final String value;

    HttpStatusCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HttpStatusCode fromValue(String v) {
        for (HttpStatusCode c: HttpStatusCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
