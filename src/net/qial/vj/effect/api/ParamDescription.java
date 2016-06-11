package net.qial.vj.effect.api;

import java.util.LinkedHashMap;

public class ParamDescription extends Description {

	private String name;
	
	private int start = 0;
	
	private int increment = 0;
	
	public ParamDescription() {
		
	}
	
	public void set(String k, Object v) {
		if("name".equals(k)) {
			this.name = (String) v;
		}
		else if("start".equals(k)) {
			this.start = (Integer) v;
		}
		else if("increment".equals(k)) {
			this.increment = (Integer) v;
		}
		else {
			super.set(k,v);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}
	
}
