
package edu.indiana.cs.c212.view.graphical;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.MenuContainer;
import java.io.Serializable;
import java.util.EventListener;
import java.util.Observer;
import java.util.Scanner;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import edu.indiana.cs.c212.board.SimpleGameBoard;
import edu.indiana.cs.c212.gameMechanics.GameRunner;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.view.textual.CommandLineView;

@SuppressWarnings("serial")
public class GraphicalBoardView extends javax.swing.JFrame implements
java.awt.event.ActionListener {

	private JButton startButton;
	private JPanel bigJPanel;
	private JPanel selectionPanel;
	private GameRunner game;
	private BoardSetupPanel boardSetupPanel;
	private PlayerChoicePanel playerOne;
	private PlayerChoicePanel playerTwo;
	private RulesChoicePanel rulesChoice;
	private BoardPanel boardPanel;
	private SimpleGameBoard board;
	private TurnViewer turn;

	public GraphicalBoardView() {
		this.setTitle("Trails");
		this.setResizable(true);
		this.setSize(900, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel bigJPanel = new JPanel();
		this.bigJPanel = bigJPanel;
		bigJPanel.setLayout(null);

		BoardSetupPanel finishedSpinnerPanel = new BoardSetupPanel();
		PlayerChoicePanel playerOne = new PlayerChoicePanel("Red");
		PlayerChoicePanel playerTwo = new PlayerChoicePanel("Blue");
		RulesChoicePanel rules = new RulesChoicePanel();
		JButton start = new JButton("Start!");
		start.addActionListener(this);


		JPanel selectionPanel = new JPanel();
		this.selectionPanel = selectionPanel;

		selectionPanel.setBounds(0, 0, 600, 150);

		this.boardSetupPanel = finishedSpinnerPanel;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.startButton = start;
		this.rulesChoice = rules;
	

		this.selectionPanel.add(playerOne);
		this.selectionPanel.add(playerTwo);
		this.selectionPanel.add(rulesChoice);
		this.selectionPanel.add(finishedSpinnerPanel);
		this.selectionPanel.add(startButton);

		bigJPanel.add(selectionPanel);

		this.add(bigJPanel);

	}

	public static java.lang.Runnable setup() {
		return new Runnable() {
			public void run() {
				GraphicalBoardView theInterface = new GraphicalBoardView();
				theInterface.setVisible(true);
			}
		};
	}

	public static void sheAGo() {
		Thread thread = new Thread(setup());
		thread.start();
	}

	boolean isThisComponentFoundInJPanel(Component c) {
		Component[] components = bigJPanel.getComponents();
		for (Component component : components) {
			if (c == component) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameRunner theGame = new GameRunner(
				this.boardSetupPanel.getBoardSize(),
				playerOne.getPlayerChoiceString(),
				playerTwo.getPlayerChoiceString(), rulesChoice.getRuleChoice());


		this.game = theGame;

		this.board = new SimpleGameBoard(this.boardSetupPanel.getBoardSize());

		BoardPanel boardPanel = new BoardPanel(board);

		this.boardPanel = boardPanel;

		this.boardPanel.setBounds(0, 150, 900, 600);

		turn = new TurnViewer (theGame.getCurrentPlayer().getColor() , theGame);
		this.turn.setBounds(450,720,200,200);
		this.bigJPanel.add(this.turn);

		this.bigJPanel.add(boardPanel);
		theGame.addObserver(this.boardPanel);
		theGame.addObserver(this.turn);


		Thread thread = new Thread(theGame);
		thread.start();
		repaint();
		this.selectionPanel.remove(startButton);
		this.bigJPanel.revalidate();
	}
}









