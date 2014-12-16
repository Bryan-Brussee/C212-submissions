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
	
	private Point point;

	public PointAndClickPlayer(PlayerColor c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

    @Override
    public Move getMove(Board board, List<Move> legalMoves) {
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 0);
        
        Move move;
        
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(this.point != null){
                move = new Move(this.point.x, this.point.y);
                if(legalMoves.contains(move));
                break;
            }
        }
        Toolkit.getDefaultToolkit().removeAWTEventListener(this); 
        return move;
    }


	@Override
	public void eventDispatched(AWTEvent event) {
		// TODO Auto-generated method stub
		point = (Point) event.getSource();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Point and Click Player";
	}

}
