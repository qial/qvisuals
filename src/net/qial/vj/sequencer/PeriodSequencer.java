package net.qial.vj.sequencer;

abstract class PeriodSequencer extends AbstractSequencer
{
  // number of times the period runs over the course of a visual
  int periods = 1;
  
  void setPeriods(int periods) {
    this.periods = periods;
    recalculate();
  }
}
