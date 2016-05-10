package net.qial.vj.effect;

import net.qial.vj.effect.api.EffectDescription;

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
	
	public void loadFrom(EffectDescription desc) {
		// do nothing as the default.
	}

	public abstract void play();
}