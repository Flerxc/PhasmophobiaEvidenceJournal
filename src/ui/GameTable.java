package ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import constants.Constants;
import manager.PhasmophobiaManager;

/**
 * Excel-like table to view the content of the database
 * @author Francis Leroux-Contant
 * @version 2021-09-18
 */
public class GameTable extends AbstractTableModel {
	
	/**************
	 * ATTRIBUTES *
	 **************/
	private String[] columnNames = Constants.MENU_COLUMN_NAMES;
	private Object[][] data = new String[PhasmophobiaManager.db.getTotalGame(Constants.TABLE_NAME)][Constants.N_COLUMNS];
	
	/**
	 * Default constructor
	 */
	public GameTable() {
		
		super();
		
		initData();
	}
	
	/**
	 * Initialize the data from the database
	 */
	private void initData() {
		
		ResultSet rs = PhasmophobiaManager.db.readDB(Constants.TABLE_NAME);
		
		int i = 0;
		
		try {
			
			while(rs.next()) {
				
				data[i][0] = rs.getString(Constants.COLUMN_GHOST_TYPE);
				data[i][1] = rs.getString(Constants.COLUMN_GHOST_TYPE);
				data[i][2] = rs.getString(Constants.COLUMN_DATE);
				
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Returns the amount of rows
	 */
	@Override
	public int getRowCount() {

		return data.length;
	}

	/**
	 * Returns the amount of columns
	 */
	@Override
	public int getColumnCount() {
		
		return columnNames.length;
	}
	
	/**
	 * Returns the name of a column
	 */
	public String getColumnName(int col) {
        return columnNames[col];
    }

	/**
	 * Returns the data at the position [rowIndex][columnIndex]
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return data[rowIndex][columnIndex];
	}
	
	/**
	 * Assure no cells are editable
	 */
	 public boolean isCellEditable(int row, int col)
     { return false; }

}
