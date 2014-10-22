package edu.indiana.cs.c212.paint.gui.drawable.impl;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

import edu.indiana.cs.c212.paint.gui.drawable.DrawableShape;

public class DrawableCircle extends DrawableShape {
	private Ellipse2D circle;
	private double radius;
	private Point2D center;
	private double diameter;
	
	public DrawableCircle(Point2D center, float radius) {
			Point2D upperLeft = new Point2D.Double(center.getX() - radius, center.getY() - radius);
			Point2D lowerRight  = new Point2D.Double(center.getX() + radius, center.getY() + radius);
			resetBounds(upperLeft, lowerRight);
		
			
			
	}
	
	public DrawableCircle(Point2D center, Point2D onCircumference) {
		radius = center.distance(onCircumference);
		Point2D upperLeft = new Point2D.Double(center.getX() - radius, center.getY() - radius);
		Point2D lowerRight  = new Point2D.Double(center.getX() + radius, center.getY() + radius);
		resetBounds(upperLeft, lowerRight);	
	}
	
	 public final void resetBounds(Point2D center, Point2D onCircumference) {
	
	        radius = center.distance(onCircumference);
	        diameter = 2 * center.distance(onCircumference);
	        
	        
	        Point2D upperLeft = new Point2D.Double(center.getX() - radius, center.getY() - radius);
	        Point2D lowerRight  = new Point2D.Double(center.getX() + radius, center.getY() + radius);
			
	        
	        super.resetBounds(upperLeft, lowerRight);
	        circle = new Ellipse2D.Double(upperLeft.getX(), upperLeft.getY(), diameter, diameter);


	    }
	

	@Override
	public void draw(Graphics2D tablet) {
		tablet = setOpacity(tablet);
        tablet.setStroke(getStroke());
        tablet.setColor(getFillColor());
        tablet.fill(this.circle);
        tablet.setColor(getPenColor());
        tablet.draw(this.circle);
		

	}
	
    public String toString() {
        return super.toString() +  "radius= " + radius + "\n" + "diamater= " + diameter
                + "\n" + "center= " + center;
    }

}
