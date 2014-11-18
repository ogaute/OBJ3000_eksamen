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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trainergui.Togglecontrolbutton;
import controller.Controller;


public class PropertyfileTool extends JPanel implements ActionListener {

	private JComboBox filechooser;

	public PropertyfileTool(String t, String[] propsfiles) {

		// default flowlayout

		JButton read = new JButton(Controller.actionloadprops);
		read.addMouseListener((MouseListener) Controller.actionloadprops);
		add(read);

		JLabel label = new JLabel("konfigurasjon");
		label.setFont(new Font("sansserif", Font.PLAIN, 12));
		add(label);

		filechooser = new JComboBox(propsfiles);
		filechooser.setEditable(true);
		filechooser.addActionListener(this);
		add(filechooser);

		Togglecontrolbutton continuedtesting = new Togglecontrolbutton(
				Controller.actionpollnet);
		continuedtesting
				.addMouseListener((MouseListener) Controller.actionpollnet);
		add(continuedtesting);

		JButton write = new JButton(Controller.actionstoreprops);
		write.addMouseListener((MouseListener) Controller.actionstoreprops);
		add(write);
	}

	public String getText() {
		return (String) filechooser.getSelectedItem();
	}

	public void refresh() {
		String s = (String) filechooser.getSelectedItem();

		filechooser.removeItem(s); // workaround to have new items displayed

		filechooser.addItem(s);
		filechooser.setSelectedItem(s);
	}

	public void actionPerformed(ActionEvent e) {
		Controller.actionloadprops.setEnabled(true);
	}

}
