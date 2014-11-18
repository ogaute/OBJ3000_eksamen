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

public class ASQLview extends SuperAction {

	public ASQLview() {
		putValue(Action.NAME, SQLVIEW.label);
		// putValue(Action.SMALL_ICON, getIcon(SMALL_ICON_ABOUT));
		// putValue(LARGE_ICON, getIcon(LARGE_ICON_ABOUT));
		putValue(Action.SHORT_DESCRIPTION, "Viser sqlvinduet");
		putValue(
				Action.LONG_DESCRIPTION,
				"Sql-vinduet brukes til å skrive og å utføre sql-setninger etter en vellykket pålogging");
		putValue(Action.MNEMONIC_KEY, SQLVIEW.key);
		putValue(Action.ACTION_COMMAND_KEY, SQLVIEW.actioncommand);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		Controller.setSQLperspective();
		setEnabled(false);
	}
}
