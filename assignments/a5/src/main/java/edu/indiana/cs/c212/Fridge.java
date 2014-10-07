package edu.indiana.cs.c212;

import edu.indiana.cs.c212.Magnet;

import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

/**
 * @author bbrussee
 * @author <YOUR PARTNER'S NAME HERE>
 *
 */
@SuppressWarnings("serial")
public class Fridge extends JPanel {
    public static final Color COLOR = Color.BLACK;

    public static final int       DEFAULT_WIDTH_IN_PIXELS  = 400;
    public static final int       DEFAULT_HEIGHT_IN_PIXELS = 400;
    public static final Dimension PREFERRED_SIZE           = new Dimension(DEFAULT_WIDTH_IN_PIXELS, DEFAULT_HEIGHT_IN_PIXELS);

    private Dimension size;
    private Graphics  offscreenTablet;

    private List<Magnet> magnets;
    private Magnet       selectedMagnet;
    private int          selectedMagnetIndex;

    /**
     * Creates a new Fridge object to hold Magnets
     */
    public Fridge() {
        magnets = new ArrayList<Magnet>();
        selectedMagnet = null;
        selectedMagnetIndex = -1;

        this.addMouseListener(new MagnetClickListener());
        this.addMouseMotionListener(new MagnetMoveListener());
        this.addComponentListener(new FridgeSizeChangeListener());

        size = PREFERRED_SIZE;
        this.setPreferredSize(PREFERRED_SIZE);
        this.setBackground(COLOR);
        this.repaint();
    }

    /**
     * Adds a new magnet to the ArrayList<Magnet> of magnets
     * Also adds the label for the magnet to the JPanel for display
     * @param magnet the magnet to add.
     */
    public void addMagnet(Magnet magnet) {
        magnets.add(magnet);
        this.add(magnet.getTextLabel());
    }

    /**
     * Paints this fridge on the screen and asks all the magnets on this fridge to draw themselves
     * Steps:
     * 		1. Set the tablet's color to white using the tablet's setColor method.
     * 		2. Fill the tablet using the tablet's fillRect method.
     * 		3. For every magnet on the fridge, redraw the magnet using the magnet's draw method.
     * 
     * @param tablet
     */
    public void paintComponent(Graphics tablet) {
        super.paintComponent(tablet);
        tablet.setColor(new Color(255, 255, 255));
        tablet.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < magnets.size(); i++) {
        	 magnets.get(i).draw(tablet, isSelected(magnets.get(i)));
        }
        //FIXME
    }

    /**
     * Returns the preferred size of the fridge
     * @return the preferred size of the fridge
     */
    public Dimension getPreferredSize() {
    	return Fridge.PREFERRED_SIZE;
    }

    /**
     * Returns the width of the fridge
     * @return the width of the fridge
     */
    public int getWidth() {
        //FIXME
    	return Fridge.DEFAULT_WIDTH_IN_PIXELS;
    }

    /**
     * Returns the height of the fridge
     * @return the height of the fridge
     */
    public int getHeight() {
        //FIXME
    	return Fridge.DEFAULT_HEIGHT_IN_PIXELS;
    }

    /**
     * Resets the size variable to the current bounds of the fridge.
     * Used when the window changes size
     */
    private void setBounds() {
        Rectangle bounds = this.getBounds();
        int width = bounds.width;
        int height = bounds.height;
        size = new Dimension(width, height);
    }

    /**
     * Returns true if the user is currently selecting the given magnet and
     * false otherwise
     * @param magnet the magnet to check
     * @return true if the magnet is selected, false otherwise
     */
    private boolean isSelected(Magnet magnet) {
    	//FIXME
    	if (magnet.equals(selectedMagnet)) {
    		return true;
    	} else {
        return false;
    }
    }

    /**
     * Checks to see if any magnet in the fridge's magnet list is selected
     * @return true if the user has selected a magnet, false otherwise
     */
    private boolean aMagnetIsSelected() {
        return ((selectedMagnetIndex >= 0) && (selectedMagnetIndex < magnets
                .size()));
    }

    private class FridgeSizeChangeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent componentEvent) {
            setBounds();
            repaint();
        }
    }

    private class MagnetClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent mouseEvent) {
            Point point = mouseEvent.getPoint();

            checkIfAMagnetIsSelected(point);
            if (aMagnetIsSelected()) {
                shiftSelectedMagnetToTopOfList();
                selectedMagnet.setOffset(point);
                selectedMagnet.draw(offscreenTablet, true);
                repaint();
            }
        }

        private void checkIfAMagnetIsSelected(Point point) {
            selectedMagnet = null;
            selectedMagnetIndex = -1;
            for (int i = 0; i < magnets.size(); i++) {
                if ((magnets.get(i)).contains(point)) {
                    selectedMagnet = magnets.get(i);
                    selectedMagnetIndex = i;
                }
            }
            repaint();
        }

        private void shiftSelectedMagnetToTopOfList() {
            for (int i = selectedMagnetIndex; i < magnets.size() - 1; i++) {
                magnets.set(i, magnets.get(i + 1));
            }
            magnets.set(magnets.size() - 1, selectedMagnet);
        }

        public void mouseReleased(MouseEvent mouseEvent) {
            selectedMagnet = null;
            selectedMagnetIndex = -1;
            repaint();
        }
    }

    private class MagnetMoveListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent mouseEvent) {
            if (aMagnetIsSelected()) {
                Point mouseLocation = mouseEvent.getPoint();
                Point offset = selectedMagnet.getOffset();

                int x = mouseLocation.x - offset.x;
                int y = mouseLocation.y - offset.y;
                Point newOriginPointOfMagnet = keepMagnetOnFridge(x, y);

                moveSelectedMagnetTo(newOriginPointOfMagnet);
                redrawAnyIntersectingMagnets();
            }
        }

        private Point keepMagnetOnFridge(int x, int y) {
            x = keepInHorizontalBounds(x);
            y = keepInVerticalBounds(y);

            return new Point(x, y);
        }

        private int keepInHorizontalBounds(int x) {
            x = Math.max(x, 0);
            x = Math.min(x, getWidth() - 1 - selectedMagnet.getWidth());

            return x;
        }

        private int keepInVerticalBounds(int y) {
            y = Math.max(y, 0);
            y = Math.min(y, getHeight() - 1 - selectedMagnet.getHeight());

            return y;
        }

        private void moveSelectedMagnetTo(Point point) {
            selectedMagnet.moveTo(point);
            selectedMagnet.draw(offscreenTablet, true);
            repaint();
        }

        private void redrawAnyIntersectingMagnets() {
            for (Magnet magnet : magnets) {
                if (magnet.intersects(selectedMagnet)) {
                    magnet.draw(offscreenTablet, isSelected(magnet));
                    repaint();
                }
            }
        }
    }
}
