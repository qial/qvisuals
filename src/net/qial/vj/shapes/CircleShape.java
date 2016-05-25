package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.ShapeType;

@ShapeType(name="circle")
public class CircleShape extends EllipseShape {
	protected int size;
	
	public CircleShape() {
		
	}
	
	public CircleShape(PaintableDescription desc) {
		super(desc);
	}
	
	public CircleShape(int x, int y, int size) {
		super(x, y, size, size);
		this.size = size;
	}
	
	public void loadFrom(PaintableDescription desc) {
		// circle uses x,y,and r, so convert to old values
		size = (Integer)desc.get("size");
		desc.set("w",size);
		desc.set("h",size);
	}

	public void paint(PApplet app) {
		// TODO handle the fill/nofill options
		app.noFill();
		// need to redefine paint to handle movements
		float drawSize = size;
		if(movement != null) {
			drawSize += movement.getMovement();
		}
		app.ellipse(x,y,drawSize,drawSize);
	}
}
