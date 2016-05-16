package net.qial.vj.processing;

import java.util.ArrayList;
import java.util.List;

import net.qial.vj.effect.Effect;

public class MovieSaverVisuals extends Visuals {
	private static List<Effect> myEffects = new ArrayList<Effect>();
	private static int movieFrames;
	
	private static String saveBase;
	private static String savePath;
	
	public MovieSaverVisuals() {

	}
	
	public static void setSaveBase(String base) {
		saveBase = base;
		long time = System.currentTimeMillis();
		savePath = saveBase+"\\"+time+"\\"+"frame-#####.png";
		
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
		if(frameCount < movieFrames+2) {
			// save frame
//			this.saveFrame("frame-#####.png");
			this.saveFrame(savePath);
		}
		else {
			// we're done
			// don't spam it too much
			if(frameCount % 60 == 0);
				System.out.println("Finished saving "+movieFrames+" frames");
		}
	}
}
