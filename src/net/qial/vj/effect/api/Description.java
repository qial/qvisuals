package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.Map;

public abstract class Description {
	
	private String type;
	
	private Description parent;
	
	private Map<String,Object> defaults;
	
	public Description() {
		defaults = new HashMap<String,Object>();
	}
	
	public Object get(String key) {
		Object v = defaults.get(key);
		if(v == null && parent != null) {
			return parent.get(key);
		}
		return v;
	}
	
	public void set(String key, Object val) {
		defaults.put(key,val);
	}
	
	public Map<String,Object> getDefaults() {
		return defaults;
	}
	
	public void setDefaults(Map<String,Object> defaults) {
		this.defaults = defaults;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Description getParent() {
		return parent;
	}
	
	public void setParent(Description parent) {
		this.parent = parent;
	}
	
}
