package com.skillstorm.models;

public class Status {
	private int statusID;
	private String statusName;
	

	
	public Status() {
		super();
	}

	public Status(int statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
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
