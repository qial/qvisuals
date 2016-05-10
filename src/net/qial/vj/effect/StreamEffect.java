package net.qial.vj.effect;

import java.util.ArrayList;

import net.qial.vj.effect.api.EffectType;
import net.qial.vj.shapes.Rectangle;

@EffectType(name="stream")
public class StreamEffect extends ProcessingEffect {
	private ArrayList<Rectangle> cams;
	private Rectangle gameOuter;
	private Rectangle gameInner;

	public StreamEffect() {
		cams = new ArrayList<Rectangle>();
	}

	public void setOuter(Rectangle outer) {
		this.gameOuter = outer;
	}

	public void setInner(Rectangle inner) {
		this.gameInner = inner;
	}

	public void addCam(Rectangle cam) {
		cams.add(cam);
	}

	public void play() {
		background(255);
		noStroke();
		fill(0);
		for (Rectangle r : cams) {
			rect(r.x, r.y, r.w, r.h);
		}
		fill(0);
		rect(gameOuter.x, gameOuter.y, gameOuter.w, gameOuter.h);
	}
}
