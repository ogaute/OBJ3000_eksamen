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

import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;


public class Controlpanel extends JPanel {

	public Controlpanel() {

		sqlview = new JButton(Controller.actionsqlview);
		sqlview.addMouseListener((MouseListener) Controller.actionsqlview);
		add(sqlview);

		logonview = new JButton(Controller.actionlogonview);
		logonview.addMouseListener((MouseListener) Controller.actionlogonview);
		add(logonview);

		visforklaring = new Togglecontrolbutton(Controller.actionexplain);
		visforklaring
				.addMouseListener((MouseListener) Controller.actionexplain);
		add(visforklaring);

		lukkprogrammet = new JButton(Controller.actionexit);
		lukkprogrammet.addMouseListener((MouseListener) Controller.actionexit);
		add(lukkprogrammet);

	}

	private Togglecontrolbutton visforklaring;

	private JButton lukkprogrammet;

	private JButton sqlview;

	private JButton logonview;

}
