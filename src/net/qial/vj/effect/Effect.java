package net.qial.vj.effect;

public interface Effect
{
  public String name();
  public void play();
  public void handleKey();
  public void setEnabled(boolean enabled);
  public boolean enabled();
  public void toggleAlwaysOn();
  public boolean alwaysOn();
}
