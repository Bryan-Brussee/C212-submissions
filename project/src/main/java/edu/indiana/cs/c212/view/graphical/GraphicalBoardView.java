package edu.indiana.cs.c212.view.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import edu.indiana.cs.c212.gameMechanics.GameRunner;

public class GraphicalBoardView extends javax.swing.JFrame implements
		java.awt.event.ActionListener {
	private JFrame pratice;
	//private static int spinnerValue;

	public GraphicalBoardView() {
		//spinnerValue = 0;
		JFrame frame = new JFrame("Trails");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pratice = frame;
		// -------------------
		// JPanel bigJPanel = new JPanel();
		// --------------------
		// BoardSetupPanel spinner = new BoardSetupPanel();
		// bigJPanel.add(spinner);
		// frame.add(bigJPanel);
		frame.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		final JFrame frame = new JFrame("Player GUI");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 50, 50);
		JPanel bigJPanel = new JPanel();
		bigJPanel.setLayout(new BoxLayout(bigJPanel, BoxLayout.Y_AXIS));
		bigJPanel.add(Box.createRigidArea(new Dimension(0,5)));
		// --------------------

		final BoardSetupPanel spinnerPanel = new BoardSetupPanel();
		final PlayerChoicePanel playerOne = new PlayerChoicePanel("Red");
		final PlayerChoicePanel playerTwo = new PlayerChoicePanel("Blue");
		final JButton start = new JButton("Start!");

		// --------------------

		start.addActionListener(

		new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				GameRunner theGame = new GameRunner(spinnerPanel.getBoardSize(), 
						playerOne.getPlayerChoiceString(),
						playerTwo.getPlayerChoiceString(), "0");
				frame.dispose();
				theGame.run();
				
			}
		}

		);

		start.setAlignmentX(0.5f);
		bigJPanel.add(start);
		bigJPanel.add(playerOne.getPlayerChoiceJPanel());
		bigJPanel.add(playerTwo.getPlayerChoiceJPanel());
		bigJPanel.add(spinnerPanel.getSpinnerJPanel());
		frame.add(bigJPanel);
		frame.setSize(200, 300);
		frame.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
