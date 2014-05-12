/**
 * 
 */
package screensaver.factory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import screensaver.mover.Walker;
import screensaver.nomodify.Canvas;
import screensaver.nomodify.Factory;

/**
 * @author connorhollenbeck
 *
 */
public class WalkerFactory extends Factory {

	/**
	 * @param name
	 */
	public WalkerFactory() {
		super("Create Walkers");
	}

	/* (non-Javadoc)
	 * @see screensaver.nomodify.Factory#createMovers(screensaver.nomodify.Canvas, int)
	 */
	@Override
	public void createMovers(Canvas target, int numberToCreate) {
		// current size of canvas
			Dimension bounds = target.getSize();
			Dimension walkerSize = new Dimension (bounds.width / numberToCreate, 
					bounds.height / numberToCreate);
			int walkerWidth = walkerSize.width;
			int walkerHeight = walkerSize.height;
	
			// create each walker and add to list
			for (int i = 0; i < numberToCreate; i++) { 
				Point center = new Point(walkerWidth / 2 + i * walkerWidth, 
						walkerHeight / 2 + i * walkerHeight);
				int speed = 4;
				int direction = 0;
				Color walkerColor = new Color(nextIntInRange(0, 255), nextIntInRange(
						0, 255), nextIntInRange(0, 255));
				Walker d = new Walker(center, walkerSize, speed, direction,
					walkerColor);
				target.add(d);
			}

	}

}
