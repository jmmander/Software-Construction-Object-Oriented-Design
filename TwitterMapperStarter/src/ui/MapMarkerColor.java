package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;


import java.awt.*;
import static ui.MapMarkerSimple.defaultMarkerSize;

public class MapMarkerColor extends MapMarkerCircle {
    public Color color;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public MapMarkerColor(Layer layer, Coordinate coord, Color color, Status status) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        this.color = color;
        setColor(color.BLACK);
        setBackColor(color);
        this.status = status;

    }


}
