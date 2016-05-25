package net.qial.vj.shape;

import net.qial.vj.effect.api.PaintableDescription;
import processing.core.PApplet;

/**
 * Abstract class to not force everything to implement empty prepare methods.
 * 
 * @author Kyle
 *
 */
public abstract class AbstractShape implements Shape {
	
	public AbstractShape() {
		// do nothing
	}
	
	public AbstractShape(PaintableDescription desc) {
		// load from description
		loadFrom(desc);
	}

	@Override
	public void prepare(PApplet app) {
		// this is implemented as an empty method because most simple shapes
		// won't need any setup
	}

}
