package net.qial.vj.shape;

public abstract class AbstractMover implements Mover {
	private String param;

	@Override
	public String getParam() {
		return param;
	}

	@Override
	public void setParam(String paramName) {
		this.param = paramName;
	}

}
