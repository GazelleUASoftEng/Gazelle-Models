package org.gazelle.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.gazelle.enums.TransactionType;
import org.gazelle.enums.TransactionApiRequestStatus;

@XmlRootElement
public class Transaction{
	private String id;
	public String getId(){
		return this.id;
	}
	public Transaction setId(UUID id){
		this.id = id.toString();
		return this;
	}
	
	private String cashierId;
	public String getCashierId(){
		return this.cashierId;
	}
	public Transaction setCashierId(String cashierId){
		this.cashierId = cashierId;
		return this;
	}

	private double amount;
	public double getAmount(){
		return this.amount;
	}
	public Transaction setAmount(double amount){
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
	
	private String parentId;
	public String getParentId(){
		return this.parentId;
	}
	public Transaction setParentId(String parentId){
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
		this.cashierId = StringUtils.EMPTY;
		this.amount = 0;
		this.transactionType = TransactionType.UNKNOWN;
		this.parentId = StringUtils.EMPTY;
		this.timeStamp = LocalDateTime.now();
	}
	
	public Transaction(org.gazelle.models.Transaction modelTransaction) {
		this.id = modelTransaction.getId().toString();
		this.cashierId = modelTransaction.getCashierId().toString();
		this.amount = modelTransaction.getAmount();
		this.transactionType = modelTransaction.getTransactionType();
		if(modelTransaction.getParentId() == null){
			this.parentId = null;
		}
		else{
			this.parentId = modelTransaction.getParentId().toString();
		}
		this.timeStamp = modelTransaction.getTimeStamp();
	
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}
}