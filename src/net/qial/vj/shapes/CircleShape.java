package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.movement.Movement;
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
		
		// try to load location
		String loc = (String)desc.get("location");
		if(loc != null) {
			if("center".equals(loc)) {
				//TODO set x and y based on app
				// Maybe keep location stored and calculate at paint time
				this.x = 640;
				this.y = 360;
			}
		}
		
		// test x and y individually
		if(desc.get("x") != null) {
			this.x = (int) desc.get("x");
		}
		if(desc.get("y") != null) {
			this.y = (int) desc.get("y");
		}
		
	}

	public void paint(PApplet app) {
		// TODO handle the fill/nofill options
		app.noFill();
		// need to redefine paint to handle movements
		float drawSize = size;
		if(movements != null) {
			for(Movement m : movements) {
				if(m.getParam().equals("size")) {
					drawSize += m.getMovement();
				}
			}
		}
		app.ellipse(x,y,drawSize,drawSize);
	}
}
