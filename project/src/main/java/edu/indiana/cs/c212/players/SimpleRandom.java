package edu.indiana.cs.c212.players;

import java.util.List;
import java.util.Random;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.view.textual.CommandLineView;

public class SimpleRandom extends AbstractPlayer {
	protected PlayerColor color;
	
	public SimpleRandom(PlayerColor color) {
		super(color);
	}

	@Override
	public Move getMove(Board board, List<Move> moves) {
		
		
		System.out.println(CommandLineView.boardToString(board));
		
		Random random = new Random();
		int randominteger = random.nextInt(moves.size());
		Move randommove = moves.get(randominteger);
		return randommove;
			
	}

	@Override
	public String getName() {
		return "Simple Random";
	}
	

}
