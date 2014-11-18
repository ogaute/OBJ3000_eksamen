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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import menu.Mainmenu;
import model.Model;
import view.Message;
import view.SQLtestMessages;
import view.View;
import controller.Controller;

public class Maingui extends OOJFrame {

	static String VERSION = "JDBC Trainer 1.0";

	View view;

	Controller controller;

	Model model;

	private SQLtestMessages messages = new SQLtestMessages();

	Component center = null;

	Container cp = null;

	Southgui southgui;

	public Maingui() {

		model = new Model(this);
		controller = new Controller(this);
		view = new View(controller, messages);

		southgui = new Southgui();

		cp = getContentPane();
		cp.setLayout(new BorderLayout(15, 15));
		cp.setBackground(new Color(221, 221, 221));
		JLabel header = new JLabel("SQL/jdbc testsenter", JLabel.CENTER);
		header.setFont(new Font("sansserif", Font.PLAIN, 14));
		cp.add(header, BorderLayout.NORTH);

		JPanel southpanel = new JPanel(new GridLayout(2, 0));
		southpanel.add(new Controlpanel());
		southpanel.add(southgui);
		cp.add(southpanel, BorderLayout.SOUTH);
		cp.add(view, BorderLayout.CENTER);
		prettysides();

		setlogonperspective();
		setSize(600, 600);

		setJMenuBar(new Mainmenu());

		setVisible(true);
		new Message(messages, 600);
		
	

	}

	JFrame explainwindow = null;

	public void visforklaring() {
		if (explainwindow == null) {
			explainwindow = new ExplainWindow();
			explainwindow.setLocation(getWidth(), 0);
		} else {
			explainwindow.dispose();
			explainwindow = null;
		}
	}

	public void setsqlperspective() {
		view.setsqlperspective(model, controller);
	}

	public void setlogonperspective() {
		view.setlogonperspective();
	}

	public void testlogonproperties() {
		model.testlogonproperties();
	}

	public void storeprops() {
		view.storeprops();
	}

	public void renewsqllist() {
		model.renewsqllist();
		view.updatejtable(model, controller);
	}

	public void loadproperties() {
		view.loadproperties();
		testlogonproperties();

	}

	public void runsql(Model model) {
		Point d = getLocation();
		view.runsql(model, d.x + getWidth(), controller);
	}

	public void setsqlcommand(int row) {
		view.setsqlcommand(row);
	}

	private void prettysides() {
		Container cp = getContentPane();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setBackground(new Color(221, 221, 221));
		p2.setBackground(new Color(221, 221, 221));
		cp.add(p1, BorderLayout.WEST);
		cp.add(p2, BorderLayout.EAST);
	}

	public void exit() {
		if (about(true)) {
			System.exit(0);
		}

	}

	public boolean about(boolean exit) {
		if (exit) {
			Object[] options = { "Avslutt", "Fortsett" };
			return 0 == JOptionPane.showOptionDialog(null, VERSION,
					"V. Holmstedt", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		} else {
			JOptionPane.showMessageDialog(null, VERSION, "V. Holmstedt",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	public void setStatustext(String message) {
		southgui.setStatustext(message);
	}

	public void updatemodel() {
		if (view != null)
			view.updatemodel();

	}

	public void runsql() {
		model.runsql();
	}

	/**
	 * @param meldinger
	 * @param b
	 * @param catalogue
	 */
	public void logonproperties(String meldinger, boolean b, String catalogue) {
		view.logonproperties(meldinger, b, catalogue);
	}

	/**
	 *  
	 */
	public void startlogontestsignal() {
		view.startlogontestsignal();
	}

	/**
	 *  
	 */
	public void driverTeststarted() {
		view.driverTeststarted();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public void driverTestDone(boolean ok, String meldinger) {
		view.driverTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public void urlTeststarted() {
		view.urlTeststarted();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public void urlTestDone(boolean ok, String meldinger) {
		view.urlTestDone(ok, meldinger);
	}

	/**
	 *  
	 */
	public void unknownhost() {
		view.unknownhost();
	}

	/**
	 *  
	 */
	public void accessdeniedforuser() {
		view.accessdeniedforuser();
	}

}
