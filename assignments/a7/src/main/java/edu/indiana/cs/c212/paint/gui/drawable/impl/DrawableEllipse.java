package edu.indiana.cs.c212.paint.gui.drawable.impl;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;

import edu.indiana.cs.c212.paint.gui.drawable.DrawableShape;

public class DrawableEllipse extends DrawableShape {
		private Ellipse2D ellipse;
		private double width, height;
		
		
		public DrawableEllipse(Point2D from, Point2D to) {
			resetBounds(from,to);
		}

		
	    public final void resetBounds(Point2D from, Point2D to) {
	        super.resetBounds(from, to);
	        
	        double x = getUpperLeft().getX();
	        double y = getUpperLeft().getY();
	        width = getLowerRight().getX() - getUpperLeft().getX();
	        height = getLowerRight().getY() - getUpperLeft().getY();

	        ellipse = new Ellipse2D.Double(x, y, width, height);

	    }
		
		public void draw(Graphics2D tablet) {
			tablet = setOpacity(tablet);
	        tablet.setStroke(getStroke());
	        tablet.setColor(getFillColor());
	        tablet.fill(ellipse);
	        tablet.setColor(getPenColor());
	        tablet.draw(ellipse);
			
		}


	    public String toString() {
	        return super.toString() + "width = " + width + "\n" + "height = "
	                + height + "\n";
	    }


}
