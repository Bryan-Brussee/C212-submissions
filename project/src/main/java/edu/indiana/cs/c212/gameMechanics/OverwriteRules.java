package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.Player;

public class OverwriteRules extends StandardRules {

	public OverwriteRules(Board board, Player red, Player blue) {
		super(board, red, blue);

	}

	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		for (int x = 0; x < this.board.getSize(); x++) {
			for (int y = 0; y < this.board.getSize(); y++) {

				if (this.board.getTileAt(x, y).getColor() == PlayerColor.BLANK) {
					legalMoves.add(new Move(x, y));
				}
				if (this.board.getTileAt(x, y).getColor() != player.getColor()) {
					legalMoves.add(new OverwriteMove(x, y));
				}
			}
		}
		return legalMoves;

	}

	@Override
	public boolean isLegalMove(Move m) {

		if (m.getX() >= 0 && m.getX() < this.board.getSize() && m.getY() >= 0
				&& m.getY() < this.board.getSize()) {

			if (m.getClass().equals(Move.class)) {
				return super.isLegalMove(m);
			}

			else if (this.board.getTileAt(m.getX(), m.getY()).getColor() == PlayerColor.BLANK) {
				return false;
			}

			else if (this.board.getTileAt(m.getX(), m.getY()).getColor() == getPlayers()
					.peek().getColor()) {
				return false;
			}

			else
				return true;
		}

		return false;
	}

}
