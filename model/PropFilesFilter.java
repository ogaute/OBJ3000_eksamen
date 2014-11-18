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

package model;

import java.io.File;
import java.io.FilenameFilter;

/*
 * 2004-11-23
 * 
 */

final class PropFilesFilter implements FilenameFilter {

	public boolean nameFound(String s) {
		return s.endsWith(PROPS);
	}

	public boolean accept(File dir, String fileName) {
		return nameFound(fileName);
	}

	static final String PROPS = ".props";

}
