import React, { useEffect } from "react";
import { MapContainer, Marker, Popup, TileLayer, useMap } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from "leaflet";
import OwnLocationMarker from "../OwnLocationMarker";

const icon = L.icon({
  iconUrl: "https://cdn-icons-png.flaticon.com/512/9800/9800512.png",
  iconSize: [35, 38],
});

const position = [43.61947, 7.081601];

function ResetCenterView(props) {
  const { selectPosition } = props;
  const map = useMap();

  useEffect(() => {
    if (selectPosition) {
      map.setView(
        L.latLng(selectPosition?.lat, selectPosition?.lon),
        map.getZoom(),
        {
          animate: true
        }
      )
    }
  }, [selectPosition]);

  return null;
}

export default function Maps(props) {
  const { selectPosition } = props;
  const locationSelection = [selectPosition?.lat, selectPosition?.lon];

  return (
    <MapContainer
      center={position}
      zoom={8}
      style={{ width: "100%", height: "100%" }}
    >
      <TileLayer
        attribution='&copy;'
        url="https://{s}.tile-cyclosm.openstreetmap.fr/cyclosm/{z}/{x}/{y}.png?key=LEwqj633W8lJloJ9ek4z"
      />
      {selectPosition && (
        <Marker position={locationSelection} icon={icon}>
        </Marker>
      )}
      <OwnLocationMarker />

      <ResetCenterView selectPosition={selectPosition} />
    </MapContainer>
  );
}