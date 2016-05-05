package net.qial.vj.shape;

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
public @interface Movement {
	String name();
}
