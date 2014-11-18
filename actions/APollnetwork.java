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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.AbstractButton;
import javax.swing.Action;

import model.Model;
import controller.Controller;

public class APollnetwork extends SuperAction {

	private PropertyChangeSupport changes;

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void firePropertyChange(String s, Object o, Object n) {
		changes.firePropertyChange(s, o, n);
	}

	public APollnetwork() {
		changes = new PropertyChangeSupport(this);
		putValue(Action.NAME, POLLNET.label);
		// putValue(Action.SMALL_ICON, getIcon(SMALL_ICON_ABOUT));
		// putValue(LARGE_ICON, getIcon(LARGE_ICON_ABOUT));
		putValue(Action.SHORT_DESCRIPTION, "tester argumentene hele tiden");
		putValue(Action.LONG_DESCRIPTION,
				"Hver gang et argument endres, prøver programmet å koble seg opp på nytt");
		putValue(Action.MNEMONIC_KEY, POLLNET.key);
		putValue(Action.ACTION_COMMAND_KEY, POLLNET.actioncommand);
	}

	public void actionPerformed(ActionEvent e) {
		boolean b = ((AbstractButton) e.getSource()).isSelected();
		Model.setContinously(b);
		if (Model.getContinously())
			Controller.testlogonproperties();
		firePropertyChange("selected", new Boolean(!b), new Boolean(b));
	}

}
