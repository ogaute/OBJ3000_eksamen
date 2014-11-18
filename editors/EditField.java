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


package editors;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.OOJLabel;
import controller.Controller;

/*
 * 2004-11-24
 *  
 */
public class EditField extends JPanel {

	static boolean ignorelistener = false;

	static Controller controller;

	public EditField(String ex, String t, boolean ispassw, Controller controller) {
		EditField.controller = controller;
		setLayout(new GridLayout(1, 0));
		add(new OOJLabel(ex + ": ", JLabel.RIGHT));

		status = new JLabel();

		if (ispassw) {
			textfield = new JPasswordField(t);
		} else {
			textfield = new JTextField(t);
		}
		add(textfield);
		if (controller != null) {
			textfield.getDocument().addDocumentListener(controller);
		}
		add(status);
		setVirginview();
	}

	public String getText() {
		return textfield.getText();
	}

	/* --------------------- */
	public void setTestingview() {
		status.setText("tester");
		textfield.setFont(new Font("sansserif", Font.ITALIC, 13));
	}

	public void setSuccessview() {
		status.setText("aktiv");		
		textfield.setFont(new Font("sansserif", Font.PLAIN, 12));
	}

	public void setFailedview() {
		status.setText("feil");		
		textfield.setFont(new Font("sansserif", Font.PLAIN, 12));
	}

	public void setVirginview() {
		status.setText("ikke testet");		
		textfield.setFont(new Font("sansserif", Font.PLAIN, 12));
	}

	/* ------------- */

	public void setText(String s) {
		if (ignorelistener) {
			textfield.getDocument().removeDocumentListener(controller);
		}
		textfield.setText(s);
		textfield.getDocument().addDocumentListener(controller);
	}

	protected JTextField textfield;

	protected JLabel status;

	public static boolean isIgnorelistener() {
		return ignorelistener;
	}

	public static void setIgnorelistener(boolean ignorelistener) {
		EditField.ignorelistener = ignorelistener;
	}
}

class EditFieldRO extends EditField {

	public EditFieldRO(String ex, String t) {
		super(ex, t, false, null);
		textfield.setEnabled(false);
	}

}