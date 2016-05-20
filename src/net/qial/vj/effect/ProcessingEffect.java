package net.qial.vj.effect;

import processing.core.PApplet;
import net.qial.vj.processing.NeedsApp;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.Visuals;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.sequencer.SequencerViewer;
import net.qial.vj.sequencers.SineSequencer;

public abstract class ProcessingEffect extends SimpleEffect implements NeedsApp {

	// if needed, subclasses can access this
	protected Visuals app = ProcessingUtil.getApp(this);

	// subclasses can access this directly
	protected Sequencer seq = new SineSequencer();

	public void setApp(Visuals v) {
		this.app = v;
	}

	public Visuals getApp() {
		return app;
	}

	public void setSequencer(Sequencer seq) {
		this.seq = seq;
	}

	public Sequencer seq() {
		return seq;
	}

	protected char key() {
		return app.key;
	}

	protected void println(String string) {
		PApplet.println(string);
	}

	protected void message(String string) {
		app.message(string);
	}

	protected void background(int rgb) {
		app.background(rgb);
	}
	
	protected void background(int r, int g, int b) {
		app.background(r,g,b);
	}

	protected void stroke(int rgb) {
		app.stroke(rgb);
	}
	
	protected void stroke(int r, int g, int b) {
		app.stroke(r,g,b);
	}

	protected void noStroke() {
		app.noStroke();
	}
	
	protected void strokeWeight(float w) {
		app.strokeWeight(w);
	}

	protected void fill(int rgb) {
		app.fill(rgb);
	}

	protected void noFill() {
		app.noFill();
	}

	protected int round(float n) {
		return PApplet.round(n);
	}

	protected int height() {
		return app.height;
	}

	protected int width() {
		return app.width;
	}

	protected int frameCount() {
		return app.frameCount;
	}
	
	protected void line(float x1, float y1, float x2, float y2) {
		app.line(x1, y1, x2, y2);
	}
	
	protected void line(float x1, float y1, float x2, 
			float y2, float z1, float z2) {
		app.line(x1, y1, x2, y2,z1,z2);
	}

	protected void rect(float x, float y, float w, float h) {
		app.rect(x, y, w, h);
	}

	protected void quad(float x1, float y1, float x2, float y2, float x3,
			float y3, float x4, float y4) {
		app.quad(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	protected float sin(float angle) {
		return PApplet.sin(angle);
	}

	protected float cos(float angle) {
		return PApplet.cos(angle);
	}
	
	protected float sqrt(float n) {
		return PApplet.sqrt(n);
	}
	
	public SequencerViewer getSequencerViewer() {
		return new SequencerViewer(seq);
	}

}
