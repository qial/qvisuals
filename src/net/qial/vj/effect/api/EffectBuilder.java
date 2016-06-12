package net.qial.vj.effect.api;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.AnnotationDetector.TypeReporter;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import net.qial.vj.bpm.BPM;
import net.qial.vj.effect.Effect;
import net.qial.vj.effect.ParamEffect;
import net.qial.vj.movement.ConstantMovement;
import net.qial.vj.movement.Movement;
import net.qial.vj.movement.MovementType;
import net.qial.vj.movement.SequencerMovement;
import net.qial.vj.sequencer.Sequencer;
import net.qial.vj.sequencer.SequencerType;
import net.qial.vj.sequencers.BpmPulseSequencer;
import net.qial.vj.sequencers.BpmSequencer;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.ShapeType;
import net.qial.vj.shapes.CircleShape;
import net.qial.vj.shapes.DiamondShape;
import net.qial.vj.shapes.EllipseShape;
import net.qial.vj.shapes.RectShape;
import net.qial.vj.shapes.ShapeSet;
import net.qial.vj.shapes.SquareShape;
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
	private static boolean loaded = false;
	private static FastClasspathScanner scanner;
	private static Map<String,Class<?>> effectMap;
	private static Map<String,Class<?>> sequencerMap;
	private static Map<String,Class<?>> paintableMap;
	private static Map<String,Class<?>> movementMap;
	
	public static Effect buildEffect(EffectDescription desc) {
		// make sure the classpath scanner is initialized
		loadScanner();
		
		Effect effect = null;
		
		String type = desc.getType();
		
		Class<?> cls = effectMap.get(type);
		if(cls != null) {
			try {
				Effect e = (Effect)cls.newInstance();
				Effect e2 = e.loadFrom(desc);
				return e2;
			} catch(Exception e) {
				System.out.println("Unable to create effect for type "+type+" and class "+cls.getCanonicalName());
				e.printStackTrace();
				return null;
			}
		}
		else {
			System.out.println("Could not find effect for type "+type);
			return null;
		}
		
//		if("param".equals(type)) {
//			
//		}
//		else if("designed".equals(type)) {
//			effect = buildDesignedEffect(desc);
//		}
//		
//		return effect;
	}
	
