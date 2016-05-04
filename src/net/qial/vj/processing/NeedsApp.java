package net.qial.vj.processing;

/**
 * Interface for anything that needs a reference to the PApplet for information.
 * Implementations are encouraged to use <code>ProcessingUtil.getApp()</code> to
 * get a reference to the statically set app as a default, and store it in a 
 * protected local variable named "app". This makes code re-use much easier.
 * 
 * Abstract classes implementing this are encouraged to implement needed methods
 * from PApplet as protected classes. This makes it easier to copy code directly
 * from a Processing sketch into any child classes.
 * 
 * Implementations MUST implement setApp(), however, to make sure that more
 * advanced situations with multiple apps can be supported if needed.
 * 
 * @author Kyle
 * 
 */
public interface NeedsApp {
	public void setApp(Visuals v);
	public Visuals getApp();
}
