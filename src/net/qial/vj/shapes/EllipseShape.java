package net.qial.vj.shapes;

class EllipseShape extends RectShape
{
  EllipseShape(int x, int y, int w, int h) {
    super(x,y,w,h);
  }
  void paint() {
    ellipse(x,y,w,h);
  }
}