//	public DesignedEffect buildDesignedEffect(EffectDescription desc) {
//		DesignedEffect d = new DesignedEffect();
//		d.loadFrom(desc);
//		return d;
//	}
	
	public static Paintable buildPaintable(PaintableDescription desc) {
		Paintable p = null;
		
		String type = desc.getType();
		
		Class<?> cls = paintableMap.get(type);
		if(cls != null) {
			try {
				p = (Paintable)cls.newInstance();
				p.loadFrom(desc);
				return p;
			} catch(Exception e) {
				System.out.println("Unable to create effect for type "+type+" and class "+cls.getCanonicalName());
				e.printStackTrace();
				return null;
			}
		}
		else {
			System.out.println("Could not find effect for type "+type);
			return null;
		}
	}
	
	public static Movement buildMovement(MovementDescription desc) {
		String type = desc.getType();
		Movement move = getMovement(type);
		if(move != null) {
			move.loadFrom(desc);
		}
		return move;
	}
	
	public static Sequencer buildSequencer(SequencerDescription desc) {
		String type = desc.getType();
		Sequencer seq = getSequencer(type);
		if(seq != null) {
			seq.loadFrom(desc);
		}
		return seq;
	}
	
	private static synchronized void loadScanner() {
		// TODO fix scanning
		if(loaded) {
			return;
		}

		// TODO don't hardcode like this
		// effects
		effectMap = new HashMap<String,Class<?>>();
		effectMap.put("param", ParamEffect.class);
		effectMap.put("designed", DesignedEffect.class);
		
		// sequencers
		sequencerMap = new HashMap<String,Class<?>>();
		sequencerMap.put("bpm", BpmSequencer.class);
		sequencerMap.put("pulseDown", BpmPulseSequencer.class);
		sequencerMap.put("pulseUp", BpmPulseSequencer.class);
		sequencerMap.put("pulse", BpmPulseSequencer.class);
		
		// movements
		movementMap = new HashMap<String,Class<?>>();
		movementMap.put("constant", ConstantMovement.class);
		movementMap.put("sequencer", SequencerMovement.class);
		
		// shapes
		paintableMap = new HashMap<String,Class<?>>();
		paintableMap.put("circle", CircleShape.class);
		paintableMap.put("diamond", DiamondShape.class);
		paintableMap.put("rect", RectShape.class);
		paintableMap.put("ellipse", EllipseShape.class);
		paintableMap.put("set", ShapeSet.class);
		paintableMap.put("square", SquareShape.class);
		paintableMap.put("v-up", VShape.class);
		
		// TODO maybe scan everything?
		// maybe only scan everything if we can detect this is 
		// running as a library in another project?
//		boolean needScan = true;
//		if(scanner == null) {			
//			scanner = new FastClasspathScanner("net.qial.vj");
//		} else {
//			needScan = scanner.classpathContentsModifiedSinceScan();
//		}
//		if(needScan) {
//			// update scan
////			scanner.verbose();
//			scanner.scan();
//			
//			// build maps
//			effectMap = new HashMap<String,Class<?>>();
//			sequencerMap = new HashMap<String,Class<?>>();
//			movementMap = new HashMap<String,Class<?>>();
//			paintableMap = new HashMap<String,Class<?>>();
//			
//			// build annotation detector class
//			final TypeReporter reporter = new TypeReporter() {
//			    @SuppressWarnings("unchecked")
//			    @Override
//			    public Class<? extends Annotation>[] annotations() {
//			        return new Class[]{EffectType.class,SequencerType.class,
//			        		MovementType.class,ShapeType.class};
//			    }
//
//				@Override
//				public void reportTypeAnnotation(
//						Class<? extends Annotation> annotation, 
//						String className) {
//					// load class first
//					System.out.println("Attempting to get type for "+className);
//					try {
//						Class<?> cls = null;
//						cls = getClass().getClassLoader().loadClass(className);
//						//cls.getAnnotation
//						//Method nameMethod = annotation.getMethod("name",null);
//						//String type = nameMethod.
//						System.out.println(annotation.getName());
//						System.out.println(EffectType.class.getName());
//						if(annotation.getName().equals(EffectType.class.getName())) {
//							EffectType typeAnnotation = (EffectType)cls.getAnnotation(annotation);
//							String type = typeAnnotation.name();
//							System.out.println("WHAT");
//							effectMap.put(type,cls);
//							System.out.println(typeAnnotation.getClass().getName()+
//									": '"+type+"' -> "+cls.getCanonicalName());
//						} 
//						else if(annotation == SequencerType.class) {
//							
//						}
//						else if(annotation == MovementType.class) {
//							
//						}
//						else if(annotation == ShapeType.class) {
//							
//						}
//					} catch (Exception e) {
//						System.out.println("Unable to import annotation for "+className);
//						e.printStackTrace();
//						return;
//					}
//				}
//
//			};
//			final AnnotationDetector cf = new AnnotationDetector(reporter);
//			try {
//				cf.detect();
//			} catch (IOException e) {
//				System.err.println("Error trying to load types");
//				e.printStackTrace();
//			}
//			System.out.println("Finished scan");
//			
//			// load effect types
//			loadTypes(EffectType.class,effectMap);
//			System.out.println("Effects:"+PrintUtil.toString(effectMap));
//			
//			// load sequencer types
//			loadTypes(SequencerType.class, sequencerMap);
//			System.out.println("Sequencers:"+PrintUtil.toString(sequencerMap));
//			
//			// load movement types
//			loadTypes(MovementType.class, movementMap);
//			System.out.println("Movements:"+PrintUtil.toString(movementMap));
//			
//			// load shapes
//			loadTypes(ShapeType.class, paintableMap);
//			System.out.println("Paintables:"+PrintUtil.toString(paintableMap));
//		}
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
