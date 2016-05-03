package net.qial.vj.effects.pulse;

import net.qial.vj.sequencers.PulseUpSequencer;
import net.qial.vj.util.DrawUtil;

public class PulseCircle2 extends PulseCircle1 {
	public PulseCircle2() {
		super();
		setSequencer(new PulseUpSequencer());
		// set new default params
	    setParam(amt,10);
	    setParam(inc,60);
	    setParam(amp,60);
	    setParam(skip,3);
	}
	public void play() {
		stroke(255);
		noFill();
		int printlimit = 60;
		if (frameCount() <= printlimit)
			println("\nFrame: " + frameCount());
		// Keep a circle drawn on the outside param
		for (int i = 0; i < getParam(amt); i++) {
			float offset = i * getParam(inc);
			float pulse = seq.get(i);
			float movement = pulse * getParam(amp);
			int circle = (int) (600 - offset - movement);
			DrawUtil.makeCircle(circle, app);
			if (frameCount() <= printlimit) {
				// println(i+": off="+offset+" pls="+pulse+" mv="+movement+" cir="+circle);
			}
		}
	}
}
