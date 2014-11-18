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
 * Created on 14.jun.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package actions;

/**
 * @author segovia
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface IActions {

	ActionConstant EXIT = new ActionConstant('e', "exit", "avslutt");

	ActionConstant ABOUT = new ActionConstant('o', "about", "om");

	ActionConstant EXPLAIN = new ActionConstant('f', "explain", "forklaring");

	ActionConstant POLLNET = new ActionConstant('p', "pollnet",
			"test kontinuerlig");

	ActionConstant SQLVIEW = new ActionConstant('q', "sqlview", "sqlperspektiv");

	ActionConstant LOGONVIEW = new ActionConstant('l', "logonview",
			"logonperspektiv");

	ActionConstant RUNSQL = new ActionConstant('r', "runsql", "kjør sql");

	ActionConstant NEWHISTORY = new ActionConstant('h', "newhistory",
			"begynn på ny sql-historie");

	ActionConstant STOREPROPS = new ActionConstant('s', "storeprops", "gjem");

	ActionConstant LOADPROPS = new ActionConstant('l', "loadprops", "hent");

	// Placeholders for more actions: 
	//	 ActionConstant = new ActionConstant('',"","");
	//	 ActionConstant = new ActionConstant('',"","");
	//	 ActionConstant = new ActionConstant('',"","");
	//	 ActionConstant = new ActionConstant('',"","");
	//	 ActionConstant = new ActionConstant('',"","");
	//	 ActionConstant = new ActionConstant('',"","");
}
