package net.qial.vj.processing;

// static class to handle the Processing API vars and 
public class ProcessingUtil {
	// at the moment uses the Visuals app exclusively so I can use the
	// message methods to draw text on the screen during testing
	private static Visuals app;
	
	public static void setApp(Visuals v) {
		app = v;
	}
	
	public static Visuals getApp() {
		return app;
	}
}
