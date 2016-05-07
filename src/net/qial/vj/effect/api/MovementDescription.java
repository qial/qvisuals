package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MovementDescription {

	private String type;
	
	private int amplitude;
	
	private HashMap<String,Object> others;
	
	public MovementDescription() {
		others = new HashMap<String,Object>();
	}
	
	public void setValues(LinkedHashMap map) {
		for(Object o : map.keySet()) {
			String k = (String)o;
			Object v = map.get(k);
			
			// handle some values specially
			if("type".equals(k)) {
				type = (String) v;
			}
			else if("amplitude".equals(k)) {
				amplitude = (Integer) v;
			}
			else {
				others.put(k, v);
			}
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MovementDescription{");
		sb.append("type=").append(type);
		sb.append(",amplitude=").append(amplitude);
		for(String k : others.keySet()) {
			Object v = others.get(k);
			sb.append(",").append(k);
			sb.append("=").append(v);
		}
		sb.append("}");
		return sb.toString();
	}

}
