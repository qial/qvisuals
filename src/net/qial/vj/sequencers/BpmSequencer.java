package net.qial.vj.sequencers;

import net.qial.vj.bpm.BPM;
import net.qial.vj.bpm.BpmBased;
import net.qial.vj.sequencer.ProcessingSequencer;
import net.qial.vj.sequencer.SequencerType;
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
@SequencerType(name="bpm")
public class BpmSequencer extends ProcessingSequencer implements BpmBased {
	
	protected BPM bpm = new BPM(120);

	public BpmSequencer() {
		this(new BPM(120));
	}
	
	public BpmSequencer(BPM bpm) {
		setBpm(bpm);
	}

	public float get(int point) {
		float runLength = bpm.getFramesPerBeatf();
		float currentFrame = bpm.getCurrentFrame();
		
		float curMod = currentFrame % runLength;
		
		return curMod / runLength;
	}

	// recalculate internal variables
	protected void recalculate() {
		// no internal variables anymore
	}
	
	public void setBpm(BPM bpm) {
		this.bpm = bpm;
		recalculate();
	}
	
	public BPM getBpm() {
		return bpm;
	}
}
