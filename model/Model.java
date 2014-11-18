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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.tree.DefaultMutableTreeNode;

import network.ConnectingListener;
import network.Network;
import trainergui.Maingui;
import controller.Controller;

/**
 * Forsyner JTree med argument fra props-filene. 
 */

public class Model implements ConnectingListener {

	private static String currentclasspath = System.getProperty(
			"java.class.path", ".");

	private static String currenturl = "";

	private static String currentpassword = "";

	private static String currentdriver = "";

	private static String currentusername = "";

	private static boolean continously = false; // tester oppkobling ved

	// forandring eller manglende
	// kontakt

	Maingui gui = null;

	private Statement stmt;

	public Model(Maingui gui) {

		this.gui = gui;
	}

	static public String[] getpropsfiles() {
		File f = new File(".");
		String[] s = f.list(new PropFilesFilter());
		for (int i = 0; i < s.length; i++) {
			String ss = s[i];
			s[i] = ss.substring(0, ss.indexOf(PropFilesFilter.PROPS));
		}
		return s;
	}

	static public DefaultMutableTreeNode getpropstree() {
		String[] filenames = getpropsfiles();
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Properties");
		for (int i = 0; i < filenames.length; i++) {
			DefaultMutableTreeNode ny = populate(filenames[i]);
			top.add(ny);
		}
		return top;
	}

	public static DefaultMutableTreeNode populate(String s) {
		DefaultMutableTreeNode ny = new DefaultMutableTreeNode(s);
		Properties p = new Properties();
		try {
			InputStream o = new FileInputStream(propfilename(s));
			p.load(o);
			o.close();
		} catch (Exception e) {
		}
		Enumeration keys = p.keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			DefaultMutableTreeNode keynode = new DefaultMutableTreeNode(key);
			keynode
					.add(new DefaultMutableTreeNode(p.getProperty((String) key)));
			ny.add(keynode);
		}
		return ny;
	}

	static public String propfilename(String s) {
		return s + PropFilesFilter.PROPS;

	}

	static public String readPropfile(String s) {
		String r = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					propfilename(s)));
			String l = null;
			while ((l = br.readLine()) != null) {
				r += l + "\n";
			}
			br.close();
		} catch (Exception e) {
			r = e.toString();
		}
		return r;
	}

	public void testlogonproperties() {
		if (continously) {
			new Network(this).start();
		}
	}

	public CachingResultSetTableModel getquerylist() {
		try {
			return new CachingResultSetTableModel(stmt
					.executeQuery("select * from querylist"));
		} catch (Exception e) {
			return null;
		}
	}

	public Statement getStatement() {
		return stmt;
	}

	public void runsql() {
		gui.runsql(this);
	}

	public void renewsqllist() {
		Querylist.createTable(stmt);

	}

	// relies on windows semikolonseparated paths
	static public String formatclasspath() {
		String s = currentclasspath;
		StringTokenizer st = new StringTokenizer(s, ";");
		String r = "";
		while (st.hasMoreTokens()) {
			r += "\t" + st.nextToken() + "\n";
		}

		return "\nKlassestier: " + r;

	}

	// getters og setters for de fire hovedattributtene

	public static String getCurrentclasspath() {
		return currentclasspath;
	}

	public static String getCurrentdriver() {
		return currentdriver;
	}

	public static void setCurrentdriver(String currentdriver) {
		Model.currentdriver = currentdriver;
	}

	public static String getCurrentpassword() {
		return currentpassword;
	}

	public static void setCurrentpassword(String currentpassword) {
		Model.currentpassword = currentpassword;
	}

	public static String getCurrenturl() {
		return currenturl;
	}

	public static void setCurrenturl(String currenturl) {
		Model.currenturl = currenturl;
	}

	public static String getCurrentusername() {
		return currentusername;
	}

	public static void setCurrentusername(String currentusername) {
		Model.currentusername = currentusername;
	}

	public static boolean getContinously() {
		return continously;
	}

	public static void setContinously(boolean continously) {
		Model.continously = continously;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see network.ConnectingListener#beginConnecting()
	 */
	public void beginConnecting() {
		Controller.startlogontestsignal();
	}

	public void connected(Connection connection, String meldinger) {
		boolean b = false;
		String catalogue = "";
		try {			
			stmt = connection.createStatement();			
			catalogue = connection.getCatalog();			
			b = true;
			Controller.actionsqlview.setEnabled(true);
		} catch (Exception e) {
			stmt = null;
			meldinger += "\nProblem:\t " + e;
			Controller.actionsqlview.setEnabled(false);
		}
		Controller.setlogonproperties(meldinger, b, catalogue);

	}

	public void driverTestDone(boolean ok, String meldinger) {
		Controller.driverTestDone(ok, meldinger);
	}

	
	public void driverTeststarted() {
		Controller.driverTeststarted();

	}

	
	public void urlTeststarted() {
		Controller.urlTeststarted();
	}

	
	public void urlTestDone(boolean ok, String meldinger) {
		Controller.urlTestDone(ok, meldinger);
	}

	
	public void unknownhost() {
		Controller.unknownhost();
	}

	
	public void accessdeniedforuser() {
		Controller.accessdeniedforuser();
	}
}

// ----------------------------------------------------------------------

