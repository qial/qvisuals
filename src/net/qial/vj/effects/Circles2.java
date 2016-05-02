package net.qial.vj.effects;

class Circles2 extends SimpleEffect
{
  void play() {
    noFill();
    stroke(255);
    for(int i = 0; i < 20; i++) {
      float s = seq.get(i);
      int offset = i*35 + (int)(s * 30);
      makeCircle(offset);
      //makeTriangle(100+getSizeForOffset(offset),360-offset);
    }
  }
}
