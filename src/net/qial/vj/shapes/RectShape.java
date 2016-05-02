package net.qial.vj.shapes;

class RectShape implements Shape
{
  int x,y,w,h;
  RectShape(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
  void paint() {
    rect(x,y,w,h);
  }
}
