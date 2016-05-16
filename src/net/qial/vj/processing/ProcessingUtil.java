package net.qial.vj.processing;

import java.util.ArrayList;
import java.util.List;

// static class to handle the Processing API vars and 
public class ProcessingUtil {
	// at the moment uses the Visuals app exclusively so I can use the
	// message methods to draw text on the screen during testing
	private static Visuals app;
	
	// Keep track of all the NeedsApp objects we give the app to.
	// This way we can update them if the app changes.
	private static List<NeedsApp> objs = new ArrayList<NeedsApp>();

	public static void setApp(Visuals v) {
		app = v;
		// update all the callers
		for(NeedsApp n : objs) {
			n.setApp(v);
		}
	}

	public static Visuals getApp(NeedsApp caller) {
		if(caller != null) {
			// save the caller
			objs.add(caller);
		}
		return app;
	}
}
