package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.gazelle.models.fieldnames.TransactionEntryFieldNames;
import org.gazelle.repositories.TransactionEntryRepository;
import org.npc.dataaccess.model.BaseModel;

public class TransactionEntry extends BaseModel<TransactionEntry> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.price = rs.getFloat(TransactionEntryFieldNames.PRICE);
		this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
		this.createdon = rs.getTimestamp(TransactionEntryFieldNames.CREATED_ON).toLocalDateTime();
	}
	
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionEntryFieldNames.PRICE, this.price);
		record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
		
		record.put(TransactionEntryFieldNames.CREATED_ON, Timestamp.valueOf(this.createdon));
	
		return record;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
	public TransactionEntry setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(TransactionEntryFieldNames.PRICE);
		}
		return this;
	}
	
	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntry setQuantity(int quantity) {
		if (this.quantity != quantity) {
			this.quantity = quantity;
			this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
		}
		return this;
	}
	
	private LocalDateTime createdon;
	public LocalDateTime getCreatedOn() {
		return this.createdon;
	}
	public TransactionEntry setCreatedOn(LocalDateTime createdon){
		if (this.createdon != createdon){
			this.createdon = createdon;
			this.propertyChanged(TransactionEntryFieldNames.CREATED_ON);
		}
		return this;
	}
	
	private UUID record_id;
	public UUID getRecordID() {
		return this.record_id;
	}
	
	public TransactionEntry setRecordID(UUID record_id) {
		if (this.record_id != record_id) {
			this.record_id = record_id;
			this.propertyChanged(TransactionEntryFieldNames.RECORD_ID);
		}
		return this;
	}
	
	private UUID product_id;
	public UUID getProductID() {
		return this.product_id;
	}
	
	public TransactionEntry setProductID(UUID product_id) {
		if (this.product_id != product_id) {
			this.product_id = product_id;
			this.propertyChanged(TransactionEntryFieldNames.PRODUCT_ID);
		}
		return this;
	}
	
	private UUID transaction_id;
	public UUID getTransactionID() {
		return this.transaction_id;
	}
	
	public TransactionEntry setTransactionID(UUID transaction_id) {
		if (this.transaction_id != transaction_id) {
			this.transaction_id = transaction_id;
			this.propertyChanged(TransactionEntryFieldNames.TRANSACTION_ID);
		}
		return this;
	}
	
	public TransactionEntry() {
		super(new TransactionEntryRepository());
		this.record_id = new UUID(0, 0);
		this.price = 0;
		this.quantity = 0;
		this.createdon = LocalDateTime.now();
	}
}

