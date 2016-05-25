package net.qial.vj.shape;

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
	public void loadFrom(MovementDescription desc);
}
