package net.qial.vj.processing;

import java.util.ArrayList;

import net.qial.vj.effect.*;
import net.qial.vj.effects.*;
import net.qial.vj.effects.pulse.*;
import net.qial.vj.sequencer.*;
import net.qial.vj.sequencers.*;
import net.qial.vj.spout.Spout;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Applet for testing effects. Attempts not to run a window.
 * 
 * @author Kyle
 *
 */
public class TestApp extends Visuals {
	public TestApp() {
		ProcessingUtil.setApp(this);
	}
}
