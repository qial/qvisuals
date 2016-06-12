package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.AbstractShape;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.ShapeType;
import net.qial.vj.util.DrawUtil;

@ShapeType(name="v-up")
public class VShape extends AbstractShape {
	private int w, o;
	
	public VShape() {
		
	}
	
	public VShape(PaintableDescription desc) {
		super(desc);
	}

	public VShape(int w, int offset) {
		this.w = w;
		this.o = offset;
	}
	
	public void prepare(PApplet app) {
		// no changes needed yet
	}

	public void paint(PApplet app) {
		float offset = (float) o;
		float width = (float) w;
		
		if(movement != null) {
			if(movement.getParam().equals("offset")) {
				offset += movement.getMovement();
			}
			else if(movement.getParam().equals("width")) {
				width += movement.getMovement();
			}
			else {
				super.applyMovement(movement, app);
			}
		}
		DrawUtil.makeV((int) width, (int) offset, app);

		// TODO handle the fill/nofill options
		//app.noFill();
		// need to redefine paint to handle movements
		//float drawSize = size;
		//if(movement != null) {
		//	drawSize += movement.getMovement();
		//}
		//app.ellipse(x,y,drawSize,drawSize);
	}

	@Override
	public void loadFrom(PaintableDescription desc) {
		this.w = (Integer)desc.get("width");
		this.o = (Integer)desc.get("offset");
	}
}
