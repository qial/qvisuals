package net.qial.vj.sequencer;

import net.qial.vj.effect.ParamEffect;
import net.qial.vj.sequencers.PulseSequencer;

public class SequencerViewer extends ParamEffect {
	// declaring params
	final String w = "boxWidth";
	final String h = "boxHeight";
	final String a = "amplitude";
	final String m = "multiplier";
	Sequencer seq;

	public SequencerViewer() {
		this(new PulseSequencer());
	}

	public SequencerViewer(Sequencer seq) {
		this.seq = seq;
		addParam(w, 20);
		addParam(h, 20);
		addParam(a, 120);
		addParam(m, 1);
	}

	public void play() {
		// draw the boxes
		noFill();
		stroke(255);
		for (int i = 0; i < seq.getPoints(); i++) {
			float amt = seq.get(i);
			int offset = round(getParam(a) * amt);
			int x = i * getParam(w) * 2;
			int y = height() - getParam(h) - offset;
			rect(x, y, getParam(w), getParam(h));
		}
	}

}