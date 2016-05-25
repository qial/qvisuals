package net.qial.vj.shape;

import net.qial.vj.effect.api.MovementDescription;

public abstract class AbstractMovement implements Movement {
	private String param;

	@Override
	public String getParam() {
		return param;
	}

	@Override
	public void setParam(String paramName) {
		this.param = paramName;
	}
	
	@Override
	public void loadFrom(MovementDescription desc) {
		// try to load the param name
		String param = (String)desc.get("param");
		if(param != null) {
			setParam(param);
		}
	}

}
