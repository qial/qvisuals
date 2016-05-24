package net.qial.vj.shapes;

import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.ShapeType;

@ShapeType(name="circle")
public class CircleShape extends EllipseShape {
	public CircleShape() {
		
	}
	
	public CircleShape(PaintableDescription desc) {
		super(desc);
	}
	
	public CircleShape(int x, int y, int size) {
		super(x, y, size, size);
	}
	
	public void loadValues(PaintableDescription desc) {
		// circle uses x,y,and r, so convert to old values
		int size = (Integer)desc.get("size");
		desc.set("w",size);
		desc.set("h",size);
	}
}
