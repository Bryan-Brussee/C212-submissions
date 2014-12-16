package edu.indiana.cs.c212.view.graphical;

/**@author jzapatav
 * @author bbrussee
 *
 **/

import java.awt.MenuContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import javax.accessibility.Accessible;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.GameRunner;

public class RulesChoicePanel extends JPanel implements ImageObserver,
		MenuContainer, Serializable, Accessible {

	private String rules;

	public RulesChoicePanel() {
		super();

		rules = "Standard Rules";

		final JComboBox<String> rulesList = new JComboBox<String>();

		for (String s : GameRunner.getRuleSets()) {
			rulesList.addItem(s);
		}

		rulesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rules = (String) rulesList.getSelectedItem();
			}

		}

		);

		JLabel ruleName = new JLabel("Rules: ");

		this.add(ruleName);
		this.add(rulesList);

	}

	public String getRuleChoice() {
		/*
		 * if (this.rules.equals("Standard Rules")) { return "0"; }
		 * 
		 * if (this.rules.equals("Overwrite Rules")) { return "1"; }
		 * 
		 * if (this.rules.equals("Lose by Connecting Rules")) { return "2"; }
		 * else { return "3"; } }
		 */
		return rules;
	}

}

