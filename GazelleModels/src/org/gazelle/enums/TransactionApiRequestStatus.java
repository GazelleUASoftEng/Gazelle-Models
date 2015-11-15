package org.gazelle.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionApiRequestStatus{
	OK(0),
	INVALID_INPUT(1),
	INVALID_CASHIER_ID(2),
	INVALID_RECORD_ID(3),
	INVALID_TRANSACTION_PARENT_ID(4),		
	UNKNOWN_ERROR(5);
	
	public int getValue() {
		return value;
	}

	public static TransactionApiRequestStatus map(int key){
		if (valueMap == null) {
			valueMap = new HashMap<Integer, ProductApiRequestStatus>();

			for (TransactionApiRequestStatus status : TransactionApiRequestStatus.values()){
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionApiRequestStatus.UNKNOWN_ERROR);
	}
	
	private int value;

	private static Map<Integer, TransactionApiRequestStatus> valueMap = null;

	private TransactionApiRequestStatus(int value) {
		this.value = value;
	}
}