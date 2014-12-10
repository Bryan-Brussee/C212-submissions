package edu.indiana.cs.c212.view.graphical;

import java.awt.Color;
import java.awt.Polygon;

import javax.swing.JButton;

import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class HexTile extends JButton {
	private int x;
	private int y;
	private int radius;
	private Tile tile;
	private Polygon hex;

	public HexTile(int x, int y, int radius, Tile tile) {
		this.x = x;
		this.y = y;
		this.radius = 100;
		this.tile = tile;

		int[] xArray = new int[6];
		int[] yArray = new int[6];

		for (int i = 0; i < xArray.length; i++) {
			for (double a = Math.PI/6; a < 2* Math.PI; a += Math.PI/3) {
				xArray[i] = radius + (int) (this.radius * Math.cos(a));
				yArray[i] = radius + (int) (this.radius * Math.sin(a));

			}
		}

		hex = new Polygon(xArray, yArray, 6);

	}

	public final int getBoardX() {
		return this.x;
	}

	public final int getBoardY() {
		return this.y;
	}

	public void paint(java.awt.Graphics g) {
		System.out.println("Tile painted!");
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

	}

	public void setRadius(int radius) {
		this.radius = radius;

	}

}