package ui;


import javax.swing.JFrame;
import constants.Constants;

/**
 * Main frame of the program. Gets called by SwingUtilities.invokeLater()
 * @author Francis Leroux-Contant
 * @version 2021-03-19
 */
public class MyFrame extends JFrame implements Runnable {
	

	
	/**
	 * Parameter constructor
	 * @param title the title of the frame
	 */
	public MyFrame(String title) {
		
		super(title);
	}
	
	@Override
	/**
	 * Implementation of run() from the Runnable interface
	 */
	public void run() {
		
		setContentPane(new MyPanel());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(Constants.maxSize);
		
		setResizable(false);
	
		// Sets the frame in the middle of the screen
		setLocation(Constants.screenSize.width / 2 - getSize().width / 2, 
					Constants.screenSize.height / 2 - getSize().height / 2);
		
		setVisible(true);
	}
}
