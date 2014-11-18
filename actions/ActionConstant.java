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
 * 2005-10-17
 *
 */
package actions;

public class ActionConstant {

	Integer key;

	String label;

	String actioncommand;

	public ActionConstant(char k, String ac, String l) {
		actioncommand = ac;
		key = new Integer(k);
		label = l;
	}

	public ActionConstant(int k, String ac, String l) {
		actioncommand = ac;
		key = new Integer(k);
		label = l;
	}

}
