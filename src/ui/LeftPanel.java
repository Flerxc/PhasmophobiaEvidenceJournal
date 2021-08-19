package ui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants;

/**
 * Left panel containing all the evidence buttons
 * @author Francis Leroux-Contant
 * @version 2021-05-22
 */
public class LeftPanel extends JPanel{
	
	/***************
	 *  ATTRIBUTES *
	 ****************/
	private JButton btnEMF;
	private JButton btnFingerprints;
	private JButton btnFreezing;
	private JButton btnOrb;
	private JButton btnWriting;
	private JButton btnBox;
	

	/**
	 * Default constructor
	 */
	public LeftPanel() {
		super();

		// Initialize buttons
		initButtons();

		// Adds a rigid area to the panel to center the buttons
		add(Box.createRigidArea(Constants.BIG_RIGID_AREA_DIM));
		
		// Adds the button to the panel
		addButtons();
		
		// Sets the layout and the alignment
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	/**
	 * Initialize all the buttons
	 */
	private void initButtons() {
		
		btnEMF = new EvidenceButton(Constants.EMF_TEXT);
		btnFingerprints = new EvidenceButton(Constants.FINGERPRINTS_TEXT);
		btnFreezing = new EvidenceButton(Constants.FREEZING_TEXT);
		btnOrb = new EvidenceButton(Constants.ORB_TEXT);
		btnWriting = new EvidenceButton(Constants.WRITING_TEXT);
		btnBox = new EvidenceButton(Constants.BOX_TEXT);
	
	}


	/**
	 * Adds all the buttons to the panel with a RigidArea of 
	 * Dimension smallRigidAreaDim between them
	 */
	private void addButtons() {
		
		add(btnEMF);
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnFingerprints);
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnFreezing);
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnOrb);
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnWriting);
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnBox);
	}
}
