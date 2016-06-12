package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MovementDescription extends Description {
	
//	private int amplitude;
//	private int start;
//	private int end;
	
//	private HashMap<String,Object> others;
	
//	private DesignedEffect parent;
	
	public MovementDescription() {
//		others = new HashMap<String,Object>();
	}
	
	public void set(String k, Object v) {
		// handle some values specially
		if("type".equals(k)) {
			setType((String) v);
		}
		else {
			super.set(k,v);
		}
	}

//	public int getAmplitude() {
//		return amplitude;
//	}
//
//	public void setAmplitude(int amplitude) {
//		this.amplitude = amplitude;
//	}
	
//	public DesignedEffect getParent() {
//		return parent;
//	}
//
//	public void setParent(DesignedEffect parent) {
//		this.parent = parent;
//	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MovementDescription{");
		sb.append("type=").append(getType());
		for(String k : getDefaults().keySet()) {
			Object v = getDefaults().get(k);
			sb.append(",").append(k);
			sb.append("=").append(v);
		}
		sb.append("}");
		return sb.toString();
	}

}
