package com.skillstorm.models;

public class Reason {
	private int reasonID;
	private String reasonName;
	private String reasonDescription;
	
	private String[] tran = {"Transportation", "Reimburse gas, hotel, and flight costs for business purposes"};
	private String[] supp = {"Supplies", "Reimburse stationary, technology, and other office supplies"};
	private String[] educ = {"Education", "Reimburse continued education costs, like seminars or certifications"};
	private String[] food = {"Food", "Reimburse shared food, like communal coffee or pastries, or office-wide luncheons"};
	private String[] othe = {"Other", "Reimburse expenses not otherwise specified"};
	
	
	public Reason() {
		super();
	}

	public Reason(int reasonID) {
		super();
		this.reasonID = reasonID;
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

	
	public void setReasonInfo(int reasonID) {
		String[] reasonInfo;
		switch (reasonID) { //assigns a string to the statusName instance variable, based on the statusID argument value
			case(1): {reasonInfo = tran; } break;
			case(2): {reasonInfo = supp; } break;
			case(3): {reasonInfo = educ; } break;
			case(4): {reasonInfo = food; } break;
			case(5): {reasonInfo = othe; } break;
			default: {reasonInfo = othe; this.reasonID = 5;} break;
		}
		this.reasonName = reasonInfo[0];
		this.reasonDescription = reasonInfo[1];
	}
	
	public void setReason(int reasonID) {
		setReasonID(reasonID);
		setReasonInfo(reasonID);
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
