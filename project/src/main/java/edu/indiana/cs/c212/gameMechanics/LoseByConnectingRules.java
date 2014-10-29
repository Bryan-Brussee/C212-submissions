package edu.indiana.cs.c212.gameMechanics;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.Player;

public class LoseByConnectingRules extends StandardRules {

	
		public LoseByConnectingRules(Board board, Player red, Player blue) {
			super(board, red, blue);

		}
		
		@Override
		public PlayerColor checkForWins() {

			if (areTilesConnected(board, board.getTileAt(-1, 0),
					board.getTileAt(board.getSize(), 0), PlayerColor.BLUE)) {
				return PlayerColor.RED;
			}
			if (areTilesConnected(board, board.getTileAt(0, -1),
					board.getTileAt(0, board.getSize()), PlayerColor.RED)) {

				return PlayerColor.BLUE;
			}

			return null;
		}
		}

