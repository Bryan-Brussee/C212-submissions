package edu.indiana.cs.c212.board;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class SimpleGameBoard extends AbstractGameBoard implements Board {
	private Tile[][] board;
	private Tile east;
	private Tile west;
	private Tile north;
	private Tile south;

	public SimpleGameBoard(int size){
		this.size = size;

		this.east = new Tile(PlayerColor.BLUE, new Point(size,0));
		this.west = new Tile(PlayerColor.BLUE, new Point(-1,0));
		this.south = new Tile(PlayerColor.RED, new Point(0,size));
		this.north = new Tile(PlayerColor.RED, new Point(0,-1));

		this.board =  new Tile[this.size][this.size];
		for (int x= 0; x < this.size; x++) {
			for (int y = 0; y < this.size; y++) {
				board[x][y] = new Tile(PlayerColor.BLANK, new Point(x,y));
			}
		}

	}

	public SimpleGameBoard(SimpleGameBoard other){
		this.size = other.getSize();



		this.east = new Tile(PlayerColor.BLUE, new Point(size,0));
		this.west = new Tile(PlayerColor.BLUE, new Point(-1,0));
		this.south = new Tile(PlayerColor.RED, new Point(0,size));
		this.north = new Tile(PlayerColor.RED, new Point(0,-1));
		this.board = new Tile[this.size][this.size];
		for (int x= 0; x < this.size; x++) {
			for (int y = 0; y < this.size; y++) {
				board[x][y] = new Tile(PlayerColor.BLANK, new Point(x,y));
			}
		}
	}


	@Override
	public Tile getTileAt(int x, int y) {

		if (x < -1 || y < -1 || x > this.size || y > this.size){
			return null;
		}

		if (x == -1){
			return this.west;
		}
		if (x == this.size){
			return this.east;
		}
		if (y == -1){
			return this.north;
		}
		if (y == this.size ){
			return this.south;
		}
		else
		return this.board[x][y];
	}

	@Override
	public Set<Tile> getNeighbors(Tile t) {

		Set<Tile> neighbors = new HashSet<Tile>();
		if (t.equals(west)){
			for(int y = 0; y < this.size; y++){
				neighbors.add(getTileAt(0,y));
			}
			return neighbors;
		}
		if (t.equals(east)){
			for(int y = 0; y < this.size; y++){
				neighbors.add(getTileAt((this.size - 1),y));
			}
			return neighbors;
		}

		if (t.equals(north)){
			for(int x = 0; x < this.size; x++){
				neighbors.add(getTileAt(x,0));
			}
			return neighbors;
		}

		if (t.equals(south)){
			for(int x = 0; x < this.size; x++){
				neighbors.add(getTileAt(x,(this.size - 1)));
			}
			return neighbors;
		}
		neighbors.add(getTileAt((((int)t.getPoint().getX()) - 1), ((int)t.getPoint().getY())));
		neighbors.add(getTileAt((((int)t.getPoint().getX()) - 1), (((int)t.getPoint().getY()) + 1)));
		neighbors.add(getTileAt(((int)t.getPoint().getX()), (((int)t.getPoint().getY()) + 1)));
		neighbors.add(getTileAt(((int)t.getPoint().getX()), (((int)t.getPoint().getY()) - 1)));
		neighbors.add(getTileAt((((int)t.getPoint().getX()) + 1), (((int)t.getPoint().getY()))));
		neighbors.add(getTileAt((((int)t.getPoint().getX()) + 1), (((int)t.getPoint().getY()) - 1)));
		return neighbors;

	}

	@Override
	public void makeMove(Move m, PlayerColor player) {
		// TODO Auto-generated method stub
		int mX = m.getX();
		int mY = m.getY();
		if (getTileAt(mX, mY).getColor().equals(PlayerColor.BLANK)){
			this.board[mX][mY].setColor(player);
		}
	}
	
	

}