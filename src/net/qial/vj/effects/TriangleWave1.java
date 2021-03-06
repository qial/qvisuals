package net.qial.vj.effects;

import net.qial.vj.effect.ParamEffect;
import net.qial.vj.util.DrawUtil;

public class TriangleWave1 extends ParamEffect {
	final String amt = "shapes";
	final String inc = "spacing";
	final String amp = "amplitude";
	final String start = "size";

	public TriangleWave1() {
		// set up params
		addParam(amt, 10);
		addParam(inc, 28);
		addParam(amp, 18);
		addParam(start, 80);
	}

	public void play() {
		for (int i = 0; i < getParam(amt); i++) {
			float s = seq.get(i);
			int offset = i * 20 + (int) (s * 20);
			DrawUtil.makeTriangle(100 + DrawUtil.getSizeForOffset(offset),
					360 - offset, app);
		}
		// for(int i = 1; i < 10; i++) {
		// float s = seq.get(9-i);
		// int offset = i*20 + (int)(s * 20);
		// makeTriangle(100+getSizeForOffset(offset),360-offset);
		// }
	}
}
