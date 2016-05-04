package net.qial.vj.shapes;

import net.qial.vj.shape.Shape;

@Shape(name="diamond")
public class DiamondShape extends RectShape {
	public DiamondShape(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint() {
		// TODO: reimplement paint to just make a diamond
	}
}