package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.Shape;

@Shape(name="ellipse")
public class EllipseShape extends RectShape {
	public EllipseShape() {
		// we need a zero argument constructor
	}
	
	public EllipseShape(PaintableDescription desc) {
		super(desc);
	}
	
	public EllipseShape(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(PApplet app) {
		 app.ellipse(x,y,w,h);
	}
}
