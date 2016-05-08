package net.qial.vj.effect.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.qial.vj.shape.Paintable;
import net.qial.vj.util.PrintUtil;

/**
 * Stores the description of an effect. Used in the Effect API to save and load
 * different effects. This class and the rest of 
 * <code>net.qial.vj.effect.api</code> can be used
 * @author kw
 *
 */
public class EffectDescription {

	// Defines what top-level Effect class this should use
	private String type;
	
	// Defines a special class if required 
	private String subtype;
	
	// Defines the sequencer
	private SequencerDescription sequencer;
	
	// defines the paintables
	private List<PaintableDescription> paintables;
	private List<LinkedHashMap> shapes;
	
	// list of defaults
	// paintables can access this
	private HashMap<String,String> defaults;
	
	public EffectDescription() {
		paintables = new ArrayList<PaintableDescription>();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("EffectDescription{\n");
		sb.append("  type=").append(type).append(",\n");
		sb.append("  subtype=").append(subtype).append(",\n");
		sb.append("  defaults={").append(PrintUtil.toString(defaults));
		sb.append("},\n");
		if(sequencer != null) {
			sb.append("  seq=").append(sequencer).append(",\n");
		}
		if(shapes != null && shapes.size() > 0) {
			sb.append("  shapes=[");
			if(shapes != null) {
				boolean first = true;
				for(PaintableDescription shape : paintables) {
					if(first) {
						first = false;
					} else {
						sb.append(",");
					}
					sb.append("\n    ").append(shape);
					//System.out.println(shape);
					//System.out.println(shape.get("movement"));
				}
			}
			sb.append("\n  ]");
		}
		sb.append("\n}");
		return sb.toString();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		//System.out.println("Set type: "+type);
		this.type = type;
	}

	public SequencerDescription getSequencer() {
		return sequencer;
	}

	public void setSequencer(SequencerDescription sequencer) {
		//System.out.println("Set sequencer: "+sequencer);
		this.sequencer = sequencer;
	}

	public List<LinkedHashMap> getShapes() {
		return shapes;
	}
	
	public List<PaintableDescription> getPaintables() {
		return paintables;
	}

	public void setShapes(List<LinkedHashMap> shapes) {
		//System.out.println("Set shapes: "+shapes);
		this.shapes = shapes;
		
		// create list of paintables
		try{
			List<PaintableDescription> paintables = new ArrayList<PaintableDescription>();
			for(LinkedHashMap map : shapes) {
				PaintableDescription p = new PaintableDescription();
				p.setValues(map);
				paintables.add(p);
				this.paintables = paintables;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getDefaults() {
		return defaults;
	}

	public void setDefaults(HashMap<String, String> defaults) {
		//System.out.println("Set defaults: "+defaults);
		this.defaults = defaults;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	
}
