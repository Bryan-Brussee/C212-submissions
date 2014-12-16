package edu.indiana.cs.c212.view.graphical;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.awt.Color;
import java.awt.MenuContainer;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.SimpleGameBoard;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class BoardPanel extends JPanel implements ActionListener,
		ImageObserver, MenuContainer, Serializable, EventListener, Observer,
		Accessible {
	protected Board board;
	protected java.awt.Point chosenXY;
	private ArrayList<HexTile> hex;

	public BoardPanel(Board board) {
		this.board = board;
		hex = new ArrayList<HexTile>();
		this.setSize(700, 800);
		this.setBackground(Color.BLACK);
		this.setLayout(null);

		for (int x = 0; x <= this.board.getSize() + 1; x++) {
			for (int y = 0; y <= this.board.getSize() + 1; y++) {

				if (x == 0) {
					HexTile hexagon = new HexTile(x, y, 30, (new Tile(
							PlayerColor.BLUE, new Point(-1, 0))));

					hexagon.setBounds(y * hexagon.b, 0 - hexagon.a * y,
							this.getWidth(), this.getHeight());
					this.add(hexagon);

				} else if (x == this.board.getSize() + 1) {
					HexTile hexagon = new HexTile(x, y, 30, (new Tile(
							PlayerColor.BLUE,
							new Point(this.board.getSize(), 0))));

					hexagon.setBounds(y * hexagon.b, 0 - hexagon.a * y,
							this.getWidth(), this.getHeight());
					this.add(hexagon);

				}

				else if (y == 0) {
					HexTile hexagon = new HexTile(x, y, 30, (new Tile(
							PlayerColor.RED, new Point(0, -1))));

					hexagon.setBounds(y * hexagon.b, 0 - hexagon.a * y,
							this.getWidth(), this.getHeight());
					this.add(hexagon);

				}

				else if (y == this.board.getSize() + 1) {
					HexTile hexagon = new HexTile(x, y, 30,
							(new Tile(PlayerColor.RED, new Point(0,
									this.board.getSize()))));

					hexagon.setBounds(y * hexagon.b, 0 - hexagon.a * y,
							this.getWidth(), this.getHeight());
					this.add(hexagon);

				}

				else {
					HexTile hexagon = new HexTile(x, y, 30, board.getTileAt(
							x - 1, y - 1));

					hexagon.setBounds(y * hexagon.b, 0 - hexagon.a * y,
							this.getWidth(), this.getHeight());
					this.add(hexagon);
					hex.add(hexagon);
					hexagon.addActionListener(this);
				}

			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("called");
		repaint();
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

	public void paintCompenent(java.awt.Graphics g) {
		for (int i = 0; i < hex.size(); i++) {
			hex.get(i).paint(g);
		}
	}
}

	
	
