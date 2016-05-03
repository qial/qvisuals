package net.qial.vj.shapes;

import net.qial.vj.shape.Shape;
//import net.qial.vj.util.DrawUtil;

class VShape implements Shape
{
  int w, o;
  public VShape(int w, int offset) {
    this.w = w;
    this.o = offset;
  }
  public void paint() {
    //DrawUtil.makeV(w,o);
  }
}
