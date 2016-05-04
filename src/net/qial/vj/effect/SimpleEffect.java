package net.qial.vj.effect;

public abstract class SimpleEffect implements Effect {
	private boolean enabled = false;
	private boolean alwaysOn = false;

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean enabled() {
		if (alwaysOn) {
			return true;
		}
		return enabled;
	}

	public void toggleAlwaysOn() {
		if (alwaysOn) {
			alwaysOn = false;
		} else {
			alwaysOn = true;
		}
	}

	public boolean alwaysOn() {
		return alwaysOn;
	}

	public String name() {
		return getClass().getName();
	}

	public void handleKey() {
	}

	public abstract void play();
}