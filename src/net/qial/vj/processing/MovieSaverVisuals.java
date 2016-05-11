package net.qial.vj.processing;

import java.util.ArrayList;
import java.util.List;

import net.qial.vj.effect.Effect;

public class MovieSaverVisuals extends Visuals {
	private static List<Effect> myEffects = new ArrayList<Effect>();
	private static int movieFrames;
	
	public MovieSaverVisuals() {
		
	}
	
	public static void setFrames(int frames) {
		movieFrames = frames;
	}
	
	public static void addEffect(Effect e) {
		myEffects.add(e);
	}
	
	public static void clearEffects() {
		myEffects.clear();
	}
	
	public void loadEffects() {
		for(Effect e : myEffects) {
			e.setEnabled(true);
			
			effects.add(e);
			
		}
	}
	
	public void draw() {
		// draw effects
		for(Effect e : effects) {
			if(e.enabled()) {
				e.play();
			}
		}
		if(frameCount < movieFrames) {
			// save frame
			this.saveFrame("frame-#####.png");
		}
		else {
			// we're done
			System.out.println("Finished saving "+movieFrames+" frames");
			System.exit(0);
		}
	}
}
