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
 * 2005-03-19
 *
 */
package menu;

import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.Controller;

public class Mainmenu extends JMenuBar {

	public Mainmenu() {
		buildverticalmenus();
		fix2menubar();
	}

	// list of verticals
	private JMenu file = new JMenu("file");

	private JMenu edit = new JMenu("edit");

	private JMenu tools = new JMenu("tools");

	private JMenu search = new JMenu("search");

	private JMenu windows = new JMenu("windows");

	private JMenu help = new JMenu("help");

	private void buildverticalmenus() {

		// file
		file.add(Controller.actionstoreprops).addMouseListener(
				(MouseListener) Controller.actionstoreprops);
		file.add(Controller.actionexit).addMouseListener(
				(MouseListener) Controller.actionexit);

		// edit

		// tools
		tools.add(new Toggleitem(Controller.actionpollnet)).addMouseListener(
				(MouseListener) Controller.actionpollnet);
		tools.add(Controller.actionrunsql).addMouseListener(
				(MouseListener) Controller.actionrunsql);
		tools.add(Controller.actionnewhistory).addMouseListener(
				(MouseListener) Controller.actionnewhistory);

		// windows
		windows.add(Controller.actionsqlview).addMouseListener(
				(MouseListener) Controller.actionsqlview);
		windows.add(Controller.actionlogonview).addMouseListener(
				(MouseListener) Controller.actionlogonview);

		// help
		help.add(new Toggleitem(Controller.actionexplain)).addMouseListener(
				(MouseListener) Controller.actionexplain);
		help.add(Controller.actionabout).addMouseListener(
				(MouseListener) Controller.actionabout);

	}

	private void fix2menubar() {
		add(file);
		add(edit);
		add(tools);
		add(search);
		add(windows);
		add(help);
	}

}
