package net.qial.vj.effect.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
	
	private List<MovementDescription> movements;
	
	private List<ParamDescription> params;
	
//	private HashMap<String,Object> others;
	
	//private DesignedEffect parent;

	public PaintableDescription() {
//		others = new HashMap<String,Object>();
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
			movements = new ArrayList<MovementDescription>();
			
			// check if its one movement or more
			if(v instanceof List<?>) {
				for(LinkedHashMap vals : (List<LinkedHashMap>) v) {
					MovementDescription desc = new MovementDescription();
					desc.setValues(vals);
					desc.setParent(this);
					movements.add(desc);
				}
			}
			else if(v instanceof LinkedHashMap) {
				MovementDescription desc = new MovementDescription();
				desc.setValues((LinkedHashMap)v);
				// set parent
				desc.setParent(this);
				movements.add(desc);
			}
			
		}
		else if("params".equals(k)) {
			params = new ArrayList<ParamDescription>();
			if(v instanceof List<?>) {
				List<LinkedHashMap> paramList = (List<LinkedHashMap>) v;
				for(LinkedHashMap vals : paramList) {
					ParamDescription param = new ParamDescription();
					param.setValues(vals);
					params.add(param);
				}
			}
			else if(v instanceof LinkedHashMap) {
				// probably just one param
				LinkedHashMap vals = (LinkedHashMap) v;
				ParamDescription param = new ParamDescription();
				param.setValues(vals);
				params.add(param);
			}
			else {
				System.out.println("Couldn't figure out 'params' var, class "+ 
						v.getClass().getName() + ": " + v);
			}
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

	public List<MovementDescription> getMovements() {
		return movements;
	}

	public void setMovements(List<MovementDescription> movements) {
		this.movements = movements;
	}
	
	public void addMovement(MovementDescription movement) {
		if(movements == null) {
			movements = new ArrayList<MovementDescription>();
		}
		movements.add(movement);
	}
	
	public List<ParamDescription> getParams() {
		return params;
	}

	public void setParams(List<ParamDescription> params) {
		this.params = params;
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
		if(movements != null)
			sb.append(",movement=").append(movements);
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
