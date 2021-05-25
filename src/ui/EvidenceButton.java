package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import constants.Constants;
import data.Evidence;
import manager.PhasmophobiaManager;

/**
 * Class representing a button that adds an Evidence to the player's ghost
 * or the list of impossible evidences
 * @author Francis Leroux-Contant
 * @version 2021-05-22
 *
 */
public class EvidenceButton extends JButton{

	/**************
	 * ATTRIBUTES *
	 **************/
	
	// If the shift key currently pressed
	private boolean shiftPressed = false;
	
	// If the mouse is in the button
	private boolean mouseIn = false;
	
	// Has the button been clicked
	private int buttonState = Constants.BUTTON_INACTIVE_STATE;
	
	// The evidence corresponding to the button
	private Evidence evidence;
	
	/**
	 * Parameter constructor
	 * @param title the text of the button
	 */
	public EvidenceButton(String title) {
		
		super(title);
		
		this.evidence = new Evidence(title);
		
		setMaximumSize(Constants.BUTTON_SIZE);
		
		addActionListener(new ButtonActionListener());
		
		addKeyListener(new ButtonKeyListener());
		
		addMouseListener(new ButtonMouseListener());
	}
	
	/**
	 * Private class implementing ActionLsitener
	 */
	private class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// If the button is in the inactive state
			if(buttonState == Constants.BUTTON_INACTIVE_STATE) {
				
				// If SHIFT has not been pressed
				if(!shiftPressed) {
					
					try {
						
						// Tries to add the evidence 
						PhasmophobiaManager.addEvidence(evidence);
						
						// Changes the color of the button
						setBackground(Constants.BUTTON_YES_COLOR);
						
						// Sets the state of the button as active
						buttonState = Constants.BUTTON_ACTIVE_STATE;
					} catch (Exception theException) {
						
						// Shows an error message to the user
						JOptionPane.showMessageDialog(new JFrame(), 
								"Too many evidences! Choose maximum 3", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}else if(shiftPressed){ // SHIFT is not pressed

					// Adds the evidence to the list of impossible evidences
					PhasmophobiaManager.addImpossibleEvidence(evidence);
					
					// Changes the color of the button
					setBackground(Constants.BUTTON_NO_COLOR);
					
					// Sets the state of the button as active
					buttonState = Constants.BUTTON_ACTIVE_STATE;
				}
				
			}else { // The button has been activated
				
				// Removes the evidence from...
				if(getBackground().equals(Constants.BUTTON_YES_COLOR)) {
					
					// ... the ghost's evidence list
					PhasmophobiaManager.removeEvidence(evidence);
				}else if(getBackground().equals(Constants.BUTTON_NO_COLOR)) {
					
					// ... the impossible evidences list
					PhasmophobiaManager.removeImpossibleEvidence(evidence);
				}
				
				// Changes the color of the button
				setBackground(Constants.BUTTON_DEFAULT_COLOR);
				
				// Sets the button as inactive
				buttonState = Constants.BUTTON_INACTIVE_STATE;
			}
			
			// Tells the RightPanel something has changed
			RightPanel.update();
		}
	}
	
	/**
	 * Private class implementing KeyListener
	 */
	private class ButtonKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) { /* DO NOTHING */ }

		@Override
		public void keyPressed(KeyEvent e) {
			
			// If SHIFT is pressed and the mouse is in the button, 
			// sets shiftPressed to true
			if(e.getKeyCode() == KeyEvent.VK_SHIFT && mouseIn) {
				
				shiftPressed = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			// If SHIFT is released, sets shiftPressed to false
			if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
				
				shiftPressed = false;
			}
		}
	}

	/**
	 * Private class extending MouseAdapter
	 */
	private class ButtonMouseListener extends MouseAdapter{
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
			// When the mouse enters, cancel the shiftPressed no matter what
			shiftPressed = false;
			
			mouseIn = true;
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
			mouseIn = false;
		}
	}
}
