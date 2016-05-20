package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;

// This class was adapted from code found on KhanAcademy
// https://www.khanacademy.org/computer-programming/super-spiral/823021393
// Many thanks to John on the Khan team
public class SuperSpiral extends ProcessingEffect {
	// number of points on the spiral
	int N = 240;

	float maxRadius = 200;

	// determines the inital spiral configuration
	float angleChange = 90;
	
	int cx = width()/2;
	int cy = height()/2;

	// color of the spiral
	int redValue = 255;
	int greenValue = 0;
	int blueValue = 0;

	// how much each color component changes every time
	int dRed = -1;
	int dGreen = 2;
	int dBlue = 3;
	
	@Override
	public void play() {
		background(0,0,0);
	    stroke(redValue, greenValue, blueValue);
	    strokeWeight(3);
	    

	    // coordinates of the current point
	    float x = 200;
	    float y = 200;

	    // coordinates of the previous point
	    float lastX = width()/2;
	    float lastY = height()/2;

	    for (int i = 0; i < N; i += 1) {
	        // calculate position of current point
	        float theta = angleChange * i;
	        float radius = maxRadius * sqrt(i / (float)N);
	        x = 200 + radius * cos(theta);
	        y = 200 + radius * sin(theta);
	        
	        // draw a line from the last point to the current point
	        line(lastX+cx, lastY+cy, x+cx, y+cy,0,0);
	        
	        // update the previous point to be the current point
	        lastX = x;
	        lastY = y;
	        
	        System.out.println((x+cx) + " " + (y+cy));
	    }
	    
	    // if colors go out of range,
	    // flip the direction of change
	    if (redValue < 0 || redValue > 255) {
	        dRed = -dRed;
	    }
	    if (blueValue < 0 || blueValue > 255) {
	        dBlue = -dBlue;
	    }
	    if (greenValue < 0 || greenValue > 255) {
	        dGreen = -dGreen;
	    }
	    
	    // increment colors
	    redValue += dRed;
	    blueValue += dBlue;
	    greenValue += dGreen;
	    
	    // increment angleChange to rotate the spiral
	    angleChange += 0.01;
	}
	
}
