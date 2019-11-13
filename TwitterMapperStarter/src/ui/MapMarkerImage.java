package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static ui.MapMarkerSimple.defaultMarkerSize;

public class MapMarkerImage extends MapMarkerCircle {
    public Color color;
    public BufferedImage image;
    private Status status;
    private String imageUrl;
    private String tweet;




    public Status getStatus() {
        return status;
    }


    public MapMarkerImage(Layer layer, Coordinate coord, Color color, Status status, BufferedImage image) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        this.color = color;
        setColor(color.BLACK);
        setBackColor(color);
        this.status = status;
        this.image = image;
        paint(image.getGraphics(),  new Point(new Integer((int) coord.getLat()), new Integer((int) coord.getLon())), 12);

        }


        @Override
    public void paint(Graphics g, Point position, int radius) {
        g.setColor(color);
        int x = (int) position.getX();
        int y = (int) position.getY();
        g.fillOval(x-4, y-4, 24, 24);
        g.drawImage(image, x, y, 16, 16, null);
        this.paintText(g, position);
    }



}

