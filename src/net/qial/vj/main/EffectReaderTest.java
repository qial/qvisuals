package net.qial.vj.main;

import java.io.*;

import net.qial.vj.effect.api.EffectDescription;
import net.qial.vj.effect.api.EffectReader;

public class EffectReaderTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		testVup();
	}
	
	public static void testVup() throws Exception {
		EffectReader er = new EffectReader();
		
		File dir = new File(".");
		//System.out.println(dir.getAbsolutePath());
		//System.out.println(dir.exists());
		String[] files = dir.list();
		for(String f : files) {
			//System.out.println(f);
		}
		
		InputStream is = new FileInputStream("effects\\test\\vup.yaml");
		EffectDescription desc = er.readEffect(is);
		System.out.println(desc);
	}

}
