package net.qial.vj.util;

import processing.core.PApplet;

public class DrawUtil {
	
	private static final float altitude = 0.5f * PApplet.sqrt(3);
	
	int getSizeForOffset(int offset) {
		  return (int)(offset*2 * altitude);
		}

		void makeTriangle(int size, int offset) {
		  //noFill();
		  //stroke(255);
		  int topx = 640;
		  int topy = offset;
		  int leftx = (int) (640 - (0.5 * size));
		  int lefty = (int) (offset + (size * altitude));
		  int rightx = (int) (640 + (0.5 * size));
		  int righty = lefty;
		  //triangle(topx,topy,leftx,lefty,rightx,righty);
		}

		void makeCircle(int size) {
		  //makeCircle(width/2,height/2,size);
		}

		void makeCircle(int x, int y, int size) {
		  //ellipse(x,y,size,size);
		}

		void makeV(int width, int offset) {
		  
//		  quad(0,640+offset+width,
//		       0,640+offset,
//		       640,offset,
//		       640,offset+width);
//		  quad(640,offset,
//		       640,offset+width,
//		       1280,640+offset+width,
//		       1280,640+offset);
		}

		// uses a cosine model from 0 to pi and
		// returns a value from 1.0 to 0.0
		// frame/total is mapped to 0 to pi radians
		float waveDown(float frame, int total) {
		  float dist = ((float)frame)/((float)total);
		  float amp = PApplet.cos(dist*PApplet.PI);
		  // turn amplitude from -1 -> 1 to 0 -> 2
		  amp += 1.0;
		  // divide by 2 to make 0 -> 1
		  amp /= 2.0;
		  return amp;
		}

		// uses a cosine model from pi to 2pi and
		// returns a value from 0.0 to 1.0
		// frame/total is mapped to pi to 2pi radians
		public static float waveUp(float frame, int total) {
		  float dist = ((float)frame)/((float)total);
		  float amp = PApplet.cos((dist*PApplet.PI)+PApplet.PI);
		  // turn amplitude from -1 -> 1 to 0 -> 2
		  amp += 1.0;
		  // divide by 2 to make 0 -> 1
		  amp /= 2.0;
		  return amp;
		}

		// essentially combines waveDown and waveUp
		// frame/total is mapped to pi to 3pi radians
		// uses a cosine model from pi to 3pi and
		// returns a value from 0.0 to 1.0
		public static float wave(float frame, int total) {
		  float dist = ((float)frame)/((float)total);
		  float amp = PApplet.cos((dist*PApplet.TWO_PI)+PApplet.PI);
		  // turn amplitude from -1 -> 1 to 0 -> 2
		  amp += 1.0;
		  // divide by 2 to make 0 -> 1
		  amp /= 2.0;
		  return amp;
		}
}
