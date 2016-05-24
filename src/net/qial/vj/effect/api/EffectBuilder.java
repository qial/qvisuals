package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import net.qial.vj.bpm.BPM;
import net.qial.vj.effect.Effect;
import net.qial.vj.effect.ParamEffect;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.sequencer.SequencerType;
import net.qial.vj.sequencers.BpmPulseSequencer;
import net.qial.vj.shape.MovementType;
import net.qial.vj.shape.Movement;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.ShapeType;
import net.qial.vj.shapes.VShape;
import net.qial.vj.util.PrintUtil;

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
	private static Map<String,Class<?>> effectMap;
	private static Map<String,Class<?>> sequencerMap;
	private static Map<String,Class<?>> paintableMap;
	private static Map<String,Class<?>> movementMap;
	
	public Effect buildEffect(EffectDescription desc) {
		// make sure the classpath scanner is initialized
		loadScanner();
		
		Effect effect = null;
		
		String type = desc.getType();
		
		
		
		if("param".equals(type)) {
			
		}
		else if("designed".equals(type)) {
			effect = buildDesignedEffect(desc);
		}
		
		return effect;
	}
	
	public DesignedEffect buildDesignedEffect(EffectDescription desc) {
		DesignedEffect d = new DesignedEffect();
		if(desc.getSequencer() != null) {
			Sequencer seq = buildSequencer(desc.getSequencer());
			d.setSequencer(seq);
		}
		d.setDefaults(d.getDefaults());
		for(PaintableDescription pdesc : desc.getPaintables()) {
			// set parent effect
			//pdesc.setParent(d);
			Paintable p = buildPaintable(pdesc);
			if(p != null) {
				d.addPart(p);
			}
		}
		return d;
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
	public MovementType buildMovement(MovementDescription desc) {
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
	
	private static synchronized void loadScanner() {
		// TODO maybe scan everything?
		// maybe only scan everything if we can detect this is 
		// running as a library in another project?
		boolean needScan = true;
		if(scanner == null) {			
			scanner = new FastClasspathScanner("net.qial.vj");
		} else {
			needScan = scanner.classpathContentsModifiedSinceScan();
		}
		if(needScan) {
			// update scan
			scanner.verbose();
			scanner.scan();
			
			// load effect types
			effectMap = new HashMap<String,Class<?>>();
			loadTypes(EffectType.class,effectMap);
			System.out.println("Effects:"+PrintUtil.toString(effectMap));
			
			// load sequencer types
			sequencerMap = new HashMap<String,Class<?>>();
			loadTypes(SequencerType.class, sequencerMap);
			System.out.println("Sequencers:"+PrintUtil.toString(sequencerMap));
			
			// load movement types
			movementMap = new HashMap<String,Class<?>>();
			loadTypes(MovementType.class, movementMap);
			System.out.println("Movements:"+PrintUtil.toString(movementMap));
			
			// load shapes
			paintableMap = new HashMap<String,Class<?>>();
			loadTypes(ShapeType.class, paintableMap);
			System.out.println("Paintables:"+PrintUtil.toString(paintableMap));
		}
	}
	
	public static Effect getEffect(String type) {
		// ensure scanner is loaded
		loadScanner();
		
		Class<?> cls = effectMap.get(type);
		return (Effect)getInstance(cls);
	}
	
	public static Sequencer getSequencer(String type) {
		// ensure scanner is loaded
		loadScanner();
		
		Class<?> cls = sequencerMap.get(type);
		return (Sequencer)getInstance(cls);
	}
	
	public static Movement getMovement(String type) {
		// ensure scanner is loaded
		loadScanner();
		
		Class<?> cls = movementMap.get(type);
		return (Movement)getInstance(cls);
	}
	
	public static Paintable getShape(String type) {
		// ensure scanner is loaded
		loadScanner();
		
		Class<?> cls = paintableMap.get(type);
		return (Paintable)getInstance(cls);
	}
	
	public static <T> T getInstance(Class<T> clazz) {
		if(clazz == null) {
			// it wasn't found
			return null;
		}
		try {
			T obj = clazz.newInstance();
			return obj;
		} catch (InstantiationException e) {
			System.err.println("Unable to load instance of class "+clazz.getCanonicalName());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("Unable to load instance of class "+clazz.getCanonicalName());
			e.printStackTrace();
		}
		return null;
	}
	
	private static synchronized void loadTypes(Class<?> clazz, Map<String,Class<?>> map) {
		// update effect type map
		List<String> classes = scanner.getNamesOfClassesWithAnnotation("net.qial.vj.effect.api.EffectType");
		System.out.println(clazz.getCanonicalName()+" found: "+classes+" ("+classes.size()+")");
		for(String cls : classes) {
			try {
				Class c = EffectBuilder.class.getClassLoader().loadClass(cls);
				map.put(cls, c);
			} catch (ClassNotFoundException e) {
				System.out.println("Unable to load @"+clazz.getName()+" class "+cls);
				e.printStackTrace();
			} 
		}
	}
}
