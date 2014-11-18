



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
	Kjøring av dette eksemplet forutsetter en installert JDBC for mySQL og en tilgjengelig konto på en mySQL-tjener.

	For bedre lesbarhet er de tre objektmetodene forsynt med "throws Exception"
	i stedet for mindre lesbare try-catch setninger.

	Entry point, dvs main-metoden, fanger opp alle eventuelle feil.

	Bruk av passord kan forenkles ved å fylle ut variabelnavnet og fjerne "new Password().getpw()"-setningen.

*/

public class EnkelSQLTest {


Connection connection	= null;

public EnkelSQLTest() throws Exception {
	// mittpassord = new Password().getpw(); // kan fjernes helt, hvis "mittpassord" allerede har gyldig innhold
	connect();
	test();
	connection.close();
}

private void connect()  throws Exception {
	Class.forName(driver);
	connection	= DriverManager.getConnection(url, username, password);
}

private void test() throws Exception {
	System.out.println("Starter test");
	Statement statement	= connection.createStatement();
	ResultSet rs		= statement.executeQuery(sqltekst);
	while (rs.next()) {
		System.out.println(rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(2));
																			// erstatt med f. eks.
																			// rs.getString("teacher") osv

	}
	System.out.println("Starter test");
}

// **************************************
// 				entry point
// --------------------------------------
static public void main(String[] s) {
	try {
		new EnkelSQLTest();		// normal kjøring
	}
	catch(Exception e) {
		System.out.println(e);	// kjøring hvis det oppstår en feil
	}
}



// ---------------------------------------------------------------------------------------------
// Disse variablene må få tilpasset innhold, slik at de stemmer med dine egne konto-opplysninger
// ---------------------------------------------------------------------------------------------.
private String database		= "baselot";
private String username		= "lanchelot";
private String password		= "coachingByEvalanche";
private String tablename	= "films";
private String sqlserver	= "evalanche.hve.no/";

// ---------------------------------------------------------------------------------------------
// Disse variablene stemmer med en mySQL-basert server og JDBC
// ---------------------------------------------------------------------------------------------.
// private String driver		= "com.mysql.jdbc.Driver";
// private String url			= "jdbc:mysql://"+minsqltjener+minkonto;
// private String sqltekst		= "select course, description, teacher from "+mintabell;

//---------------------------------------------------------------------------------------------
//Disse variablene stemmer med en PostgreSQL-basert server og JDBC
//---------------------------------------------------------------------------------------------.
private String driver		= "org.postgresql.Driver";
private String url			= "jdbc:postgresql://"+sqlserver+database;
private String sqltekst		= "select * from "+tablename;




}
