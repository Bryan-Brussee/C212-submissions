package edu.indiana.cs.c212.view.graphical;

import java.awt.MenuContainer;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.accessibility.Accessible;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements ActionListener,
                ImageObserver, MenuContainer, Serializable, EventListener, Observer,
                Accessible {

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