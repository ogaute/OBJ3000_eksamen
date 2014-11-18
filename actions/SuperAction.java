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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;

import controller.Controller;

abstract public class SuperAction extends AbstractAction implements IActions,
		MouseListener {

	protected boolean selected = false;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean newValue) {

		boolean oldValue = this.selected;

		if (oldValue != newValue) {
			this.selected = newValue;
			firePropertyChange("selected", Boolean.valueOf(oldValue), Boolean
					.valueOf(newValue));
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
		Controller.setStatustext("Ready ... ");
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent evt) {
		if (evt.getSource() instanceof AbstractButton) {
			AbstractButton button = (AbstractButton) evt.getSource();
			Action action = button.getAction(); 
			if (action != null) {
				String message = (String) action
						.getValue(Action.LONG_DESCRIPTION);
				Controller.setStatustext(message);
			}
		}
	}

}
