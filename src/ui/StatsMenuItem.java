package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * A simple menu item with an action listener. Will open a frame depending on 
 * menu item text.
 * @author Francis Leroux-Contant
 * @version 2021-09-18
 */
public class StatsMenuItem extends JMenuItem{
	
	/**
	 * Parameter constructor
	 * @param title the item's text
	 */
	public StatsMenuItem(String title) {
		
		super(title);
		
		addActionListener(new MenuItemActionListener());
	}
	
	// Private class to open a new frame depending on the menu choosen
	private class MenuItemActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { 
			
			
			if(PhasmophobiaManager.db.getTotalGame(Constants.TABLE_NAME) == 0) {
				JOptionPane.showMessageDialog(new JFrame(), 
						Constants.DATABASE_EMPTY_MSG, Constants.ERROR_MSG,
						JOptionPane.WARNING_MESSAGE);
			}else {
				
				switch (getText()){
				
				case Constants.MENU_GENERAL: new StatFrame(); break;
				
				case Constants.MENU_HISTORY: new HistoryFrame(); break;
				
				default : /*DO NOTHING*/ break;
				}
			}	
		}
	}
}
