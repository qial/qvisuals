package net.qial.vj.effect.api;

import java.util.HashMap;

import net.qial.vj.util.PrintUtil;

/**
 * Defines information about a sequencer for an effect.
 * 
 * @author kw
 *
 */
public class SequencerDescription extends Description {
	public SequencerDescription() {
		super(DescriptionClass.SEQUENCER);
	}
	
	// the "type" key defines the sequencer class used
	private String type;
	
	private Integer bpm;
	
	private boolean positive;
	
	// TODO: Add methods to create sequencer from the description
	// (not sure if they should be in this class)
	
	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}
	
	public Integer getBpm() {
		return bpm;
	}
	
	public void setPositive(boolean positive) {
		this.positive = positive;
	}
	
	public boolean getPositive() {
		return positive;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("SequencerDescription{");
		if(getLabel() != null) {
			sb.append("label=").append(getLabel()).append(",");
		}
		sb.append("type=").append(type);
		sb.append(",bpm=").append(bpm);
		sb.append(",positive=").append(positive);
		sb.append("}");
		return sb.toString();
	}
}
