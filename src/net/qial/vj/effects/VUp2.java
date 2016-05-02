package net.qial.vj.effects;

class VUp2 extends ParamEffect
{
  final String amt = "shapes";
  final String w = "width";
  final String inc = "spacing";
  final String fade = "fade";
  //String amp = "amplitude";
  //String start = "start";
  VUp2() {
    // set up params
    addParam(amt,4);
    addParam(w,60);
    addParam(inc,60);
    addParam(fade,60);
    //addParam(amp,18);
    //addParam(start,2);
  }
  void play() {
    stroke(255);
    for(int i = 0; i < 6; i++){
      if(i == 0) {
        float opacity = 255.0/120.0;
        int frameAmt = frameCount%120;
        
        int alpha = (int) (255.0 * (waveDown(frameAmt,120)));
        stroke(alpha);
        fill(alpha);
      } else {
        stroke(255);
        fill(255);
      }
      int off = 120*i;
      off -= frameCount%120;
      makeV(60,off+150);
    }
  }
}