package net.qial.vj.effects.pulse;

import net.qial.vj.bpm.BPM;
import net.qial.vj.effect.ParamEffect;
import net.qial.vj.sequencers.BpmPulseSequencer;
import net.qial.vj.util.DrawUtil;

public class BpmPulseCircle extends ParamEffect {
	protected final String bpm = "bpm";
	protected final String mult = "multiplier";
	protected final String amt = "shapes";
	protected final String inc = "spacing";
	protected final String amp = "amplitude";
	
	private BPM myBpm;

	public BpmPulseCircle() {
		// set up bpm
		myBpm = new BPM(90);
		// set up sequencer
		BpmPulseSequencer bpmseq = new BpmPulseSequencer(myBpm);
		this.setSequencer(bpmseq);
		// set up params
		addParam(bpm, 90);
		addParam(mult, 1);
		addParam(amt, 10);
		addParam(inc, 60);
		addParam(amp, 30);
	}
	
	@Override
	public void handleKey() {
		// make sure we change the BPM object when BPM changes
		int temp = getParam(bpm);
		super.handleKey();
		if(temp != getParam(bpm)) {
			// bpm has changed
			myBpm.setBpm(getParam(bpm));
		}
	}

	public void play() {
		stroke(255);
		noFill();
		int printlimit = 60;
		if (frameCount() <= printlimit)
			println("\nFrame: " + frameCount());
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
