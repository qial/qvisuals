package net.qial.vj.effect.api;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 * This class reads YAML files and turns them into a DesignedEffect
 * object using the effects API
 * 
 * @author kw
 *
 */
public class EffectReader {
	public EffectDescription readEffect(InputStream is) throws IOException {
		Yaml yaml = new Yaml(new Constructor(EffectDescription.class));
		EffectDescription desc = yaml.loadAs(is, EffectDescription.class);
		return desc;
	}
}
