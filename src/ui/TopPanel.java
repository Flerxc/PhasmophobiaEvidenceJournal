package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import constants.Constants;

/**
 * Top Panel containing a left side panel (buttons) and a right side panel (text)
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 *
 */
public class TopPanel extends JPanel{
	
	/***************
	 *  ATTRIBUTES *
	 ****************/
	
	private LeftPanel btnPanel;
	private RightPanel infoPanel;
	
	/**
	 * Default constructor
	 */
	public TopPanel() {
		
		super();
		
		btnPanel = new LeftPanel();
		infoPanel = new RightPanel();
		
		setLayout(new GridLayout(1,2));
		
		add(btnPanel);
		add(infoPanel);
		
		setPreferredSize(Constants.TOP_PANEL_SIZE);
	}

	/**
	 * resets both panels
	 */
	public void reset() {
		btnPanel.reset();
		infoPanel.reset();
	}
}
