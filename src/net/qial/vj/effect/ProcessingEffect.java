package net.qial.vj.effect;

import processing.core.PApplet;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.Visuals;

public abstract class ProcessingEffect extends SimpleEffect {
	
	private Visuals app = ProcessingUtil.getApp();
	
	public void setPApplet(Visuals v) {
		this.app = app;
	}
	
	public PApplet getPApplet() {
		return app;
	}
	
	protected char key() {
		return app.key;
	}
	
	protected void println(String string) {
		app.println(string);
	}
	
	protected void message(String string) {
		app.message(string);
	}
	
	protected void background(int rgb) {
		app.background(rgb);
	}
	
	protected void noStroke() {
		app.noStroke();
	}
	
	protected void fill(int rgb) {
		app.fill(rgb);
	}
	
	protected void noFill() {
		app.noFill();
	}
	
	protected void rect(float x, float y, float w, float h) {
		app.rect(x, y, w, h);
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

}
