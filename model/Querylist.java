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

import java.sql.Statement;

public class Querylist {

	static public void createTable(Statement stmt) {
		droptable(stmt);
		String command = "create table querylist (sqlhistorie char(255) primary key)";
		try {
			stmt.executeUpdate(command);
		} catch (Exception e) {
		}
	}

	static private void droptable(Statement stmt) {
		String command = "drop table querylist";
		try {
			stmt.executeUpdate(command);
		} catch (Exception e) {
		}
	}

	static public void insert(Statement stmt, String s) {
		s = fixsingleapostroph(s);
		String command = "insert into querylist values ('" + s + "' )";
		try {
			stmt.executeUpdate(command);
		} catch (Exception excp) {
			System.out.println("insert " + excp);
		}
	}

	static private String fixsingleapostroph(String s) {
		String ss = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			ss += c;
			if (c == '\'') {
				ss += c;
			}
		}
		return ss;
	}

}