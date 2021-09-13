package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * Frame containing a combobox and a submit button to choose the right ghost if
 * the player is wrong
 * @author Francis Leroux-Contant
 * @version 2021-08-19
 *
 */
public class WrongGhostFrame extends JFrame{

	/*************
	 * ATTRIBUTES *
	 *************/
	
	private JPanel panel;
	private JLabel label;
	private JComboBox<String> combobox;
	private JButton submitBtn;
	
	/**
	 * Default constructor
	 */
	public WrongGhostFrame() {
		
		super();
		
		initFrame();
	
		initComponents();

		addComponents();

		setVisible(true);	
	}

	

	/**
	 * Initialize the frame
	 */
	private void initFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(Constants.WRONG_GHOST_FRAME_SIZE);
		
		setResizable(false);
		
		// Sets the frame in the middle of the screen
		setLocation(Constants.ACTUAL_SCREEN_SIZE.width / 2 - getSize().width / 2, 
					Constants.ACTUAL_SCREEN_SIZE.height / 2 - getSize().height / 2);
	}
	
	/**
	 * Initialize the frame's components
	 */
	private void initComponents() {

		panel = new JPanel();
		setContentPane(panel);
		
		label = new JLabel("What is the right ghost?");
		
		combobox = new JComboBox<String>(getGhostTypes());
		
		submitBtn = new JButton ("Submit");
		submitBtn.addActionListener(new ButtonListener());	
	}

	/**
	 * Adds the frame's components
	 */
	private void addComponents() {

		add(label);
		add(combobox);
		add(submitBtn);
	}


	private String[] getGhostTypes() {
		String[] ghosts = new String[Constants.ALL_GHOSTS.size()];
		
		for(int i= 0; i< Constants.ALL_GHOSTS.size(); i++) {
			ghosts[i] = Constants.ALL_GHOSTS.get(i).getGhostName();
		}
		return ghosts;
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String ghostType = (String) combobox.getSelectedItem();
			
			PhasmophobiaManager.db.addGhost(PhasmophobiaManager.possibleGhosts.get(0).getGhostName(), 
					ghostType, 
					Constants.TABLE_NAME);
			System.out.println(ghostType);
			
			dispose();
		}
		
	}
}

