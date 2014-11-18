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

package trainergui;

import java.awt.Container;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

import model.CachingResultSetTableModel;


public class JTableframe extends OOJFrame {

	public JTableframe(int left, String title) {
		setTitle(title);
		contentpane = getContentPane();
		setLocation(left + (20 * countframes), 25 * countframes);
		countframes++;
	}

	public void viewResultset(ResultSet rs) {
		AbstractTableModel model = new CachingResultSetTableModel(rs);
		if (jtable != null) {
			contentpane.remove(0);
		}
		jtable = new JTable(model);
		contentpane.add(new JScrollPane(jtable));
		setSize(600, 300);
		setVisible(true);
	}

	static private int countframes = 0;

	private Container contentpane;

	private JTable jtable = null;

}
