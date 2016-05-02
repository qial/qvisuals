package net.qial.vj.effects;

class VDown extends SimpleEffect
{
  void play() {
    fill(255);
    stroke(255);
    for(int i = 1; i < 10; i++){
      int off = 120*i;
      off += frameCount%120;
      makeV(60,off);
    }
  }
}