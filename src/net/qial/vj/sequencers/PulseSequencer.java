package net.qial.vj.sequencers;

import net.qial.vj.sequencer.ProcessingSequencer;
import net.qial.vj.sequencer.SequencerType;
import net.qial.vj.util.DrawUtil;

@SequencerType(name="pulse")
public class PulseSequencer extends ProcessingSequencer {
	// amount of frames it takes for the pulse to fully travel
	protected int pulseLength = 30;

	// amount of frames the pulse takes to go up and back.
	protected int pulseWidth = 20;

	// internal vars
	protected float pointWidth = 0.0f;

	public PulseSequencer() {
		// pulses are in a single direction, so always positive
		setPositive(true);
		recalculate();
	}

	public float get(int point) {

		int pointLocation = getPointLocation(point);
		int pulseStart = getPulseStart();
		int pulseEnd = getPulseEnd();
		// println("point=" + point + " pointw=" + pointWidth + " pulseFrame="
		// + pulseFrame + " position=" + pointLocation + " pStart="
		// + pulseStart + " pEnd=" + pulseEnd);
		if (pointLocation >= pulseStart && pointLocation <= pulseEnd) {
			// get distance from pulse start
			float dist = pointLocation - pulseStart;
			// use the wave function
			float amt = DrawUtil.wave(dist, pulseWidth);
			println("dist=" + dist + " amt=" + amt);
			return amt;
		} else {
			return 0.0f;
		}

	}

	protected float getPulseLocation() {
		// determine framecount to figure out what range
		// of points are within the pulse
		int pulseFrame = frameCount() % pulseLength;
		// we need to adjust so the pulse starts before and
		// ends after the start and end points of the effect
		float pulseAdjustment = (pulseLength + pulseWidth)
				/ ((float) pulseLength);
		float pulseLocation = pulseFrame * pulseAdjustment
				- (pulseWidth / 2.0f);
		return pulseLocation;
	}

	protected int getPointLocation(int point) {
		return round(pointWidth * point);
	}

	protected int getPulseStart() {
		return round(getPulseLocation() - (pulseWidth / 2.0f));
	}

	protected int getPulseEnd() {
		return round(getPulseLocation() + (pulseWidth / 2.0f));
	}

	public void setPulseLength(int pulseLength) {
		this.pulseLength = pulseLength;
		recalculate();
	}

	public int getPulseLength() {
		return pulseLength;
	}

	public int getPulseWidth() {
		return pulseWidth;
	}

	// recalculate internal variables
	protected void recalculate() {
		pointWidth = ((float) pulseLength) / ((float) getPoints());
	}
}
