package data;
import java.util.ArrayList;
import java.util.Collections;

import constants.Constants;

/**
 * Class representing a ghost in the game Phasmophobia
 * @author Francis Leroux-Contant
 * @version 2021-05-22
 */
public class Ghost {

	/**************
	 * ATTRIBUTES *
	 **************/
	
	private ArrayList<Evidence> evidences;
	private int ghostId;
	private String ghostName;
	
	/****************
	 * CONSTRUCTORS *
	 ****************/
	
	/**
	 * Default Constructor
	 */
	public Ghost() {
		
		initGhost(new ArrayList<Evidence>(),
				Constants.INVALID_GHOST_ID, 
				Constants.INVALID_GHOST_NAME);
	}
	
	/**
	 * Parameters constructor
	 * @param evidences the evidence list
	 * @param ghostId the ghost id
	 * @param ghostName the ghost name
	 */
	public Ghost(ArrayList<Evidence> evidences, int ghostId, 
				 String ghostName) {
		
		initGhost(evidences, ghostId, ghostName);
	}
	
	public Ghost(Ghost g) {
		
		initGhost(g.evidences, g.ghostId, g.ghostName);
	}

	/**
	 * Initialize the attributes
	 * @param evidences the list of evidences
	 * @param ghostId the ghost id
	 * @param ghostName the ghost name
	 */
	private void initGhost(ArrayList<Evidence> evidences, 
						   int ghostId, 
						   String ghostName) {
		
		this.evidences = evidences;
		this.ghostId = ghostId;
		this.ghostName = ghostName;
	}
	
	
	
	/***********
	 * METHODS *
	 ***********/
	
	/**
	 * Adds an evidence to the list
	 * @param e the new element
	 * @throws Exception if the list is full (Constants.MAX_AMOUNT_EVIDENCES)
	 * @throws Exception if the evidence is invalid
	 */
	public void addEvidence(Evidence e) throws Exception{
		
		if(evidences.size() == Constants.MAX_AMOUNT_EVIDENCE) {
			throw new Exception("Evidence list is full");
		}
		
		if(!e.isValid()) {
			throw new Exception("Invalid evidence");
		}
		
		// Adds the evidence to the list
		evidences.add(e);
		
		// Sorts the list
		Collections.sort(evidences);
	}

	/**
	 * Deletes a given element from the list
	 * @param e the element to delete
	 * @throws Exception 
	 */
	public void deleteEvidence(Evidence e) throws Exception {
		
		if(evidences.isEmpty()) {
			throw new Exception("List is empty");
		}
		
		if(!e.isValid()) {
			throw new Exception("Evidence is invalid");
		}
		
		if(!evidences.contains(e)) {
			throw new Exception("Evidence not found in the list");
		}
		
		evidences.remove(e);
	}
	
	/**
	 * Returns if both ghosts are the same
	 * @param g the ghost
	 * @return If both ghosts have the same evidences
	 */
	public boolean equals(Ghost g) {
		
		boolean isSameType = true;
		
		if(bothListsAreFull(g)) {
			
			for(int i = 0; i < evidences.size(); i++) {
				
				if(!evidences.get(i).equals(g.evidences.get(i))) {
					
					isSameType = false;
				}
			}
		}
		
		return (bothListsAreFull(g)) ? 
				isSameType : false;
	}
	

	/**
	 * Checks if the evidence is contained in the list
	 * @param evidence the evidence to check
	 * @return if the evidence is in the list
	 */
	public boolean hasEvidence(Evidence evidence) {
		
		boolean hasEvidence = false;
		
		for(Evidence e : this.evidences) {
			if(e.equals(evidence)) {
				hasEvidence = true;
			}
		}
		
		return hasEvidence;
	}
	
	/**
	 * Checks if two evidence lists are full
	 * @param g ghost to compare
	 * @return if both lists are full or not
	 */
	private boolean bothListsAreFull(Ghost g) {
		
		return listIsFull(this.evidences) && listIsFull(g.evidences);
	}
	

	/**
	 * Checks if a list is full (size == Constants.MAX_AMOUNT_EVIDENCE)
	 *  @param list list to check
	 *  @return if the list is full or not
	 */
	private boolean listIsFull(ArrayList<Evidence> list) {
		return list.size() == Constants.MAX_AMOUNT_EVIDENCE;
	}
	
	
	/**
	 * Formats the attributes as a printable String
	 * @return the attributes formatted as a String
	 */
	public String toString() {
		
		return this.ghostName;
	}
	
	/**
	 * Creates a copy of the ghost
	 * @return A copy of the Ghost
	 */
	public Ghost clone() {
		
		return new Ghost(this);
	}
	
	/***********
	 * GETTERS *
	 ***********/
	
	/**
	 * @return the evidences
	 */
	public ArrayList<Evidence> getEvidences() {
		return evidences;
	}

	/**
	 * @return the ghostId
	 */
	public int getGhostId() {
		return ghostId;
	}

	/**
	 * @return the ghostName
	 */
	public String getGhostName() {
		return ghostName;
	}

	
	/***********
	 * SETTERS *
	 ***********/
	
	/**
	 * @param evidences the evidences to set
	 */
	public void setEvidences(ArrayList<Evidence> evidences) {
		this.evidences = evidences;
	}

	/**
	 * @param ghostId the ghostId to set
	 */
	public void setGhostId(int ghostId) {
		this.ghostId = ghostId;
	}

	/**
	 * @param ghostName the ghostName to set
	 */
	public void setGhostName(String ghostName) {
		this.ghostName = ghostName;
	}
}
