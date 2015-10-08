package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.gazelle.enums.ProductItemType;
import org.gazelle.models.fieldnames.ProductFieldNames;
import org.gazelle.repositories.ProductRepository;
import org.npc.dataaccess.model.BaseModel;

public class Product extends BaseModel<Product> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {

		this.description = rs.getString(ProductFieldNames.DESCRIPTION);
		this.lookupCode = rs.getString(ProductFieldNames.LOOKUP_CODE);
		this.price = rs.getFloat(ProductFieldNames.PRICE);
		this.itemType = ProductLookupCode.map(rs.getInt(ProductFieldNames.ITEM_TYPE));
		this.cost = rs.getFloat(ProductFieldNames.CLASSIFICATION);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.reorderPoint = rs.getInt(ProductFieldNames.REORDER_POINT);
		this.restockLevel = rs.getInt(ProductFieldNames.RESTOCK_LEVEL);
		this.parentItem = rs.getInt(ProductFieldNames.PARENT_ITEM);//this is currently an int, but may need to be a foreign key
		this.extendedDescription = rs.getString(ProductFieldNames.EXTENDED_DESCRIPTION);
		this.msrp = rs.getFloat(ProductFieldNames.MSRP);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();

	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {

		record.put(ProductFieldNames.DESCRIPTION, this.description);
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.PRICE, this.price);
		record.put(ProductFieldNames.ITEM_TYPE, this.itemType);
		record.put(ProductFieldNames.CLASSIFICATION, this.classification);
		record.put(ProductFieldNames.QUANTITY, this.quantity);
		record.put(ProductFieldNames.REORDER_POINT, this.reorderPoint);
		record.put(ProductFieldNames.RESTOCK_LEVEL, this.restockLevel);
		record.put(ProductFieldNames.PARENT_ITEM, this.parentItem);
		record.put(ProductFieldNames.EXTENDED_DESCRIPTION, this.itemDescription);
		record.put(ProductFieldNames.MSRP, this.msrp);
		record.put(ProductFieldNames.CREATED_ON, this.createdOn);
				
		return record;
	}
	
	private String description;
	public String getDescription(){
		return this.description;
	}
	
	public Product setDescription(String description){
		if(!this.description.equals(description)){
			this.description = description;
			this.propertyChanged(ProductFieldNames.DESCRIPTION);
		}
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode(){
		return this.lookupCode;
	}
	
	public Product setLookupCode(String lookupCode){
		if(!this.lookupCode.equals(lookupCode)){
			this.lookupCode = lookupCode;
			this.propertyChanged(ProductFieldNames.LOOKUP_CODE);
		}
		return this;
	}
	
	private float price;
	public Float getPrice(){
		return this.price;
	}
	
	public Product setPrice(float price){
		if(this.price != price){
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		return this;
	}
	
	private ProductItemType itemType;
	public ProductItemType getItemType(){
		return this.itemType;
	}
	
	public Product setItemType(ProductItemType itemType){
		if(this.itemType != itemType){
			this.itemType = itemType;
			this.propertyChanged(ProductFieldNames.ITEM_TYPE);
		}
		return this;
	}
	
	private float cost;
	public int getCost(){
		return this.cost;
	}
	
	public float setCost(float cost){
		if(this.cost != cost){
			this.cost = cost;
			this.propertyChanged(ProductFieldNames.COST);
		}
		return this;
	}
	
	private int quantity;
	public int getQuantity(){
		return this.quantity;
	}
	
	public int setQuantity(int quantity){
		if(this.quantity != quantity){
			this.quantity = quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		return this;
	}
	
	private int reorderPoint;
	public int getReorderPoint(){
		return this.reorderPoint;
	}
	
	public int setReorderPoint(int reorderPoint){
		if(this.reorderPoint != reorderPoint){
			this.reorderPoint = reorderPoint;
			this.propertyChanged(ProductFieldNames.REORDER_POINT);
		}
		return this;
	}
	
	private int restockLevel;
	public int getRestockLevel(){
		return this.restockLevel;
	}
	
	public int setRestockLevel(int restockLevel){
		if(this.restockLevel != restockLevel){
			this.restockLevel = restockLevel;
			this.propertyChanged(ProductFieldNames.RESTOCK_LEVEL);
		}
		return this;
	}
	
	private int parentItem;
	public int getParentItem(){
		return this.parentItem;
	}
	
	public int setParentItem(int parentItem){
		if(this.parentItem != parentItem){
			this.parentItem = parentItem;
			this.propertyChanged(ProductFieldNames.PARENT_ITEM);
		}
		return this;
	}
	
	private String extendedDescription;
	public String getExtendedDescription(){
		return this.extendedDescription;
	}
	
	public String setExtendedDescription(String extendedDescription){
		if(!this.extendedDescription.equals(extendedDescription)){
			this.extendedDescription = extendedDescription;
			this.propertyChanged(ProductFieldNames.EXTENDED_DESCRIPTION);
		}
		return this;
	}
	
	private boolean active;
	public boolean getActive(){
		return this.active;
	}
	
	public boolean setActive(){
		if(this.active != active){
			this.active = active;
			this.propertyChanged(ProductFieldNames.ACTIVE);
		}
		return this;
	}
	
	private float msrp;
	public float getMsrp(){
		return this.msrp;
	}
	
	public float setMsrp(float msrp){
		if(this.msrp != msrp){
			this.msrp = msrp;
			this.propertyChanged(ProductFieldNames.MSRP);
		}
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn(){
		return this.createdOn;
	}
	
	public LocalDateTime setCreatedOn(LocalDateTime createdOn){
		if(this.createdOn != createdOn){
			this.createdOn = createdOn;
			this.propertyChanged(ProductFieldNames.CREATED_ON);
		}
		return this;
	}
	
	public Product() {
		super(new ProductRepository());
		
		this.description = StringUtils.EMPTY;
		this.lookupCode = StringUtils.EMPTY;
		this.price = 0;
		this.itemType = ProductItemType.NORMAL;
		this.cost = 0;
		this.quantity = 0;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		this.parentItem = StringUtils.EMPTY;
		this.extendedDescription = StringUtils.EMPTY;
		this.active = false;
		this.msrp = 0;
		this.createdOn = LocalDateTime.now();
	}
	
	//TODO: look into UUIDs for product table
	/*
	public Product (UUID id) {
		super(id, new ProductRepository());
		
		this.description = StringUtils.EMPTY;
		this.lookupCode = StringUtils.EMPTY;
		this.price = 0;
		this.itemType = ProductItemType.NORMAL;
		this.cost = 0;
		this.quantity = 0;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		this.parentItem = StringUtils.EMPTY;
		this.extendedDescription = StringUtils.EMPTY;
		this.active = false;
		this.msrp = 0;
		this.createdOn = LocalDateTime.now();
	}*/

}