package edu.indiana.cs.c212.paint.gui.drawable.impl;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import edu.indiana.cs.c212.paint.gui.drawable.DrawableShape;

public class DrawableLine extends DrawableShape {
	private Line2D line;
	private double length;
	
    public DrawableLine(Point2D from, Point2D to) {
        resetBounds(from, to);
    }
    
    public final void resetBounds(Point2D from, Point2D to) {
        super.resetBounds(from, to);
        line = new Line2D.Double(from, to);

    }

    public void draw(Graphics2D tablet) {
        tablet = setOpacity(tablet);
        tablet.setStroke(getStroke());
        tablet.setColor(getPenColor());
        tablet.draw(line);
    }
    
    public String toString() {
        return super.toString() + "length = " + length;
    }
}
