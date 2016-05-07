package net.qial.vj.util;

import java.util.Map;

public class PrintUtil {
	public static String toString(Map<?, ?> map) {
		if(map == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for(Object k : map.keySet()) {
			Object v = map.get(k);
			if(first) {
				first = false;
			} else {
				sb.append(",");
			}
			sb.append(k).append("=").append(v);
		}
		return sb.toString();
	}
}
