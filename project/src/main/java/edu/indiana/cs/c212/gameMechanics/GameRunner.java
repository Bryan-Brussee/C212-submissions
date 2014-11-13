package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.SimpleGameBoard;
import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.CommandLinePlayer;
import edu.indiana.cs.c212.players.Player;
import edu.indiana.cs.c212.players.SimpleRandom;
import edu.indiana.cs.c212.view.textual.CommandLineView;

public class GameRunner extends Observable implements Runnable {
	private int boardSize;
	private Player redPlayer;
	private Player bluePlayer;
	private Rules rules;
	private boolean running;
	private Board board;
	
	
	public GameRunner(int boardSize, String red, String blue, String ruleSet) {
		this.boardSize = boardSize;
		this.redPlayer = createPlayer(red, PlayerColor.RED);
		this.bluePlayer = createPlayer(blue, PlayerColor.BLUE);
		this.rules = createRules(ruleSet, getBoard(), redPlayer, bluePlayer);
		this.running = true;
		this.board = getBoard();
		
		

		
	}
	
	
	protected static Player createPlayer(String playerType, PlayerColor color) {
		switch(playerType) {

		case "Simple Random Player" :
			SimpleRandom simpleRandomPlayer = new SimpleRandom(color);
			return simpleRandomPlayer;
		case "Command Line Player" :
			CommandLinePlayer humanPlayer = new CommandLinePlayer(color);
			return humanPlayer;
		}
			
		return null;
	}
		
	
	protected static Rules createRules(String ruleSet, Board board, Player red, Player blue) {
		System.out.println("ruleSet" + ruleSet);	
		
		ruleSet = getRuleSets().get( new Integer(ruleSet) );
		
		switch(ruleSet) {
		case "Standard Rules" :
			StandardRules standardRules = new  StandardRules(board, red, blue);
			return standardRules;
		case "Overwrite Rules" :
			OverwriteRules overwriteRules = new OverwriteRules(board, red, blue);
			return overwriteRules;
		case "Lose by Connecting Rules" :
			LoseByConnectingRules loseByConnectingRules = new LoseByConnectingRules(board, red, blue);
			return loseByConnectingRules;
		}
		//System.out.println("Is null");
		return null;
	}
	
	
	public Board getBoard() {
		
		SimpleGameBoard board = new SimpleGameBoard(boardSize);
		
		return board;
	}
	
	
	public Player getCurrentPlayer() {
		System.out.println("Rules: " + this.rules);
		System.out.println("Get Players: " + rules.getPlayers());
		
		return rules.getPlayers().peek();
	}

	
	public static List<String> getPlayersList() {
		ArrayList<String> playersList = new ArrayList<String>();
		playersList.add("Command Line Player");
		playersList.add("Simple Random");
		return playersList;
		
	}
	
	public static List<String> getRuleSets() {
		// TODO Auto-generated method stub
		
		List<String> ruleChoices = new ArrayList<String>();
		
		ruleChoices.add("Standard Rules");
		ruleChoices.add("Overwrite Rules");
		ruleChoices.add("Lose by Connecting Rules");
		
		return ruleChoices;
	}
	
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandLineView.setup(scanner);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			Player current = getCurrentPlayer();
	
			Move currentmove = current.getMove(getBoard(), rules.getLegalMoves(current));
			
			if (rules.isLegalMove(currentmove)) {
				if (rules.checkForWins() == null) {
					try {
						rules.makeMove(currentmove);
					} catch (InvalidMoveException e) {
						System.out.println("Player " + rules.getNextPlayer() + " wins!");
						stopGame();
					}
					rules.nextTurn();
				}
			}
		}
	}
	
	
	void stopGame() {
		running = false;
	}

}
