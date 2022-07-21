package com.skillstorm.models;

public class Reason {
	private int reasonID;
	private String reasonName;
	private String reasonDescription;

	
	
	public Reason() {
		super();
	}

	public Reason(int reasonID, String reasonName, String reasonDescription) {
		super();
		this.reasonID = reasonID;
		this.reasonName = reasonName;
		this.reasonDescription = reasonDescription;
	}

	public int getReasonID() {
		return reasonID;
	}

	public void setReasonID(int reasonID) {
		this.reasonID = reasonID;
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	public String getReasonDescription() {
		return reasonDescription;
	}

	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}

	@Override
	public String toString() {
		return "Reason [reasonID=" + reasonID + ", reasonName=" + reasonName + ", reasonDescription="
				+ reasonDescription + "]";
	}





	/*
 	 Reason DB table structure:

    - Reason_ID
        - INT
        - Primary Key
        - Foreign Key with Expenses(Reason_ID)
    - Reason_Name
        - VARCHAR(45)
    - Reason_Description
        - VARCHAR(90)


	 * */
	
}
