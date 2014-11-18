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
 * 2005-07-18
 *
 */
package menu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;

public class Toggleitem extends JCheckBoxMenuItem implements
		PropertyChangeListener {

	public Toggleitem(Action a) {
		super(a);
		a.addPropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		boolean b = ((Boolean) evt.getNewValue()).booleanValue();
		setSelected(b);
	}

}
