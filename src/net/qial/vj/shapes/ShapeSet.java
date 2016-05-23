package net.qial.vj.shapes;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import net.qial.vj.effect.api.PaintableDescription;
import net.qial.vj.shape.AbstractShape;
import net.qial.vj.shape.Paintable;

public class ShapeSet extends AbstractShape {
	
	protected int startSize = 0;
	protected int increment = 0;
	protected int amount = 0;
	protected String shape;
	
	// TODO handle the movement
	protected List<Paintable> shapes;
	
	public ShapeSet() {
		
	}
	
	public ShapeSet(PaintableDescription desc) {
		super(desc);
	}

	@Override
	public void paint(PApplet app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadValues(PaintableDescription desc) {
		// determine our shapes
		// TODO determine load order to use the Shape Annotation
		this.startSize = (Integer) desc.get("start-size");
		this.increment = (Integer) desc.get("increment");
		this.amount = (Integer) desc.get("amount");
		this.shape = (String) desc.get("circle");
		
		shapes = new ArrayList<Paintable>();
		
		if("circle".equals(shape)) {
			int curSize = startSize;
			for(int i = 0; i < amount; i++) {
				// TODO figure out good way of setting the center
				Paintable p = new CircleShape(640,360,curSize);
				shapes.add(p);
				curSize += increment;
			}
		}
	}

}
