package net.qial.vj.effect.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.shape.Paintable;

/**
 * Base abstract class for effects defined using Paintables and the Shape
 * annotation options.
 * 
 * @author kw
 *
 */
@EffectType(name="designed")
public class DesignedEffect extends ProcessingEffect {
	private List<Paintable> parts;
	private LinkedHashMap defaults;
	
	public DesignedEffect() {
		parts = new ArrayList<Paintable>();
	}

	@Override
	public void play() {
		for(Paintable p : parts) {
			// set up any defaults it needs
			p.prepare(app);
			// paint this shape
			p.paint(app);
		}
	}
	
	public void addPart(Paintable p) {
		parts.add(p);
	}

	public LinkedHashMap getDefaults() {
		return defaults;
	}

	public void setDefaults(LinkedHashMap defaults) {
		this.defaults = defaults;
	}
}
