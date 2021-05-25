package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Main panel containing a left side (buttons) and a right side (text)
 * @author Francis Leroux-Contant
 * @version 2021-03-19
 */
public class MyPanel extends JPanel{

	/**************
	 * ATTRIBUTES *
	 **************/
	
	private JPanel btnPanel;
	private JPanel infoPanel;
	
	/**
	 * Default constructor
	 */
	public MyPanel() {
		
		super();
		
		btnPanel = new LeftPanel();
		infoPanel = new RightPanel();
		
		setLayout(new GridLayout(1, 2));
		
		add(btnPanel);
		add(infoPanel);
	}	
}
