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



import java.awt.event.*;
import javax.swing.*;


/**
	Denne klassen tillater inntasting av passord både for GUI-baserte og tegnbaserte programmer
	Nyttig også under demonstrasjoner som krever passord, som for eksempel oppkopling til web-kontoer.
*/

public class Password {

private boolean goon 				= true;
private JPasswordField jpassword 	= new JPasswordField ();

public Password() {
  JFrame f = new JFrame("Tast inn passord. Returner ved å lukke vinduet.");
  f.getContentPane().add(jpassword);
  f.addWindowListener(new WindowAdapter() {
	  public void windowClosing(WindowEvent e) {
		goon = false;
  	  }
	  }
	 );
  f.setSize(400,65);
  f.show();
}

public String getpw() {
	while (goon);
	return new String(jpassword.getPassword());

}
}