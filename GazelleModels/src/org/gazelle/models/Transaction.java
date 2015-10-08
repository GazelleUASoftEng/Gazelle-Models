package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.gazelle.enums.TransactionType;
import org.gazelle.models.fieldnames.TransactionFieldNames;
import org.gazelle.repositories.TransactionRepository;
import org.npc.dataaccess.model.BaseModel;

public class Transaction extends BaseModel<Transaction>{
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.cashierId = (UUID)rs.getObject(TransactionFieldNames.CASHIER_ID);
		
		this.amount = rs.getDouble(TransactionFieldNames.AMOUNT);
		this.type = TransactionType.map(rs.getInt(TransactionFieldNames.TYPE));
		
		Object parentId = rs.getObject(TransactionFieldNames.PARENT_ID);
		this.parentId = ((parentId != null) ? ((UUID) parentId) : (new UUID(0, 0)));
		
		this.timeStamp = rs.getTimestamp(TransactionFieldNames.TIME_STAMP).toLocalDateTime();
	}
	
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.CASHIER_ID, this.cashierId);
		record.put(TransactionFieldNames.AMOUNT, this.amount);
		record.put(TransactionFieldNames.TYPE, this.type.getValue());
		
		if (this.parentId != null) {
			record.put(TransactionFieldNames.PARENT_ID, this.parentId);
		}
		
		record.put(TransactionFieldNames.TIME_STAMP, Timestamp.valueOf(this.timeStamp));
	
		return record;
	}
	
	private LocalDateTime timeStamp;
	public LocalDateTime getTimeStamp() {
		return this.timeStamp;
	}
	
	private UUID parentId;
	public UUID getParentId() {
		return this.parentId;
	}
	
	public Transaction setParentId(UUID parentId) {
		if (!this.parentId.equals(parentId)) {
			this.parentId = parentId;
			this.propertyChanged(TransactionFieldNames.PARENT_ID);
		}
		
		return this;
	}
	
	private TransactionType type;
	public TransactionType getType() {
		return this.type;
	}
	public Transaction setType(TransactionType type) {
		if(this.type != type){
			this.type = type;
			this.propertyChanged(TransactionFieldNames.TYPE);
		}
		
		return this;
	}
	
	private double amount;
	public double getAmount() {
		return this.amount;
	}
	public Transaction setAmount(double amount) {
		if(this.amount != amount){
			this.amount = amount;
			this.propertyChanged(TransactionFieldNames.AMOUNT);
		}
		
		return this;
	}
	
	private UUID cashierId;
	public UUID getCashierId() {
		return this.cashierId;
	}
	public Transaction setCashierId(UUID cashierId) {
		if (!this.cashierId.equals(cashierId)) {
			this.cashierId = cashierId;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		
		return this;
	}
	
	public Transaction() {
		super (new TransactionRepository());
		
		this.cashierId = new UUID (0, 0);
		this.amount = 0.00;
		this.type = TransactionType.UNKNOWN;
		this.parentId = new UUID (0, 0);
		this.timeStamp = LocalDateTime.now();
		
	}
	
	public Transaction (UUID id) {
		super(id, new TransactionRepository());
		
		this.cashierId = new UUID (0, 0);
		this.amount = 0.00;
		this.type = TransactionType.UNKNOWN;
		this.parentId = new UUID (0, 0);
		this.timeStamp = LocalDateTime.now();
	}
}
