package com.heavyclient.app;
import com.heavyclient.app.generated.*;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class StepsRunner {
    Result result;
    JXMapViewer mapViewer;
    JTextArea stepsTextArea;
    JButton nextButton;
    JButton prevButton;
    List<Step> steps;
    int currentStepIndex = 0;
    Step currentStep;
    int currentRoutePartIndex = 0;
    WaypointPainter<DefaultWaypoint> waypointPainter = new WaypointPainter<>();
    Set<DefaultWaypoint> waypoints = new HashSet<>();
    List<RoutePainter> painters = new ArrayList<>();
    List<RoutePainter> currentPainters = new ArrayList<>();

    public StepsRunner(Result result) {
        this.result = result;

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
        stepsTextArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        stepsTextArea.setEditable(false);

        JScrollPane stepsScrollPane = new JScrollPane(stepsTextArea);

        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");
        prevButton.setEnabled(false);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStepIndex++;
                updateStep();
            }
        });
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStepIndex--;
                updateStep();
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

    public void run() {
        var fullRoute = result.getSuccessfullResult().getValue().getFullRoute().getValue();
        var routeParts = fullRoute.getRoutePart();

        steps = routeParts.get(0).getPath().getValue().getFeatures().getValue().getFeature().get(0).getProperties().getValue().getSegments().getValue().getSegment().get(0).getSteps().getValue().getStep();

        currentStep = steps.get(0);

        for (RoutePart routePart : result.getSuccessfullResult().getValue().getFullRoute().getValue().getRoutePart()) {
            List<GeoPosition> track = new ArrayList<>();
            for(ArrayOfdouble a : routePart.getPath().getValue().getFeatures().getValue().getFeature().get(0).getGeometry().getValue().getCoordinates().getValue().getArrayOfdouble()) {
                double lat = a.getDouble().get(1);
                double lon = a.getDouble().get(0);
                track.add(new GeoPosition(lat, lon));
            }

            Color color = (routePart.getWayOfTransport().value().equals("WALK")) ? Color.RED : Color.BLUE;
            RoutePainter routePainter = new RoutePainter(track, color);
            painters.add(routePainter);
        }

        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
        mapViewer.setOverlayPainter(painter);
        updateStep();

    }

    private void updateStep() {
        // Clear the text area
        stepsTextArea.setText("");
        painters.removeAll(currentPainters);
        currentPainters.clear();
        if (currentStepIndex >= steps.size()) {
            currentRoutePartIndex++;

            if (currentRoutePartIndex < result.getSuccessfullResult().getValue().getFullRoute().getValue().getRoutePart().size()) {
                steps = result.getSuccessfullResult().getValue().getFullRoute().getValue().getRoutePart().get(currentRoutePartIndex).getPath().getValue().getFeatures().getValue().getFeature().get(0).getProperties().getValue().getSegments().getValue().getSegment().get(0).getSteps().getValue().getStep();

                currentStepIndex = 0;
            }
        }

        Step step = steps.get(currentStepIndex);

        String duration = formatDuration(step.getDuration().intValue());
        String distance = formatDistance(step.getDistance().intValue());
        String[] titles = {
                "Going from starting point to nearest station",
                "Going from nearest station to destination station",
                "Going from destination station to destination"
        };
        Color c = (currentRoutePartIndex == 1) ? Color.RED : Color.BLUE;
        stepsTextArea.setForeground(c);

        stepsTextArea.append("--- " + titles[currentRoutePartIndex] + " ---\n");

        stepsTextArea.append("Step " + (currentStepIndex + 1) + ": " + step.getInstruction().getValue() + "\n\t Duration: " + duration + "\n\t Distance: " + distance + "\n");

        var fullRoute = result.getSuccessfullResult().getValue().getFullRoute().getValue();
        var routeParts = fullRoute.getRoutePart();
        var path = routeParts.get(currentRoutePartIndex).getPath().getValue();
        var features = path.getFeatures().getValue().getFeature();
        var coordinates = features.get(0).getGeometry().getValue().getCoordinates().getValue();
        double lat = coordinates.getArrayOfdouble().get(features.get(0).getProperties().getValue().getSegments().getValue().getSegment().get(0).getSteps().getValue().getStep().get(currentStepIndex).getWayPoints().getValue().getInt().get(1)).getDouble().get(1);
        double lon = coordinates.getArrayOfdouble().get(features.get(0).getProperties().getValue().getSegments().getValue().getSegment().get(0).getSteps().getValue().getStep().get(currentStepIndex).getWayPoints().getValue().getInt().get(1)).getDouble().get(0);
        mapViewer.setAddressLocation(new GeoPosition(lat, lon));
        mapViewer.setZoom(25);

        // Create a RoutePainter for the current step
        List<GeoPosition> track = new ArrayList<>();
        for(int i= step.getWayPoints().getValue().getInt().get(0); i < step.getWayPoints().getValue().getInt().get(1); i++) {
            double waypointLat = coordinates.getArrayOfdouble().get(i).getDouble().get(1);
            double waypointLon = coordinates.getArrayOfdouble().get(i).getDouble().get(0);
            track.add(new GeoPosition(waypointLat, waypointLon));
        }
        currentPainters.add(new RoutePainter(track, Color.MAGENTA));

        painters.addAll(currentPainters);
        CompoundPainter<JXMapViewer> painter = new CompoundPainter<>(painters);
        mapViewer.setOverlayPainter(painter);



        prevButton.setEnabled(currentStepIndex > 0);
        nextButton.setEnabled(currentStepIndex < steps.size() - 1 || currentRoutePartIndex < result.getSuccessfullResult().getValue().getFullRoute().getValue().getRoutePart().size() - 1);
    }


    private String formatDuration(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        if (hours > 0) {
            return hours + " hours " + minutes + " minutes " + seconds + " seconds";
        } else if (minutes > 0) {
            return minutes + " minutes " + seconds + " seconds";
        } else {
            return seconds + " seconds";
        }
    }

    private String formatDistance(double totalMeters) {
        if (totalMeters >= 1000) {
            double kilometers = totalMeters / 1000;
            if (kilometers >= 1.0) {
                return String.format("%.2f km", kilometers);
            } else {
                return String.format("%.0f meters", totalMeters);
            }
        } else {
            return String.format("%.0f meters", totalMeters);
        }
    }
}
