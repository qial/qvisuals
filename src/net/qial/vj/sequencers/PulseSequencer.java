package net.qial.vj.sequencers;

class PulseSequencer extends AbstractSequencer
{
  // amount of frames it takes for the pulse to fully travel
  int pulseLength = 60;
  
  // amount of frames the pulse takes to go up and back.
  int pulseWidth = 30;
  
  // internal vars
  float pointWidth = 0.0;
  
  PulseSequencer() {
    // pulses are in a single direction, so always positive
    setPositive(true);
    recalculate();
  }
  
  float get(int point) {
    // determine framecount to figure out what range
    // of points are within the pulse
    int pulseFrame = frameCount % pulseLength;
    // pulseFrame is now the current frame along the pulse
    
    int pointLocation = round(pointWidth * point);
    int pulseStart = round(pulseFrame - (pulseWidth/2.0));
    int pulseEnd = round(pulseFrame + (pulseWidth/2.0));
    println("point="+point
        +" pointw="+pointWidth
        +" pulseFrame="+pulseFrame
        +" position="+pointLocation
        +" pStart="+pulseStart
        +" pEnd="+pulseEnd);
    if(pointLocation >= pulseStart && pointLocation <= pulseEnd) {
      // get distance from pulse start
      float dist = pointLocation-pulseStart;
      // use the wave function
      float amt = wave(dist,pulseWidth);
      println("dist="+dist+" amt="+amt);
      return amt;
    }
    else {
      return 0.0;
    }
    
    
    // total pulse is the essential number of frames it uses.
    //float totalPulse = ((float)pulseLength) + ((float)pulseWidth);
    //float pulseStart = 0.0 - (pulseWidth/2.0);
    // technically we don't need a pulseEnd variable, it ends at pulseLength
    
    // calculate conversion rate for pulse location and frame count
    //float pulseRate = totalPulse / pulseLength;
    
    //float pulseLocation = pulseStart + (pulseFrame * pulseRate); 
    
    // calculate this points position along the pulse
    //float pointLocation = point * pointWidth;
    
    // return 0 unless point is within pulseWidth/2 of pulse location
    //if(pointLocation < (pulseLocation - (pointWidth/2.0)) ||
    //    pointLocation > (pulseLocation + (pointWidth/2.0))) {
      //return 0;
    //}
    
    // we're in the wave, so calculate location
    //float pointInWave = (pointLocation + pulseWidth/2.0) - pulseLocation;
    //println("poL="+pointLocation+"\tpW2="+pulseWidth/2.0+"\tpuL="+pulseLocation+"\tpiW="+pointInWave);
    //float amt = wave(pointInWave,pulseWidth);
    //return amt;
  }
  
  void setPulseLength(int pulseLength) {
    this.pulseLength = pulseLength;
    recalculate();
  }
  
  // recalculate internal variables
  void recalculate() {
    pointWidth = ((float)pulseLength)/((float)points);
  }
}
