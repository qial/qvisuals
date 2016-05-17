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
	protected Visuals app = ProcessingUtil.getApp(this);
	
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
	
//	public int fpb() {
//		return getFramesPerBeat();
//	}
	
	private int debugFrameRate = 0;
	private int debugFramesPerBeat = 0;
	
//	public int getFramesPerBeat() {
//		if(!integer) {
//			throw new RuntimeException("Can't get integer frames per beat with a non-integer bpm");
//		}
//		
//		//TODO remove debug shit
//		boolean debugrate = false;
//		
//		int frameRate = round(app.frameRate);
//		int fpb = (frameRate * 60) / bpmi;
//		
//		// TODO remove more of this debug shit
//		if(frameRate != debugFrameRate) {
//			System.out.println("frameRate changed from "+debugFrameRate+" to "+frameRate);
//			debugrate = true;
//		}
//		if(fpb != debugFramesPerBeat && !debugrate) {
//			System.out.println("framesPerBeat changed from "+debugFramesPerBeat + " to "+fpb);
//		}
//		debugFrameRate = frameRate;
//		debugFramesPerBeat = fpb;
//		
//		return fpb;
//	}

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
	
	private class TimeArray {
		private final long[] times;
		private boolean init = false;
		//private int idx = 0;
		public TimeArray(int num) {
			times = new long[num];
			// pretty sure its zero by default, but whatever
			for(int i = 0; i < times.length; i++) {
				times[i]=0;
			}
		}
		public void addNow() {
			addTime(System.currentTimeMillis());
		}
		public void addTime(long time) {
			// TODO: Make this circular. I was lazy
			// move values forward
			for(int i = 0; i < times.length-1; i++) {
				times[i+1] = times[i];
			}
			times[0] = time;
		}
		public int getAverage() {
			// smallest will always be at the end
			long smallest = times[times.length-1];
			long runningAvg = 0;
			for(int i = times.length-1; i > 0; i--) {
				long dif = times[i]-times[i-1];
				runningAvg += dif;
			}
			// divide by times.length-1 to find actual average
			return (int)(runningAvg / (times.length-1));
		}
	}
}
