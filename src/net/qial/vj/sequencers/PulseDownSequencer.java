package net.qial.vj.sequencers;

import net.qial.vj.util.DrawUtil;

/**
 * This class uses the same movement as the PulseSequencer, but all points
 * are at 1.0 at the start, and only move to 0.0 after the pulse peak passes.
 * @author kw
 *
 */
public class PulseDownSequencer extends PulseSequencer {
	public float get(int point) {
		float pulseLocation = getPulseLocation();

		int pointLocation = getPointLocation(point);
		int pulseStart = getPulseStart();
		int pulseEnd = getPulseEnd();
		if(pointLocation >= pulseLocation) {
			// if pulse hasn't passed, stay at 1.0
			return 1.0f;
		} else if (pointLocation >= pulseStart && pointLocation < pulseEnd) {
			// pulse is going down
			// get distance from pulse start
			float dist = pointLocation - pulseStart;
			// use the wave function
			float amt = DrawUtil.wave(dist, pulseWidth);
			println("dist=" + dist + " amt=" + amt);
			return amt;
		} else {
			// return 0 because pulse has passed us
			return 0.0f;
		}

	}
}
