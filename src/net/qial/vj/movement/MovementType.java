package net.qial.vj.movement;

/**
 * Base annotation for defining movement of shapes or lists of shapes.
 * Requires a name (for parsing/saving/loading needs).
 * 
 * Maybe we should add an Enum handling what this movement is doing.
 * Maybe this annotation should just be how to connect a shape to 
 * a movement that has actual methods for manipulating the shape.
 * 
 * @author kw
 *
 */
public @interface MovementType {
	String name();
}


// Movements need to be able to define the parameter that they work against
// Paintables can then use the parameter name to know what to change when
// they get a movement applied to them.
// For example, a Paintable might need multiple movements. In the V-up effect,
// all Vs need to have the upward Y movement. The topmost v has the additional
// movement of slowly fading to black over some point of the effect