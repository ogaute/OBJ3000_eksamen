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

import controller.Controller;

public class AExplain extends SuperAction {

	public AExplain() {
		changes = new PropertyChangeSupport(this);
		putValue(Action.NAME, EXPLAIN.label);
		// putValue(Action.SMALL_ICON, getIcon(SMALL_ICON_ABOUT));
		// putValue(LARGE_ICON, getIcon(LARGE_ICON_ABOUT));
		putValue(Action.SHORT_DESCRIPTION, "Viser forklaring");
		putValue(Action.LONG_DESCRIPTION,
				"Viser en grundigere beskrivelse av hva dette programmet gjør");
		putValue(Action.MNEMONIC_KEY, EXPLAIN.key);
		putValue(Action.ACTION_COMMAND_KEY, EXPLAIN.actioncommand);
	}

	public void actionPerformed(ActionEvent e) {
		boolean b = ((AbstractButton) e.getSource()).isSelected();
		Controller.visforklaring();
		firePropertyChange("selected", new Boolean(!b), new Boolean(b));
	}

	private PropertyChangeSupport changes;

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void firePropertyChange(String s, Object o, Object n) {
		changes.firePropertyChange(s, o, n);
	}

}
