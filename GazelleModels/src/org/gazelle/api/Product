package org.gazelle.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.gazelle.enums.ProductApiRequestStatus;
import org.gazelle.enums.ProductItemType;
import org.gazelle.models.fieldnames.ProductFieldNames;

@XmlRootElement
public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	private String description;
	public String getDescription(){
		return this.description;
	}
	
	
	
	private String lookupCode;
	public String getLookupCode(){
		return this.lookupCode;
	}
	
	
	private double price;
	public double getPrice(){
		return this.price;
	}
	
	
	
	private ProductItemType itemType;
	public ProductItemType getItemType(){
		return this.itemType;
	}
	
	
	
	private double cost;
	public double getCost(){
		return this.cost;
	}
	
	
	
	private int quantity;
	public int getQuantity(){
		return this.quantity;
	}
	
	
	
	private int reorderPoint;
	public int getReorderPoint(){
		return this.reorderPoint;
	}
	
	
	
	private int restockLevel;
	public int getRestockLevel(){
		return this.restockLevel;
	}
	
	
	private int parentItem;
	public int getParentItem(){
		return this.parentItem;
	}
	
	
	private String extendedDescription;
	public String getExtendedDescription(){
		return this.extendedDescription;
	}
	
	
	
	private boolean active;
	public boolean getActive(){
		return this.active;
	}
	
	
	
	private double msrp;
	public double getMsrp(){
		return this.msrp;
	}
	
	
	
	
	
	private int count;
	public int getCount() {
		return this.count;
	}
	public Product setCount(int count) {
		this.count = count;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Product setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private ProductApiRequestStatus apiRequestStatus;
	public ProductApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Product setApiRequestStatus(ProductApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Product setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Product() {
		this.description = StringUtils.EMPTY;
		this.lookupCode = StringUtils.EMPTY;
		this.price = 0;
		this.itemType = ProductItemType.NORMAL;
		this.cost = 0;
		this.quantity = 0;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		this.parentItem = 0;
		this.extendedDescription = StringUtils.EMPTY;
		this.active = false;
		this.msrp = 0;
		this.createdOn = LocalDateTime.now();
	}
	
	public Product(org.gazelle.models.Product modelProduct) {
		this.id = modelProduct.getId();
		//this.count = modelProduct.getCount(); not sure if this is necessary
		this.createdOn = modelProduct.getCreatedOn();
		this.lookupCode = modelProduct.getLookupCode();
		this.description = modelProduct.getDescription();
		this.active = modelProduct.getActive();
		this.cost = modelProduct.getCost();
		this.extendedDescription = modelProduct.getExtendedDescription();
		this.id = modelProduct.getId();
		this.itemType = modelProduct.getItemType();
		this.msrp = modelProduct.getMsrp();
		this.price = modelProduct.getPrice();
		this.quantity= modelProduct.getQuantity();
		this.reorderPoint = modelProduct.getQuantity();
		this.restockLevel = modelProduct.getRestockLevel();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}
