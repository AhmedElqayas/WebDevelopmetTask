package org.qayas.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import org.qayas.exception.InputException;
import org.qayas.models.Repository;
import org.qayas.models.User;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int userId = 1;
       
    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		validateInput(firstName);
		validateInput(lastName);
		validateEmail(email);
		validatePhone(phone);
		
		User user = new User();
		user.setUserId(userId++);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhone(phone);
		
		Repository repository = new Repository();
		try {
			repository.saveUser(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("registration-done.jsp");
	}
	
	private void validateInput(String input) {
		if (input.equals(""))
			throw new InputException("Input cannot be empty!");
	}
	
	private void validateEmail(String email) {
		validateInput(email);
		
		if (!email.contains("@"))
			throw new InputException("Please use valid email!");
	}
	
	private void validatePhone(String phone) {
		validateInput(phone);
		
		if (phone.length() != 11)
			throw new InputException("Phone number should be 11 digits!");
	}

}
