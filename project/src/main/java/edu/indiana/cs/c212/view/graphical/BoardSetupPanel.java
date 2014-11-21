package edu.indiana.cs.c212.view.graphical;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BoardSetupPanel extends javax.swing.JPanel {

	private JSpinner boardSizeSpinner;
	private JPanel spinnerJPanel;
	private int spinnerValue;

	public static final int DEFAULT_BOARD_SIZE = 7;
	public static final int MAX_SUPPORTED_BOARD_SIZE = 10;
	public static final int MIN_SUPPORTED_BOARD_SIZE = 3;

	public BoardSetupPanel() {
		spinnerValue = DEFAULT_BOARD_SIZE;
		SpinnerModel model = new SpinnerNumberModel(DEFAULT_BOARD_SIZE,
				MIN_SUPPORTED_BOARD_SIZE, MAX_SUPPORTED_BOARD_SIZE, 1);

		final JSpinner spinner = new JSpinner(model);
		spinner.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				spinnerValue = (int) spinner.getValue();
			}
		});

		JLabel spinnerName = new JLabel("Board Size");
		JPanel boardSizeChoice = new JPanel();
		boardSizeChoice.add(spinnerName);
		boardSizeChoice.add(spinner);
		this.spinnerJPanel = boardSizeChoice;

	}

	public JPanel getSpinnerJPanel() {
		return spinnerJPanel;
	}

	public JSpinner getSpinner() {
		return boardSizeSpinner;
	}
	
	public int getBoardSize() {
		return spinnerValue;
	}

}
