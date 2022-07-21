package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.skillstorm.models.Expenses;

public class ReimbursementDAO {
	
	private Connection connection;

	public ReimbursementDAO()  {
		try {
			String url = "jdbc:mysql://localhost:3306/reimbursement";
			String username = "root";
			String password = "12345678";
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			this.connection = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
	}
	 
	
	public Expenses create(Expenses expense) throws SQLException { //receives expenses object from doPost method in ReimbursementController
		String sql = "insert into Expenses(Name,Reason_ID,Amount,Notes,Status_ID) values (?,?,?,?,?)"; 	
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //initializes DB connection
		statement.setString(1, expense.getName());  //gets name   field from expense object
		statement.setInt(2, expense.getReason().getReasonID()); //gets reason id from reason object in expense object
		statement.setFloat(3, expense.getAmount()); //gets amount field from expense object
		statement.setString(4, expense.getNotes()); //gets notes  field from expense object
		statement.setInt(5, expense.getStatus().getStatusID()); //gets status id from status object in expense object
		statement.executeUpdate();
		
		ResultSet rs = statement.getGeneratedKeys();
		rs.next();
		int generatedId = rs.getInt(1);
		expense.setExpensesID(generatedId);
		return expense; 
	}
	
	public Set<Expenses> findAll() throws SQLException { 
		Set<Expenses> expenses = new LinkedHashSet<>(); 
		String sql = "SELECT Expenses_ID, Name, e.Reason_ID, Amount, Notes, e.Status_ID, s.Status_Name, r.Reason_Name, r.Reason_Description FROM Expenses e INNER JOIN Reason r ON e.Reason_ID = r.Reason_ID INNER JOIN Status s ON e.Status_ID = s.Status_ID ORDER BY Expenses_ID DESC";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql); 
		while (rs.next()) { 
			Expenses row = new Expenses();
			
//			 initializing variables with the fields from the DB output
			int expensesID = rs.getInt("Expenses_ID"); 
			String name    = rs.getString("Name"); 
			int reasonID   = rs.getInt("Reason_ID");
			float amount   = rs.getFloat("Amount");
			String notes   = rs.getString("Notes");
			int statusID   = rs.getInt("Status_ID");
			String statusName   = rs.getString("Status_Name");
			String reasonName   = rs.getString("Reason_Name");
			String reasonDescription   = rs.getString("Reason_Description");
			
//			stores values in the Java object
			row.setExpensesID(expensesID);  
			row.setName(name);
			row.setReason(reasonID, reasonName, reasonDescription);
			row.setAmount(amount);
			row.setNotes(notes);
			row.setStatus(statusID, statusName);
			
			expenses.add(row);
		}
		return expenses;
		
	}
	

	
	public boolean delete(int expensesID) throws SQLException { //deletes row with id in table
		String sql = "delete from Expenses where Expenses_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expensesID);
		return statement.executeUpdate() == 1;
	}
	
	public boolean update(Expenses expense) throws SQLException{ //updates value in table
		String sql = "update Expenses set Status_ID = ? where Expenses_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, expense.getStatus().getStatusID());
		statement.setInt(2, expense.getExpensesID());
		return statement.executeUpdate() == 1;
	}
}
