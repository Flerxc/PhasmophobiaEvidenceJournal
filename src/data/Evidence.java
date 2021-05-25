package data;

import constants.Constants;

/**
 * Class representing an Evidence in the game Phasmophobia
 * @author Francis Leroux-Contant
 * @version  2021-05-22
 */
public class Evidence implements Comparable<Object> {
	
	/**************
	 * ATTRIBUTES *
	 **************/
	
	private int id;
	private String text;
	
	/**
	 * Default constructor
	 */
	public Evidence() {
		
		initEvidence(Constants.INVALID_EVIDENCE_ID, 
					 Constants.INVALID_EVIDENCE_TEXT);
	}
	/**
	 * Parameter constructor
	 * @param id The id of the evidence
	 * @param text The text of the evidence
	 */
	public Evidence(int id, String text) {
		
		initEvidence(id, text);
	}
	
	/**
	 * Parameter constructor
	 * @param text the text of the evidence
	 */
	public Evidence(String text) {
		
		// Finds the id corresponding to the text, then initialize the evidence
		for(Evidence e : Constants.ALL_EVIDENCES) {
			
			if(text.equals(e.getText())) {
				
				initEvidence(e.getId(), text);
			}
		}
	}

	/**
	 * Initialize the attributes
	 * @param id The id
	 * @param text The text
	 */
	private void initEvidence(int id, String text) {
		
		this.id = id;
		this.text = text;
	}
	
	/**
	 * Check if the evidence id is valid
	 * @return if the evidence is valid
	 */
	public boolean isValid() {
		
		return id != Constants.INVALID_EVIDENCE_ID;
	}
	
	/**
	 * Compares two evidences
	 * @param e the other evidence
	 * @return the difference between both evidences IDs
	 */
	@Override
	public int compareTo(Object e) {
		
		int compareId = ((Evidence) e).getId();
		
		return this.id - compareId;
	}
	
	/**
	 * Returns the attributes as a String
	 */
	public String toString() {
		return "ID: " + id + " Text: " + text;
	}
	
	
	/**
	 * Returns a new instance of this Evidence
	 */
	public Evidence clone() {
		
		return new Evidence(id, text);
	}
	
	/**
	 * Check if this evidence is the same as another one
	 * @param e the evidence to compare
	 * @return If the evidences are equals or not
	 */
	public boolean equals(Evidence e) {
		
		return this.id == e.id;
	}
	
	/************
	 *  GETTERS *
	 ************/
	
	/**
	 * Access to the id attribute
	 * @return the id attribute
	 */
	public int getId() {
		
		return id;
	}

	/**
	 * Access the text attribute
	 * @return the text attribute
	 */
	public String getText() {
		
		return text;
	}

	/***********
	 * SETTERS *
	 ***********/
	
	/**
	 * Sets the id attribute to a new value
	 * @param id the new value of id
	 */
	public void setId(int id) {
		
		this.id = id;
	}
	
	/**
	 * Sets the text attribute to a new value
	 * @param text the new value of text
	 */
	public void setText(String text) {
		
		this.text = text;
	}
}