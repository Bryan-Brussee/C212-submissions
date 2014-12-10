package edu.indiana.cs.c212.view.graphical;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class BoardPanel extends JPanel implements ActionListener, Observer {

	public BoardPanel(Board board) {

		// HexTile test = new HexTile(0, 0, 1, new Tile(PlayerColor.BLUE, new
		// Point(0, 0)));

	}

	public static void main(String args[]) {
		JFrame test = new JFrame();
		test.setSize(500, 500);
		JPanel panel = new JPanel();
		//panel.setBackground(Color.BLACK);
		//panel.add(new HexTile(0, 0, 100, new Tile(PlayerColor.BLUE, new Point(0,
				//0))));
		JButton start = new JButton("Start!");
		panel.add(start);
		test.add(panel);
		test.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HexTile tile = (HexTile) e.getSource();
		MoveEvent move = new MoveEvent(new Point(tile.getBoardX(),
				tile.getBoardY()), 0);
		for (AWTEventListener l : Toolkit.getDefaultToolkit()
				.getAWTEventListeners()) {
			l.eventDispatched(move);
		}
	}
}