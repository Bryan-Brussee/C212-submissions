package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.Player;

import java.util.LinkedList;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class StandardRules implements Rules {
	protected final Board board;
	private Queue<Player> players;

	StandardRules(Board board, Player red, Player blue) {
		this.board = board;
		players = new LinkedList<Player>();
		players.add(red);
		players.add(blue);

	}

	public static boolean areTilesConnected(Board board, Tile start, Tile goal,
			PlayerColor color) {
		Queue<Tile> Q = new LinkedList<Tile>();
		Set<Tile> V = new HashSet<Tile>();
		V.add(start);
		Q.add(start);
		while (!Q.isEmpty()) {
			Tile t = Q.poll();
			if (t.equals(goal)) {
				return true;
			}
			for (Tile neighbor : board.getNeighbors(t)) {
				if (!V.contains(neighbor) && neighbor.getColor().equals(color)) {
					V.add(neighbor);
					Q.add(neighbor);
				}
			}
		}
		return false;
	}

	@Override
	public Queue<Player> getPlayers() {
		return players;
	}

	@Override
	public PlayerColor checkForWins() {

		if (areTilesConnected(board, board.getTileAt(-1, 0),
				board.getTileAt(board.getSize(), 0), PlayerColor.BLUE)) {
			return PlayerColor.BLUE;
		}
		if (areTilesConnected(board, board.getTileAt(0, -1),
				board.getTileAt(0, board.getSize()), PlayerColor.RED)) {

			return PlayerColor.RED;
		}

		return null;
	}

	@Override
	public boolean isLegalMove(Move m) {
		if (m.getX() >= 0 && m.getX() < this.board.getSize() && m.getY() >= 0
				&& m.getY() < this.board.getSize()) {
			if (this.board.getTileAt(m.getX(), m.getY()).getColor()
					.equals(PlayerColor.BLANK)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Player nextTurn() {
		Player a = players.peek();
		players.remove();
		players.add(a);
		return players.peek();
	}

	@Override
	public Player getNextPlayer() {
		Player[] p = players.toArray(new Player[players.size()]);
		return p[1];

	}

	@Override
	public void makeMove(Move m) throws InvalidMoveException {
		if (m.getX() <= -1 || m.getY() <= -1
				|| m.getX() >= this.board.getSize()
				|| m.getY() >= this.board.getSize()) {
			throw new InvalidMoveException("OUTSIDE_BOARD", m, -1);
		}
		if (!isLegalMove(m)) {
			throw new InvalidMoveException("ALREADY_TAKEN", m, -1);
		}
		if (getPlayers().peek().getColor() == PlayerColor.RED) {
			this.board.makeMove(m, PlayerColor.RED);
		} else {
			this.board.makeMove(m, PlayerColor.BLUE);
		}
	}

	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		for (int x = 0; x < this.board.getSize(); x++) {
			for (int y = 0; x < this.board.getSize(); y++) {
				if (this.board.getTileAt(x, y).getColor() == PlayerColor.BLANK) {
					legalMoves.add(new Move(x, y));
				}
			}
		}
		return legalMoves;
	}

}
