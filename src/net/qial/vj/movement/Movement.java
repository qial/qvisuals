package net.qial.vj.movement;

import net.qial.vj.effect.api.MovementDescription;

public interface Movement {
	// should it move the shape, or should the shape use it to adjust
	// its own size/etc? Probably the latter, The mover says what to
	// do and the shape applies it during printing.
	public float getMovement();
	public String getParam();
	public void setParam(String paramName);
	public int getAmplitude();
	public void setAmplitude(int amplitude);
	public int getStart();
	public void setStart(int start);
	public int getEnd();
	public void setEnd(int end);
	public void setStyle(MovementStyle style);
	public void loadFrom(MovementDescription desc);
	
	public enum MovementStyle {
		AMPLITUDE, RANGE
	}
}
