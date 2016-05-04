package net.qial.vj.effects;

import net.qial.vj.effect.StreamEffect;
import net.qial.vj.shapes.Rectangle;

public class WatashiMachine1 extends StreamEffect {
	WatashiMachine1() {
		// this one is nearly exact
		// addCam(new Rectangle(0,530,250,180));
		// this one doesn't cover up the white
		addCam(new Rectangle(0, 522, 248, 195));
		// nearly exact
		// setOuter(new Rectangle(300,44,960,600));
		// for ff9
		setOuter(new Rectangle(315, 44, 915, 600));
		setInner(new Rectangle(335, 64, 875, 560));
	}
}
