package edu.indiana.cs.c212.players;

import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.List;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class PointAndClickPlayer extends AbstractPlayer implements
		AWTEventListener {
	
	private Point p;

	public PointAndClickPlayer(PlayerColor c) {
		super(c);
	}

    @Override
    public Move getMove(Board board, List<Move> legalMoves) {
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 0);
        
        Move move;
        
        while(true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(this.p != null){
                move = new Move(this.p.x, this.p.y);
                if(legalMoves.contains(move));
                break;
            }
        }
        Toolkit.getDefaultToolkit().removeAWTEventListener(this); 
        return move;
    }


	@Override
	public void eventDispatched(AWTEvent event) {
		p = (Point) event.getSource();

	}

	@Override
	public String getName() {
		return "Point and Click Player";
	}

}
