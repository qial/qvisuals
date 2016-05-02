package net.qial.vj.effects;

import net.qial.vj.effect.ProcessingEffect;
import net.qial.vj.util.DrawUtil;

public class VDown1 extends ProcessingEffect
{
  public void play() {
    stroke(255);
    for(int i = 0; i < 6; i++){
      if(i == 0) {
        float opacity = 255.0f/120.0f;
        int frameAmt = frameCount()%120;
        
        int alpha = (int) (255.0 * (DrawUtil.waveUp(frameAmt,120)));
        stroke(alpha);
        fill(alpha);
      } else {
        stroke(255);
        fill(255);
      }
      int off = 120*i;
      off += frameCount()%120;
      DrawUtil.makeV(60,off+30,app);
    }
  }
}
