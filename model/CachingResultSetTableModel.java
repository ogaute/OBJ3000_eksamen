/*
 * Dette er en kildefil til boken "Objektorientert programmering med Java"
 * 
 * Boken fåes i bokhandelen og http://www.fagbokforlaget.no
 * ISBN 82-7674-748-5
 * 
 * Direkte link: http://www.fagbokforlaget.no/?isbn=978-82-7674-748-5
 * 
 * Viggo Holmstedt 2002 - 2014

 */ 

package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CachingResultSetTableModel extends AbstractTableModel {

	public CachingResultSetTableModel(ResultSet rs) {
		try {
			rsmd = rs.getMetaData();
			colcnt = rsmd.getColumnCount();
			colnames = new String[colcnt];
			for (int i = 0; i < colcnt; i++) { // caching loop for all
				// coloumnnames
				colnames[i] = rsmd.getColumnName(i + 1);
			}
			cache = new ArrayList();
			while (rs.next()) { // caching loop for all datarows
				Object[] row = new Object[colcnt];
				for (int j = 0; j < row.length; j++)
					row[j] = rs.getObject(j + 1); // combining the row
				cache.add(row);
			}
		} catch (SQLException e) {
			System.out.println("Error " + e);
		}
	}

	private ArrayList cache = null; // to cache all datarows

	private String[] colnames = null; // to cache the coloumnnames

	private ResultSetMetaData rsmd = null; // argument reference from the SQL
	
	private int colcnt = 0;

	// **********************************************************
	// Oppfyller resten av kontrakten for interface TableModel.
	// AbstractTableModels har allerede oppfylt de andre.
	// ----------------------------------------------------------

	public int getRowCount() {
		return cache.size();
	}

	public int getColumnCount() {
		return colcnt;
	}

	public Object getValueAt(int r, int c) {
		if (r < cache.size())
			return ((Object[]) cache.get(r))[c];
		else
			return null;
	}

	// --------------------------------
	//   Ferdig med kontrakten.
	// ********************************

	// **********************************************************************************
	// Overstyrer AbstractTableModel::getColumnName for å forenkle henting av
	// kolonnenavn
	// ----------------------------------------------------------------------------------

	public String getColumnName(int c) {
		return colnames[c];
	}

	// ----------------------------------------------------------------------------------
	// **********************************************************************************

}
