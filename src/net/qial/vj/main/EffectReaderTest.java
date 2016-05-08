package net.qial.vj.main;

import java.io.*;

import net.qial.vj.effect.api.EffectDescription;
import net.qial.vj.effect.api.EffectReader;
import net.qial.vj.effect.api.yaml.YamlEffectReader;

public class EffectReaderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//testVup();
		//testCircles1();
		trianglewave1();
	}
	
	public static void testVup() throws Exception {
		readEffect("effects\\test\\vup.yaml");
	}
	
	public static void testCircles1() throws Exception {
		readEffect("effects\\test\\circles1.yaml");
	}
	
	public static void trianglewave1() throws Exception {
		readEffect("effects\\test\\trianglewave1.yaml");
	}
	
	public static EffectDescription readEffect(String s) throws Exception {
		EffectReader er = new YamlEffectReader();
		
		File dir = new File(".");
		//System.out.println(dir.getAbsolutePath());
		//System.out.println(dir.exists());
		String[] files = dir.list();
		for(String f : files) {
			//System.out.println(f);
		}
		
		InputStream is = new FileInputStream(s);
		EffectDescription desc = er.readEffect(is);
		System.out.println(desc);
		return desc;
	}

}
