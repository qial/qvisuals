package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.AbstractShape;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.Shape;

@Shape(name="rect")
public class RectShape extends AbstractShape {
	protected int x, y, w, h;

	public RectShape() {
		
	}
	
	public RectShape(PaintableDescription desc) {
		super(desc);
	}
	
	public RectShape(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void prepare(PApplet app) {
		// no changes needed
	}

	public void paint(PApplet app) {
		app.rect(x, y, w, h);
	}

	@Override
	public void loadValues(PaintableDescription desc) {
		this.x = (Integer)desc.get("x");
		this.y = (Integer)desc.get("y");
		this.w = (Integer)desc.get("w");
		this.h = (Integer)desc.get("h");
	}
}
