package net.qial.vj.effect.api;

import java.util.Map;

public class DescriptionFile {
	
	// defines top level type for effect description files.
	// I feel like this shouldn't be in description file
	private String type;

	// set defaults for the whole file
	private Map<String,Object> defaults;

	

	public Map<String,Object> getDefaults() {
		return defaults;
	}

	public void setDefaults(Map<String,Object> defaults) {
		this.defaults = defaults;
	}
	
	
}
