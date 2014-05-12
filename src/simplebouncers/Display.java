package simplebouncers;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * Animates two ovals that start in the center of the window, moving in two
 * directions, and "bounce" elastically, i.e., as a perfect reflection, when
 * they hit the boundaries of the window.
 * 
 * Each time paint is called, it changes the position of the oval and the
 * reports to Java that it needs to be painted again, causing the paint method
 * to be called again (and again and again ...).
 * 
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener {

	// state to remember over time
	private BouncingBall myBouncer1;
	private BouncingBall myBouncer2;

	/**
	 * Construct panel of the given size.
	 * 
	 * @param size
	 *            total size of the Canvas
	 */
	public Display(Dimension size) {
		myBouncer1 = new BouncingBall(
				new Point(size.width / 2, size.height / 2), new Point(3, 1));
		myBouncer2 = new BouncingBall(
				new Point(size.width / 2, size.height / 2), new Point(-3, -1));
	}

	/**
	 * Paint the contents of the panel.
	 * 
	 * Never called by you directly, instead called by Java runtime when area of
	 * screen covered by this container needs to be displayed (i.e., creation,
	 * uncovering, change in status)
	 * 
	 * @param pen
	 *            used to paint shape on the screen
	 */
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		myBouncer1.paint(pen);
		myBouncer2.paint(pen);
	}

	/**
	 * Updates the contents of the panel.
	 * 
	 * Never called by you directly, instead called by the Timer every few
	 * milli-seconds.
	 */
	public void actionPerformed(ActionEvent e) {
		// update the state of the animation
		Dimension bounds = getSize();
		myBouncer1.update(bounds);
		myBouncer2.update(bounds);
		// let Java runtime know panel needs to be repainted
		repaint();
	}
}
