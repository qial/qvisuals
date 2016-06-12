package net.qial.vj.shape;

import java.util.List;

import net.qial.vj.movement.Movement;
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
	public List<Movement> getMovements();
	public void setMovements(List<Movement> movements);
	public void addMovement(Movement movement);
	public ProcessingSettings getSettings();
	public void setSettings(ProcessingSettings settings);
}
