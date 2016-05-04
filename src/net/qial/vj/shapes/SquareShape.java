package net.qial.vj.shapes;

import net.qial.vj.shape.Shape;

@Shape(name="square")
public class SquareShape extends RectShape {
	public SquareShape(int x, int y, int s) {
		super(x, y, s, s);
	}
}
