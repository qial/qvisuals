package net.qial.vj.main;

import processing.core.PApplet;
import net.qial.vj.effect.Effect;
import net.qial.vj.effects.Circles1;
import net.qial.vj.effects.Circles2;
import net.qial.vj.effects.pulse.BpmPulseCircle;
import net.qial.vj.processing.MovieSaverVisuals;
import net.qial.vj.processing.ProcessingUtil;
import net.qial.vj.processing.TestApp;
import net.qial.vj.processing.Visuals;
import net.qial.vj.processing.VisualsViewer;

public class EffectViewerMain {

	public static void main(String[] args) throws Exception {
		// first make a fake applet to let effects load correctly
		ProcessingUtil.setApp(new TestApp());
		
		//System.exit(0);
		
		//TODO give effects as arguments instead of hardcoded
		
		Effect e = getEffect();
		saveEffect(e);
	}
	
	public static void saveEffect(Effect e) {
		// add e to the MovieSaverVisuals list
		VisualsViewer.addEffect(e);
		// set video to 16 seconds long
		
		// run PApplet
		run(VisualsViewer.class.getName());
	}
	
	public static void run(String className) {
		PApplet.main(new String[]{className});
	}
	
	private static Effect getEffect() throws Exception {
		// TODO return something
//		return new BpmPulseCircle();
		// lets load a designed effect
		return EffectBuilderTest.testvup();
	}

}
