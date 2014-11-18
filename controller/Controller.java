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
/*
 * 2004-12-06
 *
 */
package controller;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import trainergui.Maingui;
import actions.AAbout;
import actions.AExit;
import actions.AExplain;
import actions.APollnetwork;
import actions.ASQLview;
import actions.Aloadprops;
import actions.Alogonview;
import actions.Anewhistory;
import actions.Arunsql;
import actions.Astoreprops;

public class Controller extends JPanel implements DocumentListener,
		ListSelectionListener {

	static Maingui maingui = null;

	boolean viewinstanceready = false;

	public Controller(Maingui gui) {

		Controller.maingui = gui;

		actionabout = new AAbout();
		actionexit = new AExit();
		actionexplain = new AExplain();
		actionpollnet = new APollnetwork();
		actionsqlview = new ASQLview();
		actionlogonview = new Alogonview();
		actionrunsql = new Arunsql();
		actionnewhistory = new Anewhistory();
		actionstoreprops = new Astoreprops();
		actionloadprops = new Aloadprops();

	}

	public static void loadproperties() {
		maingui.loadproperties();
		actionstoreprops.setEnabled(false);
	}

	static public void testlogonproperties() {
		maingui.testlogonproperties();		
	}

	public static void setSQLperspective() {
		actionlogonview.setEnabled(true);
		actionnewhistory.setEnabled(true);
		maingui.setsqlperspective();
	}

	public static void setlogonperspective() {
		actionsqlview.setEnabled(true);
		actionlogonview.setEnabled(false);
		actionnewhistory.setEnabled(false);
		maingui.setlogonperspective();
	}

	public static void storeprops() {
		maingui.storeprops();
		actionstoreprops.setEnabled(false);
	}

	static public void visforklaring() {
		maingui.visforklaring();
	}

	public void viewinstanceready() {
		viewinstanceready = true;
	}

	private void respondtoEdits() {
		maingui.updatemodel();
		if (!viewinstanceready)
			return;
		actionstoreprops.setEnabled(true);
		actionloadprops.setEnabled(true);
		testlogonproperties();
	}

	public static void renewsqllist() {
		maingui.renewsqllist();
	}

	public static void exit() {
		maingui.exit();
	}

	public static void about() {
		maingui.about(false); // false = no option, just message
	}

	public static void setStatustext(String message) {
		maingui.setStatustext(message);
	}

	public static void runsql() {
		maingui.runsql();
	}

	// -------------------------------------------
	// implementing DocumentListener contract for logon propertyeditor:

	public void changedUpdate(DocumentEvent e) {
		// brukes ikke her
	}

	public void insertUpdate(DocumentEvent e) {
		respondtoEdits();
	}

	public void removeUpdate(DocumentEvent e) {
		respondtoEdits();
	}

	//  -------------------------------------------
	// implementing SelectionListener contract for sql-history:

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (!lsm.isSelectionEmpty()) {
			maingui.setsqlcommand(lsm.getMinSelectionIndex());
		}
	}

	public static AbstractAction actionabout;

	public static AbstractAction actionexit;

	public static AbstractAction actionexplain;

	public static AbstractAction actionpollnet;

	public static AbstractAction actionsqlview;

	public static AbstractAction actionlogonview;

	public static AbstractAction actionrunsql;

	public static AbstractAction actionnewhistory;

	public static AbstractAction actionstoreprops;

	public static AbstractAction actionloadprops;

	/**
	 * @param meldinger
	 * @param b
	 * @param catalogue
	 */
	public static void setlogonproperties(String meldinger, boolean b,
			String catalogue) {
		maingui.logonproperties(meldinger, b, catalogue);
	}

	/**
	 *  
	 */
	public static void startlogontestsignal() {
		maingui.startlogontestsignal();
	}

	/**
	 *  
	 */
	public static void driverTeststarted() {
		maingui.driverTeststarted();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public static void driverTestDone(boolean ok, String meldinger) {
		maingui.driverTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public static void urlTeststarted() {
		maingui.urlTeststarted();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public static void urlTestDone(boolean ok, String meldinger) {
		maingui.urlTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public static void unknownhost() {
		maingui.unknownhost();
	}

	/**
	 *  
	 */
	public static void accessdeniedforuser() {
		maingui.accessdeniedforuser();
	}

}
