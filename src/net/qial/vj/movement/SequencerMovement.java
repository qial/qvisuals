package net.qial.vj.movement;

import net.qial.vj.effect.api.MovementDescription;
import net.qial.vj.sequencer.Sequencer;

@MovementType(name="sequencer")
public class SequencerMovement extends AbstractMovement {

	private int point;
	protected Sequencer seq;
	
	public SequencerMovement() {
		
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public float getMovement() {
		// determine style to figure out what we need to do
		if(style == MovementStyle.AMPLITUDE) {
			return seq.get(point) * amplitude;
		}
		else if(style == MovementStyle.RANGE) {
			// calculate range
			float val = end - start;
			float pt = seq.get(point);
			val *= pt;
			val += start;
			// Sanity check values in case of floating point errors
//			if(val > end) {
//				return end;
//			}
//			else if(val < start) {
//				return start;
//			}
			return val;
		}
		
		return 0;
	}
	
	public void loadFrom(MovementDescription desc) {
		// call parent class to load some parts
		super.loadFrom(desc);
		// load point and sequencer
		Integer point = (Integer) desc.get("point");
		if(point != null) {
			setPoint(point);
		}
		else {
			// default to zero
			setPoint(0);
		}
		seq = (Sequencer)desc.get("sequencerObject");
	}
	
}
