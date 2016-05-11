package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import net.qial.vj.bpm.BPM;
import net.qial.vj.effect.Effect;
import net.qial.vj.effect.ParamEffect;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.sequencers.BpmPulseSequencer;
import net.qial.vj.shape.Movement;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shapes.VShape;

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
	private static FastClasspathScanner scanner;
	private static Map<String,Class<?>> typeMap;
	
	public Effect buildEffect(EffectDescription desc) {
		// make sure the classpath scanner is initialized
		loadScanner();
		
		Effect effect = null;
		
		String type = desc.getType();
		
		
		
		if("param".equals(type)) {
			
		}
		else if("designed".equals(type)) {
			DesignedEffect d = new DesignedEffect();
			if(desc.getSequencer() != null) {
				Sequencer seq = buildSequencer(desc.getSequencer());
				d.setSequencer(seq);
			}
			d.setDefaults(d.getDefaults());
			for(PaintableDescription pdesc : desc.getPaintables()) {
				Paintable p = buildPaintable(pdesc);
				if(p != null) {
					d.addPart(p);
				}
			}
			
			effect = d;
		}
		
		return effect;
	}
	
	public Paintable buildPaintable(PaintableDescription desc) {
		Paintable p = null;
		
		//TODO move this into individual paintables
		String type = desc.getType();
		if("v".equals(type)) {
			// TODO determine offset? Maybe change how vshape is?
			// TODO movements?
			VShape v = new VShape((Integer)desc.get("width"),0);
			p = v;
			System.out.println(p);
		}
		
		return p;
	}
	
	// TODO: Figure out final movement classes
	public Movement buildMovement(MovementDescription desc) {
		return null;
	}
	
	public Sequencer buildSequencer(SequencerDescription desc) {
		Sequencer seq = null;
		
		String type = desc.getType();
		if("bpm".equals(type)) {
			int bpmSpeed = desc.getBpm();
			BPM bpm = new BPM(bpmSpeed);
			BpmPulseSequencer bpmseq = new BpmPulseSequencer(bpm);
			seq = bpmseq;
		}
		
		return seq;
	}
	
	private void loadScanner() {
		// TODO maybe scan everything?
		// maybe only scan everything if we can detect this is 
		// running as a library in another project?
		boolean needScan = scanner.classpathContentsModifiedSinceScan();
		if(scanner == null) {			
			scanner = new FastClasspathScanner("net.qial.vj");
			scanner.scan();
			needScan = true;
		}
		if(needScan) {
			// update scan
			scanner.scan();
			
			typeMap = new HashMap<String,Class<?>>();
			
			// update effect type map
			List<String> effectClasses = scanner.getNamesOfClassesWithAnnotation(EffectType.class);
			for(String cls : effectClasses) {
				try {
					Class c = getClass().getClassLoader().loadClass(cls);
					typeMap.put(cls, c);
				} catch (ClassNotFoundException e) {
					System.out.println("Unable to load @EffectType class "+cls);
					e.printStackTrace();
				} 
			}
		}
	}
}
