package net.qial.vj.shape;

import java.util.ArrayList;
import java.util.List;

import net.qial.vj.effect.api.EffectBuilder;
import net.qial.vj.effect.api.MovementDescription;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.movement.Movement;
import net.qial.vj.movement.Movement.MovementStyle;
import net.qial.vj.processing.ProcessingSettings;
import processing.core.PApplet;

/**
 * Abstract class to not force everything to implement empty prepare methods.
 * 
 * @author Kyle
 *
 */
public abstract class AbstractShape implements Shape {
	
	protected List<Movement> movements;
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
	
	public List<Movement> getMovements() {
		return movements;
	}
	
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	public void addMovement(Movement movement) {
		if(movements == null) {
			movements = new ArrayList<Movement>();
		}
		movements.add(movement);
	}
	
	public ProcessingSettings getSettings() {
		return settings;
	}
	
	public void setSettings(ProcessingSettings settings) {
		this.settings = settings;
	}
	
	public void loadFrom(PaintableDescription desc) {
		// default loading values for settings and description
		List<MovementDescription> mdescs = desc.getMovements();
		if(mdescs != null) {
			for(MovementDescription mdesc : mdescs) {
				Movement m = EffectBuilder.buildMovement(mdesc);
				addMovement(m);
			}
		}
	}

	public void applyMovement(Movement m, PApplet app) {
		// this is where it gets weird
		// for movements that only change app settings
		// we need something better than just adding to
		// some static value.
		// We basically need start and end values instead
		// of amplitude modifiers.
		
		if(m.getParam().equals("fill")) {
			// change the fill parameter
			if(m.getStyle() == MovementStyle.RANGE) {
				//System.out.println("Setting fill from movement");
				app.fill(m.getMovement());
			}
			else {
				System.err.println(m.getStyle()+" movement for 'fill' param not implemented");
			}
		}
		if(m.getParam().equals("stroke")) {
			// change the stroke parameter
			if(m.getStyle() == MovementStyle.RANGE) {
				//System.out.println("Setting stroke from movement");
				app.stroke(m.getMovement());
			}
			else {
				System.err.println(m.getStyle()+" movement for 'stroke' param not implemented");
			}
		}
		
	}

}
