package com.skillstorm.servlets;

/**
 * @author froyo49
 * Controller that takes all incoming HTTP requests, and runs the applicable method based on the type of request 
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.ReimbursementDAO;
import com.skillstorm.models.Expenses;
import com.skillstorm.models.Reason;


@WebServlet(urlPatterns = "/*")
public class ReimbursementController extends HttpServlet{

	private static ReimbursementDAO dao = new ReimbursementDAO();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			ObjectMapper map = new ObjectMapper(); //initializes Jackson ObjectMapper object
			String path = req.getPathInfo();
			
			switch (path) {
			case "/table":
				Set<Expenses> expense = dao.findAll(); //retrieves expenses from DB
				resp.setContentType("application/json"); //tells client that the response will be JSON
				resp.getWriter().append(map.writeValueAsString(expense)); //adds expenses to response as JSON
				break;
			case "/form":
				Set<Reason> reason = dao.findReason(); //retrieves reasons from DB;
				resp.setContentType("application/json"); //tells client that the response will be JSON
				resp.getWriter().append(map.writeValueAsString(reason)); //adds reasons to response as JSON
				break;
			default:
				break;
			}

			
			
		} catch (SQLException|IOException e) {
			e.printStackTrace();
		}
		 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		InputStream requestBody = req.getInputStream(); //retrieves HTTP request body
		ObjectMapper objectMapper = new ObjectMapper(); //initializes Jackson ObjectMapper object
		Expenses expense = objectMapper.readValue(requestBody, Expenses.class); // takes InputStream, converts to Expenses object
		try {
			dao.create(expense); //passes Expenses object to create method in ReimbursementDAO
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setStatus(201); //indicates that the change was committed
		

		
//		this could be as short as one line
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody = req.getInputStream(); //retrieves HTTP request body
		ObjectMapper objectMapper = new ObjectMapper(); //initializes Jackson ObjectMapper object
		Expenses expense = objectMapper.readValue(requestBody, Expenses.class); // takes InputStream, converts to Expenses object
		try {
			dao.update(expense);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setStatus(201); //indicates that the change was committed

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream requestBody = req.getInputStream(); //retrieves HTTP request body
		ObjectMapper objectMapper = new ObjectMapper(); //initializes Jackson ObjectMapper object
		Expenses expense = objectMapper.readValue(requestBody, Expenses.class); // takes InputStream, converts to Expenses object
		try {
			dao.delete(expense);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setStatus(201); //indicates that the change was committed

	}
}
