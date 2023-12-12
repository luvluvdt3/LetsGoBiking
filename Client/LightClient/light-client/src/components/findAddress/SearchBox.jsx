import React, { useState } from "react";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import Button from "@material-ui/core/Button";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import cogoToast from 'cogo-toast';
// import { usePosition } from 'use-position';

const NOMINATIM_BASE_URL = "https://nominatim.openstreetmap.org/search?";
const params = {
    q: "",
    format: "json",
    addressdetails: "addressdetails",
};
const text = {
    backgroundColor: "white"
}

export default function SearchBox(props) {
    const { selectPosition, setSelectPosition, location, setLocation, setFindOrFound, setShow } = props;
    const [searchText, setSearchText] = useState("");
    const [listPlace, setListPlace] = useState([]);
    return (
        <div style={{ display: "flex", flexDirection: "column" }}>

        <Button
            color="primary"
            variant="contained"
            onClick={() => {
                const {hide} = cogoToast.loading("Getting your location. Please wait...", { position: 'top-center', hideAfter:0 });
                navigator.geolocation.getCurrentPosition(
                    (position) => {
                        clearTimeout(500);
                        props.setLocation({
                            ...props.location,
                            lat: position.coords.latitude,
                            lng: position.coords.longitude,
                            addressName: "Your Current Location"
                        });
                        setSelectPosition({
                            "lat": position.coords.latitude,
                            "lon": position.coords.longitude
                        });
                        setFindOrFound(true);
                        hide();
                        cogoToast.success("Your Location Is Saved", { position: 'top-center' });
                        setTimeout(() => {
                            props.setShow(false);
                        }, 1000);                    },
                    (error) => {
                        clearTimeout(500);
                        hide()
                        if (error.code === error.PERMISSION_DENIED) {
                            cogoToast.error("Error in retrieving your location. Please provide us the permission");
                        } else {
                            cogoToast.error("Error in retrieving your location");
                        }
                    }
                );
            }}
        >
            Use Your Location
        </Button>
            <hr />
            <div className="center">Or search for an adress :</div><br />
            <div style={{ display: "flex" }}>
                <div style={{ flex: 1 }}>
                    <OutlinedInput
                        style={{ width: "100%" }}
                        value={searchText}
                        onChange={(event) => {
                            setSearchText(event.target.value);
                        }}
                    />
                </div>
                <div
                    style={{ display: "flex", alignItems: "center", padding: "0px 20px" }}
                >
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={(e) => {
                            // Search
                            const params = {
                                q: searchText,
                                format: "json",
                                addressdetails: 1,
                                polygon_geojson: 0,
                            };
                            const queryString = new URLSearchParams(params).toString();
                            const requestOptions = {
                                method: "GET",
                                redirect: "follow",
                            };
                            fetch(`${NOMINATIM_BASE_URL}${queryString}`, requestOptions)
                                .then((response) => response.text())
                                .then((result) => {
                                    setListPlace(JSON.parse(result));
                                })
                                .catch((err) => console.log("err: ", err));
                        }}
                    >
                        Search
                    </Button>
                </div>
            </div>
            <div className="bg-white">
                <List component="nav" aria-label="main mailbox folders">
                    {listPlace.map((item) => {
                        return (
                            <div key={item?.place_id}>
                                <ListItem
                                    button
                                    onClick={() => {
                                        props.setLocation({
                                            ...props.location,
                                            lat: item?.lat,
                                            lng: item?.lon,
                                            addressName: item?.display_name
                                        })
                                        setFindOrFound(true)
                                        setSelectPosition(
                                            {
                                                "lat": item?.lat,
                                                "lon": item?.lon
                                            }
                                        )
                                        cogoToast.success("Your Location Is Saved", { position: 'top-center' });
                                        setTimeout(() => {
                                            props.setShow(false);
                                        }, 1000);
                                    }}
                                >
                                    <ListItemIcon primaryTypographyProps={{ style: text }} >
                                        <img
                                            src="https://img.freepik.com/free-vector/pin-symbol-indicates-location-gps-map_68708-398.jpg?w=2000"
                                            alt="Placeholder"
                                            style={{ width: 38, height: 38 }}
                                        />
                                    </ListItemIcon>
                                    <ListItemText primaryTypographyProps={{ style: text }} primary={item?.display_name} />
                                </ListItem>
                                <Divider />
                            </div>
                        );
                    })}
                </List>
            </div>
        </div>
    );
}