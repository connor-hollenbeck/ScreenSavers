/**
 * 
 */
package screensaver.factory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import screensaver.mover.Racer;
import screensaver.nomodify.Canvas;
import screensaver.nomodify.Factory;

/**
 * @author connorhollenbeck
 *
 */
public class RacerFactory extends Factory {

	/**
	 * @param name
	 */
	public RacerFactory() {
		super("Create Racers");
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see screensaver.nomodify.Factory#createMovers(screensaver.nomodify.Canvas, int)
	 */
	@Override
	// need to space them out evenly
	public void createMovers(Canvas target, int numberToCreate) {
		Dimension bounds = target.getSize();
		int difference = bounds.height / numberToCreate;
		int position = bounds.height - difference / 2;

		// create each racer and add to list
		for (int i = 0; i < numberToCreate; i++) { 
			Point center = new Point(0, position);
			Dimension racerSize = new Dimension(20, difference);
			int speed = nextIntInRange(1, 10);
			int direction = 0;
			Color racerColor = new Color(nextIntInRange(0, 255), nextIntInRange(
				0, 255), nextIntInRange(0, 255));
			Racer d = new Racer(center, racerSize, speed, direction,
					racerColor);
			target.add(d);
			position = d.getCenter().y - difference; 
		}

	}

}
