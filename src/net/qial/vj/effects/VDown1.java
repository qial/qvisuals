package net.qial.vj.effects;

class VDown1 extends SimpleEffect
{
  void play() {
    stroke(255);
    for(int i = 0; i < 6; i++){
      if(i == 0) {
        float opacity = 255.0/120.0;
        int frameAmt = frameCount%120;
        
        int alpha = (int) (255.0 * (waveUp(frameAmt,120)));
        stroke(alpha);
        fill(alpha);
      } else {
        stroke(255);
        fill(255);
      }
      int off = 120*i;
      off += frameCount%120;
      makeV(60,off+30);
    }
  }
}
