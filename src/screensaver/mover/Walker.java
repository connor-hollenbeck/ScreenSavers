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
public class Walker extends Mover {

	/**
	 * @param center
	 * @param size
	 * @param speed
	 * @param angle
	 * @param color
	 */
	public Walker(Point center, Dimension size, int speed, int angle,
			Color color) {
		super(center, size, speed, angle, color);
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
	 * Describes how to "animate" the shape by changing its state
	 * 
	 * @param bounds
	 *            which encloses this shape
	 */
	public void move(Dimension bounds) {
		direction = ourGenerator.nextInt(360) + 1;
		super.move(bounds);
	}


}
