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


package view;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Model;
import model.Querylist;
import trainergui.JTableframe;
import controller.Controller;

public class SQLDevice extends JPanel implements DocumentListener {

	public SQLDevice(JTextArea r, Controller controller) {
		sqlstrings.getDocument().addDocumentListener(this);
		messages = r;
		if (messages == null)
			messages = new JTextArea();
		setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(sqlstrings);
		add(sp);

		runsql = new JButton(Controller.actionrunsql);
		runsql.addMouseListener((MouseListener) Controller.actionrunsql);

		renewsqllist = new JButton(Controller.actionnewhistory);
		renewsqllist
				.addMouseListener((MouseListener) Controller.actionnewhistory);

		JPanel controlpanel = new JPanel();
		controlpanel.add(runsql);
		controlpanel.add(renewsqllist);
		add(controlpanel, BorderLayout.SOUTH);
	}

	public void runsql(Model model, int left, String title) {
		Statement stmt = model.getStatement();
		JTableframe jtable = new JTableframe(left, title);

		try {
			ResultSet rs = stmt.executeQuery(sqlstrings.getText());
			jtable.viewResultset(rs);
			Querylist.insert(stmt, sqlstrings.getText());
		} catch (Exception excp) {
			messages.append("\r\nSQLDevice Error " + excp);
		}
	}

	public void setText(String s) {
		sqlstrings.setText(s);
	}

	
	private JTextArea messages = null;

	private JTextArea sqlstrings = new JTextArea();

	public JButton runsql;

	public JButton renewsqllist; //  	= new JButton("Slett sql-liste");

	// *********************************************
	// keeping run-button in sync with text/no text:

	public void insertUpdate(DocumentEvent arg0) {
		Controller.actionrunsql.setEnabled(!sqlstrings.getText().equals(""));
	}

	public void removeUpdate(DocumentEvent arg0) {
		Controller.actionrunsql.setEnabled(!sqlstrings.getText().equals(""));
	}

	public void changedUpdate(DocumentEvent arg0) {
		Controller.actionrunsql.setEnabled(!sqlstrings.getText().equals(""));
	}

	//
	// *********************************************

}