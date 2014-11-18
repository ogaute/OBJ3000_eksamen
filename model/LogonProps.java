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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import view.Logonview;


public class LogonProps {

	Logonview logonview = null;

	public Properties logonproperties = null;

	public LogonProps(Logonview l) {
		this.logonview = l;
		logonproperties = logonview.editors2props();
		load(l.getFileName());
	}

	public void load(String filename) {
		try {
			InputStream o = new FileInputStream(filename
					+ PropFilesFilter.PROPS);
			logonproperties.load(o);
			o.close();
		} catch (Exception e) {
		}
		logonview.props2editors(logonproperties);
	}

	public void store(String filename) {
		logonproperties = logonview.editors2props();
		try {
			OutputStream o = new FileOutputStream(filename
					+ PropFilesFilter.PROPS);
			logonproperties.store(o, null);
			o.close();
		} catch (Exception e) {
		}
	}

	public String gettitle() {
		return logonproperties.getProperty(Logonview.URL, "?");
	}

}
