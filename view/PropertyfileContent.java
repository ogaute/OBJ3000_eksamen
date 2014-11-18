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

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Model;


public class PropertyfileContent extends JPanel {

	private Border compound = null;

	private JTextPane showpropsfilecontent = new JTextPane();

	public PropertyfileContent(String s) {
		super();
		if (s != null) {
			setLayout(new BorderLayout());
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			compound = BorderFactory.createCompoundBorder(raisedbevel,
					loweredbevel);
			add(showpropsfilecontent, BorderLayout.CENTER);
			setpropscontent(s);
		}
		showpropsfilecontent.setEnabled(false);
	}

	private void setpropscontent(String s) {
		compound = BorderFactory.createTitledBorder(compound,
				"Logon-properties in property-file: " + Model.propfilename(s),
				TitledBorder.CENTER, TitledBorder.BELOW_TOP);
		setBorder(null);
		setBorder(compound);
		showpropsfilecontent.setText(Model.readPropfile(s));
	}

}