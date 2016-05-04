package net.qial.vj.effects;

import net.qial.vj.effect.ParamEffect;

public class Diamond3 extends ParamEffect {
	final String amt = "shapes";
	final String inc = "spacing";
	final String amp = "amplitude";
	final String start = "start";

	public Diamond3() {
		// set up params
		addParam(amt, 10);
		addParam(inc, 28);
		addParam(amp, 18);
		addParam(start, 2);
	}

	public void play() {
		stroke(255);
		noFill();
		// num of shapes
		// int amt = 10;
		// distance between shapes
		// int inc = 28;
		// size of motion
		// int amp = 18;
		// min shape size
		// int start = 80;
		// width ratio
		float ratio = 1.6f;
		for (int i = getParam(start); i < getParam(amt); i++) {
			float s = seq.get(i) * getParam(amp);
			int bottom_x = (width() / 2);
			int bottom_y = (height() / 2) + (i * getParam(inc));
			int right_x = (width() / 2) + ((int) (i * getParam(inc) * ratio));
			int right_y = (height() / 2);
			int top_x = (width() / 2);
			int top_y = (height() / 2) - (i * getParam(inc));
			int left_x = (width() / 2) - ((int) (i * getParam(inc) * ratio));
			int left_y = (height() / 2);
			quad(bottom_x, bottom_y + s, right_x + s, right_y, top_x,
					top_y - s, left_x - s, left_y);
		}
	}
}
