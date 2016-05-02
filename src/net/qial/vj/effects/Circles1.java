package net.qial.vj.effects;

class Circles1 extends SimpleEffect
{
  void play() {
    fill(255);
    stroke(0);
    for(int i = 0; i < 20; i++) {
      float s = seq.get(i);
      int offset = i*35 + (int)(s * 30);
      makeCircle(offset);
    }
  }
}