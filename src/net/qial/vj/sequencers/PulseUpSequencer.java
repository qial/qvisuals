package net.qial.vj.sequencers;

import net.qial.vj.util.DrawUtil;

/**
 * This class uses the same movement as the PulseSequencer, but all points are
 * at 0.0 at the start, and stay at 1.0 after the pulse peak passes.
 * 
 * @author kw
 * 
 */
public class PulseUpSequencer extends PulseSequencer {
	public float get(int point) {
		float pulseLocation = getPulseLocation();

		int pointLocation = getPointLocation(point);
		int pulseStart = getPulseStart();
		int pulseEnd = getPulseEnd();
		//println("point=" + point + " pointw=" + pointWidth + " pulseFrame="
		//		+ pulseFrame + " position=" + pointLocation + " pStart="
		//		+ pulseStart + " pEnd=" + pulseEnd);
		if(pointLocation <= pulseLocation) {
			// if pulse has passed, stay at 1.0
			return 1.0f;
		} else if (pointLocation >= pulseStart && pulseLocation < pulseEnd) {
			// pulse is going up
			// get distance from pulse start
			float dist = pointLocation - pulseStart;
			// use the wave function
			float amt = DrawUtil.wave(dist, pulseWidth);
			println("dist=" + dist + " amt=" + amt);
			return amt;
		} else {
			// return 0 because pulse hasn't gotten to us yet
			return 0.0f;
		}

	}
}
