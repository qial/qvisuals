package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.util.DrawUtil;

public class TriangleWave2 extends ProcessingEffect {
	public void play() {
		float amt = sin(frameCount() / 60.0f) * 30.0f;
		for (int i = 1; i < 20; i++) {
			DrawUtil.makeTriangle((int) (100 + (amt * i)), 100 * i, app);
		}
	}
}