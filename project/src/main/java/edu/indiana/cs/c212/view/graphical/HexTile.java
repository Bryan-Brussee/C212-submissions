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
	private Polygon hexTile;



public HexTile(int x, int y, int radius, Tile tile) {
	this.x = x;
	this.y = y;
	this.radius = radius;
	this.tile = tile;
	
	int[] xarray = new int[6];
	int[] yarray = new int[6];

	for (int i = 0; i < xarray.length; i++) {
		for (int a = 30; a < 360; a += 60) {
			xarray[i] = (int) (this.radius * Math.cos(a));
		}
	}
	
	for (int i = 0; i < yarray.length; i++) {
		for (int a = 30; a < 360; a += 60) {
			yarray[i] = (int) (this.radius * Math.sin(a));
		}
	}

	this.hexTile = new Polygon(xarray, yarray, 6);
	
}

public final int getBoardX() {
	return this.x;	
}

public final int getBoardY() {
	return this.y;
}


public void paint(java.awt.Graphics g) {

	PlayerColor hexcolor = tile.getColor();
	
	if (hexcolor == PlayerColor.RED) {
		g.setColor(Color.RED);
	} else if (hexcolor ==PlayerColor.BLUE) {
		g.setColor(Color.BLUE);
	} else {
		g.setColor(Color.WHITE);
	}
	
	g.drawPolygon(hexTile);
}

@Override
public boolean contains(java.awt.Point p) {
	
	return hexTile.contains(p);
	
}

@Override
public boolean contains(int x, int y) {
	
	return hexTile.contains(x,y);
	
}

protected void processMouseEvent(java.awt.event.MouseEvent e) {
	
}

public void setRadius(int radius) {
	this.radius = radius;
	
	
}


}