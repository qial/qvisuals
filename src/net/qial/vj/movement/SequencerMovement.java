package net.qial.vj.movement;

import net.qial.vj.shape.AbstractMovement;
import net.qial.vj.shape.MovementType;

@MovementType(name="sequencer")
public class SequencerMovement extends AbstractMovement {

	private int point;
	
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
		// TODO Auto-generated method stub
		return 0;
	}
	
}
