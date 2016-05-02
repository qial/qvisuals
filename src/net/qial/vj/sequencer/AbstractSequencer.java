package net.qial.vj.sequencer;

public abstract class AbstractSequencer implements Sequencer
{
  // number of points in set
  // default is 10
  int points = 10;
  
  // if true, range is 0 to 1 instead of -1 to 1
  boolean positive = false;
  
  // recalculate any internal vars
  protected abstract void recalculate();
  
  public int getPoints() {
    return points;
  }
  
  public boolean positive() {
    return positive;
  }
  
  public void setPoints(int points) {
    this.points = points;
    recalculate();
  }
  
  public void setPositive(boolean positive) {
    this.positive = positive;
    // likely nothing to recalculate, but just in case
    recalculate();
  }
}
