package net.qial.vj.effects.pulse;

import net.qial.vj.sequencers.PulseSequencer;
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
		// get reference to sequencer
		PulseSequencer mySeq = (PulseSequencer)seq;
		noFill();
		int printlimit = 60;
		if (frameCount() <= printlimit)
			println("\nFrame: " + frameCount());
		
		int currentFrame = frameCount() % mySeq.getPulseLength();
		// Keep a circle drawn on the outside param
		// fade outside circle in
		int outsideCircleStroke = (int)(255 * 
				DrawUtil.waveUp(currentFrame, mySeq.getPulseLength()));
		stroke(outsideCircleStroke);
		DrawUtil.makeCircle(600,app);
		
		// loop through the circles that can move
		for (int i = 0; i < getParam(amt); i++) {
			float offset = i * getParam(inc);
			float pulse = seq.get(i);
			float movement = pulse * getParam(amp);
			int circle = (int) (600 - offset - movement);
			
			// make last circle fade out
			if(i == getParam(amt)-1) {
				float brightness = DrawUtil.waveDown(pulse*mySeq.getPulseWidth(), 
						mySeq.getPulseWidth());
				stroke((int)(brightness*255));
			} else {
				stroke(255);
			}
			DrawUtil.makeCircle(circle, app);
			if (frameCount() <= printlimit) {
				// println(i+": off="+offset+" pls="+pulse+" mv="+movement+" cir="+circle);
			}
		}
	}
}
