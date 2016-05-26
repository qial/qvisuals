package net.qial.vj.shape;

import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.processing.ProcessingSettings;
import processing.core.PApplet;

/**
 * Abstract class to not force everything to implement empty prepare methods.
 * 
 * @author Kyle
 *
 */
public abstract class AbstractShape implements Shape {
	
	protected Movement movement;
	protected ProcessingSettings settings;
	
	public AbstractShape() {
		// do nothing
	}
	
	public AbstractShape(PaintableDescription desc) {
		// load from description
		loadFrom(desc);
	}

	@Override
	public void prepare(PApplet app) {
		// apply any settings we need
		if(settings != null) {
			settings.apply(app);
		}
	}
	
	public Movement getMovement() {
		return movement;
	}
	
	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	public ProcessingSettings getSettings() {
		return settings;
	}
	
	public void setSettings(ProcessingSettings settings) {
		this.settings = settings;
	}

}
