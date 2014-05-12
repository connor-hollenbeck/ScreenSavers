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
public class Attractor extends Mover {

	/**
	 * @param center
	 * @param size
	 * @param speed
	 * @param angle
	 * @param color
	 */
	public Attractor(Point center, Dimension size, int speed, int angle,
			Color color) {
		super(center, size, speed, angle, color);
	}

	/* (non-Javadoc)
	 * @see screensaver.mover.Mover#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics pen) {
		pen.setColor(getColor());
		pen.fillOval(getLeft(), getTop(), getSize().width, getSize().height);

	}
	
	public void move(Dimension bounds) {
		int diameter = Math.min(bounds.width, bounds.height);
		double Xcoord = Math.cos(2 * Math.PI * diameter / 2) + diameter / 2;
		double Ycoord = Math.sin(2 * Math.PI * diameter / 2) + diameter / 2;
		
		if (myCenter.x > Xcoord && myCenter.y > Ycoord) {
			direction = 225;
		}
		if (myCenter.x < Xcoord && myCenter.y > Ycoord) {
			direction = 315;
		}
		if (myCenter.x > Xcoord && myCenter.y < Ycoord) {
			direction = 135;
		}
		if (myCenter.x < Xcoord && myCenter.y < Ycoord) {
			direction = 45;
		}
		super.move(bounds);
	}
	

}
