package edu.indiana.cs.c212.view.graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.GameRunner;

public class RulesChoicePanel extends JPanel {
	
	
	
	private JPanel rulesChoiceJPanel;
	private String rules;
	
	
	public RulesChoicePanel() {
		
		super();
		
		rules = "0";	
		
		
		final JComboBox<String> ruleList = new JComboBox<String>();
		
		
		for (String s : GameRunner.getRuleSets()) {
			ruleList.addItem(s);
		}
		
		
		ruleList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rules = (String) ruleList.getSelectedItem();
			}

		}

		);
		
		JLabel ruleName = new JLabel("Rules: ");

		JPanel rulesChoice = new JPanel();
		rulesChoice.add(ruleName);
		rulesChoice.add(ruleList);
		this.rulesChoiceJPanel = rulesChoice;
		
		
	}
	
	
	public JPanel getPlayerChoiceJPanel() {
		return rulesChoiceJPanel;
	}
	
	public String getRuleSet() {
		
		return this.rules;
		
		
	}

}
