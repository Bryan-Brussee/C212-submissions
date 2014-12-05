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
	
		private PlayerChoicePanel redChoice;
		private PlayerChoicePanel blueChoice;
		private BoardSetupPanel boardSizePanel;
	
	

	public GraphicalBoardView() {		
		this.setTitle("Trails");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(0, 0, 300, 300);
		
		
		JPanel bigJPanel = new JPanel();
		bigJPanel.setLayout(new BoxLayout(bigJPanel, BoxLayout.Y_AXIS));
		bigJPanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		this.redChoice = new PlayerChoicePanel("Red");
		this.blueChoice = new PlayerChoicePanel("Blue");
		this.boardSizePanel = new BoardSetupPanel();
		JButton start = new JButton("Start!");
		start.addActionListener(this);
		
		bigJPanel.add(redChoice);
		bigJPanel.add(blueChoice);
		bigJPanel.add(boardSizePanel);
		bigJPanel.add(start);
		
		this.add(bigJPanel);
		
	}

	//@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		//GraphicalBoardView gameWindow = new GraphicalBoardView();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				
				GraphicalBoardView gameWindow = new GraphicalBoardView();
			}
		});
	}
		
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GameRunner theGame = new GameRunner(boardSizePanel.getBoardSize(), 
				redChoice.getPlayerChoiceString(),
				blueChoice.getPlayerChoiceString(), "2");
		this.dispose();
		theGame.run();
		

	}

}
