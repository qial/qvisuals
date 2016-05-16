package net.qial.vj.sequencer;

import processing.core.PApplet;
import net.qial.vj.processing.NeedsApp;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.Visuals;

public abstract class ProcessingSequencer extends AbstractSequencer implements NeedsApp {
	private Visuals app = ProcessingUtil.getApp(this);

	public void setApp(Visuals v) {
		this.app = v;
	}

	public Visuals getApp() {
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
