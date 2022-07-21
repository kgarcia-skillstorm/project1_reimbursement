package com.skillstorm.models;

public class Status {
	private int statusID;
	private String statusName;
	
	private String pending = "Pending";
	private String approved = "Approved";
	private String denied = "Denied";
	

	
	public Status() {
		super();
	}

	public Status(int statusID) {
		super();
		this.statusID = statusID;
		this.statusName = pending;
	}
	


	public int getStatusID() {
		return statusID;
	}


	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setStatusName(int statusID) {
		String statName;
		switch (statusID) { //assigns a string to the statusName instance variable, based on the statusID argument value
			case(1): {statName = pending;} break;
			case(2): {statName = approved; } break;
			case(3): {statName = denied; } break;
			default: {statName = pending; this.statusID = 1;} break;
		}
		this.statusName = statName;
	}
	
	public void setStatus(int statusID) { //receives statusID from the setStatusID method in Expenses.java, which is called by row.setStatusID(statusID) in DAO, which is called by doGet in Controller
		setStatusID(statusID);   //calls method to set statusID instance variable equal to the statusID argument passed
		setStatusName(statusID); //calls method to set statusName instances variable equal to the appropriate string
	}
	
	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", statusName=" + statusName + "]";
	}





	/*
	 Status DB table structure:
	   
    - Status_ID
        - INT 
        - Primary Key
        - Foreign Key with Expenses(Status_ID)
    - Status_Name
        - VARCHAR(45)
	 * */
	
}
