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
 * 2005-06-14
 *
 */
package actions;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import controller.Controller;

public class Alogonview extends SuperAction {

	public Alogonview() {
		putValue(Action.NAME, LOGONVIEW.label);
		putValue(Action.SHORT_DESCRIPTION, "Viser logonvinduet");
		putValue(Action.LONG_DESCRIPTION,
				"logon-vinduet brukes til parametre for pålogging til en databasetjener");
		putValue(Action.MNEMONIC_KEY, LOGONVIEW.key);
		putValue(Action.ACTION_COMMAND_KEY, LOGONVIEW.actioncommand);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		Controller.setlogonperspective();
		setEnabled(false);
	}

	
}
