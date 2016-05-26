package net.qial.vj.shape;

import net.qial.vj.processing.ProcessingSettings;

/**
 * I like the name Shape in the heirarchy, so I'm using this
 * as the top level interface instead of Paintable.
 * 
 * Shape will require extra methods under the assumption that
 * its working with the Effect API, including Description classes
 * and builders.
 * 
 * Paintable is a simple interface that allows another class
 * to be used inside shapes developed through code.
 * 
 * @author kw
 *
 */
public interface Shape extends Paintable {
	public Movement getMovement();
	public void setMovement(Movement movement);
	public ProcessingSettings getSettings();
	public void setSettings(ProcessingSettings settings);
}
