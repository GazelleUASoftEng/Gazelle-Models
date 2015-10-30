package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import org.gazelle.enums.EmployeeClassification;
import org.gazelle.enums.Paytype;
import org.gazelle.models.fieldnames.EmployeeFieldNames;
import org.gazelle.models.fieldnames.ProductFieldNames;
import org.gazelle.models.fieldnames.TenderEntryFieldNames;
import org.gazelle.models.fieldnames.TransactionFieldNames;
import org.gazelle.repositories.TenderEntryRepository;
import org.npc.dataaccess.model.BaseModel;
import java.util.UUID;


public class TenderEntry extends BaseModel<TenderEntry> {

	private UUID record_id;
	private double amount;
	private Paytype paytype;
	private LocalDateTime time;
	private UUID transactionid;
	
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {

		this.record_id = (UUID)rs.getObject(TenderEntryFieldNames.record_id); // make
		this.amount = rs.getDouble(TenderEntryFieldNames.amount);		// make
//		this.paytype = rs.getFloat(TenderEntryFieldNames.paytype);		// make
		this.paytype = Paytype.map(rs.getInt(TenderEntryFieldNames.paytype));
		this.time = rs.getTimestamp(TenderEntryFieldNames.time).toLocalDateTime();
//		this.time = rs.getFloat(TenderEntryFieldNames.time);			// make
		this.transactionid = (UUID)rs.getObject(TenderEntryFieldNames.transactionid);
//		this.transactionid = rs.getFloat(TenderEntryFieldNames.transactionid);	// make

	}
	
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TenderEntryFieldNames.paytype, this.paytype);
		record.put(TenderEntryFieldNames.amount, this.amount);
		record.put(TenderEntryFieldNames.record_id, this.record_id);
		record.put(TenderEntryFieldNames.time, this.time);
		record.put(TenderEntryFieldNames.transactionid, this.transactionid);
	
		return record;
	}
	
	public UUID getRecID(){
		return this.record_id;
	}

	public double getAmount(){
		return this.amount;
	}
		
	public LocalDateTime getTime() {
		return this.time;  
	}

	public Paytype getPaytype(){
		return this.paytype;
	}

	public UUID getTransID(){
		return this.transactionid;
	}

	public TenderEntry setRecID(UUID input){
		if(this.record_id != input)
		{
			this.record_id = input;
			this.propertyChanged(TenderEntryFieldNames.record_id);
		}
		return this;
	}

	public TenderEntry setAmount(double input){
		if(this.amount != input)
		{
			this.amount = input;
			this.propertyChanged(TenderEntryFieldNames.amount);
		}
		return this;
	}
	public TenderEntry setTime(LocalDateTime input){
		if(this.time != input)
		{
			this.time = input;
			this.propertyChanged(TenderEntryFieldNames.time);
		}
		return this;
	}
	public TenderEntry setPaytype(Paytype input){
		if(this.paytype != input)
		{
			this.paytype = input;
			this.propertyChanged(TenderEntryFieldNames.paytype);
		}
		return this;
	}
	public TenderEntry setTransID(UUID input){
		if(this.transactionid != input)
		{
			this.transactionid = input;
			this.propertyChanged(TenderEntryFieldNames.transactionid);
		}
		return this;
	}

	public TenderEntry() {
		super(new TenderEntryRepository());
		this.record_id = new UUID (0, 0);
		this.amount = 0.0;
		this.time = LocalDateTime.now();
		this.paytype = null;
		this.transactionid = new UUID (0, 0);
	}

}