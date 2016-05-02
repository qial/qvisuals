package net.qial.vj.effect;

import java.util.ArrayList;

import net.qial.vj.shapes.Rectangle;

class StreamEffect extends SimpleEffect
{
  private ArrayList<Rectangle> cams;
  private Rectangle gameOuter;
  private Rectangle gameInner;
  StreamEffect() {
    cams = new ArrayList<Rectangle>();
  }
  void setOuter(Rectangle outer) {
    this.gameOuter = outer;
  }
  void setInner(Rectangle inner) {
    this.gameInner = inner;
  }
  void addCam(Rectangle cam) {
    cams.add(cam);
  }
  void play() {
    background(255);
    noStroke();
    fill(0);
    for(Rectangle r : cams) {
      rect(r.x,r.y,r.w,r.h);
    }
    fill(0);
    rect(gameOuter.x,gameOuter.y,gameOuter.w,gameOuter.h);
  }
}
