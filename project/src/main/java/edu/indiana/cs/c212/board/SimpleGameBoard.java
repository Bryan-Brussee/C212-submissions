package edu.indiana.cs.c212.board;

import java.awt.Point;
import java.util.Set;

import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class SimpleGameBoard extends AbstractGameBoard implements Board {
	protected Tile[][] board;
	private Tile east;
	private Tile west;
	private Tile north;
	private Tile south;
	
	
	
	SimpleGameBoard(int size) {
		this.east = new Tile(PlayerColor.BLUE, new Point(size, 0));
		this.west
		this.north
		this.south
		this.size = size;
		board = new Tile[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				board[x][y] = new Tile(PlayerColor.BLANK, new Point(x, y));
			}
		}
	}
	
	SimpleGameBoard(SimpleGameBoard other) {
		int n = other.getSize();
		this.board = new Tile[n][n];
	}

	@Override
	public Tile getTileAt(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tile> getNeighbors(Tile t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeMove(Move m, PlayerColor player) {
		// TODO Auto-generated method stub

	}

}
