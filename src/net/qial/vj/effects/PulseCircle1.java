package net.qial.vj.effects;

class PulseCircle1 extends ParamEffect
{
  Sequencer seq = new PulseSequencer();
  
  final String amt = "shapes";
  final String inc = "spacing";
  final String amp = "amplitude";
  final String skip = "skip";
  PulseCircle1() {
    // set up params
    addParam(amt,10);
    addParam(inc,60);
    addParam(amp,30);
    addParam(skip,3);
  }
  void play() {
    stroke(255);
    noFill();
    int printlimit = 60;
    if(frameCount<=printlimit)
      println("\nFrame: "+frameCount);
    for(int i = 0; i < getParam(amt); i++) {
      float offset = i * getParam(inc);
      float pulse = seq.get(i);
      float movement = pulse * getParam(amp);
      int circle = (int) (600 - offset - movement);
      makeCircle(circle);
      if(frameCount<=printlimit) {
        //println(i+": off="+offset+" pls="+pulse+" mv="+movement+" cir="+circle);
      }
    }
  }
}
