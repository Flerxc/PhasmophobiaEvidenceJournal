package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Ghost;
import manager.PhasmophobiaManager;

/**
 * Right panel containing the list of possible ghosts
 * @author Francis Leroux-Contant
 * @version 2021-05-22
 */
public class RightPanel extends JPanel{

	/**************
	 * ATTRIBUTES *
	 **************/
	private static JLabel label;

	public RightPanel() {
		
		label = new JLabel("");
		label.setFont(new Font("Arial", Font.PLAIN, 24));
		label.setForeground(Color.BLACK);
		
		setLayout(new GridBagLayout());
		
		add(label);
		
		update();
	}
	
	/**
	 * Updates the label to fit the updated list of possible ghosts from
	 * the controller
	 */
	public static void update() {
		
		/**
		* It is possible to creates new lines in the JLabel by 
		* formating the string as HTML. Center the text with the "body" tag
		* Inspired by : 
		* http://www.java2s.com/Tutorial/Java/0240__Swing/MultilinelabelHTML.htm
		*/
		String str  = "<html><body style='text-align: center'>";
		
		for (Ghost g : PhasmophobiaManager.possibleGhosts) {
			
			str+= g.toString() + "<br>";
		}
		
		label.setText(str);
	}
}
