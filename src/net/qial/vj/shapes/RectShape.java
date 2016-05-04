package net.qial.vj.shapes;

import processing.core.PApplet;
import net.qial.vj.shape.Shape;

public class RectShape implements Shape {
	protected int x, y, w, h;

	public RectShape(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void paint(PApplet app) {
		app.rect(x, y, w, h);
	}
}
