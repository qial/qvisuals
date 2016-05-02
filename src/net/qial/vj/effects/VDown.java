package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.util.DrawUtil;

public class VDown extends ProcessingEffect
{
  public void play() {
    fill(255);
    stroke(255);
    for(int i = 1; i < 10; i++){
      int off = 120*i;
      off += frameCount()%120;
      DrawUtil.makeV(60,off,app);
    }
  }
}