package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Description {

	private String label;
	
	private String type;
	
	private Description parent;
	
	private Map<String,Object> defaults;
	
	public Description() {
		defaults = new HashMap<String,Object>();
	}
	
	public void setValues(LinkedHashMap map) {
		for(Object o : map.keySet()) {
			String k = (String)o;
			Object v = map.get(k);
			
			set(k,v);
		}
	}
	
	public Object get(String key) {
		Object v = defaults.get(key);
		if(v == null && parent != null) {
			return parent.get(key);
		}
		return v;
	}
	
	public void set(String key, Object val) {
		//WARNING: I was dumb at least once. The yaml reader will detect any
		// variable names with get/set on the original pass so we don't
		// need to handle it ourselves. Just pass anything it can't figure
		// out to the defaults map and later code can deal with it.
		defaults.put(key,val);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public 
	
}
