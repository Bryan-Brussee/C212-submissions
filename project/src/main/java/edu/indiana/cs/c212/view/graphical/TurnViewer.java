package edu.indiana.cs.c212.view.graphical;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuContainer;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.accessibility.Accessible;
import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.GameRunner;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class TurnViewer extends JPanel implements ImageObserver, MenuContainer,
		Serializable, Accessible, Observer {

	private PlayerColor player;
	private GameRunner game;
	private Polygon triangle;

	public TurnViewer(PlayerColor player, GameRunner game) {
		this.player = player;
		this.game = game;
		this.setSize(100, 100);
		this.setBounds(50, 50, 100, 100);
		this.setLayout(null);
		this.setBackground(Color.WHITE);

		Dimension size = this.getSize();

		Point point1 = new Point(size.width / 3, (2 * size.height) / 3);

		Point point2 = new Point(size.width / 2, size.height / 3);

		Point point3 = new Point((2 * size.width) / 3, (2 * size.height) / 3);

		int[] x = { point1.x, point2.x, point3.x };

		int[] y = { point1.y, point2.y, point3.y };

		this.triangle = new Polygon(x, y, x.length);
		// triangle.setBounds(50,50,50,50);
	}

	public void paintComponent(java.awt.Graphics g) {

		if (player == PlayerColor.RED) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}
		g.fillPolygon(triangle);
		g.drawPolygon(triangle);
		g.setColor(Color.BLACK);
		g.drawPolygon(triangle);

	}

	@Override
	public void update(Observable o, Object arg) {

		repaint();

	}

}
