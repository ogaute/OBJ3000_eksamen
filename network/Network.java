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
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Model;


public class Network extends Thread {

	String meldinger = "";

	ConnectingListener connectinglistener;

	public Network(ConnectingListener connectinglistener) {
		this.connectinglistener = connectinglistener;
	}

	public void run() {
		connectinglistener.beginConnecting();
		String drivers = Model.getCurrentdriver();
		String url = Model.getCurrenturl();
		String username = Model.getCurrentusername();
		String password = Model.getCurrentpassword();
		meldinger += "\n ----------------------------------------------";
		meldinger += "\n           Nytt forsøk på oppkobling           ";
		meldinger += "\n ----------------------------------------------";
		meldinger += Model.formatclasspath();
		try {
			meldinger += " \nJavakode: \tClass.forName(\"" + drivers + "\")";
			Class.forName(drivers);
			connectinglistener.driverTestDone(true, meldinger);
		} catch (Exception e) {
			meldinger += "\nProblem(Network):\t " + e;
			connectinglistener.driverTestDone(false, meldinger);
			return;
		}
		meldinger += "\nJavakode:\tDriverManager.getConnection(\"" + url
				+ "\",\"" + username + "\",\""
				// +password+"\")";
				+ "*******\")";
		Connection connection;
		connectinglistener.urlTeststarted();
		try {
			connection = DriverManager.getConnection(url, username, password);
			connectinglistener.urlTestDone(true, meldinger);
			connectinglistener.connected(connection, meldinger);

		} catch (SQLException e1) {
			connectinglistener.urlTestDone(false, meldinger);
			if (e1.getSQLState().equals("08S01")
					|| e1.getSQLState().equals("08001")) {
				connectinglistener.unknownhost();
			}
			if (e1.getSQLState().equals("28000")) {
				connectinglistener.accessdeniedforuser();
			}
			connectinglistener.connected(null, meldinger + "\n" + e1);
			System.out.println("SJEKK TYPE:" + e1.getClass());
			System.out.println("SJEKK error og state:" + e1.getErrorCode()
					+ " " + e1.getSQLState());
			System.out.println("SJEKK getNextException class "
					+ e1.getNextException());
			System.out.println("FILTER OUT SOMETHIN?->[" + e1 + "]");
		}
		

	}

}
