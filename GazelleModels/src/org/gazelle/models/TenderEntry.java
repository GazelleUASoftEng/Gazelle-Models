package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import org.gazelle.models.fieldnames.TenderEntryFieldNames;
import org.gazelle.repositories.TenderEntryRepository;
import org.npc.dataaccess.model.BaseModel;

public class TenderEntry extends BaseModel<TenderEntry> {

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.price = rs.getFloat(TenderEntryFieldNames.PRICE);
		this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
		this.createdon = rs.getTimestamp(TransactionEntryFieldNames.CREATED_ON).toLocalDateTime();

		this.recordid = rs.getFloat(TenderEntryFieldNames.recordid);
		this.amount = rs.getFloat(TenderEntryFieldNames.amount);
		this.price = rs.getFloat(TenderEntryFieldNames.paytype);
		this.price = rs.getFloat(TenderEntryFieldNames.time);
		this.price = rs.getFloat(TenderEntryFieldNames.transactionid);

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
	public TenderEntry setPrice(double price) {
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
	
	public TenderEntry setQuantity(int quantity) {
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
	public TenderEntry setCreatedOn(LocalDateTime createdon){
		if (this.createdon != createdon){
			this.createdon = createdon;
			this.propertyChanged(TransactionEntryFieldNames.CREATED_ON);
		}
		return this;
	}
	
	public TenderEntry() {
		super(new TenderEntry());
		this.price = 0;
		this.quantity = 0;
		this.time = LocalDateTime.now();
	}
}

