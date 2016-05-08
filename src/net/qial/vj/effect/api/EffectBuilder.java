package net.qial.vj.effect.api;

import net.qial.vj.effect.Effect;
import net.qial.vj.effect.ParamEffect;

/**
 * Builds an actual Effect given an EffectDescription Handles types and such.
 * 
 * Right now types are hardcoded. I'd like to use Annotations to link types and
 * effect implementations. Maybe effect implementations can eventually handle
 * their own creation given the EffectDescription object.
 * 
 * @author kw
 *
 */
public class EffectBuilder {
	public Effect buildEffect(EffectDescription desc) {
		Effect effect = null;
		
		String type = desc.getType();
		if("param".equals(type)) {
			String cls = desc.getSubtype();
			try {
				Class c = getClass().getClassLoader().loadClass(cls);
				Class<ParamEffect> paramClass = c.asSubclass(ParamEffect.class);
				ParamEffect peffect = paramClass.newInstance();
				for(String k : desc.getDefaults().keySet()) {
					Object v = desc.getDefaults().get(k);
					int i = (Integer)v;
					peffect.setParam(k, i);
				}
				effect = peffect;
			} catch (ClassNotFoundException e) {
				System.out.println("Unable to load class from subtype "+cls);
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.out.println("Unable to instantiate class from subtype "+cls);
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("Unable to instantiate class from subtype "+cls);
				e.printStackTrace();
			}
		}
		else if("designed".equals(type)) {
			
		}
		
		return effect;
	}
}
