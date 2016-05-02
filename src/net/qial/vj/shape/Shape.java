package net.qial.vj.shape;

public interface Shape
{
  public void paint();
}

//For shapes like the V, maybe I need a way to define a 
//movement of some sort. That movement could be distance
//in the case of the Vs, or size in the case of circles.
//Movement could even be both, just an abstraction of 
//size and position movements. Each shape can decide how
//exactly to handle size or position changes defined by
//the movements.
