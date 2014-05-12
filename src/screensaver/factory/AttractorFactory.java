package screensaver.factory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import screensaver.mover.Attractor;
import screensaver.nomodify.Canvas;
import screensaver.nomodify.Factory;

public class AttractorFactory extends Factory {

	public AttractorFactory() {
		super("Create Attractors");
	}

	@Override
	public void createMovers(Canvas target, int numberToCreate) {
		Dimension bounds = target.getSize();
		int diameter = Math.min(bounds.height, bounds.width); 
		
		// create each attractor and add to list
		for (int i = 0; i < numberToCreate; i++) { 
			Dimension attractorSize = new Dimension ((int) Math.PI * diameter / numberToCreate, 
					(int) (Math.PI * diameter / numberToCreate));
			double difference = (double) i / numberToCreate;
			double Xcoord = diameter / 2 * Math.cos(2 * Math.PI * difference) + diameter / 2;
			double Ycoord = diameter / 2 * Math.sin(2 * Math.PI * difference) + diameter / 2;
			Point center = new Point((int) (Xcoord), (int) (Ycoord));
			int speed = 4;
			int direction = 0;
			Color attractorColor = new Color(nextIntInRange(
					0, 255), 0, 0);
			Attractor d = new Attractor(center, attractorSize, speed, direction,
					attractorColor);
			target.add(d);
		}
	}
}
