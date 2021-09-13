package ui;


import javax.swing.JFrame;
import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * Main frame of the program. Gets called by SwingUtilities.invokeLater()
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 */
public class MyFrame extends JFrame implements Runnable {
	
	private static MyPanel panel;
	/**
	 * Parameter constructor
	 * @param title the title of the frame
	 */
	public MyFrame(String title) {
		
		super(title);
		panel = new MyPanel();
	}
	
	@Override
	/**
	 * Implementation of run() from the Runnable interface
	 */
	public void run() {
		
		PhasmophobiaManager.db.connect(Constants.DATABASE_NAME);
		
		setContentPane(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(Constants.MAX_SCREEN_SIZE);
		
		setResizable(false);
	
		// Sets the frame in the middle of the screen
		setLocation(Constants.ACTUAL_SCREEN_SIZE.width / 2 - getSize().width / 2, 
					Constants.ACTUAL_SCREEN_SIZE.height / 2 - getSize().height / 2);
		
		setVisible(true);
	}
	
	
	/**
	 * Resets the top panel and the manager
	 */
	public static void reset() {

		PhasmophobiaManager.reset();
		panel.reset();
	}
}
