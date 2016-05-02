package net.qial.vj.shapes;

class CircleShape extends EllipseShape
{
  CircleShape(int x, int y, int r) {
    super(x,y,r*2,r*2);
  }
}
