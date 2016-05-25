package net.qial.vj.movement;

import net.qial.vj.effect.api.MovementDescription;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.shape.AbstractMovement;
import net.qial.vj.shape.MovementType;

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
		return seq.get(point) * amplitude;
	}
	
	public void loadFrom(MovementDescription desc) {
		// call parent class to load some parts
		super.loadFrom(desc);
		// load point and sequencer
		int point = (Integer) desc.get("point");
		setPoint(point);
		seq = (Sequencer)desc.get("sequencerObject");
	}
	
}
