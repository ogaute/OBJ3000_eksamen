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

public class AExit extends SuperAction {

	public AExit() {

		putValue(Action.NAME, EXIT.label);
		putValue(Action.SHORT_DESCRIPTION, "Stopper programmet");
		putValue(Action.LONG_DESCRIPTION,
				"Lukker alle vinduer og stopper programmet");
		putValue(Action.MNEMONIC_KEY, EXIT.key);
		putValue(Action.ACTION_COMMAND_KEY, EXIT.actioncommand);
	}

	public void actionPerformed(ActionEvent e) {
		Controller.exit();
	}

}
