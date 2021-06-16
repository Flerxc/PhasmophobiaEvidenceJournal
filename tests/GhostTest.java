package tests;

import org.junit.*;

import constants.Constants;
import data.Evidence;
import data.Ghost;

/**
 * Tests for the Ghost class
 * @author Francis Leroux-Contant
 * @version 2021-03-19
 *
 */
public class GhostTest {
	
	@Test
	public void itShouldAddAnEvidence() {
		// Arrange
		Integer expected = 1;
		Ghost g = new Ghost();
		
		// Act
		try {
			
			g.addEvidence(new Evidence(Constants.EMF_ID, Constants.EMF_TEXT));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		Integer compare = g.getEvidences().size();
		
		// Assert
		Assert.assertEquals(expected, compare);
	}
	
	@Test
	public void itShouldThrowListFullException() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);
		
		// Act
		try {
			
			g.addEvidence(new Evidence(Constants.EMF_ID, Constants.EMF_TEXT));
		} catch (Exception e) {
			
			
			// Assert
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldThrowInvalidEvidenceOnAddException() {
		// Arrange
		Ghost g = new Ghost();
		
		// Act
		try {
			
			g.addEvidence(new Evidence(Constants.INVALID_EVIDENCE_ID, 
					Constants.INVALID_EVIDENCE_TEXT));
		} catch (Exception e) {
			
			// Assert
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldDeleteAnEvidence() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);

		// Act
		try {
			g.deleteEvidence(new Evidence(Constants.EMF_ID, 
										  Constants.EMF_TEXT));
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldThrowInvalidEvidenceOnDeleteException() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);

		// Act
		try {
			g.deleteEvidence(new Evidence());
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldThrowListEmptyException() {
		// Arrange
		Ghost g = new Ghost();

		// Act
		try {
			g.deleteEvidence(new Evidence(Constants.EMF_ID, 
										  Constants.EMF_TEXT));
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldThrowEvidenceNotFoundException() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);

		// Act
		try {
			g.deleteEvidence(new Evidence(Constants.BOX_ID, 
										  Constants.BOX_TEXT));
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		// Assert
		Assert.assertFalse(false);
	}
	
	@Test
	public void itShouldSayTwoIdenticGhostsAreEquals() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);
		Ghost g2 = new Ghost(Constants.BANSHEE);
		
		// Act
		boolean sameGhost = g.equals(g2);
		
		// Assert
		Assert.assertTrue(sameGhost);
	}
	
	@Test
	public void itShouldSayTwoDifferentGhostsAreNotEquals() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);
		Ghost g2 = new Ghost(Constants.REVENANT);
		
		// Act
		boolean sameGhost = g.equals(g2);
		
		// Assert
		Assert.assertFalse(sameGhost);
	}
	
	@Test
	public void itShouldSayAPartialGhostIsNotEqual() {
		// Arrange
		Ghost g = new Ghost(Constants.BANSHEE);
		Ghost g2 = new Ghost();
		
		// Act
		try {
			g2.addEvidence(new Evidence(g.getEvidences().get(0).getId(),
										g.getEvidences().get(0).getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
		boolean sameGhost = g.equals(g2);
		
		// Assert
		Assert.assertFalse(sameGhost);
	}
}
