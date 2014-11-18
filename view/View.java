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

import java.util.Properties;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import model.LogonProps;
import model.Model;
import controller.Controller;


public class View extends JSplitPane {

	SQLDevice sqldevice = null;

	Logonview logonview = null;

	JScrollPane topscroll = new JScrollPane();

	JScrollPane lowerscroll = new JScrollPane();

	JTable jtable = null;

	LogonProps logonprops = null;

	public View(Controller controller, SQLtestMessages messages) {
		super(VERTICAL_SPLIT);
		logonview = new Logonview(controller, messages);
		logonprops = new LogonProps(logonview);
		add(topscroll);
		add(lowerscroll);
		controller.viewinstanceready();
		sqldevice = new SQLDevice(messages, controller);
	}

	public void updatejtable(Model model, Controller controller) {
		jtable = new JTable(model.getquerylist());
		jtable.getSelectionModel().addListSelectionListener(controller);
		lowerscroll.setViewportView(jtable);
	}

	public void runsql(Model model, int left, Controller controller) {
		sqldevice.runsql(model, left, logonprops.gettitle());
		updatejtable(model, controller);
	}

	public void storeprops() {
		logonprops.store(logonview.getFileName());
		logonview.refresh(logonview.getFileName());
	}

	public void loadproperties() {
		logonprops.load(logonview.getFileName());
	}

	public Properties editors2props() {
		return logonview.editors2props();
	}

	public void setlogonperspective() {
		remove(lowerscroll);
		topscroll.setViewportView(logonview);
	}

	public void setsqlcommand(int row) {
		if (jtable != null) {
			sqldevice.setText(((String) jtable.getModel().getValueAt(row, 0))
					.trim());
		}
	}

	public void setsqlperspective(Model model, Controller controller) {
		add(lowerscroll);
		topscroll.setViewportView(sqldevice);
		jtable = new JTable(model.getquerylist());
		jtable.getSelectionModel().addListSelectionListener(controller);
		lowerscroll.setViewportView(jtable);
		setDividerLocation(0.4);

	}

	public void logonproperties(String s, boolean b, String catalogue) {
		logonview.testlogonproperties(s, b, catalogue);
	}

	/**
	 *  
	 */
	public void updatemodel() {
		logonview.updatemodel();
	}

	/**
	 *  
	 */
	public void startlogontestsignal() {
		logonview.startTestlogonsignal();
	}

	/**
	 * 
	 * 
	 * public void setTestState() { 
	 * 		logonview.setTestState();
	 *  }
	 */
	/**
	 *  
	 */
	public void driverTeststarted() {
		logonview.driverTeststarted();

	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public void driverTestDone(boolean ok, String meldinger) {
		logonview.driverTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public void urlTeststarted() {
		logonview.urlTeststarted();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public void urlTestDone(boolean ok, String meldinger) {
		logonview.urlTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public void unknownhost() {
		logonview.unknownhost();
	}

	/**
	 *  
	 */
	public void accessdeniedforuser() {
		logonview.accessdeniedforuser();
	}

}
