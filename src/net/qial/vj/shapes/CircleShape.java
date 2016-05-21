package net.qial.vj.shapes;

import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.Shape;

@Shape(name="circle")
public class CircleShape extends EllipseShape {
	public CircleShape() {
		
	}
	
	public CircleShape(PaintableDescription desc) {
		super(desc);
	}
	
	public CircleShape(int x, int y, int r) {
		super(x, y, r * 2, r * 2);
	}
	
	public void loadValues(PaintableDescription desc) {
		// circle uses x,y,and r, so convert to old values
		int r = (Integer)desc.get("r");
		desc.set("w",r*2);
		desc.set("h",r*2);
	}
}
