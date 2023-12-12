package com.heavyclient.app;

import com.heavyclient.app.generated.IRoutingService;
import com.heavyclient.app.generated.Result;
import com.heavyclient.app.generated.RoutingService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws JSONException {
        RoutingService server;
        HttpClient client = HttpClient.newHttpClient();

        try {
            server = new RoutingService();
        } catch (Exception e) {
            System.err.println("Cannot connect to server, make sure it is running and that you have an internet connection");
            return;
        }

        var routingService = server.getBasicHttpBindingIRoutingService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the starting point:");
        String startPoint = scanner.nextLine();
        GeoPosition startGeoPosition = handleLocationInput(startPoint, client);

        System.out.println("Enter the destination:");
        String destination = scanner.nextLine();
        GeoPosition destinationGeoPosition = handleLocationInput(destination, client);

        if (startGeoPosition != null && destinationGeoPosition != null) {
            Result res;
            try {
                res = routingService.getItinerary(startGeoPosition.getLatitude(), startGeoPosition.getLongitude(), destinationGeoPosition.getLatitude(), destinationGeoPosition.getLongitude());
            } catch (Exception e) {
                System.err.println("Cannot connect to server, make sure it is running and that you have an internet connection");
                return;
            }

            if (res.getSuccessfullResult() != null && res.getSuccessfullResult().getValue() != null) {
                StepsRunner stepsRunner = new StepsRunner(res);
                stepsRunner.run();
            }
            else {
                System.out.println("Error: " + res.getErrorResult().getValue().getMessage().getValue());
            }
        }
    }

    private static GeoPosition handleLocationInput(String location, HttpClient client) throws JSONException {
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
        HttpRequest locationRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search?format=json&q=" + encodedLocation))
                .build();

        HttpResponse<String> locationResponse;
        try {
            locationResponse = client.send(locationRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.err.println("Cannot connect to OpenStreetMap API");
            return null;
        }

        JSONArray locationOptions = new JSONArray(locationResponse.body());

        // Print the options for the location
        System.out.println("Location options:");
        int optionsCount = Math.min(5, locationOptions.length());
        for (int i = 0; i < optionsCount; i++) {
            JSONObject option = locationOptions.getJSONObject(i);
            System.out.println(i + ": " + option.getString("display_name"));
        }
        System.out.println("Choose the location:");
        int locationChoice = new Scanner(System.in).nextInt();
        JSONObject chosenLocation = locationOptions.getJSONObject(locationChoice);
        double lat = chosenLocation.getDouble("lat");
        double lon = chosenLocation.getDouble("lon");

        return new GeoPosition(lat, lon);
    }
}