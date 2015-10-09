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
		this.price = rs.getDouble(ProductFieldNames.PRICE);
		this.itemType = ProductItemType.map(rs.getInt(ProductFieldNames.ITEM_TYPE));
		this.cost = rs.getDouble(ProductFieldNames.COST);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.reorderPoint = rs.getInt(ProductFieldNames.REORDER_POINT);
		this.restockLevel = rs.getInt(ProductFieldNames.RESTOCK_LEVEL);
		this.parentItem = rs.getInt(ProductFieldNames.PARENT_ITEM);
		this.extendedDescription = rs.getString(ProductFieldNames.EXTENDED_DESCRIPTION);
		this.active = rs.getBoolean(ProductFieldNames.ACTIVE);
		this.msrp = rs.getDouble(ProductFieldNames.MSRP);
		this.createdOn = rs.getTimestamp(ProductFieldNames.CREATED_ON).toLocalDateTime();

	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {

		if (this.description != null){ 
			record.put(ProductFieldNames.DESCRIPTION, this.description);
		}
		record.put(ProductFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(ProductFieldNames.PRICE, this.price);
		record.put(ProductFieldNames.ITEM_TYPE, this.itemType.getValue());
		record.put(ProductFieldNames.COST, this.cost);
		record.put(ProductFieldNames.QUANTITY, this.quantity);
		record.put(ProductFieldNames.REORDER_POINT, this.reorderPoint);
		record.put(ProductFieldNames.RESTOCK_LEVEL, this.restockLevel);
		record.put(ProductFieldNames.PARENT_ITEM, this.parentItem);
		if (this.extendedDescription != null){ 
			record.put(ProductFieldNames.EXTENDED_DESCRIPTION, this.extendedDescription);
		}
		record.put(ProductFieldNames.ACTIVE, this.active);
		record.put(ProductFieldNames.MSRP, this.msrp);
		record.put(ProductFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
				
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
	
	private double price;
	public double getPrice(){
		return this.price;
	}
	
	public Product setPrice(double price){
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
	
	private double cost;
	public double getCost(){
		return this.cost;
	}
	
	public Product setCost(double cost){
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
	
	public Product setQuantity(int quantity){
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
	
	public Product setReorderPoint(int reorderPoint){
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
	
	public Product setRestockLevel(int restockLevel){
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
	
	public Product setParentItem(int parentItem){
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
	
	public Product setExtendedDescription(String extendedDescription){
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
	
	public Product setActive(boolean active){
		if(this.active != active){
			this.active = active;
			this.propertyChanged(ProductFieldNames.ACTIVE);
		}
		return this;
	}
	
	private double msrp;
	public double getMsrp(){
		return this.msrp;
	}
	
	public Product setMsrp(double msrp){
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
	
	public Product setCreatedOn(LocalDateTime createdOn){
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
		this.parentItem = 0;
		this.extendedDescription = StringUtils.EMPTY;
		this.active = false;
		this.msrp = 0;
		this.createdOn = LocalDateTime.now();
	}
	
	public Product(UUID id) {
		super(id, new ProductRepository());
		
		this.description = StringUtils.EMPTY;
		this.lookupCode = StringUtils.EMPTY;
		this.price = 0;
		this.itemType = ProductItemType.NORMAL;
		this.cost = 0.00;
		this.quantity = 0;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		this.parentItem = 0;
		this.extendedDescription = StringUtils.EMPTY;
		this.active = false;
		this.msrp = 0;
		this.createdOn = LocalDateTime.now();
	}

}