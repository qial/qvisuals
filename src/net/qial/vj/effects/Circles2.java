package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.util.DrawUtil;

public class Circles2 extends ProcessingEffect
{
  public void play() {
    noFill();
    stroke(255);
    for(int i = 0; i < 20; i++) {
      float s = seq.get(i);
      int offset = i*35 + (int)(s * 30);
      DrawUtil.makeCircle(offset,app);
      //makeTriangle(100+getSizeForOffset(offset),360-offset);
    }
  }
}
