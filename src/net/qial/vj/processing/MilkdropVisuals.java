package net.qial.vj.processing;

import processing.core.PImage;
import processing.opengl.PGraphicsOpenGL;
import spout.Spout;

public class MilkdropVisuals extends Visuals {
	// this class just extends visuals with the addition of a spout receiver
	// then it combines the receiver texture with the effect outpu
	
	protected Spout spout;

	protected PImage img;
	
	protected PGraphicsOpenGL pgl;
	
	@Override
	public void setup() {
		// call the main setup
		super.setup();

		// CREATE A NEW SPOUT OBJECT HERE
		spout = new Spout(this);

		img = createImage(width, height, ARGB);
		pgl = (PGraphicsOpenGL) g;
	}
	
	@Override
	public void draw() {
		// draw the effects
		super.draw();

		// receive pixels from spout
		img = spout.receivePixels(img);
		
		// now we want to look for non-black pixels in our effects
		// TODO, maybe resize to width/height? Or force it in winamp?
		for(int x = 0; x < width && x < img.width; x++) {
			for(int y = 0; y < height && y < img.height; y++) {
				int color = pgl.get(x, y);
				//System.out.print(color+" ");
				if(color == -16777216) {
					// black, do nothing
				} else {
					// TODO make this better
					// for now just replace with milkdrop
					int mlk = img.get(x, y);
					pgl.set(x,y,mlk);
				}
			}
		}
	}
	
	//SELECT A SPOUT SENDER
	public void mousePressed() {
		// RH click to select a sender
		if (mouseButton == RIGHT) {
			// Bring up a dialog to select a sender.
			// Spout installation required
			spout.selectSender();
		}
		else {
			// we aren't handling it, send it up
			super.mousePressed();
		}
	}
	
	@Override
	public void exit() {

		// CLOSE THE SPOUT RECEIVER HERE
		spout.closeReceiver();
		
		// propogate the exit upwards
		super.exit();
	}
}
