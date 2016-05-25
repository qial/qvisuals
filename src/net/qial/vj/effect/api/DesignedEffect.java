package net.qial.vj.effect.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.qial.vj.effect.Effect;
import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.sequencer.Sequencer;
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
	private Map<String,Object> defaults;
	
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

	public Map<String,Object> getDefaults() {
		return defaults;
	}

	public void setDefaults(Map<String,Object> defaults) {
		this.defaults = defaults;
	}
	
	public Effect loadFrom(EffectDescription desc) {
		if(desc.getSequencer() != null) {
//			Sequencer seq = buildSequencer(desc.getSequencer());
			setSequencer(seq);
		}
		setDefaults(desc.getDefaults());
		for(PaintableDescription pdesc : desc.getPaintables()) {
			Paintable p = EffectBuilder.buildPaintable(pdesc);
			if(p != null) {
				addPart(p);
			}
		}
		return this;
	}
}
