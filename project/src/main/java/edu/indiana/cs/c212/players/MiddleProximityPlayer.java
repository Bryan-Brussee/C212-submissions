package edu.indiana.cs.c212.players;

import java.util.List;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.view.textual.CommandLineView;

public class MiddleProximityPlayer extends AbstractPlayer implements Player {
	
		
		/*int compareX;
		int compareY;
		int idealX;
		int idealY;
		*/
		public MiddleProximityPlayer(PlayerColor c) {
		super(c);
		
	/*	this.compareX = 1;
		this.compareY = 1;
		this.idealX = 0;
		this.idealY = 0;*/
	}

	

	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		// TODO Auto-generated method stub
		System.out.println(CommandLineView.boardToString(board));
		
		
			//The idea here is to first try and make the best move - the middle move in the board.
			//If it can't, then it iterates through the legal moves, checking how far away each of their
		// x and y values are from that of the ideal move.
		
			int idealX = board.getSize() / 2;
			int idealY = board.getSize() / 2;
			
			int lessIdealX = 20;
			int lessIdealY = 20;
			
			int compareX = 0;
			
		
		
		
			Move idealMove = new Move(idealX, idealY);
			
			if (legalMoves.contains(idealMove)) {
				
				return idealMove;
			
			} else {
				
				for (int i = 0; i < legalMoves.size(); i++) {
					
					
					int curX = legalMoves.get(i).getX();
					int curY = legalMoves.get(i).getY();
					
					
					int stackUpX = idealX - curX;
					int stackUpY = idealY - curY;
					
					if (Math.abs(stackUpX + stackUpY) <= Math.abs(lessIdealX + lessIdealY)) {
						lessIdealX = curX;
						lessIdealY = curY;
					}
					
				}
				
				
				
			}
			
		
		return new Move(idealX, idealY);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Middle Proximity Player";
	}

}
