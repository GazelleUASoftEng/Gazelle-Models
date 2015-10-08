package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
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
		record.put(TransactionEntryFieldNames.QUANIITY, this.quantity);
		
		record.put(TransactionEntryFieldNames.CREATED_ON, Timestamp.valueOf(this.createdon));
	
		return record;
	}
	
	private float price;
	public float getPrice() {
		return this.price;
	}
	public TransactionEntry setPrice(float price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(TransactionEntryFieldNames.PRICE);
		}
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
	}
	
	private LocalDateTime createdon;
	public LocalDateTime getCreatedOn() {
		return this.createdon;
	}
	public TransactionEntry setCreatedOn(LocalDateTime createdOn){
		if (this.createdOn != createdOn){
			this.createdOn = createdOn;
			this.propertyChanged(TransactionEntryFieldNames.CREATED_ON);
		}
		return this;
	}
	
	public TransactionEntry() {
		super(new TransactionEntryRepository());
		this.price = 0;
		this.quantity = 0;
		this.createdOn = LocalDateTime.now();
	}
}

