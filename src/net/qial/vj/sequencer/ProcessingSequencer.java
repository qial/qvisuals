package net.qial.vj.sequencer;

import processing.core.PApplet;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.Visuals;

public abstract class ProcessingSequencer extends AbstractSequencer {
	private Visuals app = ProcessingUtil.getApp();

	public void setPApplet(Visuals v) {
		this.app = v;
	}

	public PApplet getPApplet() {
		return app;
	}

	protected void println(String string) {
		PApplet.println(string);
	}

	protected int frameCount() {
		return app.frameCount;
	}

	protected int round(float n) {
		return PApplet.round(n);
	}

	protected float frameRate() {
		return app.frameRate;
	}
}
