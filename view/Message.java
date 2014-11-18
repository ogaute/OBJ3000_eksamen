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
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import trainergui.OOJFrame;

/**
 * @author vh
 *  
 */
public class Message extends OOJFrame implements ActionListener {

	JButton clear = new JButton("clear");

	JTextArea viewmessages = null;

	public Message(JTextArea j, int y) {
		setTitle("Meldinger fra handlinger");
		viewmessages = j;
		Container cp = getContentPane();
		cp.add(new JScrollPane(j));
		cp.add(clear, BorderLayout.SOUTH);

		clear.addActionListener(this);
		setSize(800, 350);
		setLocation(0, y);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		viewmessages.setText("");
	}

}
