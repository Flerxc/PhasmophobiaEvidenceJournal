package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Methods for the app local SQLite database
 * @author Francis Leroux-Contant
 * @version 2021-09-17
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

		boolean ghostAdded = false;
		if(createTable(tableName)) {
			try {
				
				PreparedStatement pstmt = conn.prepareStatement(
											"INSERT INTO " +
											tableName +
											" (ghost_type,correct_ghost,date)" + 
											" VALUES(?,?,?)"
										);
				
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
			stmt.execute(
						  "CREATE TABLE IF NOT EXISTS " 
						  + tableName 
						  +	" (\n"
						  + " game_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
						  + " ghost_type TEXT NOT NULL,\n"
						  + " correct_ghost TEXT NOT NULL,\n"
						  + " date TEXT NOT NULL\n"
						  + ");"
					  );
			tableCreated = true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return tableCreated;
	}
	
	/**
	 * Reads the table given by table_name 
	 * @param table_name the name of the table to read
	 * @return the ResulSet read in the database
	 */
	public ResultSet readDB(String tableName) {
		
		ResultSet rs = null;
		try {
			
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	/**
	 * Counts the ammount of time a certain ghost appears in the given column
	 * @param ghost the ghost type
	 * @param column the column
	 * @param tableName the table to read from
	 * @return the ammount of time the ghost appears in the database in the column
	 */
	public int count(String ghost, String column, String tableName) {
		int count = countGeneric("SELECT count(" 
							+ column 
							+ ") as total FROM " 
							+ tableName 
							+ " WHERE " + column + " = '" + ghost + "';"
						);
		
		return count;
	}


	/**
	 * Counts the percentage of time the value of the ghost_type column = the value of the correct_ghost column.
	 * @param tableName The table to read the data from
	 * @return The percentage of game that were won by the user (winrate)
	 */
	public double countWinrate(String tableName) {

		int gameCount = getTotalGame(tableName);
		double winrate = 0.0;
		
		if(gameCount > 0) {
			
			int winCount = countGeneric("SELECT count(*) as total FROM " + 
								    tableName + 
								    " WHERE correct_ghost = ghost_name;");
			
			winrate = ((double)winCount / (double)gameCount * 100.0);
		}
		
		return Math.round(winrate * 100.0) / 100.;
	}
	
	/**
	 * Counts the frequency a ghost type is played against
	 * @param ghost the type of ghost to count
	 * @param tableName the table to read
	 * @return the frequency the player has seen the ghost
	 */
	public double frequency(String ghost, String tableName) {
		
		double frequency = (double)count(ghost, "correct_ghost", tableName) / (double)getTotalGame(tableName) * 100.0;
		return Math.round(frequency * 100.0) / 100.0;
	}
	
	/**
	 * Counts the total number of games played.
	 * @param tableName
	 * @return
	 */
	public int getTotalGame(String tableName) {
		return countGeneric("SELECT count(*) as total FROM " + 
				 tableName + ";");
	}
	
	/**
	 * Runs a sql query to count the number of time x value appears in y column
	 * @param sql the sql query to run
	 * @return the count
	 */
	private int countGeneric(String sql){
		
		int count = 0;
		
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				count = rs.getInt("total");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * Returns today's date in the dd-MM-yyyy format
	 * @return today's date.
	 */
	private String getDate() {
		
		return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
}
