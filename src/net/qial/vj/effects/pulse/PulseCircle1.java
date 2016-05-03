package net.qial.vj.effects.pulse;

import net.qial.vj.effect.ParamEffect;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.sequencers.PulseSequencer;
import net.qial.vj.util.DrawUtil;

public class PulseCircle1 extends ParamEffect
{
  protected final String amt = "shapes";
  protected final String inc = "spacing";
  protected final String amp = "amplitude";
  protected final String skip = "skip";
  public PulseCircle1() {
	// set up sequencer
	this.setSequencer(new PulseSequencer());
    // set up params
    addParam(amt,10);
    addParam(inc,60);
    addParam(amp,30);
    addParam(skip,3);
  }
  public void play() {
    stroke(255);
    noFill();
    int printlimit = 60;
    if(frameCount()<=printlimit)
      println("\nFrame: "+frameCount());
    for(int i = 0; i < getParam(amt); i++) {
      float offset = i * getParam(inc);
      float pulse = seq.get(i);
      float movement = pulse * getParam(amp);
      int circle = (int) (600 - offset - movement);
      DrawUtil.makeCircle(circle,app);
      if(frameCount()<=printlimit) {
        //println(i+": off="+offset+" pls="+pulse+" mv="+movement+" cir="+circle);
      }
    }
  }
}
