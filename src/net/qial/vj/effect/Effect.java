package net.qial.vj.effect;

interface Effect
{
  String name();
  void play();
  void handleKey();
  void setEnabled(boolean enabled);
  boolean enabled();
  void toggleAlwaysOn();
  boolean alwaysOn();
}
