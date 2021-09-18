package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * Frame containing a combobox and a submit button to choose the right ghost if
 * the player is wrong
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 *
 */
public class WrongGhostFrame extends AbstractFrame{

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
		
		super(Constants.SMALL_SECONDARY_FRAME_SIZE);
	}

	
	/**
	 * Initialize the frame's components
	 */
	protected void initComponents() {

		panel = new JPanel();
		setContentPane(panel);
		
		label = new JLabel(Constants.WHAT_IS_GHOST);
		
		combobox = new JComboBox<String>(getGhostTypes());
		
		submitBtn = new JButton (Constants.BUTTON_SUBMIT);
		submitBtn.addActionListener(new ButtonListener());	
	}

	/**
	 * Adds the frame's components
	 */
	protected void addComponents() {

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
			
			MyFrame.reset();
			dispose();
		}
		
	}
}

