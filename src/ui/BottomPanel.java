package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * Bottom Panel containing a button to save the game in the database 
 * @author Francis Leroux-Contant
 * @version 2021-08-19
 *
 */
public class BottomPanel extends JPanel{

	/***************
	 *  ATTRIBUTES *
	 ****************/
	
	private JButton btn;
	
	/**
	 * Default constructor
	 */
	public BottomPanel() {
		
		super();
		
		btn = new JButton("GUESS");
		btn.addActionListener(new ButtonListener());
		
		add(btn);
		

		btn.setPreferredSize(Constants.BUTTON_SIZE);
		setPreferredSize(Constants.BOT_PANEL_SIZE);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(PhasmophobiaManager.possibleGhosts.size()==1) {
				
				String ghostType = "Is your ghost a " + PhasmophobiaManager.possibleGhosts.get(0).getGhostName() + "?";
				if(JOptionPane.showConfirmDialog(null, ghostType, "Take a guess!", 
												JOptionPane.YES_NO_OPTION) ==  
												JOptionPane.YES_OPTION) {
					System.out.println("RIGHT");
					// TODO ADD TO DB
					
				}else {
					System.out.println("WRONG");
					new WrongGhostFrame();
				}
				
			}else {
				JOptionPane.showMessageDialog(new JFrame(), 
						"You need exactly ONE possible ghosts!", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}		
	}
}
