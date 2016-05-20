package net.qial.vj.processing;

import processing.core.PImage;
import spout.Spout;

// Extends Visuals with the addition of a spout sender
public class VisualsSender extends Visuals {


	protected Spout spout;

	protected PImage tex;
	
	@Override
	public void setup() {
		// call the main setup
		super.setup();


		// CREATE A NEW SPOUT OBJECT HERE
		spout = new Spout(this);

		// INITIALIZE A SPOUT SENDER HERE
		spout.createSender("Spout QVisuals", width, height);
	}
	
	@Override
	public void draw() {
		// draw the effects
		super.draw();

		// SEND A SHARED TEXTURE HERE
		spout.sendTexture();
	}
	
	@Override
	public void exit() {

		// CLOSE THE SPOUT SENDER HERE
		spout.closeSender();
		
		// propogate the exit upwards
		super.exit();
	}
}
