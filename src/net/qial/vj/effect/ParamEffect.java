package net.qial.vj.effect;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ParamEffect extends ProcessingEffect {
	ArrayList<String> paramNames = new ArrayList<String>();
	HashMap<String, Integer> params = new HashMap<String, Integer>();

	protected void addParam(String name, int initialValue) {
		paramNames.add(name);
		params.put(name, initialValue);
	}

	public void setParam(String name, int val) {
		params.put(name, val);
	}

	public int getParam(String name) {
		// this was originally casting float to int
		// I've changed the map to only use ints
		return params.get(name);
	}

	public void handleKey() {
		println("gotkey " + key());
		switch (key()) {
		case 'q':
			incParam(0);
			break;
		case 'Q':
			incParamAmt(0);
			break;
		case 'a':
			decParam(0);
			break;
		case 'A':
			decParamAmt(0);
			break;
		case 'w':
			incParam(1);
			break;
		case 'W':
			incParamAmt(1);
			break;
		case 's':
			decParam(1);
			break;
		case 'S':
			decParamAmt(1);
			break;
		case 'e':
			incParam(2);
			break;
		case 'E':
			incParamAmt(2);
			break;
		case 'd':
			decParam(2);
			break;
		case 'D':
			decParamAmt(2);
			break;
		case 'r':
			incParam(3);
			break;
		case 'R':
			incParamAmt(3);
			break;
		case 'f':
			decParam(3);
			break;
		case 'F':
			decParamAmt(3);
			break;
		case 't':
			incParam(4);
			break;
		case 'T':
			incParamAmt(4);
			break;
		case 'g':
			decParam(4);
			break;
		case 'G':
			decParamAmt(4);
			break;
		case 'y':
			incParam(5);
			break;
		case 'Y':
			incParamAmt(5);
			break;
		case 'h':
			decParam(5);
			break;
		case 'H':
			decParamAmt(5);
			break;
		}
	}

	private void incParam(int num) {
		if (num >= paramNames.size())
			return;
		println("incParam: " + num);
		String param = (String) paramNames.get(num);
		int v = (int) params.get(param);
		v += 1;
		message(param + " = " + v);
		params.put(param, v);
	}

	private void decParam(int num) {
		if (num >= paramNames.size())
			return;
		println("decParam: " + num);
		String param = (String) paramNames.get(num);
		int v = (int) params.get(param);
		v -= 1;
		message(param + " = " + v);
		params.put(param, v);
	}

	private void incParamAmt(int num) {
		if (num >= paramNames.size())
			return;
		println("incParamAmt: " + num);
		// TODO make this change amount instead of just +5
		String param = (String) paramNames.get(num);
		int v = (int) params.get(param);
		v += 15;
		message(param + " = " + v);
		params.put(param, v);
	}

	private void decParamAmt(int num) {
		println("decParamAmt: " + num);
		if (num >= paramNames.size())
			return;
		// TODO make this change amount instead of just +5
		String param = (String) paramNames.get(num);
		int v = (int) params.get(param);
		v -= 15;
		message(param + " = " + v);
		params.put(param, v);
	}
}