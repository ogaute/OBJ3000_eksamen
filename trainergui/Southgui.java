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

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Southgui extends JPanel {
	private JLabel status;

	public Southgui() {

		status = new JLabel("Ready...");
		status.setFont(new Font("sansserif", Font.PLAIN, 12));
		status.setBorder(BorderFactory.createEtchedBorder());
		add(status);
	}

	/**
	 * @param message
	 */
	public void setStatustext(String message) {
		status.setText(message);

	}

}
