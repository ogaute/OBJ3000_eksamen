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
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Model;
import controller.Controller;
import editors.EditField;


public class Logonview extends JPanel {

	public Logonview(Controller controller, SQLtestMessages r) {

		jdbcdriverseditor = new EditField("Driver",
				"com.pointbase.jdbc.jdbcDriver", false, controller);

		jdbcurleditor = new EditField("Url", "jdbc:pointbase:corejava", false,
				controller);

		jdbcusernameeditor = new EditField("Username", "PUBLIC", false,
				controller);

		jdbcpasswordeditor = new EditField("Password", "PUBLIC", true,
				controller);

		messages = r;
		if (messages == null)
			messages = new SQLtestMessages();
		setBackground(Color.yellow);
		setLayout(new BorderLayout(5, 5));

		JPanel proppanel = new JPanel(new GridLayout(2, 0));
		proppanel.add(propertyfiletool);
		JPanel northpanel = new JPanel(new GridLayout(2, 0));
		northpanel.add(logonsignal);
		northpanel.add(proppanel);

		JPanel edpropspanel = new JPanel();
		edpropspanel.setLayout(new GridLayout(0, 1));
		edpropspanel.add(jdbcdriverseditor);
		edpropspanel.add(jdbcurleditor);
		edpropspanel.add(jdbcusernameeditor);
		edpropspanel.add(jdbcpasswordeditor);

		jtree = new JTree(Model.getpropstree());
		jtree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				JTree tree = (JTree) e.getSource();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				if (node != null) {
					Object nodeInfo = node.getUserObject();
					Object parent = node.getParent();

					if (parent != null
							&& parent.toString().equals("Properties")) {
						centerlow.remove(propsfilecontent);
						propsfilecontent = new PropertyfileContent(nodeInfo
								.toString());
						centerlow.add(propsfilecontent);
						centerlow.setDividerLocation(0.3);
					}
				}
			}
		});

		scrolltree = new JScrollPane(jtree);
		JScrollPane edscroller = new JScrollPane(edpropspanel);

		JSplitPane centerpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		centerlow = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(centerpane, BorderLayout.CENTER);
		centerpane.add(edscroller);

		centerlow.add(scrolltree);
		centerlow.add(propsfilecontent);
		centerpane.add(centerlow);
		add(northpanel, BorderLayout.NORTH);
		new Thread(logonsignal).start();
	}

	static final public String DRIVER = "driver";

	static final public String URL = "url";

	static final public String USERNAME = "username";

	static final public String PASSWORD = "password";

	public Properties editors2props() {
		Properties p = new Properties();
		p.setProperty(DRIVER, jdbcdriverseditor.getText());
		p.setProperty(URL, jdbcurleditor.getText());
		p.setProperty(USERNAME, jdbcusernameeditor.getText());
		p.setProperty(PASSWORD, jdbcpasswordeditor.getText());
		return p;
	}

	public void props2editors(Properties p) {
		EditField.setIgnorelistener(true);
		jdbcdriverseditor.setText(p.getProperty(DRIVER, ""));
		jdbcurleditor.setText(p.getProperty(URL, ""));
		jdbcusernameeditor.setText(p.getProperty(USERNAME, ""));
		jdbcpasswordeditor.setText(p.getProperty(PASSWORD, ""));
		updatemodel();
		EditField.setIgnorelistener(false);
	}

	public void refresh(String propsname) {
		propertyfiletool.refresh();
		((DefaultTreeModel) jtree.getModel()).setRoot(Model.getpropstree());
	}

	public String getFileName() {
		return propertyfiletool.getText();
	}

	public void testlogonproperties(String s, boolean b, String catalog) {
		messages.append(s);
		if (b) {
			messages.append("Logon:\tOK");
			messages.append("SQL database:\t" + catalog);
			setSuccessState();
		} else {

			messages.append("\r\nLogon:\tmislykket");
			// setNotactive();
		}
		logonsignal.setActive(b, b);

	}

	/**
	 *  
	 */

	public void startTestlogonsignal() {
		logonsignal.setActive(true, false);
		setNotactive();
	}

	private Logonsignal logonsignal = new Logonsignal();

	private PropertyfileContent propsfilecontent = new PropertyfileContent(null);

	private JSplitPane centerlow = null;

	private EditField jdbcdriverseditor = null;

	private EditField jdbcurleditor = null;

	private EditField jdbcusernameeditor = null;

	private EditField jdbcpasswordeditor = null;

	private SQLtestMessages messages = null;

	private JTree jtree = null;

	JScrollPane scrolltree = null;

	public void setSuccessState() {		
		jdbcpasswordeditor.setSuccessview();
		jdbcusernameeditor.setSuccessview();
		jdbcurleditor.setSuccessview();
		jdbcdriverseditor.setSuccessview();
	}

	private void setNotactive() {
		jdbcpasswordeditor.setVirginview();
		jdbcusernameeditor.setVirginview();
		jdbcurleditor.setVirginview();
		jdbcdriverseditor.setVirginview();
	}

	public void updatemodel() {
		Model.setCurrentdriver(jdbcdriverseditor.getText());
		Model.setCurrenturl(jdbcurleditor.getText());
		Model.setCurrentusername(jdbcusernameeditor.getText());
		Model.setCurrentpassword(jdbcpasswordeditor.getText());
	}

	private PropertyfileTool propertyfiletool = new PropertyfileTool(
			"PointBase", Model.getpropsfiles());

	/**
	 *  
	 */
	public void driverTeststarted() {
		jdbcdriverseditor.setTestingview();
		jdbcpasswordeditor.setVirginview();
		jdbcusernameeditor.setVirginview();
		jdbcurleditor.setVirginview();
	}

	/**
	 * @param ok
	 * @param meldinger
	 */
	public void driverTestDone(boolean ok, String meldinger) {
		if (ok) {
			jdbcdriverseditor.setSuccessview();
		} else {
			jdbcdriverseditor.setFailedview();
			logonsignal.setActive(false, false);
		}

	}

	
	public void urlTeststarted() {
		jdbcurleditor.setTestingview();		
	}

	
	public void urlTestDone(boolean ok, String meldinger) {		
		if (ok) {
			jdbcurleditor.setSuccessview();
		}
	}

	
	public void unknownhost() {
		jdbcurleditor.setFailedview();
	}

	
	public void accessdeniedforuser() {
		jdbcurleditor.setSuccessview();
		jdbcusernameeditor.setFailedview();
		jdbcpasswordeditor.setFailedview();
	}

}
