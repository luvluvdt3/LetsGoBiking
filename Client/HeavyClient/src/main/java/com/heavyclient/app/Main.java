package com.heavyclient.app;

import com.heavyclient.app.activemq.ActiveMqClient;
import com.heavyclient.app.generated.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class Main {
    static RoutingService server;
    static HttpClient client = HttpClient.newHttpClient();
    static String stepQueueId;
    static JXMapViewer mapViewer;
    static JTextArea stepsTextArea;
    static JButton nextButton;
    static JButton prevButton;
    static HashMap<Integer, List<Step>> steps = new HashMap<>();
    static int currentRoutePartIndex = 0;
    static int currentStep=1;
    static WaypointPainter<DefaultWaypoint> waypointPainter = new WaypointPainter<>();
    static Set<DefaultWaypoint> waypoints = new HashSet<>();
    static GeoPosition startGeoPosition;
    static GeoPosition destinationGeoPosition;
    public static void main(String[] args) throws JSONException {
        try {
            server = new RoutingService();
        } catch (Exception e) {
            System.err.println("Cannot connect to server, make sure it is running and that you have an internet connection");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the starting point:");
        String startPoint = scanner.nextLine();
        startGeoPosition = handleLocationInput(startPoint, client);

        System.out.println("Enter the destination:");
        String destination = scanner.nextLine();
        destinationGeoPosition = handleLocationInput(destination, client);

        if (startGeoPosition != null && destinationGeoPosition != null) {
            updateSteps();
            setupMap();
            updateStep();
        }
    }

    private static void updateSteps(){
        PartialRoutingResult res;
        var routingService = server.getBasicHttpBindingIRoutingService();
        try {
            res = routingService.getPartialRoute(startGeoPosition.getLatitude(), startGeoPosition.getLongitude(), destinationGeoPosition.getLatitude(), destinationGeoPosition.getLongitude(),stepQueueId, currentRoutePartIndex);

            if (res.getPartialRoutingSuccessfulResult().getValue().getGuiId() == null) {
                System.err.println("Error: " + res.getErrorResult().getValue().getMessage().getValue());
                return;
            }
            
            stepQueueId = res.getPartialRoutingSuccessfulResult().getValue().getGuiId().getValue();

            JSONObject instance = new JSONObject(ActiveMqClient.INSTANCE.getNextQueueMessage(stepQueueId));
            JSONArray features = instance.getJSONObject("Path").getJSONArray("Features");
            JSONArray segments = features.getJSONObject(0).getJSONObject("Properties").getJSONArray("Segments");
            JSONArray segmentSteps = segments.getJSONObject(0).getJSONArray("Steps");

            List<Step> stepList = new ArrayList<>();
            for (int i = 0; i < segmentSteps.length(); i++) {
                JSONObject jsonStep = segmentSteps.getJSONObject(i);
                // Create a new Step object
                Step step = new Step();
                step.setDistance(jsonStep.getDouble("Distance"));
                step.setDuration(jsonStep.getDouble("Duration"));
                step.setType(jsonStep.getInt("Type"));
                step.setInstruction(new JAXBElement<>(new QName("Instruction"), String.class, jsonStep.getString("Instruction")));
                step.setName(new JAXBElement<>(new QName("Name"), String.class, jsonStep.getString("Name")));

                // Handle WayPoints
                JSONArray jsonWayPoints = jsonStep.getJSONArray("WayPoints");
                ArrayOfint wayPoints = new ArrayOfint();
                for (int k = 0; k < jsonWayPoints.length(); k++) {
                    wayPoints.getInt().add(jsonWayPoints.getInt(k));
                }
                step.setWayPoints(new JAXBElement<>(new QName("WayPoints"), ArrayOfint.class, wayPoints));

                // Add the Step object to the list
                stepList.add(step);
            }
            steps.put(currentRoutePartIndex, stepList);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }
    private static void setupMap(){
        mapViewer = new JXMapViewer();

        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);
        MouseInputListener mia = new PanMouseInputListener(mapViewer);
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.setOverlayPainter(waypointPainter);

        stepsTextArea = new JTextArea(20, 30);
        stepsTextArea.setEditable(false);

        JScrollPane stepsScrollPane = new JScrollPane(stepsTextArea);

        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");
        prevButton.setEnabled(false);


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep < steps.get(currentRoutePartIndex).size()) {
                    currentStep++;
                    updateStep();
                } else if (currentRoutePartIndex < 2) {
                    currentRoutePartIndex++;
                    currentStep = 1;
                    updateSteps();
                    updateStep();
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep > 1) {
                    currentStep--;
                    updateStep();
                }
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mapViewer, stepsScrollPane);
        splitPane.setResizeWeight(0.7);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Map Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void updateStep() {
        Step step = steps.get(currentRoutePartIndex).get(currentStep - 1);
        switch(currentRoutePartIndex){
            case 0:
                stepsTextArea.setText("-----Going from starting point to nearest station-----\n");
                stepsTextArea.setFont(new Font("Monospaced", Font.BOLD, 15));
                stepsTextArea.setForeground(Color.RED);
                break;
            case 1:
                stepsTextArea.setText("-----Going from nearest station to destination station-----\n");
                stepsTextArea.setFont(new Font("Monospaced", Font.BOLD, 15));
                stepsTextArea.setForeground(Color.BLUE);
                break;
            case 2:
                stepsTextArea.setText("-----Going from destination station to destination-----\n");
                stepsTextArea.setFont(new Font("Monospaced", Font.BOLD, 15));
                stepsTextArea.setForeground(Color.RED);
                break;
        }
        stepsTextArea.append("Step " + currentStep + " : " + step.getInstruction().getValue());
        
        prevButton.setEnabled(currentStep > 1);
        nextButton.setEnabled(currentStep < steps.get(currentRoutePartIndex).size() || currentRoutePartIndex < 2);
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
        int locationChoice = -1;
        JSONObject chosenLocation = null;
        while (chosenLocation == null) {
            System.out.println("Choose the location:");
            try {
                Scanner scanner = new Scanner(System.in);
                locationChoice = scanner.nextInt();
                chosenLocation = locationOptions.getJSONObject(locationChoice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (JSONException e) {
                System.out.println("Invalid choice. Please choose a number from the list.");
            }
        }
        double lat = chosenLocation.getDouble("lat");
        double lon = chosenLocation.getDouble("lon");

        return new GeoPosition(lat, lon);
    }
}