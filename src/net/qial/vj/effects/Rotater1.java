package net.qial.vj.effects;

import net.qial.vj.effect.ParamEffect;

public class Rotater1 extends ParamEffect
{
  final String amt = "shapes";
  final String inc = "spacing";
  final String amp = "amplitude";
  final String start = "size";
  public Rotater1() {
    // set up params
    addParam(amt,10);
    addParam(inc,28);
    addParam(amp,18);
    addParam(start,80);
  }
  public void play() {
    
    for(int i = 0; i < 10; i++) {
      int size = getParam(start)+(i*getParam(inc)); 
      //rect(
      //rotate(
    }
  }
}