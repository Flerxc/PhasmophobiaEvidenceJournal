package ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;
import data.Ghost;
import manager.PhasmophobiaManager;

/**
 * A menu frame showing stats: winrate, amount of games played then the amount 
 * of time each each ghost has ben seen + frequency 
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 */
public class StatFrame extends AbstractFrame{
	
	/**************
	 * ATTRIBUTES *
	 **************/
	private JPanel panel;
	
	/**
	 * Default constructor
	 */
	public StatFrame() {
		super(Constants.BIG_SECONDARY_FRAME_SIZE);
	}
	
	@Override
	/**
	 * Initialize components
	 */
	void initComponents() {
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(Constants.MENU_PANEL_BORDER_SIZE_VERT,
				Constants.MENU_PANEL_BORDER_SIZE_HOR,
				Constants.MENU_PANEL_BORDER_SIZE_VERT,
				Constants.MENU_PANEL_BORDER_SIZE_HOR));
		addLabelsToPanel();
	}

	@Override
	/**
	 * Adds components
	 */
	void addComponents() {
		add(panel);
	}
	
	/**
	 * Adds labels for all ghosts, winrate and total amount of games
	 * It uses html to format the JLabels
	 */
	private void addLabelsToPanel(){

		panel.add(new JLabel("<html><span style='font-size:14px'>" + "Winrate: " 
		+ PhasmophobiaManager.db.countWinrate(Constants.TABLE_NAME) + "%" + "</span></html>"));

		panel.add(new JLabel("<html><span style='font-size:14px'>" + "Game played: " 
		+ PhasmophobiaManager.db.getTotalGame(Constants.TABLE_NAME)+ "</span></html>"));
		
		for (Ghost g : Constants.ALL_GHOSTS) {
			panel.add(new JLabel("<html><span style='font-size:14px'>" +
										g.getGhostName() + ": " + 
										PhasmophobiaManager.db.count(
												g.getGhostName(), 
												Constants.COLUMN_CORRECT_GHOST, 
												Constants.TABLE_NAME)
									+ "\t\t" + PhasmophobiaManager.db.frequency(g.getGhostName(), Constants.TABLE_NAME) 	
									+ "%</span></html>"));
		}
	}
}
