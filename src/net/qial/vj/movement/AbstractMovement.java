package net.qial.vj.movement;

import net.qial.vj.effect.api.MovementDescription;

public abstract class AbstractMovement implements Movement {
	
	protected String param;
	protected int amplitude;
	protected int start;
	protected int end;
	protected MovementStyle style;

	@Override
	public String getParam() {
		return param;
	}

	@Override
	public void setParam(String paramName) {
		this.param = paramName;
	}
	
	@Override
	public int getAmplitude() {
		return amplitude;
	}
	
	@Override
	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}
	
	@Override
	public int getStart() {
		return start;
	}
	
	@Override
	public void setStart(int start) {
		this.start = start;
	}
	
	@Override
	public int getEnd() {
		return end;
	}
	
	@Override
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public void setStyle(MovementStyle style) {
		this.style = style;
	}
	
	@Override
	public void loadFrom(MovementDescription desc) {
		// try to load the param name
		String param = (String)desc.get("param");
		if(param != null) {
			setParam(param);
		}
		// try to load amplitude
		Integer amp = (Integer)desc.getAmplitude();
		if(amp != null) {
			setAmplitude(amp);
		}
	}
}
