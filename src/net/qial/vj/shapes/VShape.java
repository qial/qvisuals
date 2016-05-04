package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.Shape;
import net.qial.vj.util.DrawUtil;

@Shape(name="v-up")
class VShape implements Paintable {
	int w, o;

	public VShape(int w, int offset) {
		this.w = w;
		this.o = offset;
	}

	public void paint(PApplet app) {
		DrawUtil.makeV(w, o, app);
	}
}
