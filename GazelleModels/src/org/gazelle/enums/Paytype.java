package org.gazelle.enums;

import java.util.HashMap;
import java.util.Map;

public enum Paytype {
	CASH(0), GIFT(1), MASTERCARD(2), VISA(3), DISCOVER(4), AMEX(5), DEBIT(6), UNKNOWN(7);

	private int value;
	private Paytype(int value) {
		this.value = value;
	}
	
	private static Map<Integer, Paytype> valueMap = null;

	public int getValue() {
		return value;
	}
	
	public static Paytype map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, Paytype>();

			for (Paytype status : Paytype.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : Paytype.UNKNOWN);
	}

}
