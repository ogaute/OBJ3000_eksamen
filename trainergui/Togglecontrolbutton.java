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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;


public class Togglecontrolbutton extends JCheckBox implements
		PropertyChangeListener {

	public Togglecontrolbutton(AbstractAction actionexplain) {
		super(actionexplain);
		actionexplain.addPropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		boolean b = ((Boolean) evt.getNewValue()).booleanValue();
		setSelected(b);
	}
}
