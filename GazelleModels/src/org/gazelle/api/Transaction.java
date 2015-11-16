package org.gazelle.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.gazelle.enums.TransactionType;
import org.gazelle.enums.TransactionApiRequestStatus;

@XmlRootElement
public class Transaction{
	private UUID id;
	public UUID getId(){
		return this.id;
	}
	public Transaction setId(UUID id){
		this.id = id;
		return this;
	}
	
	private UUID cashierId;
	public float getCashierId(){
		return this.cashierId;
	}
	public Transaction setCashierId(float cashierId){
		this.cashierId = cashierId;
		return this;
	}
	
	private float amount;
	public float getAmount(){
		return this.amount;
	}
	public Transaction setAmount(float amount){
		this.amount = amount;
		return this;
	}
	
	private TransactionType transactionType;
	public TransactionType getTransactionType(){
		return this.transactionType;
	}
	public Transaction setTransactionType(TransactionType transactionType){
		this.transactionType = transactionType;
		return this;
	}
	
	private UUID parentId;
	public UUID getParentId(){
		return this.parentId;
	}
	public Transaction setParentId(UUID parentId){
		this.parentId = parentId;
		return this;
	}
	
	private LocalDateTime timeStamp;
	public LocalDateTime getTimeStamp(){
		return this.timeStamp;
	}
	public Transaction setTimeStamp(LocalDateTime timeStamp){
		this.timeStamp = timeStamp;
		return this;
	}

	private TransactionApiRequestStatus apiRequestStatus;
	public TransactionApiRequestStatus getApiRequestStatus(){
		return this.apiRequestStatus;
	}
	public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus){
		if (this.apiRequestStatus != apiRequestStatus){
			this.apiRequestStatus = apiRequestStatus;
		}
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage(){
		return this.apiRequestMessage;
	}
	public Transaction setApiRequestMessage(String apiRequestMessage){
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)){
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Transaction(){
		this.recordId = new UUID(0,0);
		this.cashierId = new UUID(0,0);
		this.amount = 0;
		this.transactionType = 0;
		this.parentId = new UUID(0,0);
		this.timeStamp = LocalDatetime.now();
	}
	
	public Transaction(org.gazelle.models.Transaction modelTransaction) {
		this.recordId = modelTransaction.getId();
		this.cashierId = modelTransaction.getCashierId();
		this.amount = modelTransaction.getAmount();
		this.transactionType = modelTransaction.getTransactionType();
		this.parentId = modelTransaction.getParentId();
		this.timeStamp = modelTransaction.getTimeStamp();
	
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}