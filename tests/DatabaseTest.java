package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;

import data.Database;

/**
 * Tests for the Database class
 * @author Francis Leroux-Contant
 * @version 2021-09-17
 */
public class DatabaseTest {
	
	@Test
	 public void itShouldConnectToADatabase() {
		 // Arrange
		Database  db =  new Database();
		boolean connEstablished = false; 
		
		 // Act
		 connEstablished = db.connect("test.db");
				 
		 // Assert
		 Assert.assertTrue(connEstablished);
	 }
	
	
	@Test
	 public void itShouldDisconnectFromADatabase() {
		 // Arrange
		Database  db =  new Database();
		boolean disconnected = false; 
		
		 // Act
		 db.connect("test.db");
		 disconnected = db.disconnect();
				 
		 // Assert
		 Assert.assertTrue(disconnected);
	 }
	
	@Test
	public void itShouldCreateATable() {
		 // Arrange
		Database  db =  new Database();
		boolean tableCreated = false; 
		
		 // Act
		 db.connect("test.db");
		 
		 tableCreated = db.createTable("test_ghost");
		 
		 db.disconnect();
				 
		 // Assert
		 Assert.assertTrue(tableCreated);
	}
	
	@Test
	public void itShouldAddRightGhostToDatabase() {
		// Arrange
		Database  db =  new Database();
		db.connect("test.db");
		boolean ghostAdded = false; 
		
		// Act
		ghostAdded = db.addGhost("Spirit", "test_game");
		db.disconnect();
				 
		// Assert
		Assert.assertTrue(ghostAdded);
	}
	
	@Test
	public void itShouldAddWrongGhostToDatabase() {
		// Arrange
		Database  db =  new Database();
		db.connect("test.db");
		boolean ghostAdded = false; 
		
		 // Act
		ghostAdded = db.addGhost("Spirit", "Banshee", "test_game");
		db.disconnect();
				 
		 // Assert
		 Assert.assertTrue(ghostAdded);
	}
	
	@Test
	public void itShouldReadDB() {
		// Arrange
		int i = 0;
		Database  db =  new Database();
		db.connect("test.db");
		boolean readCorrectly = true;
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("Banshee", "Spirit", "12-09-2021", 
																   "Spirit", "Spirit", "12-09-2021", 
																   "Oni", "Hantu", "12-09-2021"));
		// Act
		ResultSet rs = db.readDB("test_read");
				 
		// Assert
		try {
			while(rs.next()) {
				
				if(!(rs.getString("ghost_name").equals(expected.get(i)) 	 &&
				   rs.getString("correct_ghost").equals(expected.get(i + 1)) &&
				   rs.getString("date").equals(expected.get(i + 2)))) {
					
					
					readCorrectly = false;
					
				}
				i+=3;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			db.disconnect();
		}
		
		Assert.assertTrue(readCorrectly);
	}
	
	@Test
	public void itShouldCountTheNumberOfTimeAGhostWasPlayed() {
		// Arrange
		Database  db =  new Database();
		db.connect("test.db");
		boolean countedCorrectly = false;
		
		// Act
		countedCorrectly = db.count("Spirit", "correct_ghost", "test_read") == 2;
				 
		// Assert
		db.disconnect();
		Assert.assertTrue(countedCorrectly);
	}
	
	@Test
	public void itShouldCounWinrate() {
		// Arrange
		Database  db =  new Database();
		db.connect("test.db");
		boolean countedCorrectly = false;
		
		// Act
		countedCorrectly = db.countWinrate("test_read") == 33.33;
		db.disconnect();
		
		// Assert
		
		Assert.assertTrue(countedCorrectly);
	}
	
	@Test
	public void itShouldCountFrequencyGhost(){
		// Arrange
		Database  db =  new Database();
		db.connect("test.db");
		
		// Act
		double correctFrequency = db.frequency("Spirit", "test_read");
		db.disconnect();
		
		// Assert
		
		Assert.assertTrue(correctFrequency == 66.67);
	}
}
