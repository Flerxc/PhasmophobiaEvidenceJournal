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
 * @version 2021-09-12
 *
 */
public class BottomPanel extends JPanel{

	/***************
	 *  ATTRIBUTES *
	 ****************/
	
	private JButton btnGuess;
	private JButton btnClear;
	
	/**
	 * Default constructor
	 */
	public BottomPanel() {
		
		super();
		
		btnGuess = new JButton(Constants.BUTTON_GUESS);
		btnGuess.addActionListener(new ButtonListener());
		
		btnClear = new JButton (Constants.BUTTON_CLEAR);
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.reset();
				
			}
		});
		
		add(btnGuess);
		add(btnClear);
		
		

		btnGuess.setPreferredSize(Constants.BUTTON_SIZE);
		btnClear.setPreferredSize(Constants.BUTTON_SIZE);
		setPreferredSize(Constants.BOT_PANEL_SIZE);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(PhasmophobiaManager.possibleGhosts.size() == 1) {
				
				String ghostType = Constants.IS_YOUR_GHOST_A_MSG 
						+ PhasmophobiaManager.possibleGhosts.get(0).getGhostName() 
						+ Constants.QUESTION_MARK;
				if(JOptionPane.showConfirmDialog(null, ghostType, Constants.TAKE_A_GUESS, 
												JOptionPane.YES_NO_OPTION) ==  
												JOptionPane.YES_OPTION) {
					System.out.println("RIGHT");
				
					PhasmophobiaManager.db.addGhost(PhasmophobiaManager.possibleGhosts.get(0).getGhostName(),
														 Constants.TABLE_NAME);
			
					MyFrame.reset();
				}else {
					
					new WrongGhostFrame();
				}
				
			}else {
				JOptionPane.showMessageDialog(new JFrame(), 
						Constants.TOO_MANY_GHOSTS_MSG, Constants.ERROR_MSG,
						JOptionPane.WARNING_MESSAGE);
			}
		}		
	}
}
