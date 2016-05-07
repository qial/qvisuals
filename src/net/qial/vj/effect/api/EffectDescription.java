package net.qial.vj.effect.api;

import java.util.List;

import net.qial.vj.shape.Paintable;

/**
 * Stores the description of an effect. Used in the Effect API to save and load
 * different effects. This class and the rest of 
 * <code>net.qial.vj.effect.api</code> can be used
 * @author kw
 *
 */
public class EffectDescription {
	// Defines what top-level Effect class this should use
	private String type;
	
	// Defines the sequencer
	private SequencerDescription sequencer;
	
	// defines the paintables
	private List<PaintableDescription> shapes;
}
