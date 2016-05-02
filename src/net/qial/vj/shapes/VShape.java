package net.qial.vj.shapes;

class VShape implements Shape
{
  int w, o;
  VShape(int w, int offset) {
    this.w = w;
    this.o = offset;
  }
  void paint() {
    makeV(w,o);
  }
}
