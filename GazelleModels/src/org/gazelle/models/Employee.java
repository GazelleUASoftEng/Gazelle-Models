package org.gazelle.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.gazelle.enums.EmployeeClassification;
import org.gazelle.models.fieldnames.EmployeeFieldNames;
import org.gazelle.repositories.EmployeeRepository;
import org.npc.dataaccess.model.BaseModel;

public class Employee extends BaseModel<Employee> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.firstName = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.lastName = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.employeeId = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);  //TODO: Dr. P --> See my comment on the field declaration.
		this.active = rs.getBoolean(EmployeeFieldNames.ACTIVE);
		this.classification = EmployeeClassification.map(rs.getInt(EmployeeFieldNames.CLASSIFICATION));

		Object managerId = rs.getObject(EmployeeFieldNames.MANAGER);
		this.managerId = ((managerId != null) ? ((UUID) managerId) : (new UUID(0, 0)));

		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.timeStamp = rs.getTimestamp(EmployeeFieldNames.TIME_STAMP).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.firstName);
		record.put(EmployeeFieldNames.LAST_NAME, this.lastName);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeId);  //TODO: Dr. P --> See my comment on the field declaration.
		record.put(EmployeeFieldNames.ACTIVE, this.active);
		record.put(EmployeeFieldNames.CLASSIFICATION, this.classification.getValue());

		if (this.managerId != null) {
			record.put(EmployeeFieldNames.MANAGER, this.managerId);
		}

		record.put(EmployeeFieldNames.PASSWORD, this.password);  //TODO: Dr. P --> You had an extra closing parenthesis.
		record.put(EmployeeFieldNames.TIME_STAMP, Timestamp.valueOf(this.timeStamp));
				
		return record;
	}

	private LocalDateTime timeStamp;
	public LocalDateTime getTimeStamp() {
		return this.timeStamp;  
	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		if(!StringUtils.equals(this.password, password)) {  
			this.password = password;  
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}

		return this;
	}

	private UUID managerId;
	public UUID getManagerId() {
		return this.managerId;
	}
	public Employee setManagerId(UUID managerId) {
		if (!this.managerId.equals(managerId)) {
			this.managerId = managerId;
			this.propertyChanged(EmployeeFieldNames.MANAGER);
		}
		
		return this;
	}

	private EmployeeClassification classification;
	public EmployeeClassification getClassification() {
		return this.classification;
	}
	public Employee setClassification(EmployeeClassification classification) {
		if(this.classification != classification) {
			this.classification = classification;  
			this.propertyChanged(EmployeeFieldNames.CLASSIFICATION);
		}

		return this;
	}

	private boolean active;
	public boolean getActive() {
		return this.active;
	}
	public Employee setActive(boolean active) {
		if(this.active != active){
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}

		return this;
	}

	private String employeeId;
	public String getEmployeeId() {
		return this.employeeId;
	}
	public Employee setEmployeeId(String employeeId){
		if (!StringUtils.equals(this.employeeId, employeeId)) {
			this.employeeId = employeeId;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}

		return this;
	}

	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(String lastName) {
		if(!StringUtils.equals(this.lastName, lastName)) {
			this.lastName = lastName;  
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}

		return this;
	}

	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(String firstName) {
		if(!StringUtils.equals(this.firstName, firstName)) {
			this.firstName = firstName;  
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}

		return this;
	}

	//TODO: Dr. P --> We haven't yet defined "api.Employee", therefore this code should be removed for the time being.
//	public org.npc.testmodel.api.Employee synchronize(org.npc.testmodel.api.Employee apiEmployee) {
//		this.setCount(apiEmployee.getCount());
//		this.setLookupCode(apiEmployee.getLookupCode());
//		
//		apiEmployee.setCreatedOn(this.createdOn);
//		
//		return apiEmployee;
//	}
	
	public Employee() {
		super(new EmployeeRepository());
		
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
		this.active = false;
		this.classification = EmployeeClassification.UNKNOWN;
		this.managerId = new UUID(0, 0);
		this.password = StringUtils.EMPTY;
		this.timeStamp = LocalDateTime.now();
	}
	
	public Employee(UUID id) {
		super(id, new EmployeeRepository());
		
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.employeeId = StringUtils.EMPTY;
		this.active = false;
		this.classification = EmployeeClassification.UNKNOWN;
		this.managerId = new UUID(0, 0);
		this.password = StringUtils.EMPTY;
		this.timeStamp = LocalDateTime.now();
	}

	//TODO: Dr. P --> We haven't yet defined "api.Employee", therefore this code should be removed for the time being.
//	public Employee(org.npc.testmodel.api.Employee apiProduct) {
//		super(apiProduct.getId(), new ProductRepository());
//		
//		this.count = apiProduct.getCount();
//		this.lookupCode = apiProduct.getLookupCode();
//
//		this.createdOn = LocalDateTime.now();
//	}
}