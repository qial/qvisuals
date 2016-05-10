package net.qial.vj.effect;

import net.qial.vj.effect.api.EffectDescription;

public interface Effect {
	public String name();

	public void play();

	public void handleKey();

	public void setEnabled(boolean enabled);

	public boolean enabled();

	public void toggleAlwaysOn();

	public boolean alwaysOn();
	
	/**
	 * Implementing classes can choose to override this to handle
	 * saving and loading to/from YAML. It returns an effect because
	 * some classes may need to return a new instance. The
	 * default implementation in SimpleEffect simply returns itself.
	 * 
	 * @param desc EffectDescription to load parameters from
	 */
	public Effect loadFrom(EffectDescription desc);
}
