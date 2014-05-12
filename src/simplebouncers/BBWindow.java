package simplebouncers;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * A simple bouncing world example to get started
 * 
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class BBWindow extends JFrame {

	public BBWindow() {
		final Dimension SIZE = new Dimension(600, 600);
		// animate 25 times per second if possible
		final int DEFAULT_DELAY = 10; // in milliseconds

		// create container that will display the shapes to animate
		Display display = new Display(SIZE);
		display.setPreferredSize(SIZE);
		display.setBackground(Color.WHITE);

		// create a timer to animate the canvas
		Timer timer = new Timer(DEFAULT_DELAY, display);

		setTitle("Ball World");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// add our container to frame
		getContentPane().add(display);
		setSize(SIZE);
		pack();

		setVisible(true);

		// start the animation
		timer.start();
	}

	public static void main(String args[]) {
		new BBWindow();
	}
}
