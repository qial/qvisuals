package net.qial.vj.effect.api;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.qial.vj.util.PrintUtil;

/**
 * Describes a paintable
 * 
 * While the PaintableDescription itself extends a HashMap, it has helper methods
 * to allow access to other information.
 * 
 * Eventually either this class or another needs to be able to create
 * Paintable objects out of this description
 * 
 * @author kw
 *
 */
public class PaintableDescription extends Description {
	
	private PaintableDescription shape;
	
	private MovementDescription movement;
	
//	private HashMap<String,Object> others;
	
	//private DesignedEffect parent;
	
	public PaintableDescription() {
//		others = new HashMap<String,Object>();
	}
	
	public void setValues(LinkedHashMap map) {
		for(Object o : map.keySet()) {
			String k = (String)o;
			Object v = map.get(k);
			
			set(k,v);
		}
	}
	
	// set a particular value
	public void set(String k, Object v) {
		// handle some values specially
		if("type".equals(k)) {
			setType((String)v);
		}
		else if("shape".equals(k)) {
			PaintableDescription desc = new PaintableDescription();
			// determine if this is a simple type name or an object
			if(v instanceof String) {
				desc.setType((String)v);
			} else {
				desc.setValues((LinkedHashMap)v);
			}
			shape = desc;
		}
		else if("movement".equals(k)) {
			MovementDescription desc = new MovementDescription();
			desc.setValues((LinkedHashMap)v);
			movement = desc;
		}
		else {
			super.set(k,v);
		}
	}

	public PaintableDescription getShape() {
		return shape;
	}

	public void setShape(PaintableDescription shape) {
		this.shape = shape;
	}

	public MovementDescription getMovement() {
		return movement;
	}

	public void setMovement(MovementDescription movement) {
		this.movement = movement;
	}

//	public DesignedEffect getParent() {
//		return parent;
//	}
//
//	public void setParent(DesignedEffect parent) {
//		this.parent = parent;
//		// set parent on our child descriptions
//		if(movement != null) {
//			movement.setParent(parent);
//		}
//	}

	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("PaintableDescription{");
		sb.append("type=").append(getType());
		if(shape != null)
			sb.append(",shape=").append(shape);
		if(movement != null)
			sb.append(",movement=").append(movement);
		//boolean first = true;
		for(Object k : getDefaults().keySet()) {
			Object v = getDefaults().get(k);
			sb.append(",");
			sb.append(k).append("=").append(v);
		}
		//sb.append(PrintUtil.toString(this));
		sb.append("}");
		return sb.toString();
	}
}
