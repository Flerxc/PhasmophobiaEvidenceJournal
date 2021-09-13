package manager;

import java.util.ArrayList;

import constants.Constants;
import data.*;

/**
 * Manipulates the data to find the possible ghost
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 */
public class PhasmophobiaManager {

	@SuppressWarnings("unchecked")
	// Possible ghosts considering current possible and impossible evidences
	public static ArrayList<Ghost> possibleGhosts = 
			(ArrayList<Ghost>) Constants.ALL_GHOSTS.clone();
	
	// The ghost the player is hunting
	private static Ghost ghost = new Ghost();
	
	// A list containing all evidences the player thinks are impossible
	private static ArrayList<Evidence> impossibleEvidences = new ArrayList<>();
	
	public static Database db = new Database();
	
	
	/**
	 * Adds an evidence to the ghost then updates the list of possible ghosts
	 * @param evidence an evidence to add
	 * @throws Exception if there is a problem while adding the evidence
	 */
	public static void addEvidence(Evidence evidence) throws Exception{

		ghost.addEvidence(evidence);
		update();
	}

	@SuppressWarnings("unchecked")
	/**
	 * Updates the list of possible ghosts
	 */
	private static void update() {
		
		// Recreates the list of possible ghosts
		possibleGhosts = (ArrayList<Ghost>) Constants.ALL_GHOSTS.clone();
		
		// Removes impossible ghosts from the possible ghost list
		removeGhostsFromPossible(findGhostsToRemove());
	}
	
	/**
	 * Removes a list of ghosts from the list of possible ghosts
	 * @param ghosts a list of ghosts to remove from the list
	 */
	private static void removeGhostsFromPossible(ArrayList<Ghost> ghosts) {
		
		for (Ghost g : ghosts) {
			
			possibleGhosts.remove(g);
		}
	}
	
	/**
	 * Finds the ghosts that need to be removed from the list of possible ghosts
	 * @return a list of ghosts to remove
	 */
	private static ArrayList<Ghost> findGhostsToRemove(){
		
		ArrayList<Ghost> ghostsToRemove = new ArrayList<>();
		
		// For each ghost in possibleGhosts
		for (int i = 0; i < possibleGhosts.size(); i++) {
			
			Ghost g = possibleGhosts.get(i);
			
			// Check if the ghost has an impossible evidence
			for(Evidence e : impossibleEvidences) {
				
				if(g.hasEvidence(e)) {
					
					ghostsToRemove.add(g);
				}
			}
			
			/**
			 * Check if the ghost in the list does not have one of the evidences
			 * of the player's ghost
			 **/
			for(Evidence e : ghost.getEvidences()) {
				
				if(!g.hasEvidence(e)) {
					
					ghostsToRemove.add(g);
				}
			}
		}
		
		return ghostsToRemove;
	}
	

	
	/**
	 * Removes an evidence from the player's ghost, then updates the list
	 * @param evidence and evidence to remove
	 */
	public static void removeEvidence(Evidence evidence) {
		
		try{
			
			ghost.deleteEvidence(evidence);
			
			update();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Adds an evidence to the list of impossible evidences
	 * @param evidence the evidence to add
	 */
	public static void addImpossibleEvidence(Evidence evidence) {
		
		impossibleEvidences.add(evidence);
		
		update();
	}

	/**
	 * Removes an impossible evidence from the list then updates
	 * @param evidence the evidence to remove
	 */
	public static void removeImpossibleEvidence(Evidence evidence) {
	
		impossibleEvidences.remove(evidence);
		update();
	}
	
	/**
	 * Resets important data
	 */
	@SuppressWarnings("unchecked")
	public static void reset() {
		possibleGhosts = 
				(ArrayList<Ghost>) Constants.ALL_GHOSTS.clone();
		impossibleEvidences = new ArrayList<Evidence>();
		ghost = new Ghost();
		
	}
}
