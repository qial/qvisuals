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
public class EffectDescription extends Description {
	
	// Defines a special class if required 
	private String subtype;
	
	// Defines the sequencer
	private SequencerDescription sequencer;
	
	// defines the paintables
	private List<PaintableDescription> paintables;
	private List<LinkedHashMap> shapes;
	
	// defines labelled sequencers and movements
	private List<SequencerDescription> sequencers;
	private List<MovementDescription> movements;
	
	// list of defaults
	// paintables can access this
	private HashMap<String,Object> defaults;
	
	public EffectDescription() {
		paintables = new ArrayList<PaintableDescription>();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("EffectDescription{\n");
		if(getLabel() != null) {
			sb.append("  label=").append(getLabel()).append(",\n");
		}
		sb.append("  type=").append(getType()).append(",\n");
		if(subtype != null) {
			sb.append("  subtype=").append(subtype).append(",\n");
		}
		sb.append("  defaults={").append(PrintUtil.toString(defaults));
		sb.append("},\n");
		if(sequencer != null) {
			sb.append("  seq=").append(sequencer).append(",\n");
		}
		descriptionListToString(sb,"shapes",paintables);
		descriptionListToString(sb,"sequencers",sequencers);
		descriptionListToString(sb,"movements",movements);
		sb.append("\n}");
		return sb.toString();
	}
	
	private void descriptionListToString(StringBuilder sb, String name,
			List<? extends Description> descs) {
		if(descs != null && descs.size() > 0) {
			sb.append("  ").append(name).append("=[");
			if(descs != null) {
				boolean first = true;
				for(Description desc : descs) {
					if(first) {
						first = false;
					} else {
						sb.append(",");
					}
					sb.append("\n    ").append(desc);
					//System.out.println(shape);
					//System.out.println(shape.get("movement"));
				}
			}
			sb.append("\n  ]");
		}
	}

	public SequencerDescription getSequencer() {
		return sequencer;
	}

	public void setSequencer(SequencerDescription sequencer) {
		//System.out.println("Set sequencer: "+sequencer);
		this.sequencer = sequencer;
		// set parent
		sequencer.setParent(this);
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
		try {
			List<PaintableDescription> paintables = new ArrayList<PaintableDescription>();
			for(LinkedHashMap map : shapes) {
				PaintableDescription p = new PaintableDescription();
				p.setValues(map);
				p.setParent(this);
				paintables.add(p);
			}
			this.paintables = paintables;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SequencerDescription> getSequencers() {
		return sequencers;
	}
	
	public void setSequencers(List<LinkedHashMap> seqs) {
		
	}
	
	public void setMovements(List<LinkedHashMap> mvmnts) {
		// create list of movements
		try {
			List<MovementDescription> movements = new ArrayList<MovementDescription>();
			for(LinkedHashMap map : mvmnts) {
				MovementDescription desc = new MovementDescription();
				desc.setValues(map);
//				String label = (String) map.getOrDefault("label", "");
//				if(label == null || label.equals("")) {
//					// no label, this is useless
//					continue;
//				}
//				// set label info
//				desc.setLabel(label);
//				// set other values
//				desc.setType((String) map.getOrDefault("type", ""));
//				desc.set
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	
	
}
