package edu.indiana.cs.c212.board;

import java.awt.Point;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class Tile {
	private Point point;
	private PlayerColor color;
	
	
	Tile (PlayerColor color, Point p) {
		super();
		this.color = color;
		this.point = p;
	}
	
	Tile(Tile tile) {
		super();
		
		this.color = tile.getColor();
		this.point = new Point(tile.getPoint());
				}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (color != other.color)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	public Point getPoint() {
		return point;
	}

	public PlayerColor getColor() {
		return color;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return this.point + " " + this.color;
	}

	
	

	
	
}

