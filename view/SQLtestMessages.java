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

import javax.swing.JTextArea;

public class SQLtestMessages extends JTextArea {

	private String inifilename = "pointbase.ini";

	public void append(String s) {
		super.append("\r\n" + s);
		invalidate();
	}


}