package org.gazelle.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionEntryApiRequestStatus{
	OK(0),
	INVALID_INPUT(1),
	INVALID_RECORD_ID(2),
	INVALID_TRANSACTION_ID(3),		
	UNKNOWN_ERROR(4);
	
	public int getValue() {
		return value;
	}

	public static TransactionEntryApiRequestStatus map(int key){
		if (valueMap == null) {
			valueMap = new HashMap<Integer, ProductApiRequestStatus>();

			for (TransactionEntryApiRequestStatus status : TransactionEntryApiRequestStatus.values()){
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionEntryApiRequestStatus.UNKNOWN_ERROR);
	}
	
	private int value;

	private static Map<Integer, TransactionEntryApiRequestStatus> valueMap = null;

	private TransactionEntryApiRequestStatus(int value) {
		this.value = value;
	}
}