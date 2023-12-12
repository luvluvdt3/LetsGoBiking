package com.heavyclient.app;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.GeoPosition;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

public class RoutePainter implements Painter<JXMapViewer> {
    private final List<GeoPosition> track;

    private final Color color;

    public RoutePainter(List<GeoPosition> track, Color color) {
        this.track = track;
        this.color = color;
    }

    @Override
    public void paint(Graphics2D g, JXMapViewer map, int w, int h) {
        g = (Graphics2D) g.create();
        Rectangle rect = map.getViewportBounds();
        g.translate(-rect.x, -rect.y);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.setStroke(new BasicStroke(4));

        Point2D prevPoint = null;
        for (GeoPosition gp : track) {
            Point2D point = map.getTileFactory().geoToPixel(gp, map.getZoom());
            if (prevPoint != null) {
                g.draw(new Line2D.Double(prevPoint, point));
            }
            prevPoint = point;
        }

        g.dispose();
    }
}