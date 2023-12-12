import {
  MapContainer,
  Marker,
  Popup,
  Polyline,
  TileLayer,
  useMapEvent,
  FeatureGroup,
  useMap,
} from "react-leaflet";
import Offcanvas from "react-bootstrap/Offcanvas";
import OffcanvasFooter from "./OffcanvasFooter";
import React, { useEffect, useState } from "react";
import OwnLocationMarker from "./OwnLocationMarker";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import L from "leaflet";
import axios from "axios";
import {
  faBicycle,
  faMapPin,
  faLocationDot,
  faStreetView,
  faShoePrints,
  faCog,
  faSquareParking,
} from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import FindAdress from "./findAddress/FindAdress";
import cogoToast from "cogo-toast";
import originIc from "../assets/origin.png";
import destinationIc from "../assets/destination.png";
import originStationIc from "../assets/originStation.png";
import destinationStationIc from "../assets/destionationStation.png";
import stepIc from "../assets/step.png";
import { CustomCursor } from "react-svg-cursor";
import Steps from "./Steps";
const position = [43.61947, 7.081601];
const Map = () => {
  const [origin, setOrigin] = useState({
    lat: 43.61947,
    lng: 7.081601,
    addressName: "",
  });
  const [destination, setDestination] = useState({
    lat: 43.61947,
    lng: 7.081601,
    addressName: "",
  });
  const [showOffcanvas, setShowOffcanvas] = useState(true);
  const [cursor, setCursor] = useState({
    type: null,
    isDisabled: true,
  });

  const originIcon = new L.icon({
    iconUrl: originIc,
    iconSize: [45, 48],
  });

  const destinationIcon = L.icon({
    iconUrl: destinationIc,
    iconSize: [45, 48],
  });

  const destinationStationIcon = L.icon({
    iconUrl: destinationStationIc,
    iconSize: [45, 48],
  });

  const originStationIcon = L.icon({
    iconUrl: originStationIc,
    iconSize: [45, 48],
  });

  const stepIcon = L.icon({
    iconUrl: stepIc,
    iconSize: [30, 30],
  });

  const [steps, setSteps] = useState({
    originStation: null,
    destinationStation: null,
    fullRoute: null,
  });

  const [currentStep, setCurrentStep] = useState({
    number: -1,
    step: null,
    nbSteps: 0,
    stepType: 0,
    currentRoute: null,
  });


  function ResetCenterView(props) {
    const { lat, lng } = props;
    const map = useMap();

    useEffect(() => {
      if (lat && lng) {
        const currentZoom = map.getZoom();
        const targetZoom = currentZoom < 10 ? 16 : currentZoom;
        map.setView(L.latLng(lat, lng), targetZoom, {
          animate: true,
        });
      }
    }, [lat, lng, map]);

    return null;
  }

  const updateCurrentStep = (num) => {
    // yeah i know it's ugly but it's 3am and i'm tired
    if (steps.fullRoute !== null) {
      const updateStep = (newStepType, newNumber) => {
        setCurrentStep((prev) => ({
          ...prev,
          number: newNumber,
          step: steps.fullRoute[newStepType].Path.Features[0].Properties
            .Segments[0].Steps[newNumber],
          nbSteps:
            steps.fullRoute[newStepType].Path.Features[0].Properties.Segments[0]
              .Steps.length,
          stepType: newStepType,
          currentRoute: steps.fullRoute[newStepType],
        }));
      };

      if (num === 0) {
        // Change step type
        updateStep(currentStep.stepType + 1, 0);
      } else if (num === -1) {
        if (currentStep.number === 0 && currentStep.stepType !== 0) {
          updateStep(currentStep.stepType - 1, 0);
        } else {
          updateStep(currentStep.stepType, currentStep.number + num);
        }
      } else {
        // num === 1
        if (
          currentStep.number === currentStep.nbSteps - 1 &&
          currentStep.stepType !== steps.fullRoute.length - 1
        ) {
          updateStep(currentStep.stepType + 1, 0);
        } else if (
          currentStep.number === currentStep.nbSteps - 1 &&
          currentStep.stepType === steps.fullRoute.length - 1
        ) {
          console.log("end");
        } else {
          updateStep(currentStep.stepType, currentStep.number + num);
        }
      }
    }
  };

  const isButtonDisabled = () => {
    return origin.addressName === "" || destination.addressName === "";
  };

  const showRoute = () => {
    const {hide} = cogoToast.loading("Getting the itinerary. Please wait...", { position: 'top-center', hideAfter:0 });

    axios
      .get(
        "http://localhost:8090/LetsGoBiking/RoutingService/rest/get_itinerary?OriginLatitude=" +
          origin.lat +
          "&OriginLongitude=" +
          origin.lng +
          "&DestinationLatitude=" +
          destination.lat +
          "&DestinationLongitude=" +
          destination.lng,
        {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
          },
        }
      )
      .then((response) => {
        console.log(response.data);
        console.log(
          "http://localhost:8090/LetsGoBiking/RoutingService/rest/get_itinerary?OriginLatitude=" +
            origin.lat +
            "&OriginLongitude=" +
            origin.lng +
            "&DestinationLatitude=" +
            destination.lat +
            "&DestinationLongitude=" +
            destination.lng
        );
        hide();
        if (response.data.GetItineraryResult.ErrorResult !== null) {
          cogoToast.error(response.data.GetItineraryResult.ErrorResult.Message);
        } else {
          setSteps((prevSteps) => ({
            ...prevSteps,
            fullRoute: response.data.GetItineraryResult.SuccessfullResult
              .FullRoute,
            originStation:
              response.data.GetItineraryResult.SuccessfullResult.StartStation,
            destinationStation:
              response.data.GetItineraryResult.SuccessfullResult.EndStation,
          }));
          setCurrentStep((prev) => ({
            number: 0,
            step:
              response.data.GetItineraryResult.SuccessfullResult.FullRoute[0]
                .Path.Features[0].Properties.Segments[0].Steps[0],
            nbSteps:
              response.data.GetItineraryResult.SuccessfullResult.FullRoute[0]
                .Path.Features[0].Properties.Segments[0].Steps.length,
            stepType: 0,
            currentRoute:
              response.data.GetItineraryResult.SuccessfullResult.FullRoute[0],
          }));
        }
      })
      .catch((error) => {});
  };

  const handleMapClick = (e) => {
    //const { lat, lng } = e.latlng;
    // Save the selected coordinates in your state or variable
    console.log(e.latlng);
  };

  function MapOnClick() {
    useMapEvent("click", (e) => {
      if (cursor.type !== null && cursor.isDisabled === false) {
        if (cursor.type === originIc) {
          setOrigin({
            lat: e.latlng.lat,
            lng: e.latlng.lng,
            addressName: "Your chosen point on the map",
          });
        } else if (cursor.type === destinationIc) {
          setDestination({
            lat: e.latlng.lat,
            lng: e.latlng.lng,
            addressName: "Your chosen point on the map",
          });
        }
        setCursor({
          type: null,
          isDisabled: true,
        });
      }
    });
    return null;
  }

  const clickOn = (type) => {
    return (e) => {
      setCursor({
        type: type,
        isDisabled: false,
      });
    };
  };

  const linkMap = (lat, lng) => {
    return "https://maps.google.com/?q=" + lat + "," + lng;
  };

  const getTotalBikesAvailable = () => {
    return (
      steps.originStation.TotalStands.Availability.Bikes +
      steps.destinationStation.TotalStands.Availability.ElectricalBikes +
      steps.destinationStation.TotalStands.Availability
        .ElectricalInternalBatteryBikes +
      steps.destinationStation.TotalStands.Availability
        .ElectricalRemovableBatteryBikes +
      steps.destinationStation.TotalStands.Availability.MechanicalBikes
    );
  };

  return (
    <>
      <MapContainer
        center={position}
        zoom={15}
        preferCanvas={true}
        onClick={handleMapClick}
      >
        <TileLayer
          attribution='&copy; <a href="https://www.cyclosm.org">OpenStreetMap</a> contributors'
          url="https://{s}.tile-cyclosm.openstreetmap.fr/cyclosm/{z}/{x}/{y}.png"
        />
        {/* //put markers here */}
        {origin.addressName !== "" && (
          <Marker position={[origin.lat, origin.lng]} icon={originIcon}>
            <Popup>
              <img src={originIc} alt="Button Icon" className="h-6 w-6 mr-2" />
              <h6 className="text-blue-900 font-bold">Your starting point</h6>
              <h6 className="text-blue-900">{origin.addressName}</h6>
              <div className="clearfix">
                <p className="mb-0 float-end fw-bold">
                  <a href={linkMap(origin.lat, origin.lng)} target="_blank" rel="noreferrer">
                    See on Google Map
                  </a>
                </p>
              </div>
            </Popup>
          </Marker>
        )}
        {destination.addressName !== "" && (
          <Marker
            position={[destination.lat, destination.lng]}
            icon={destinationIcon}
          >
            <Popup>
              <img
                src={destinationIc}
                alt="Button Icon"
                className="h-6 w-6 mr-2"
              />
              <h6 className="text-blue-900 font-bold">Your destination</h6>
              <h6 className="text-blue-900">{destination.addressName}</h6>
              <div className="clearfix">
                <p className="mb-0 float-end fw-bold">
                  <a
                    href={linkMap(destination.lat, destination.lng)}
                    target="_blank" rel="noreferrer"
                  >
                    See on Google Map
                  </a>
                </p>
              </div>
            </Popup>
          </Marker>
        )}
        {steps.originStation !== null && (
          <Marker
            position={[
              parseFloat(steps.originStation.Position.Latitude),
              parseFloat(steps.originStation.Position.Longitude),
            ]}
            icon={originStationIcon}
          >
            <Popup>
              <img
                src={originStationIc}
                alt="Button Icon"
                className="h-6 w-6 mr-2"
              />
              <h6 className="text-blue-900 font-bold">Your nearest station</h6>
              <h6 className="text-blue-900">
                Available bikes: {getTotalBikesAvailable()}
              </h6>
              <div className="clearfix">
                <p className="mb-0 float-end fw-bold">
                  <a
                    href={linkMap(
                      steps.originStation.Position.Latitude,
                      steps.originStation.Position.Longitude
                    )}
                    target="_blank" rel="noreferrer"
                  >
                    See on Google Map
                  </a>
                </p>
              </div>
            </Popup>
          </Marker>
        )}
        {steps.destinationStation !== null && (
          <Marker
            position={[
              parseFloat(steps.destinationStation.Position.Latitude),
              parseFloat(steps.destinationStation.Position.Longitude),
            ]}
            icon={destinationStationIcon}
          >
            <Popup>
              <img
                src={destinationStationIc}
                alt="Button Icon"
                className="h-6 w-6 mr-2"
              />
              <h6 className="text-blue-900 font-bold">
                Your destination station
              </h6>
              <h6 className="text-blue-900">
                Available stands:{" "}
                {steps.destinationStation.TotalStands.Availability.Stands}
              </h6>
              <div className="clearfix">
                <p className="mb-0 float-end fw-bold">
                  <a
                    href={linkMap(
                      steps.destinationStation.Position.Latitude,
                      steps.destinationStation.Position.Longitude
                    )}
                    target="_blank" rel="noreferrer"
                  >
                    See on Google Map
                  </a>
                </p>
              </div>
            </Popup>
          </Marker>
        )}

        {currentStep.step !== null && steps !== null && (
          <>
            <Marker
              position={[
                parseFloat(
                  steps.fullRoute[currentStep.stepType].Path.Features[0]
                    .Geometry.Coordinates[currentStep.step.WayPoints[1]][1]
                ),
                parseFloat(
                  steps.fullRoute[currentStep.stepType].Path.Features[0]
                    .Geometry.Coordinates[currentStep.step.WayPoints[1]][0]
                ),
              ]}
              icon={stepIcon}
            ></Marker>
            <FeatureGroup>
              <Polyline
                color="purple"
                weight={15}
                opacity={0.7}
                positions={steps.fullRoute[
                  currentStep.stepType
                ].Path.Features[0].Geometry.Coordinates.slice(
                  currentStep.step.WayPoints[0],
                  currentStep.step.WayPoints[1]
                ).map((coord) => [coord[1], coord[0]])}
              />
            </FeatureGroup>

            <ResetCenterView
              lat={
                steps.fullRoute[currentStep.stepType].Path.Features[0].Geometry
                  .Coordinates[currentStep.step.WayPoints[1]][1]
              }
              lng={
                steps.fullRoute[currentStep.stepType].Path.Features[0].Geometry
                  .Coordinates[currentStep.step.WayPoints[1]][0]
              }
            />
          </>
        )}

        {steps.fullRoute !== null && (
          <FeatureGroup>
            <Polyline
              color="blue"
              weight={7}
              opacity={0.8}
              positions={steps.fullRoute[1].Path.Features[0].Geometry.Coordinates.map(
                (coord) => [coord[1], coord[0]]
              )}
            />
            <Polyline
              color="red"
              weight={7}
              opacity={0.8}
              positions={steps.fullRoute[0].Path.Features[0].Geometry.Coordinates.map(
                (coord) => [coord[1], coord[0]]
              )}
            />
            <Polyline
              color="red"
              weight={7}
              opacity={0.8}
              positions={steps.fullRoute[2].Path.Features[0].Geometry.Coordinates.map(
                (coord) => [coord[1], coord[0]]
              )}
            />
          </FeatureGroup>
        )}
        <MapOnClick />

        <OwnLocationMarker />
      </MapContainer>
      {!showOffcanvas && (
        <div
          style={{
            position: "absolute",
            zIndex: 999,
            right: 20,
            bottom: 20,
            boxShadow: "rgba(0, 0, 0, 0.1) 0px 4px 12px",
          }}
        >
          <Button
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              width: 60,
              height: 60,
            }}
            size="lg"
            onClick={() => setShowOffcanvas(true)}
          >
            <FontAwesomeIcon size="lg" icon={faCog} />
          </Button>
        </div>
      )}
      <Offcanvas
        show={showOffcanvas}
        onHide={() => setShowOffcanvas(false)}
        backdrop={false}
        placement={"end"}
        style={{
          height: "100vh",
          border: 0,
          boxShadow: "rgba(0, 0, 0, 0.1) 0px -10px 20px 0px",
          backgroundColor: "black",
          color: "white",
          zIndex: 998,
        }}
      >
        <Offcanvas.Header closeButton className="btn-close-white">
          <Offcanvas.Title className="text-4xl font-bold text-purple-600">
            Let's go biking 🚲
          </Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body
          style={{
            padding: 0,
          }}
        >
          {steps.fullRoute !== null ? (
            <div className="h-[55%] overflow-hidden transition-all duration-700 bg-white">
              <Steps
                currentStep={currentStep}
                setCurrentStep={setCurrentStep}
                updateCurrentStep={updateCurrentStep}
                steps={steps}
              />
              <br />
            </div>
          ) : (
            <img
              className="h-[30%] object-cover transition-all duration-700"
              src="https://cdn.discordapp.com/attachments/932998584733925406/1176456037809790976/logo_long.png?ex=656eef10&is=655c7a10&hm=11605b6b3fcb734e2cf81d194ed99a0374c5050ed8c88e4cf19c0e11a8134447&"
              alt="Biking"
            />
          )}

          <div className="pt-3 pb-1">
            <div className="border-solid border-3 border-blue-500 flex flex-col items-center rounded-lg">
              <div className="flex items-center">
                <FindAdress
                  location={origin}
                  setLocation={setOrigin}
                  changeTxt={"Change your start location"}
                  chooseTxt={"Choose your start location"}
                />
                <span className="mx-4 text-white">or</span>
                <button
                  className="hover:text-white hover:bg-gradient-to-r from-purple-700 to-indigo-800 bg-white text-blue-600 py-2 px-4 rounded inline-flex items-center mr-2"
                  onClick={clickOn(originIc)}
                >
                  <img
                    src="https://cdn-icons-png.flaticon.com/512/9800/9800512.png"
                    alt="Button Icon"
                    className="h-6 w-6 mr-2"
                  />
                  Click on map{" "}
                </button>
              </div>
              <div>
                <span className="font-bold">Start from: </span>
                {origin.addressName}
              </div>
            </div>
          </div>

          <div className="pt-1 pb-1">
            <div className="border-solid border-3 border-blue-500 flex flex-col items-center rounded-lg">
              <div className="flex items-center">
                <FindAdress
                  location={destination}
                  setLocation={setDestination}
                  changeTxt={"Change your destination location"}
                  chooseTxt={"Choose your destination location"}
                />
                <span className="mx-4 text-white">or</span>
                <button
                  className="hover:text-white hover:bg-gradient-to-r from-purple-700 to-indigo-800 bg-white text-blue-600 py-2 px-4 rounded inline-flex items-center mr-2"
                  onClick={clickOn(destinationIc)}
                >
                  <img
                    src="https://cdn-icons-png.flaticon.com/512/2075/2075192.png"
                    alt="Button Icon"
                    className="h-6 w-6 mr-2"
                  />
                  Click on map{" "}
                </button>
              </div>
              <div>
                <span className="font-bold">Destination: </span>
                {destination.addressName}
              </div>
            </div>

            <div className="flex justify-center mt-2">
              <button
                className={`mx-5 w-full text-white text-2xl py-2 rounded-lg font-mono ${
                  isButtonDisabled()
                    ? "bg-gray-300 cursor-not-allowed"
                    : "bg-gradient-to-r from-blue-500 to-green-500 hover:bg-gradient-to-r hover:from-blue-600 hover:to-purple-600 "
                }`}
                disabled={isButtonDisabled()}
                onClick={() => showRoute()}
              >
                🚲 Let's go biking!
              </button>
            </div>
          </div>

          <div
            style={{
              height: 1,
              background: "#eee",
              marginTop: 10,
              marginBottom: 10,
            }}
          />
          <OffcanvasFooter />
        </Offcanvas.Body>
      </Offcanvas>
      <CustomCursor
        component={cursor.type}
        isDisabled={cursor.isDisabled}
        width={40}
        height={40}
        zIndex={999}
      />
    </>
  );
};
export default Map;


// devil's code