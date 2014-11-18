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

package network;

import java.sql.Connection;


public interface ConnectingListener {

	void beginConnecting();

	void driverTeststarted();

	void driverTestDone(boolean ok, String meldinger);

	void urlTeststarted();

	void urlTestDone(boolean ok, String meldinger);

	void connected(Connection connection, String meldinger);

	/**
	 *  
	 */
	void unknownhost();

	/**
	 *  
	 */
	void accessdeniedforuser();
}
