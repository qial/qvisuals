package net.qial.vj.shapes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import processing.core.PApplet;
import net.qial.vj.effect.api.EffectBuilder;
import net.qial.vj.effect.api.MovementDescription;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.effect.api.ParamDescription;
import net.qial.vj.movement.Movement;
import net.qial.vj.movement.SequencerMovement;
import net.qial.vj.shape.AbstractShape;
import net.qial.vj.shape.Paintable;
import net.qial.vj.shape.Shape;

public class ShapeSet extends AbstractShape {
	
//	protected int startSize = 0;
//	protected int increment = 0;
	protected int amount = 0;
	protected PaintableDescription shape = null;
//	protected String shape;
	
	// TODO handle the movement
	protected List<Paintable> shapes;
	
	public ShapeSet() {
		
	}
	
	public ShapeSet(PaintableDescription desc) {
		super(desc);
	}

	@Override
	public void paint(PApplet app) {
		for(Paintable p : shapes) {
			p.paint(app);
		}
	}

	@Override
	public void loadFrom(PaintableDescription desc) {
		// determine our shapes
		// TODO determine load order to use the Shape Annotation
//		this.startSize = (Integer) desc.get("start-size");
//		this.increment = (Integer) desc.get("increment");
		this.amount = (Integer) desc.get("amount");
		this.shape = desc.getShape();
		
//		this.shape = (String) desc.get("shape");
		
		// load movement
		List<MovementDescription> mdescs = desc.getMovements();
		
		shapes = new ArrayList<Paintable>();
		
		// handle location options if x and y isn't set
		int x = 0, y = 0;
		String location = (String) desc.get("location");
		if(location != null) {
			if("center".equals(location)) {
				// set x and y to center
				// TODO do we have to give shapes an idea of a center
				// so that when they draw using the app they can find
				// their location on the fly?
				// TODO make this dynamic somehow
				x = 640;
				y = 360;
			}
		}
		// now do overrides for x and y
		if(desc.get("x") != null) {
			x = (int) desc.get("x");
		}
		if(desc.get("y") != null) {
			y = (int) desc.get("y");
		}
		
		// TODO: make this dynamic, not just circles
		
//		int curSize = startSize;
		
		// start storing parameters with starts
		Map<String,Integer> curParams = new HashMap<String,Integer>();
		for(ParamDescription p : desc.getParams()) {
			curParams.put(p.getName(),p.getStart());
		}
		
		for(int i = 0; i < amount; i++) {
			// TODO figure out good way of setting the center
			// TODO load class dynamically, use setValues
//			Shape s = new CircleShape(x,y,curSize);
			
			// update the shape description
			for(ParamDescription p : desc.getParams()) {
				shape.set(p.getName(), curParams.get(p.getName()));
				// manually set x and y, I guess
				shape.set("x", x);
				shape.set("y", y);
			}
			
			Shape s = (Shape) EffectBuilder.buildPaintable(shape);
			
			for(MovementDescription mdesc : mdescs) {
				mdesc.set("point", i);
				Movement m = EffectBuilder.buildMovement(mdesc);
				s.addMovement(m);
			}
//			SequencerMovement seqm = new SequencerMovement();
//			seqm.setParam("size");
			
			shapes.add(s);
			// create the mover for this
			
			//TODO load movement class and values dynamically
			
			
			
			// update values for next shape
			for(ParamDescription p : desc.getParams()) {
				int amt = curParams.get(p.getName());
				amt += p.getIncrement();
				curParams.put(p.getName(), amt);
			}
		}
	}

}
