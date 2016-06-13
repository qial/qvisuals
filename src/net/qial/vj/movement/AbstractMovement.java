package net.qial.vj.movement;

import java.util.ArrayList;
import java.util.List;

import net.qial.vj.effect.api.MovementDescription;

public abstract class AbstractMovement implements Movement {
	
	protected List<String> params;
	protected int amplitude;
	protected int start;
	protected int end;
	protected MovementStyle style;

	@Override
	public List<String> getParams() {
		return params;
	}

	@Override
	public void setParams(List<String> params) {
		this.params = params;
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
	public MovementStyle getStyle() {
		return style;
	}
	
	@Override
	public void setStyle(MovementStyle style) {
		this.style = style;
	}
	
	@Override
	public void loadFrom(MovementDescription desc) {
		// try to load the param name
		Object param = desc.get("param");
		if(param != null) {
			if(param instanceof List<?>) {
				setParams((List<String>)param);
			}
			else if(param instanceof String) {
				List<String> paramList = new ArrayList<String>();
				paramList.add((String)param);
				setParams(paramList);
			}
		}
		
		boolean configured = false;
		// check for start/end
		Integer start = (Integer) desc.get("start");
		Integer end = (Integer) desc.get("end");
		if(start != null && end != null) {
			setStart(start);
			setEnd(end);
			configured = true;
			setStyle(MovementStyle.RANGE);
		}
		// try to load amplitude
		Integer amp = (Integer)desc.get("amplitude");
		if(amp != null) {
			setAmplitude(amp);
			configured = true;
			setStyle(MovementStyle.AMPLITUDE);
		}
		if(!configured) {
			throw new RuntimeException("Movement must be configured with either an Amplitude or Start & End values");
		}
	}
}
