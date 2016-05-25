package net.qial.vj.shape;

import net.qial.vj.effect.api.MovementDescription;

public abstract class AbstractMovement implements Movement {
	protected String param;
	protected int amplitude;

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
	public void loadFrom(MovementDescription desc) {
		// try to load the param name
		String param = (String)desc.get("param");
		if(param != null) {
			setParam(param);
		}
		// try to load amplitude
		Integer amp = (Integer)desc.get("amplitude");
		if(amp != null) {
			setAmplitude(amp);
		}
	}

}
