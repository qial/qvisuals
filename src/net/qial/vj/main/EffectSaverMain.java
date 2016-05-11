package net.qial.vj.main;

import processing.core.PApplet;
import net.qial.vj.effect.Effect;
import net.qial.vj.effects.Circles1;
import net.qial.vj.processing.MovieSaverVisuals;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.TestApp;
import net.qial.vj.processing.Visuals;

public class EffectSaverMain {

	public static void main(String[] args) {
		// first make a fake applet to let effects load correctly
		ProcessingUtil.setApp(new TestApp());
		
		//TODO give effects as arguments instead of hardcoded
		
		Effect e = getEffect();
		saveEffect(e);
	}
	
	public static void saveEffect(Effect e) {
		// add e to the MovieSaverVisuals list
		MovieSaverVisuals.addEffect(e);
		// set video to 16 seconds long
		MovieSaverVisuals.setFrames(16*60);
		
		// run PApplet
		run(MovieSaverVisuals.class.getName());
	}
	
	public static void run(String className) {
		PApplet.main(new String[]{className});
	}
	
	private static Effect getEffect() {
		// TODO return something
		return new Circles1();
	}

}
