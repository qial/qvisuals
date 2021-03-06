package net.qial.vj.main;

import net.qial.vj.effect.Effect;
import net.qial.vj.effect.api.EffectBuilder;
import net.qial.vj.effect.api.EffectDescription;
import net.qial.vj.processing.TestApp;

public class EffectBuilderTest {

	public static void main(String[] args) throws Exception {
		TestApp app = new TestApp();
		//testTriangleWave();
		//testvup();
		Effect e = testCircles1();
	}
	
	public static Effect testCircles1() throws Exception {
		EffectDescription desc = EffectReaderTest.testCircles1();
		return loadEffect(desc);
	}

	public static Effect testTriangleWave() throws Exception {
		EffectDescription desc = EffectReaderTest.trianglewave1();
		return loadEffect(desc);
	}

	public static Effect testvup() throws Exception {
		EffectDescription desc = EffectReaderTest.testVup();
		return loadEffect(desc);
	}
	
	public static Effect loadEffect(EffectDescription desc) {
		EffectBuilder builder = new EffectBuilder();
		Effect effect = builder.buildEffect(desc);
		System.out.println(effect);
		return effect;
	}

	public static Effect testLabels() throws Exception {
		EffectDescription desc = EffectReaderTest.testLabels();
		return loadEffect(desc);
	}

}
