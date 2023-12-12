
package com.heavyclient.app.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.heavyclient.app.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PartialRoutingResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", "PartialRoutingResult");
    private final static QName _PartialRoutingSuccessfulResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", "PartialRoutingSuccessfulResult");
    private final static QName _ErrorResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "ErrorResult");
    private final static QName _Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Result");
    private final static QName _SuccessfullResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "SuccessfullResult");
    private final static QName _ArrayOfRoutePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "ArrayOfRoutePart");
    private final static QName _RoutePart_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "RoutePart");
    private final static QName _Path_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Path");
    private final static QName _ArrayOfFeature_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "ArrayOfFeature");
    private final static QName _Feature_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Feature");
    private final static QName _Geometry_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Geometry");
    private final static QName _Properties_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Properties");
    private final static QName _ArrayOfSegment_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "ArrayOfSegment");
    private final static QName _Segment_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Segment");
    private final static QName _ArrayOfStep_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "ArrayOfStep");
    private final static QName _Step_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Step");
    private final static QName _WayOfTransport_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "WayOfTransport");
    private final static QName _HttpStatusCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/System.Net", "HttpStatusCode");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Location_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "Location");
    private final static QName _Station_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "Station");
    private final static QName _StationStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "StationStatus");
    private final static QName _ArrayOfstring_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
    private final static QName _ArrayOfArrayOfdouble_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfArrayOfdouble");
    private final static QName _ArrayOfdouble_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfdouble");
    private final static QName _ArrayOfint_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfint");
    private final static QName _Stand_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", "Stand");
    private final static QName _Availability_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", "Availability");
    private final static QName _RouteRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer", "RouteRequest");
    private final static QName _CompositeType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer", "CompositeType");
    private final static QName _GetPartialRouteGuiId_QNAME = new QName("http://tempuri.org/", "guiId");
    private final static QName _GetPartialRouteResponseGetPartialRouteResult_QNAME = new QName("http://tempuri.org/", "GetPartialRouteResult");
    private final static QName _PostPartialRouteDestination_QNAME = new QName("http://tempuri.org/", "destination");
    private final static QName _PostPartialRouteResponsePostPartialRouteResult_QNAME = new QName("http://tempuri.org/", "PostPartialRouteResult");
    private final static QName _PostItineraryResponsePostItineraryResult_QNAME = new QName("http://tempuri.org/", "PostItineraryResult");
    private final static QName _GetItineraryResponseGetItineraryResult_QNAME = new QName("http://tempuri.org/", "GetItineraryResult");
    private final static QName _GetDataUsingDataContractComposite_QNAME = new QName("http://tempuri.org/", "composite");
    private final static QName _GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME = new QName("http://tempuri.org/", "GetDataUsingDataContractResult");
    private final static QName _StationCities_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "Cities");
    private final static QName _StationContractName_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "ContractName");
    private final static QName _StationPosition_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "Position");
    private final static QName _StationTotalStands_QNAME = new QName("http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", "TotalStands");
    private final static QName _StepInstruction_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Instruction");
    private final static QName _StepName_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Name");
    private final static QName _StepWayPoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "WayPoints");
    private final static QName _SegmentSteps_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Steps");
    private final static QName _PropertiesSegments_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Segments");
    private final static QName _GeometryCoordinates_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Coordinates");
    private final static QName _GeometryType_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Type");
    private final static QName _PathFeatures_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Features");
    private final static QName _SuccessfullResultEndStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "EndStation");
    private final static QName _SuccessfullResultFullRoute_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "FullRoute");
    private final static QName _SuccessfullResultStartStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "StartStation");
    private final static QName _ErrorResultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model", "Message");
    private final static QName _PartialRoutingSuccessfulResultGuiId_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", "GuiId");
    private final static QName _CompositeTypeStringValue_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer", "StringValue");
    private final static QName _RouteRequestDestination_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer", "Destination");
    private final static QName _RouteRequestOrigin_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer", "Origin");
    private final static QName _PartialRoutingResultErrorResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", "ErrorResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.heavyclient.app.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPartialRoute }
     * 
     */
    public GetPartialRoute createGetPartialRoute() {
        return new GetPartialRoute();
    }

    /**
     * Create an instance of {@link GetPartialRouteResponse }
     * 
     */
    public GetPartialRouteResponse createGetPartialRouteResponse() {
        return new GetPartialRouteResponse();
    }

    /**
     * Create an instance of {@link PartialRoutingResult }
     * 
     */
    public PartialRoutingResult createPartialRoutingResult() {
        return new PartialRoutingResult();
    }

    /**
     * Create an instance of {@link PostPartialRoute }
     * 
     */
    public PostPartialRoute createPostPartialRoute() {
        return new PostPartialRoute();
    }

    /**
     * Create an instance of {@link RouteRequest }
     * 
     */
    public RouteRequest createRouteRequest() {
        return new RouteRequest();
    }

    /**
     * Create an instance of {@link PostPartialRouteResponse }
     * 
     */
    public PostPartialRouteResponse createPostPartialRouteResponse() {
        return new PostPartialRouteResponse();
    }

    /**
     * Create an instance of {@link PostItinerary }
     * 
     */
    public PostItinerary createPostItinerary() {
        return new PostItinerary();
    }

    /**
     * Create an instance of {@link PostItineraryResponse }
     * 
     */
    public PostItineraryResponse createPostItineraryResponse() {
        return new PostItineraryResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link GetItinerary }
     * 
     */
    public GetItinerary createGetItinerary() {
        return new GetItinerary();
    }

    /**
     * Create an instance of {@link GetItineraryResponse }
     * 
     */
    public GetItineraryResponse createGetItineraryResponse() {
        return new GetItineraryResponse();
    }

    /**
     * Create an instance of {@link GetDataUsingDataContract }
     * 
     */
    public GetDataUsingDataContract createGetDataUsingDataContract() {
        return new GetDataUsingDataContract();
    }

    /**
     * Create an instance of {@link CompositeType }
     * 
     */
    public CompositeType createCompositeType() {
        return new CompositeType();
    }

    /**
     * Create an instance of {@link GetDataUsingDataContractResponse }
     * 
     */
    public GetDataUsingDataContractResponse createGetDataUsingDataContractResponse() {
        return new GetDataUsingDataContractResponse();
    }

    /**
     * Create an instance of {@link GetOptions }
     * 
     */
    public GetOptions createGetOptions() {
        return new GetOptions();
    }

    /**
     * Create an instance of {@link GetOptionsResponse }
     * 
     */
    public GetOptionsResponse createGetOptionsResponse() {
        return new GetOptionsResponse();
    }

    /**
     * Create an instance of {@link PartialRoutingSuccessfulResult }
     * 
     */
    public PartialRoutingSuccessfulResult createPartialRoutingSuccessfulResult() {
        return new PartialRoutingSuccessfulResult();
    }

    /**
     * Create an instance of {@link ErrorResult }
     * 
     */
    public ErrorResult createErrorResult() {
        return new ErrorResult();
    }

    /**
     * Create an instance of {@link SuccessfullResult }
     * 
     */
    public SuccessfullResult createSuccessfullResult() {
        return new SuccessfullResult();
    }

    /**
     * Create an instance of {@link ArrayOfRoutePart }
     * 
     */
    public ArrayOfRoutePart createArrayOfRoutePart() {
        return new ArrayOfRoutePart();
    }

    /**
     * Create an instance of {@link RoutePart }
     * 
     */
    public RoutePart createRoutePart() {
        return new RoutePart();
    }

    /**
     * Create an instance of {@link Path }
     * 
     */
    public Path createPath() {
        return new Path();
    }

    /**
     * Create an instance of {@link ArrayOfFeature }
     * 
     */
    public ArrayOfFeature createArrayOfFeature() {
        return new ArrayOfFeature();
    }

    /**
     * Create an instance of {@link Feature }
     * 
     */
    public Feature createFeature() {
        return new Feature();
    }

    /**
     * Create an instance of {@link Geometry }
     * 
     */
    public Geometry createGeometry() {
        return new Geometry();
    }

    /**
     * Create an instance of {@link Properties }
     * 
     */
    public Properties createProperties() {
        return new Properties();
    }

    /**
     * Create an instance of {@link ArrayOfSegment }
     * 
     */
    public ArrayOfSegment createArrayOfSegment() {
        return new ArrayOfSegment();
    }

    /**
     * Create an instance of {@link Segment }
     * 
     */
    public Segment createSegment() {
        return new Segment();
    }

    /**
     * Create an instance of {@link ArrayOfStep }
     * 
     */
    public ArrayOfStep createArrayOfStep() {
        return new ArrayOfStep();
    }

    /**
     * Create an instance of {@link Step }
     * 
     */
    public Step createStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Station }
     * 
     */
    public Station createStation() {
        return new Station();
    }

    /**
     * Create an instance of {@link ArrayOfstring }
     * 
     */
    public ArrayOfstring createArrayOfstring() {
        return new ArrayOfstring();
    }

    /**
     * Create an instance of {@link ArrayOfArrayOfdouble }
     * 
     */
    public ArrayOfArrayOfdouble createArrayOfArrayOfdouble() {
        return new ArrayOfArrayOfdouble();
    }

    /**
     * Create an instance of {@link ArrayOfdouble }
     * 
     */
    public ArrayOfdouble createArrayOfdouble() {
        return new ArrayOfdouble();
    }

    /**
     * Create an instance of {@link ArrayOfint }
     * 
     */
    public ArrayOfint createArrayOfint() {
        return new ArrayOfint();
    }

    /**
     * Create an instance of {@link Stand }
     * 
     */
    public Stand createStand() {
        return new Stand();
    }

    /**
     * Create an instance of {@link Availability }
     * 
     */
    public Availability createAvailability() {
        return new Availability();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", name = "PartialRoutingResult")
    public JAXBElement<PartialRoutingResult> createPartialRoutingResult(PartialRoutingResult value) {
        return new JAXBElement<PartialRoutingResult>(_PartialRoutingResult_QNAME, PartialRoutingResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", name = "PartialRoutingSuccessfulResult")
    public JAXBElement<PartialRoutingSuccessfulResult> createPartialRoutingSuccessfulResult(PartialRoutingSuccessfulResult value) {
        return new JAXBElement<PartialRoutingSuccessfulResult>(_PartialRoutingSuccessfulResult_QNAME, PartialRoutingSuccessfulResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ErrorResult")
    public JAXBElement<ErrorResult> createErrorResult(ErrorResult value) {
        return new JAXBElement<ErrorResult>(_ErrorResult_QNAME, ErrorResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(_Result_QNAME, Result.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "SuccessfullResult")
    public JAXBElement<SuccessfullResult> createSuccessfullResult(SuccessfullResult value) {
        return new JAXBElement<SuccessfullResult>(_SuccessfullResult_QNAME, SuccessfullResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ArrayOfRoutePart")
    public JAXBElement<ArrayOfRoutePart> createArrayOfRoutePart(ArrayOfRoutePart value) {
        return new JAXBElement<ArrayOfRoutePart>(_ArrayOfRoutePart_QNAME, ArrayOfRoutePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoutePart }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoutePart }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "RoutePart")
    public JAXBElement<RoutePart> createRoutePart(RoutePart value) {
        return new JAXBElement<RoutePart>(_RoutePart_QNAME, RoutePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Path")
    public JAXBElement<Path> createPath(Path value) {
        return new JAXBElement<Path>(_Path_QNAME, Path.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ArrayOfFeature")
    public JAXBElement<ArrayOfFeature> createArrayOfFeature(ArrayOfFeature value) {
        return new JAXBElement<ArrayOfFeature>(_ArrayOfFeature_QNAME, ArrayOfFeature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Feature }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Feature }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Feature")
    public JAXBElement<Feature> createFeature(Feature value) {
        return new JAXBElement<Feature>(_Feature_QNAME, Feature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Geometry")
    public JAXBElement<Geometry> createGeometry(Geometry value) {
        return new JAXBElement<Geometry>(_Geometry_QNAME, Geometry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Properties")
    public JAXBElement<Properties> createProperties(Properties value) {
        return new JAXBElement<Properties>(_Properties_QNAME, Properties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSegment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfSegment }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ArrayOfSegment")
    public JAXBElement<ArrayOfSegment> createArrayOfSegment(ArrayOfSegment value) {
        return new JAXBElement<ArrayOfSegment>(_ArrayOfSegment_QNAME, ArrayOfSegment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Segment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Segment }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Segment")
    public JAXBElement<Segment> createSegment(Segment value) {
        return new JAXBElement<Segment>(_Segment_QNAME, Segment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ArrayOfStep")
    public JAXBElement<ArrayOfStep> createArrayOfStep(ArrayOfStep value) {
        return new JAXBElement<ArrayOfStep>(_ArrayOfStep_QNAME, ArrayOfStep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Step")
    public JAXBElement<Step> createStep(Step value) {
        return new JAXBElement<Step>(_Step_QNAME, Step.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayOfTransport }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WayOfTransport }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "WayOfTransport")
    public JAXBElement<WayOfTransport> createWayOfTransport(WayOfTransport value) {
        return new JAXBElement<WayOfTransport>(_WayOfTransport_QNAME, WayOfTransport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HttpStatusCode }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HttpStatusCode }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/System.Net", name = "HttpStatusCode")
    public JAXBElement<HttpStatusCode> createHttpStatusCode(HttpStatusCode value) {
        return new JAXBElement<HttpStatusCode>(_HttpStatusCode_QNAME, HttpStatusCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "Location")
    public JAXBElement<Location> createLocation(Location value) {
        return new JAXBElement<Location>(_Location_QNAME, Location.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "Station")
    public JAXBElement<Station> createStation(Station value) {
        return new JAXBElement<Station>(_Station_QNAME, Station.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StationStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "StationStatus")
    public JAXBElement<StationStatus> createStationStatus(StationStatus value) {
        return new JAXBElement<StationStatus>(_StationStatus_QNAME, StationStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfstring")
    public JAXBElement<ArrayOfstring> createArrayOfstring(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ArrayOfstring_QNAME, ArrayOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfArrayOfdouble")
    public JAXBElement<ArrayOfArrayOfdouble> createArrayOfArrayOfdouble(ArrayOfArrayOfdouble value) {
        return new JAXBElement<ArrayOfArrayOfdouble>(_ArrayOfArrayOfdouble_QNAME, ArrayOfArrayOfdouble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfdouble")
    public JAXBElement<ArrayOfdouble> createArrayOfdouble(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_ArrayOfdouble_QNAME, ArrayOfdouble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfint")
    public JAXBElement<ArrayOfint> createArrayOfint(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_ArrayOfint_QNAME, ArrayOfint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stand }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Stand }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", name = "Stand")
    public JAXBElement<Stand> createStand(Stand value) {
        return new JAXBElement<Stand>(_Stand_QNAME, Stand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Availability }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Availability }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", name = "Availability")
    public JAXBElement<Availability> createAvailability(Availability value) {
        return new JAXBElement<Availability>(_Availability_QNAME, Availability.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer", name = "RouteRequest")
    public JAXBElement<RouteRequest> createRouteRequest(RouteRequest value) {
        return new JAXBElement<RouteRequest>(_RouteRequest_QNAME, RouteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer", name = "CompositeType")
    public JAXBElement<CompositeType> createCompositeType(CompositeType value) {
        return new JAXBElement<CompositeType>(_CompositeType_QNAME, CompositeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guiId", scope = GetPartialRoute.class)
    public JAXBElement<String> createGetPartialRouteGuiId(String value) {
        return new JAXBElement<String>(_GetPartialRouteGuiId_QNAME, String.class, GetPartialRoute.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPartialRouteResult", scope = GetPartialRouteResponse.class)
    public JAXBElement<PartialRoutingResult> createGetPartialRouteResponseGetPartialRouteResult(PartialRoutingResult value) {
        return new JAXBElement<PartialRoutingResult>(_GetPartialRouteResponseGetPartialRouteResult_QNAME, PartialRoutingResult.class, GetPartialRouteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "destination", scope = PostPartialRoute.class)
    public JAXBElement<RouteRequest> createPostPartialRouteDestination(RouteRequest value) {
        return new JAXBElement<RouteRequest>(_PostPartialRouteDestination_QNAME, RouteRequest.class, PostPartialRoute.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "guiId", scope = PostPartialRoute.class)
    public JAXBElement<String> createPostPartialRouteGuiId(String value) {
        return new JAXBElement<String>(_GetPartialRouteGuiId_QNAME, String.class, PostPartialRoute.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartialRoutingResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PostPartialRouteResult", scope = PostPartialRouteResponse.class)
    public JAXBElement<PartialRoutingResult> createPostPartialRouteResponsePostPartialRouteResult(PartialRoutingResult value) {
        return new JAXBElement<PartialRoutingResult>(_PostPartialRouteResponsePostPartialRouteResult_QNAME, PartialRoutingResult.class, PostPartialRouteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RouteRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "destination", scope = PostItinerary.class)
    public JAXBElement<RouteRequest> createPostItineraryDestination(RouteRequest value) {
        return new JAXBElement<RouteRequest>(_PostPartialRouteDestination_QNAME, RouteRequest.class, PostItinerary.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PostItineraryResult", scope = PostItineraryResponse.class)
    public JAXBElement<Result> createPostItineraryResponsePostItineraryResult(Result value) {
        return new JAXBElement<Result>(_PostItineraryResponsePostItineraryResult_QNAME, Result.class, PostItineraryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Result }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetItineraryResult", scope = GetItineraryResponse.class)
    public JAXBElement<Result> createGetItineraryResponseGetItineraryResult(Result value) {
        return new JAXBElement<Result>(_GetItineraryResponseGetItineraryResult_QNAME, Result.class, GetItineraryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "composite", scope = GetDataUsingDataContract.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractComposite(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractComposite_QNAME, CompositeType.class, GetDataUsingDataContract.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDataUsingDataContractResult", scope = GetDataUsingDataContractResponse.class)
    public JAXBElement<CompositeType> createGetDataUsingDataContractResponseGetDataUsingDataContractResult(CompositeType value) {
        return new JAXBElement<CompositeType>(_GetDataUsingDataContractResponseGetDataUsingDataContractResult_QNAME, CompositeType.class, GetDataUsingDataContractResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Availability }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Availability }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models.BaseModels", name = "Availability", scope = Stand.class)
    public JAXBElement<Availability> createStandAvailability(Availability value) {
        return new JAXBElement<Availability>(_Availability_QNAME, Availability.class, Stand.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "Cities", scope = Station.class)
    public JAXBElement<ArrayOfstring> createStationCities(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_StationCities_QNAME, ArrayOfstring.class, Station.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "ContractName", scope = Station.class)
    public JAXBElement<String> createStationContractName(String value) {
        return new JAXBElement<String>(_StationContractName_QNAME, String.class, Station.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "Position", scope = Station.class)
    public JAXBElement<Location> createStationPosition(Location value) {
        return new JAXBElement<Location>(_StationPosition_QNAME, Location.class, Station.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stand }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Stand }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/JCDecauxProxy.Models", name = "TotalStands", scope = Station.class)
    public JAXBElement<Stand> createStationTotalStands(Stand value) {
        return new JAXBElement<Stand>(_StationTotalStands_QNAME, Stand.class, Station.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Instruction", scope = Step.class)
    public JAXBElement<String> createStepInstruction(String value) {
        return new JAXBElement<String>(_StepInstruction_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Name", scope = Step.class)
    public JAXBElement<String> createStepName(String value) {
        return new JAXBElement<String>(_StepName_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "WayPoints", scope = Step.class)
    public JAXBElement<ArrayOfint> createStepWayPoints(ArrayOfint value) {
        return new JAXBElement<ArrayOfint>(_StepWayPoints_QNAME, ArrayOfint.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Steps", scope = Segment.class)
    public JAXBElement<ArrayOfStep> createSegmentSteps(ArrayOfStep value) {
        return new JAXBElement<ArrayOfStep>(_SegmentSteps_QNAME, ArrayOfStep.class, Segment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSegment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfSegment }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Segments", scope = Properties.class)
    public JAXBElement<ArrayOfSegment> createPropertiesSegments(ArrayOfSegment value) {
        return new JAXBElement<ArrayOfSegment>(_PropertiesSegments_QNAME, ArrayOfSegment.class, Properties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Coordinates", scope = Geometry.class)
    public JAXBElement<ArrayOfArrayOfdouble> createGeometryCoordinates(ArrayOfArrayOfdouble value) {
        return new JAXBElement<ArrayOfArrayOfdouble>(_GeometryCoordinates_QNAME, ArrayOfArrayOfdouble.class, Geometry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Type", scope = Geometry.class)
    public JAXBElement<String> createGeometryType(String value) {
        return new JAXBElement<String>(_GeometryType_QNAME, String.class, Geometry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Geometry }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Geometry", scope = Feature.class)
    public JAXBElement<Geometry> createFeatureGeometry(Geometry value) {
        return new JAXBElement<Geometry>(_Geometry_QNAME, Geometry.class, Feature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Properties }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Properties", scope = Feature.class)
    public JAXBElement<Properties> createFeatureProperties(Properties value) {
        return new JAXBElement<Properties>(_Properties_QNAME, Properties.class, Feature.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfFeature }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Features", scope = Path.class)
    public JAXBElement<ArrayOfFeature> createPathFeatures(ArrayOfFeature value) {
        return new JAXBElement<ArrayOfFeature>(_PathFeatures_QNAME, ArrayOfFeature.class, Path.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Path", scope = RoutePart.class)
    public JAXBElement<Path> createRoutePartPath(Path value) {
        return new JAXBElement<Path>(_Path_QNAME, Path.class, RoutePart.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "EndStation", scope = SuccessfullResult.class)
    public JAXBElement<Station> createSuccessfullResultEndStation(Station value) {
        return new JAXBElement<Station>(_SuccessfullResultEndStation_QNAME, Station.class, SuccessfullResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRoutePart }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "FullRoute", scope = SuccessfullResult.class)
    public JAXBElement<ArrayOfRoutePart> createSuccessfullResultFullRoute(ArrayOfRoutePart value) {
        return new JAXBElement<ArrayOfRoutePart>(_SuccessfullResultFullRoute_QNAME, ArrayOfRoutePart.class, SuccessfullResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Station }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "StartStation", scope = SuccessfullResult.class)
    public JAXBElement<Station> createSuccessfullResultStartStation(Station value) {
        return new JAXBElement<Station>(_SuccessfullResultStartStation_QNAME, Station.class, SuccessfullResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "Message", scope = ErrorResult.class)
    public JAXBElement<String> createErrorResultMessage(String value) {
        return new JAXBElement<String>(_ErrorResultMessage_QNAME, String.class, ErrorResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", name = "GuiId", scope = PartialRoutingSuccessfulResult.class)
    public JAXBElement<String> createPartialRoutingSuccessfulResultGuiId(String value) {
        return new JAXBElement<String>(_PartialRoutingSuccessfulResultGuiId_QNAME, String.class, PartialRoutingSuccessfulResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer", name = "StringValue", scope = CompositeType.class)
    public JAXBElement<String> createCompositeTypeStringValue(String value) {
        return new JAXBElement<String>(_CompositeTypeStringValue_QNAME, String.class, CompositeType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "ErrorResult", scope = Result.class)
    public JAXBElement<ErrorResult> createResultErrorResult(ErrorResult value) {
        return new JAXBElement<ErrorResult>(_ErrorResult_QNAME, ErrorResult.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SuccessfullResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model", name = "SuccessfullResult", scope = Result.class)
    public JAXBElement<SuccessfullResult> createResultSuccessfullResult(SuccessfullResult value) {
        return new JAXBElement<SuccessfullResult>(_SuccessfullResult_QNAME, SuccessfullResult.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer", name = "Destination", scope = RouteRequest.class)
    public JAXBElement<Location> createRouteRequestDestination(Location value) {
        return new JAXBElement<Location>(_RouteRequestDestination_QNAME, Location.class, RouteRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Location }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer", name = "Origin", scope = RouteRequest.class)
    public JAXBElement<Location> createRouteRequestOrigin(Location value) {
        return new JAXBElement<Location>(_RouteRequestOrigin_QNAME, Location.class, RouteRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", name = "ErrorResult", scope = PartialRoutingResult.class)
    public JAXBElement<ErrorResult> createPartialRoutingResultErrorResult(ErrorResult value) {
        return new JAXBElement<ErrorResult>(_PartialRoutingResultErrorResult_QNAME, ErrorResult.class, PartialRoutingResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartialRoutingSuccessfulResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/RoutingServer.Model.ResultResponces.Routing", name = "PartialRoutingSuccessfulResult", scope = PartialRoutingResult.class)
    public JAXBElement<PartialRoutingSuccessfulResult> createPartialRoutingResultPartialRoutingSuccessfulResult(PartialRoutingSuccessfulResult value) {
        return new JAXBElement<PartialRoutingSuccessfulResult>(_PartialRoutingSuccessfulResult_QNAME, PartialRoutingSuccessfulResult.class, PartialRoutingResult.class, value);
    }

}
