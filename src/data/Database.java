package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import constants.Constants;


/**
 * Methods for the app local SQLite database
 * @author Francis Leroux-Contant
 * @version 2021-09-12
 */
public class Database {
	
	private Connection conn;
	
	/**
	 * Default constructor
	 */
	public Database() {
		
		this.conn = null;
	}

	
	/**
	 * Connects to a SQLite database with the name given by database.
	 * @param database the name of the database
	 * @return true if the connection is established
	 */
	public boolean connect(String database) {
		
		boolean connectionEstablished = false;
		
		if(conn == null) {
			try {

				conn = DriverManager.getConnection("jdbc:sqlite:" + database);
				conn.setAutoCommit(true);
				connectionEstablished = true;
				// For debug purposes
				System.out.println("Connection to database has been established");
				

			}catch(SQLException  e) {
				
				System.out.println(e.getMessage());
			} 
		}

		return connectionEstablished;
	}

	
	/**
	 * Disconnects the current database connection
	 * @return true if the connection is closed without problems
	 */
	public boolean disconnect() {
		
		boolean connectionClosed = false;
		
		//  If the connection exists, closes it
		if(conn != null) {
			try {
				
				
				conn.close();
				connectionClosed = true;
				
				// For debug purposes
				System.out.println("Connection closed");
				
			}catch (SQLException ex) {
				
				System.out.println(ex.getMessage());
			}
		}

		return connectionClosed;
	}

	
	/**
	 * Adds a ghost correctly identified by the player to the database
	 * @param ghostType the ghost type
	 * @param tableName the name of the table the ghost will be added to
	 * @return true if the operation was a success
	 */
	public boolean addGhost(String ghostType, String tableName) {
		return addGhost(ghostType,ghostType, tableName);
	}
	
	/**
	 * Adds a ghost identified by the player to the database
	 * @param ghostType the ghost type
	 * @param correctGhost the correct ghost type
	 * @param tableName the name of the table the ghost will be added to
	 * @return true if the operation was a success
	 */
	public boolean addGhost(String ghostType, String correctGhost, String tableName) {
		String sql = Constants.INSERT_STATEMENT + tableName + Constants.INSERT_COLUMNS;
		
		boolean ghostAdded = false;
		if(createTable(tableName)) {
			try {
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ghostType);
				pstmt.setString(2, correctGhost);
				pstmt.setString(3, getDate());
				pstmt.executeUpdate();
				ghostAdded = true;
				
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return ghostAdded;
	}
	
	/**
	 * Creates a table called tableName in the database if it doesn't already exist
	 * @param tableName the name of the table to create
	 * @return true if the operation was a success
	 */
	public boolean createTable(String tableName) {
	
		boolean tableCreated = false;
		try {
			
			Statement stmt = conn.createStatement();
			stmt.execute(Constants.CREATE_TABLE + tableName + Constants.TABLE_COLUMNS);
			tableCreated = true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tableCreated;
	}
	
	
	/**
	 * Returns today's date in the dd-MM-yyyy format
	 * @return today's date.
	 */
	private String getDate() {
		
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
}
