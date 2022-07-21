package com.skillstorm.models;


import com.fasterxml.jackson.annotation.*;

public class Expenses {
	private int expensesID;
	private String name;
	private Reason reason;
	private float amount;
	private String notes;
	private Status status;
	
	public Expenses() {
		super();
	}

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Expenses(@JsonProperty("name") String name, @JsonProperty("reason") int reason, @JsonProperty("amount") float amount, @JsonProperty("notes") String notes) {
		super();
		this.name = name;
//		this.reason = new Reason(reason);
		this.amount = amount;
		this.notes = notes;
		this.status = new Status(1, "Pending");
	}

	public int getExpensesID() {
		return expensesID;
	}

	public void setExpensesID(int expensesID) {
		this.expensesID = expensesID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	Reason object

	public int getReasonID() { //gets reasonID from Reason object
		return reason.getReasonID();
	}

	public void setReason(int reasonID, String reasonName, String reasonDescription) { //initializes Reason object
		this.reason = new Reason(reasonID, reasonName, reasonDescription); 
	}

	public Reason getReason() {
		return reason;
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Status getStatus() {
		return status;
	}

	public int getStatusID() {
		return status.getStatusID();
	}
	
	public void setStatus(int statusID, String statusName) {
		this.status = new Status(statusID, statusName);
	}

	@Override
	public String toString() {
		return "Expenses [expensesID=" + expensesID + ", name=" + name + ", reason=" + reason + ", amount=" + amount
				+ ", notes=" + notes + ", status=" + status + "]";
	}

	



	/*
	 Expenses DB table structure:

	- expenses_ID 
        - INT
        - Primary Key
        - Auto Incremented
    - Name 
        - VARCHAR(45)
    - Reason_ID
        - INT
        - Foreign Key with Reason(reason_ID)
    - Amount
		- DECIMAL(6,2)
    - Notes
        - VARCHAR(100)
    - Status_ID
        - INT
        - Foreign Key with Status(status_ID)

	 * */
	
}
