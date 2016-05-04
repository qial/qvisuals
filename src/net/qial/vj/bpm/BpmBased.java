package net.qial.vj.bpm;

/**
 * Interface for all effects/sequencers/etc that use a BPM object and are 
 * able to be based on a BPM.
 * 
 * @author Kyle
 *
 */
public interface BpmBased {
	public void setBpm(BPM bpm);
	public BPM getBpm();
}
