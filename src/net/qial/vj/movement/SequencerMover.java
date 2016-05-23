package net.qial.vj.movement;

import net.qial.vj.shape.AbstractMover;
import net.qial.vj.shape.Movement;

@Movement(name="sequencer")
public class SequencerMover extends AbstractMover {

	private int point;
	
	public SequencerMover() {
		
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
