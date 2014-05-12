/**
 * 
 */
package screensaver.mover;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author connorhollenbeck
 *
 */
public class Racer extends Mover {

	/**
	 * @param center
	 * @param size
	 * @param speed
	 * @param angle
	 * @param color
	 */
	public Racer(Point center, Dimension size, int speed, int angle, Color color) {
		super(center, size, speed, angle, color);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see screensaver.mover.Mover#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics pen) {
		pen.setColor(getColor());
		pen.fillRect(getLeft(), getTop(), getSize().width, getSize().height);

	}
	
	/**
	 * Describes how to "animate" the shape by changing its state.
	 * 
	 * Currently, moves the shape according to its velocity and keeps it within
	 * the bounds of the canvas.
	 * 
	 * @param bounds
	 *            which encloses this shape
	 */
	public void move(Dimension bounds) {
		direction = 0;
		super.move(bounds);
		if (myCenter.x >= bounds.width - (mySize.width / 2)) {
			this.speed = 0;
		}
		else {
			speed = ourGenerator.nextInt(10) + 1;
		}
	}

}
