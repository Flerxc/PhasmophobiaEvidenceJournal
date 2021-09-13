package ui;

import javax.swing.JPanel;

/**
 * Main panel containing a top panel and a bottom panel
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 */
public class MyPanel extends JPanel{

	/**************
	 * ATTRIBUTES *
	 **************/
	
	private TopPanel topPanel;
	private BottomPanel bottomPanel;
	
	/**
	 * Default constructor
	 */
	public MyPanel() {
		
		super();

		topPanel = new TopPanel();

		bottomPanel = new BottomPanel();

		add(topPanel);
		add(bottomPanel);
	}	
	
	/**
	 * Resets the top panel
	 */
	public void reset() {
		topPanel.reset();
	}
}
