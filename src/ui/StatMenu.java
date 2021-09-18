package ui;

import javax.swing.JMenu;

import constants.Constants;

/**
 * Custom JMenu class for statistics
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 */
public class StatMenu extends JMenu {

	/**************
	 * ATTRIBUTES *
	 **************/

	private StatsMenuItem generalStats;

	private StatsMenuItem history;
	
	/**
	 * Parameter constructor
	 * @param title the menu's name
	 */
	public StatMenu(String title) {
		super(title);
		
		initComponents();
		
		addComponents();
	}
	
	
	/**
	 * Initializes menu components
	 */
	private void initComponents() {
		
		generalStats = new StatsMenuItem(Constants.MENU_GENERAL);
		history = new StatsMenuItem(Constants.MENU_HISTORY);
	}
	
	/**
	 * Adds components to the menu
	 */
	private void addComponents() {
		
		add(generalStats, 0);
		add(history, 1);
	}
}
