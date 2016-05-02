package net.qial.vj.shapes;

import net.qial.vj.shape.Shape;

public class RectShape implements Shape
{
  protected int x,y,w,h;
  public RectShape(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
  public void paint() {
    //rect(x,y,w,h);
  }
}
