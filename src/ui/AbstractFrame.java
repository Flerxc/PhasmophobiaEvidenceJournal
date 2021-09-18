package ui;

import java.awt.Dimension;

import javax.swing.JFrame;

import constants.Constants;

/**
 * Abstract class for all secondary frames
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 */
public abstract class AbstractFrame extends JFrame {

	/**
	 * Parameter constructor
	 * @param size the frame's size
	 */
	public AbstractFrame(Dimension size) {
		
		super();
		
		initFrame(size);
	
		initComponents();

		addComponents();

		setVisible(true);	
	}

	

	/**
	 * Initialize the frame
	 */
	protected void initFrame(Dimension size) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setSize(size);
		
		setResizable(false);
		
		// Sets the frame in the middle of the screen
		setLocation(Constants.ACTUAL_SCREEN_SIZE.width / 2 - getSize().width / 2, 
					Constants.ACTUAL_SCREEN_SIZE.height / 2 - getSize().height / 2);
	}
	
	/**
	 * Initialize the frame's components
	 */
	abstract void initComponents();

	/**
	 * Adds the frame's components
	 */
	abstract void addComponents();
}
