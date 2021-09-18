package ui;


import javax.swing.JScrollPane;
import javax.swing.JTable;

import constants.Constants;

/**
 * A menu frame for the history sub menu
 * @author Francis Leroux-Contant
 * @version 2021-09-18
 *
 */
public class HistoryFrame extends AbstractFrame{

	/**************
	 * ATTRIBUTES *
	 **************/
	private JScrollPane panel;
	
	/**
	 * Default constructor
	 */
	public HistoryFrame() {
		super(Constants.BIG_SECONDARY_FRAME_SIZE);
	}

	/**
	 * Initialize components
	 */
	@Override
	void initComponents() {

		panel = new JScrollPane(new JTable(new GameTable()));	
	}

	/**
	 * Adds components to the frame
	 */
	@Override
	void addComponents() {
		
		add(panel);
	}
	

}
