package net.qial.vj.processing;

import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class ProcessingSettings {
	private Map<String,Object> settings;
	
	public ProcessingSettings() {
		setSettings(new HashMap<String,Object>());
	}
	
	public ProcessingSettings(Map<String,Object> settings) {
		setSettings(settings);
	}
	
	public void setSettings(Map<String,Object> settings) {
		this.settings = settings;
	}
	
	public void apply(PApplet app) {
		//System.out.println("appplyyyyyyy");
		// apply settings to the processing app
		if(settings.containsKey("background")) {
			Object bg = settings.get("background");
			if(bg instanceof Integer) {
				app.background((int)bg);
			}
		}
		
		if(settings.containsKey("fill")) {
			Object fill = settings.get("fill");
			if(fill instanceof String && "none".equals(fill)) {
				app.noFill();
			} 
			else if(fill instanceof Integer) {
				app.fill((int)fill);
			}
		}
		
		if(settings.containsKey("stroke")) {
			Object stroke = settings.get("stroke");
			if(stroke instanceof String && "none".equals(stroke)) {
				app.noStroke();
			}
			else if(stroke instanceof Integer) {
				app.stroke((int)stroke);
			}
		}
		
		if(settings.containsKey("strokeWeight")) {
			Object strokeWeight = settings.get("strokeWeight");
			if(strokeWeight instanceof Integer) {
				app.strokeWeight((int)strokeWeight);
			}
		}
	}
}
