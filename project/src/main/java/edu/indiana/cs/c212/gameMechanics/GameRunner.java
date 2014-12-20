package edu.indiana.cs.c212.gameMechanics;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.SimpleGameBoard;
import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.BasicTrailsPlayer;
import edu.indiana.cs.c212.players.CommandLinePlayer;
import edu.indiana.cs.c212.players.MiddleProximityPlayer;
import edu.indiana.cs.c212.players.Player;
import edu.indiana.cs.c212.players.PointAndClickPlayer;
import edu.indiana.cs.c212.players.SimpleRandom;
import edu.indiana.cs.c212.view.graphical.GraphicalBoardView;
import edu.indiana.cs.c212.view.textual.CommandLineView;

public class GameRunner extends Observable implements Runnable {
	private Player redPlayer;
	private Player bluePlayer;
	private Rules rules;
	private boolean running;
	private Board board;

	public GameRunner(int boardSize, String red, String blue, String ruleSet) {
		this.board = new SimpleGameBoard(boardSize);
		this.redPlayer = createPlayer(red, PlayerColor.RED);
		this.bluePlayer = createPlayer(blue, PlayerColor.BLUE);
		// System.out.println(ruleSet);
		this.rules = createRules(ruleSet, this.board, redPlayer, bluePlayer);
		this.running = true;
	}

	public Player getCurrentPlayer() {
		// System.out.println("Rules: " + this.rules);
		// System.out.println("Get Players: " + rules.getPlayers());
		return rules.getPlayers().peek();
	}

	protected static Player createPlayer(String playerType, PlayerColor color) {
		switch (playerType) {

		case "Command Line Player":
			CommandLinePlayer humanPlayer = new CommandLinePlayer(color);
			return humanPlayer;

		case "Simple Random Player":
			SimpleRandom simpleRandomPlayer = new SimpleRandom(color);
			return simpleRandomPlayer;

		case "Point and Click Player":
			PointAndClickPlayer player = new PointAndClickPlayer(color);
			return player;

		case "Basic Trails Player":
			BasicTrailsPlayer basic = new BasicTrailsPlayer(color);
			return basic;
			
		case "Middle Proximity Player":
			MiddleProximityPlayer prox = new MiddleProximityPlayer(color);
			return prox;

		}
		return null;
	}

	public static List<String> getPlayersList() {

		ArrayList<String> playersList = new ArrayList<String>();
		playersList.add("Command Line Player");
		playersList.add("Simple Random Player");
		playersList.add("Point and Click Player");
		playersList.add("Basic Trails Player");
		playersList.add("Middle Proximity Player");

		return playersList;
	}

	protected static Rules createRules(String ruleSet, Board board, Player red,
			Player blue) {
		// System.out.println("Rule set: " + ruleSet + " " +
		// ruleSet.getClass());
		// ruleSet = getRuleSets().get(new Integer(ruleSet));
		switch (ruleSet) {
		case "Standard Rules":
			StandardRules standardRules = new StandardRules(board, red, blue);
			return standardRules;
		case "Overwrite Rules":
			OverwriteRules overwriteRules = new OverwriteRules(board, red, blue);
			return overwriteRules;
		case "Lose by Connecting Rules":
			LoseByConnectingRules loseByConnectingRules = new LoseByConnectingRules(
					board, red, blue);
			return loseByConnectingRules;

		}

		return null;
	}

	public static List<String> getRuleSets() {
		ArrayList<String> ruleChoices = new ArrayList<String>();
		ruleChoices.add("Standard Rules");
		ruleChoices.add("Overwrite Rules");
		ruleChoices.add("Lose by Connecting Rules");

		return ruleChoices;
	}

	public Board getBoard() {
		return this.board;
	}

	public static void main(String[] args) {
		GraphicalBoardView.sheAGo();
	}

	@Override
	public void run() {
		while (running) {
			Player current = getCurrentPlayer();
			Move currentmove = current.getMove(getBoard(),
					rules.getLegalMoves(current));
			if (rules.isLegalMove(currentmove)) {
				try {
					rules.makeMove(currentmove);
					notifyObservers();
				} catch (InvalidMoveException e) {
					stopGame();
				}
				if (rules.checkForWins() == null) {
					// System.out.println(rules.checkForWins());
					rules.nextTurn();
					notifyObservers();
				} else {
					System.out.println(rules.checkForWins() + " wins!");
					stopGame();
				}
			} else {
				System.out.println("Ya blew it!");
				stopGame();
			}
		}
	}

	void stopGame() {
		running = false;
	}

}
