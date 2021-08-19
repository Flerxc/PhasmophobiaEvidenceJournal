package ui;

import javax.swing.JPanel;

/**
 * Main panel containing a top panel and a bottom panel
 * @author Francis Leroux-Contant
 * @version 2021-08-19
 */
public class MyPanel extends JPanel{

	/**************
	 * ATTRIBUTES *
	 **************/
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	
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
}
