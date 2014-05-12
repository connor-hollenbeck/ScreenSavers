package simplebouncers;

import java.awt.*;

/**
 * Represents a ball that bounces around within the given bounds.
 * 
 * Draws itself as a circle.
 * 
 * @author Robert C. Duvall
 */
public class BouncingBall {

	private static final int RADIUS = 50;
	private static final int DIAMETER = 2 * RADIUS;

	private Point myCenter;
	private Point myVelocity;

	/**
	 * Construct a bouncer at the given position and with the given velocity
	 * 
	 * @param center
	 *            initial center position of the shape
	 * @param velocity
	 *            amount to move shape in x- and y-direction
	 */
	public BouncingBall(Point center, Point velocity) {
		myCenter = center;
		myVelocity = velocity;
	}

	/**
	 * Determine how the shape animates by making a small change to some
	 * attribute (position, color, size, etc.) over time.
	 * 
	 * @param bounds
	 *            within which bouncer appears
	 */
	public void update(Dimension bounds) {
		// move shape according to its velocity
		myCenter.x += myVelocity.x;
		myCenter.y += myVelocity.y;

		// check for move out of bounds on side walls
		if (myCenter.x + RADIUS > bounds.width || myCenter.x - RADIUS < 0) {
			myVelocity.x *= -1;
		}
		// check for move out of bounds on the ceiling or floor
		if (myCenter.y + RADIUS > bounds.height || myCenter.y - RADIUS < 0) {
			myVelocity.y *= -1;
		}
	}

	/**
	 * Render a graphical view of bouncer
	 * 
	 * @param pen
	 *            used to paint shape on the screen
	 */
	public void paint(Graphics pen) {
		pen.setColor(Color.BLUE);
		pen.fillOval(myCenter.x - RADIUS, myCenter.y - RADIUS, DIAMETER,
				DIAMETER);
	}
}
