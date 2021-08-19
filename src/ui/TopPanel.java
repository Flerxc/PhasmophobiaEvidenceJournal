package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import constants.Constants;

/**
 * Top Panel containing a left side panel (buttons) and a right side panel (text)
 * @author Francis Leroux-Contant
 * @version 2021-08-19
 *
 */
public class TopPanel extends JPanel{
	
	/***************
	 *  ATTRIBUTES *
	 ****************/
	
	private JPanel btnPanel;
	private JPanel infoPanel;
	
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

}
