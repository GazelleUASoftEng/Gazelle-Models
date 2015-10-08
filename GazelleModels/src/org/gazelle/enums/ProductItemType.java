package org.gazelle.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductItemType {
	NORMAL(0),
	SERIALIZED(1),
	MATRIX(2);
	
	private int value;
	public int getValue() {
		return value;
	}

	private ProductItemType(int value) {
		this.value = value;
	}
	
	private static Map<Integer, ProductItemType> valueMap = null;

	public static ProductItemType map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, ProductItemType>();

			for (ProductItemType status : ProductItemType.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : ProductItemType.NORMAL);
	}
}
