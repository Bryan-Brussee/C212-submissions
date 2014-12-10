package edu.indiana.cs.c212.players;

import java.util.List;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.OverwriteMove;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.view.textual.CommandLineView;

public class BasicTrailsPlayer extends AbstractPlayer {
        
        public BasicTrailsPlayer(PlayerColor player){
                super(player);
        }

        @Override
        public Move getMove(Board board, List<Move> legalMoves) {
                
                System.out.print(CommandLineView.boardToString(board));
                
                int size = board.getSize();
                
                if (this.getColor().equals(PlayerColor.BLUE)) {

                        for (int moveY = 0; moveY < size; moveY++) {
                                for (int moveX = 0; moveX < size; moveX++) {

                                        Move s = new Move(moveX, moveY);
                                        OverwriteMove k = new OverwriteMove(moveX, moveY);

                                        if (legalMoves.contains(s)) {
                                                return s;
                                        } else if (legalMoves.contains(k)) {
                                                return k;
                                        }
                                }
                        }

                }

                for (int moveX = 0; moveX < size; moveX++) {
                        for (int moveY = 0; moveY < size; moveY++) {

                                Move s = new Move(moveX, moveY);
                                OverwriteMove k = new OverwriteMove(moveX, moveY);

                                if (legalMoves.contains(s)) {
                                        return s;
                                } else if (legalMoves.contains(k)) {
                                        return k;
                                }
                        }
                }

                return null;

        }

        @Override
        public String getName() {
                
                return "Basic Trails Player";
        }

}
