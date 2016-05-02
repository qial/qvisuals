package net.qial.vj.sequencer;

abstract class AbstractSequencer implements Sequencer
{
  // number of points in set
  // default is 10
  int points = 10;
  
  // if true, range is 0 to 1 instead of -1 to 1
  boolean positive = false;
  
  // recalculate any internal vars
  abstract void recalculate();
  
  int getPoints() {
    return points;
  }
  
  boolean positive() {
    return positive;
  }
  
  void setPoints(int points) {
    this.points = points;
    recalculate();
  }
  
  void setPositive(boolean positive) {
    this.positive = positive;
    // likely nothing to recalculate, but just in case
    recalculate();
  }
}
