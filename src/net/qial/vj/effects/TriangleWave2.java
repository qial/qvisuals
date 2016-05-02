package net.qial.vj.effects;

class TriangleWave2 extends SimpleEffect
{
  void play() {
    float amt = sin(frameCount/60.0)*30;
    for(int i = 1; i < 20; i++) {
      makeTriangle((int)(100+(amt * i)),100*i);
    }
  }
}