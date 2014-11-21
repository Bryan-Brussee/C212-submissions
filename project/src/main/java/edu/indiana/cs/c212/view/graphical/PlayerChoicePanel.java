package edu.indiana.cs.c212.view.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.GameRunner;

public class PlayerChoicePanel extends javax.swing.JPanel {

	// private JComboBox<String> playerList;
	private JPanel playerChoiceJPanel;
	private String player;

	public PlayerChoicePanel(String name) {
		super();
		
		player = "Command Line Player";

		final JComboBox<String> playerList = new JComboBox<String>();

		for (String s : GameRunner.getPlayersList()) {
			playerList.addItem(s);
		}

		playerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player = (String) playerList.getSelectedItem();
			}

		}

		);

		JLabel playerName = new JLabel(name + " Player Type: ");

		JPanel playerChoice = new JPanel();
		playerChoice.add(playerName);
		playerChoice.add(playerList);
		this.playerChoiceJPanel = playerChoice;
	}

	public JPanel getPlayerChoiceJPanel() {
		return playerChoiceJPanel;
	}

	public String getPlayerChoiceString() {
		return this.player;
	}

}
