package net.qial.vj.sequencers;

import processing.core.PApplet;
import net.qial.vj.sequencer.ProcessingSequencer;
import net.qial.vj.sequencer.SequencerType;

@SequencerType(name="sin")
public class SineSequencer extends ProcessingSequencer {

	// percentage of 2pi the points are over
	// default is 1
	private float period = 1.0f;

	// speed multiplier
	// default speed is a period every measure (once per 2 seconds)
	private float speed = 1.0f;

	// offset, where to start pattern (Expected to be actual number)
	// Only particularly useful for exporting
	private float offset = 0.0f;

	public SineSequencer() {
		recalculate();
	}

	public float get(int point) {
		// get the current point in the pattern
		float x = frameCount() * frameSpeed;
		// add offset
		x += periodOffset;
		// add point offset
		x += (pointOffset * point);

		if (positive()) {
			// convert sign wave to 0->1
			return (PApplet.sin(x) + 1.0f) / 2.0f;
		}
		return PApplet.sin(x);
	}

	// internal calculated variables
	private float periodOffset;
	private float pointOffset;
	private float frameSpeed;

	protected void recalculate() {
		// period offset is simply where it starts, so 1.0 is
		periodOffset = offset * PApplet.PI;
		// point offset is the period length divided by number of points
		// must also convert period length to PI amounts
		pointOffset = (period / getPoints()) * PApplet.TWO_PI;
		// framespeed is how much of a period per frame
		// speed 1.0 = 2*frameRate per period
		// speed 0.5 = frameRate per period
		frameSpeed = (PApplet.PI / frameRate()) * speed;
	}

	public void setPeriod(float period) {
		this.period = period;
		recalculate();
	}

	public void setSpeed(float speed) {
		this.speed = speed;
		recalculate();
	}

	public void setOffset(float offset) {
		this.offset = offset;
		recalculate();
	}
}
