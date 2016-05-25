package net.qial.vj.sequencer;

import net.qial.vj.effect.api.SequencerDescription;

public interface Sequencer {
	public float get(int point);

	public int getPoints();

	public void setPoints(int points);
	
	public void loadFrom(SequencerDescription desc);
}
