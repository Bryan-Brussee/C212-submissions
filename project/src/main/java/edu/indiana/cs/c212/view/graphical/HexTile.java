package edu.indiana.cs.c212.view.graphical;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.awt.Color;
import java.awt.ItemSelectable;
import java.awt.MenuContainer;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import javax.accessibility.Accessible;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class HexTile extends JButton implements ImageObserver, MenuContainer,
		Serializable, Accessible, SwingConstants, ItemSelectable {
	private int x;
	private int y;
	private int radius;
	private Tile tile;
	public Polygon hex;
	protected int b;
	protected int a;

	public HexTile(int x, int y, int radius, Tile tile) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.tile = tile;
		Polygon hexagon = new Polygon();
		int b = (int) (this.radius * Math.cos(Math.PI / 6));
		int a = (int) (this.radius / 2);
		this.b = b;
		this.a = a;
		int xOrigin = (this.x * (2 * b)) + this.radius;
		int yOrigin = (this.y * (2 * this.radius)) + this.radius;
		hexagon.addPoint(xOrigin + b, yOrigin + a);
		hexagon.addPoint(xOrigin, yOrigin + this.radius);
		hexagon.addPoint(xOrigin - b, yOrigin + a);
		hexagon.addPoint(xOrigin - b, yOrigin - a);
		hexagon.addPoint(xOrigin, yOrigin - this.radius);
		hexagon.addPoint(xOrigin + b, yOrigin - a);
		this.hex = hexagon;
	}

	public final int getBoardX() {
		return (int) tile.getPoint().getX();
	}

	public final int getBoardY() {
		return (int) tile.getPoint().getY();
	}

	public void paint(java.awt.Graphics g) {
		// System.out.println("Tile painted!");
		PlayerColor hexcolor = tile.getColor();
		if (hexcolor == PlayerColor.RED) {
			g.setColor(Color.RED);
		} else if (hexcolor == PlayerColor.BLUE) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.WHITE);
		}
		g.fillPolygon(hex);
		g.drawPolygon(hex);
		g.setColor(Color.GRAY);
		g.drawPolygon(hex);
	}

	@Override
	public boolean contains(java.awt.Point p) {
		return hex.contains(p);
	}

	@Override
	public boolean contains(int x, int y) {
		return hex.contains(x, y);
	}

	protected void processMouseEvent(java.awt.event.MouseEvent e) {
		if (e.getID() == MouseEvent.MOUSE_CLICKED
				&& hex.contains(e.getX(), e.getY())) {
			super.processMouseEvent(e);
		}
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
