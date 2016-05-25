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
		DrawUtil.makeV(w, o, app);
	}

	@Override
	public void loadFrom(PaintableDescription desc) {
		this.w = (Integer)desc.get("w");
		this.o = (Integer)desc.get("o");
	}
}
