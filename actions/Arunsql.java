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

public class Arunsql extends SuperAction {

	public Arunsql() {

		putValue(Action.NAME, RUNSQL.label);
		// putValue(Action.SMALL_ICON, getIcon(SMALL_ICON_ABOUT));
		// putValue(LARGE_ICON, getIcon(LARGE_ICON_ABOUT));
		putValue(Action.SHORT_DESCRIPTION, "kjør sql-setning");
		putValue(Action.LONG_DESCRIPTION,
				"Kjør sql-setningen som er skrevet i vinduet i sqlperspektivet");
		putValue(Action.MNEMONIC_KEY, RUNSQL.key);
		putValue(Action.ACTION_COMMAND_KEY, RUNSQL.actioncommand);
		setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		Controller.runsql();

	}

}
