package net.qial.vj.shapes;

import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.ShapeType;

@ShapeType(name="square")
public class SquareShape extends RectShape {
	public SquareShape() {
		
	}
	
	public SquareShape(PaintableDescription desc) {
		super(desc);
	}

	public SquareShape(int x, int y, int s) {
		super(x, y, s, s);
	}
	
	public void loadValues(PaintableDescription desc) {
		// square uses x, y, and s, so convert to old values
		int s = (Integer)desc.get("s");
		desc.set("w",s);
		desc.set("h",s);
	}
}
