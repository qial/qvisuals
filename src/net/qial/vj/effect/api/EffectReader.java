package net.qial.vj.effect.api;

import java.io.IOException;
import java.io.InputStream;

public interface EffectReader {
	public EffectDescription readEffect(InputStream is) throws IOException; 
}
