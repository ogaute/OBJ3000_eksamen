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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Logonsignal extends JPanel implements Runnable {

	private boolean active = false;

	private float startpos = 0;

	private Color fromcolor = Color.lightGray;

	private Color tocolor = Color.white;

	public final int TESTING = 0;

	public final int SUCCESS = 1;

	Color[] colors = { Color.lightGray, new Color(0, 150, 0) };

	public void run() {
		boolean growing = true;
		Random r = new Random();
		while (true) {
			Thread.yield();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
			if (active) {
				// fromcolor = new Color(0,150,0);
				if (growing) {
					startpos += 5;
					if (startpos > (getWidth() - 10)) {
						growing = false;
					}
				} else {
					startpos -= 5;
					if (startpos < -50) {
						growing = true;
					}
				}
				repaint();
			}
		}
	}

	public void setActive(boolean b, boolean success) {
		fromcolor = colors[TESTING];
		if (success)
			fromcolor = colors[SUCCESS];
		active = b;
		repaint();
	}

	public void paint(Graphics d) {
		int h = getHeight();
		int endpos = getWidth();
		((Graphics2D) d).setPaint(new GradientPaint(startpos, 0, fromcolor,
				endpos, 0, tocolor));
		d.fillRect(0, 0, endpos, h);
	}

}
