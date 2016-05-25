package net.qial.vj.shape;

import net.qial.vj.effect.api.PaintableDescription;
import processing.core.PApplet;

/**
 * 
 * @author Kyle
 *
 */
public interface Paintable {
	/**
	 * Prepare sets up things that are needed to draw this Paintable, such
	 * as setting fill, stroke, colors, etc.
	 * 
	 * It's a separate method because we don't want to have to copy
	 * preparations down into lower classes. More advanced Paintables will
	 * nest other Paintables, and we want to cut down on unnecessary calls
	 * to the PApplet when things don't need to change.
	 * 
	 * @param app the Processing applet
	 */
	public void prepare(PApplet app);
	
	/**
	 * Draws this Paintable onto the current app
	 * 
	 * @param app the Processing applet
	 */
	public void paint(PApplet app);
	
	/**
	 * Loads values into this Paintable from a given PaintableDescription
	 * 
	 * @param desc the PaintableDescription with settings to load from
	 */
	public void loadFrom(PaintableDescription desc);
}

// For shapes like the V, maybe I need a way to define a
// movement of some sort. That movement could be distance
// in the case of the Vs, or size in the case of circles.
// Movement could even be both, just an abstraction of
// size and position movements. Each shape can decide how
// exactly to handle size or position changes defined by
// the movements.
