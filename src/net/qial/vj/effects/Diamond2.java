package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;

public class Diamond2 extends ProcessingEffect {
	public void play() {
		stroke(255);
		noFill();
		// num of shapes
		int amt = 10;
		// distance between shapes
		int inc = 30;
		// size of motion
		int amp = 20;
		// min shape size
		int start = 90;
		// width ratio
		float ratio = 1.25f;
		for (int i = 0; i < amt; i++) {
			float s = seq.get(i) * amp;
			int bottom_x = (width() / 2);
			int bottom_y = (height() / 2) + start + (i * inc);
			int right_x = (width() / 2) - ((int) ((start + (i * inc)) * ratio));
			int right_y = (height() / 2);
			int top_x = (width() / 2);
			int top_y = (height() / 2) - start - (i * inc);
			int left_x = (width() / 2) + ((int) ((start + (i * inc)) * ratio));
			int left_y = (height() / 2);
			quad(bottom_x, bottom_y + s, right_x + s, right_y, top_x,
					top_y - s, left_x - s, left_y);

		}
	}
}
