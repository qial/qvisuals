package net.qial.vj.sequencers;

import net.qial.vj.bpm.BPM;
import net.qial.vj.bpm.BpmBased;
import net.qial.vj.sequencer.ProcessingSequencer;
import net.qial.vj.util.DrawUtil;

/**
 * For now, BPM calculations with the sequencer are going to work on a strict
 * multiplier rule.
 * 
 * pulseMultiplier is the amount of times a pulse runs in the BPM. This way
 * effects that are exact factors of BPMs can be handled.
 * 
 * @author kw
 *
 */
public class BpmPulseSequencer extends ProcessingSequencer implements BpmBased {
	// amount of times per beat 
	protected int pulseMultiplier = 1;

	// width of pulse compared to pulse length
	protected float pulsePortion = 0.666f;
	
	protected BPM bpm = new BPM(120);
	private long startTime = 0;

	public BpmPulseSequencer() {
		this(new BPM(120));
	}
	
	public BpmPulseSequencer(BPM bpm) {
		// pulses are in a single direction, so always positive
		setPositive(true);
		setBpm(bpm);
	}

	public float get(int point) {
		//int pulseFrame = frameCount() % bpm.getFramesPerBeat();
		int pointLocation = getPointLocation(point);
		int pulseStart = getPulseStart();
		int pulseEnd = getPulseEnd();
		//println("point=" + point + " pointw=" + pointWidth() + " pulseFrame="
		// + pulseFrame + " position=" + pointLocation + " pStart="
		// + pulseStart + " pEnd=" + pulseEnd + " fpb="+bpm.getFramesPerBeat()
		// + " pw=" + pulseWidth());
		if (pointLocation >= pulseStart && pointLocation <= pulseEnd) {
			// get distance from pulse start
			float dist = pointLocation - pulseStart;
			// use the wave function
			float amt = DrawUtil.wave(dist, pulseWidth());
			//println("dist=" + dist + " amt=" + amt);
			return amt;
		} else {
			return 0.0f;
		}

	}

	private int debugPulseLength = 0;
	
	protected float getPulseLocation() {
		// TODO THIS ISNT STEADY
		
		// pulse length is number of frames
		float pulseLength = bpm.getFramesPerBeatf();
		
		// get current frame
		float currentFrame = bpm.getCurrentFrame();
		
		// TODO remove debug shit
//		if(debugPulseLength != pulseLength) {
//			System.out.println("pulse length changed to "+pulseLength+" from "+debugPulseLength);
//		}
//		debugPulseLength = pulseLength;
		
		
		
		// determine framecount to figure out what range
		// of points are within the pulse
		float pulseFrame = currentFrame % pulseLength;
		// we need to adjust so the pulse starts before and
		// ends after the start and end points of the effect
		float pulseAdjustment = (pulseLength + pulseWidth())
				/ ((float) pulseLength);
		float pulseLocation = pulseFrame * pulseAdjustment
				- (pulseWidth() / 2.0f);
		return pulseLocation;
	}

	protected int getPointLocation(int point) {
		return round(pointWidth() * point);
	}

	protected int getPulseStart() {
		return round(getPulseLocation() - (pulseWidth() / 2.0f));
	}

	protected int getPulseEnd() {
		return round(getPulseLocation() + (pulseWidth() / 2.0f));
	}
	
	// Calculates and returns pulse width
	// Recalculated every time because it depends on framerate
	protected int pulseWidth() {
		return round(bpm.getFramesPerBeatf() * pulsePortion);
	}
	
	protected float pointWidth() {
		return bpm.getFramesPerBeatf() / ((float) getPoints());
	}

	public void setPulseMultiplier(int pulseMultiplier) {
		this.pulseMultiplier = pulseMultiplier;
		recalculate();
	}

	public int getPulseMultiplier() {
		return pulseMultiplier;
	}
	
	public void setPulsePortion(float pulsePortion) {
		this.pulsePortion = pulsePortion;
		recalculate();
	}
	
	public float getPulsePortion() {
		return pulsePortion;
	}

	// recalculate internal variables
	protected void recalculate() {
		// no internal variables anymore
		startTime = System.currentTimeMillis();
	}
	
	public void setBpm(BPM bpm) {
		this.bpm = bpm;
		recalculate();
	}
	
	public BPM getBpm() {
		return bpm;
	}
}
