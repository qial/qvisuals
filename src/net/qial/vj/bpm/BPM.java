package net.qial.vj.bpm;

import processing.core.PApplet;
import net.qial.vj.processing.NeedsApp;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.Visuals;

/**
 * Given a BPM and a framerate, this class uses the methods in BpmUtil to
 * provide simpler helper methods to calculate speed of travel.
 * 
 * @author kw
 *
 */
public class BPM implements NeedsApp {
	private float bpmf;
	private int bpmi;
	private boolean integer = false;
	protected Visuals app = ProcessingUtil.getApp();
	
	public BPM(int bpm) {
		setBpm(bpm);
	}
	
	public BPM(float bpm) {
		setBpm(bpm);
	}
	
	public void setBpm(int bpm) {
		bpmi = bpm;
		bpmf = bpm;
		integer = true;
	}
	
	public void setBpm(float bpm) {
		bpmf = bpm;
		bpmi = (int)bpm;
		integer = false;
	}
	
	public float fpbf() {
		return getFramesPerBeatf();
	}
	
	public float getFramesPerBeatf() {
		float frameRate = app.frameRate;
		float fpb = (frameRate * 60) / bpmf;
		//println("fps="+frameRate+" bpmf="+bpmf+" fpb="+fpb);
		return fpb;
	}
	
	public int fpb() {
		return getFramesPerBeat();
	}
	
	public int getFramesPerBeat() {
		if(!integer) {
			throw new RuntimeException("Can't get integer frames per beat with a non-integer bpm");
		}
		int frameRate = round(app.frameRate);
		int fpb = (frameRate * 60) / bpmi;
		return fpb;
	}

	@Override
	public void setApp(Visuals v) {
		this.app = v;
	}

	@Override
	public Visuals getApp() {
		return app;
	}
	
	private int round(float f) {
		return PApplet.round(f);
	}
	
	protected void println(String str) {
		PApplet.println(str);
	}
}
