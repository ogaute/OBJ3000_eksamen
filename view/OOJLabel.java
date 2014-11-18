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

package view;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * @author vh
 *  
 */
public class OOJLabel extends JLabel {
	public OOJLabel(String s) {
		super(s);
		setFont();
	}

	public OOJLabel(String s, int horizontalAlignment) {
		super(s, horizontalAlignment);
		setFont();
	}

	private void setFont() {
		setFont(new Font("SansSerif.", Font.PLAIN, 12));
	}

}
