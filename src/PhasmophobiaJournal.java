import javax.swing.SwingUtilities;

import ui.MyFrame;

/**
 * Main class
 * @author Francis Leroux-Contant
 * @version 2021-03-25
 */
public class PhasmophobiaJournal {

	public static void main(String[] args) {

		Runnable prog = new MyFrame("Phasmophobia Evidence Journal");
		
		SwingUtilities.invokeLater(prog);	
	}
}
