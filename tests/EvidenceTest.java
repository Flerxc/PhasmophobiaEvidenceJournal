package tests;

import org.junit.*;

import constants.Constants;
import data.Evidence;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Evidence class
 * @author Francis Leroux-Contant
 * @version 2021-05-22
 *
 */
public class EvidenceTest {

	 @Test
	 public void itShouldCompareSameEvidences() {
		 // Arrange
		 Integer expected = 0;
		 Evidence e = new Evidence(Constants.EMF_ID, Constants.EMF_TEXT);
		 
		 // Act
		 Integer compare = e.compareTo(new Evidence(Constants.EMF_ID, 
				 								    Constants.EMF_TEXT));
				 
		 // Assert
		 assertEquals(expected, compare);
	 }
	 
	 @Test
	 public void itShouldCompareDifferentEvidences() {
		 // Arrange
		 Integer expected = Constants.EMF_ID - Constants.BOX_ID;
		 Evidence e = new Evidence(Constants.EMF_ID, Constants.EMF_TEXT);
		 
		 // Act
		 Integer compare = e.compareTo(new Evidence(Constants.BOX_ID, 
				 								    Constants.BOX_TEXT));
				 
		 // Assert
		 assertEquals(expected, compare);
	 }
	 
	 @Test
	 public void itShouldCreateAnEvidenceWithTextOnly() {
		 // Arrange
		 Evidence expected = Constants.EMF;
		 Evidence e = new Evidence(Constants.EMF_TEXT);
		 
		 // Act
		 boolean compare = e.equals(expected);
				 
		 // Assert
		 Assert.assertTrue(compare);
	 }
	
}
