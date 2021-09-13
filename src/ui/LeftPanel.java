package ui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import constants.Constants;

/**
 * Left panel containing all the evidence buttons
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 */
public class LeftPanel extends JPanel{
	
	/***************
	 *  ATTRIBUTES *
	 ****************/
	private EvidenceButton btnEMF;
	private EvidenceButton btnFingerprints;
	private EvidenceButton btnFreezing;
	private EvidenceButton btnOrb;
	private EvidenceButton btnWriting;
	private EvidenceButton btnBox;
	private EvidenceButton btnDots;
	

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
		btnDots = new EvidenceButton(Constants.DOTS_TEXT);
	
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
		add(Box.createRigidArea(Constants.SMALL_RIGID_AREA_DIM));
		
		add(btnDots);
	}
	
	/**
	 * Resets every evidence button
	 */
	public void reset() {
		btnEMF.reset();
		btnFingerprints.reset();
		btnFreezing.reset();
		btnOrb.reset();
		btnWriting.reset();
		btnBox.reset();
		btnDots.reset();
	}
}
