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

import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ExplainWindow extends OOJFrame {
	public ExplainWindow() {
		Container cp = getContentPane();
		cp.add(explain());
		setSize(600, 600);
		setVisible(true);
	}

	public Component createEditorPane(URL u) {
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		try {
			editorPane.setPage(u);
		} catch (IOException e) {
			editorPane.setText("Error: " + e);
		}
		return new JScrollPane(editorPane);
	}

	private Component explain() {
		JPanel p = new JPanel();
		String filename = "explain.html";
		try {
			URL fileUrl = new URL("file:" + filename);
			return createEditorPane(fileUrl);
		} catch (Exception e) {
			return new JLabel("Virket ikke: " + e.toString());
		}

	}

}
