package net.qial.vj.processing;

import java.util.ArrayList;
import java.util.List;

import net.qial.vj.effect.Effect;

public class VisualsViewer extends Visuals {
	private static List<Effect> myEffects = new ArrayList<Effect>();
	
	
	public VisualsViewer() {

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
		checkFrames();
		// draw effects
		for(Effect e : effects) {
			if(e.enabled()) {
				e.play();
			}
		}
	}
	
	private int prevFrame = 0;

	private void checkFrames() {
		if(frameCount > prevFrame+1) {
			System.out.println("Skipped frames between "+prevFrame+" and "+frameCount);
		}
		prevFrame = frameCount;
	}
}
