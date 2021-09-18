package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import constants.Constants;

/**
 * A simple menu item with an action listener. Will open a frame depending on 
 * menu item text.
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 */
public class StatsMenuItem extends JMenuItem{
	
	public StatsMenuItem(String title) {
		super(title);
		
		addActionListener(new MenuItemActionListener());
	}
	
	private class MenuItemActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (getText()){
			case Constants.MENU_GENERAL: System.out.println("GENERAL"); new StatFrame(); break;
			case Constants.MENU_HISTORY: System.out.println("HISTORY");/*TODO history  frame*/ break;
			default : System.out.println("DEFAULT"); break;
			}
			
		}
		
	}

}
