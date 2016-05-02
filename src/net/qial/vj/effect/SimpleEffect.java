package net.qial.vj.effect;

abstract class SimpleEffect implements Effect
{
  boolean enabled = false;
  void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
  boolean enabled() {
    if(alwaysOn) {
      return true;
    }
    return enabled;
  }
  boolean alwaysOn = false;
  void toggleAlwaysOn() {
    if(alwaysOn) {
      alwaysOn = false;
    } else {
      alwaysOn = true;
    }
  }
  boolean alwaysOn() {
    return alwaysOn;
  }
  String name() {
    return getClass().getName();
  }
  void handleKey() {}
  abstract void play();
}