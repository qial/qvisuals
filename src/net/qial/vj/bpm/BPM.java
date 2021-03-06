package net.qial.vj.bpm;

// import the BpmMode enum
import static net.qial.vj.bpm.BpmMode.*;
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
	private BpmMode mode;
	
	private long startTime = 0;
	
	// track average over last 10 frames by default
	//private TimeArray fpsTracker = new TimeArray(10);
	
	protected Visuals app = ProcessingUtil.getApp(this);
	
	public BPM(int bpm) {
		this(bpm,PERFORMANCE);
	}
	
	public BPM(float bpm) {
		this(bpm,PERFORMANCE);
	}
	
	public BPM(int bpm, BpmMode mode) {
		setMode(mode);
		setBpm(bpm);
	}

	public BPM(float bpm, BpmMode mode) {
		setMode(mode);
		setBpm(bpm);
	}
	
	public void setBpm(int bpm) {
		bpmi = bpm;
		bpmf = bpm;
		integer = true;
		// reset timer
		startTime = System.currentTimeMillis();
	}
	
	public void setBpm(float bpm) {
		bpmf = bpm;
		bpmi = (int)bpm;
		integer = false;
		// reset timer
		startTime = System.currentTimeMillis();
	}
	
	public void setMode(BpmMode mode) {
		this.mode = mode;
		// reset timer if mode is changing
		startTime = System.currentTimeMillis();
	}
	
	public float fpbf() {
		return getFramesPerBeatf();
	}
	
	public float getFramesPerBeatf() {
		float frameRate = app.getTargetFramerate();
		float fpb = (frameRate * 60) / bpmf;
//		println("fps="+frameRate+" bpmf="+bpmf+" fpb="+fpb);
		return fpb;
	}
	
	public float getCurrentFrame() {
		// Determine mode
		switch(mode) {
		case RECORD:
			// simply return the actual frameCount
			return app.frameCount;
		case PERFORMANCE:
		default: // default to performance mode
			// calculate "frame" based on current time and target
			// framerate, so that it keeps up if framerate drops
			long curTime = System.currentTimeMillis();
			long passedTime = curTime - startTime;
			// get target framerate
			int frameRate = app.getTargetFramerate();
			// frames / sec, passedTime sec / 1000
			long frameMillis = frameRate * passedTime;
			float frame = frameMillis / 1000.0f;
			return frame;
		}
	}
	
//	public float getCurrentFrame() {
//		
//	}
	
	// uses the TimeArray averaging (only really works if this class
	// gets called every frame. Otherwise we will have issues.
	// TODO make it not suck if for some reason it isn't every frame
//	public float getFrameRate() {
//		// make sure we add the frame to our average
//		fpsTracker.addNow(app.frameCount);
//		float millisPerFrame = fpsTracker.getAverage();
//		// convert millis per frame to frames per second
//		float secPerFrame = millisPerFrame / 1000.0f;
//		return 1.0f / secPerFrame;
//	}
	
//	public int fpb() {
//		return getFramesPerBeat();
//	}
	
//	private int debugFrameRate = 0;
//	private int debugFramesPerBeat = 0;
	
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
	
	// No longer useful
//	private class TimeArray {
//		private final long[] times;
//		private boolean init = false;
//		private int lastFrame = 0;
//		public TimeArray(int num) {
//			times = new long[num];
//			// pretty sure its zero by default, but whatever
//			for(int i = 0; i < times.length; i++) {
//				times[i]=0;
//			}
//		}
//		public void addNow(int frameCount) {
//			// only add the time if its a new frame
//			if(frameCount > lastFrame) {
//				lastFrame = frameCount;
//				// add time
//				addNow();
//			}
//		}
//		public void addNow() {
//			addTime(System.currentTimeMillis());
//		}
//		public void addTime(long time) {
//			// TODO: Make this circular. I was lazy
//			// move values forward
//			for(int i = times.length-1; i > 0; i--) {
//				times[i] = times[i-1];
//			}
//			times[0] = time;
//		}
//		// this essentially returns the average milliseconds per frame
//		public float getAverage() {
//			// smallest will always be at the end
//			long smallest = times[times.length-1];
//			long runningAvg = 0;
//			for(int i = 0; i < times.length-1; i++) {
//				long dif = times[i]-times[i+1];
//				runningAvg += dif;
////				System.out.println("["+i+"] d="+dif+" r="+runningAvg);
//			}
//			// divide by times.length-1 to find actual average
//			float avg = ((float)runningAvg / ((float)(times.length-1)));
////			System.out.println("avg="+avg);
//			return avg;
//		}
//	}
}
