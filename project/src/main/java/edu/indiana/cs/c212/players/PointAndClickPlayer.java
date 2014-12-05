package edu.indiana.cs.c212.players;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.util.List;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class PointAndClickPlayer extends AbstractPlayer implements
		AWTEventListener {

	public PointAndClickPlayer(PlayerColor c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
