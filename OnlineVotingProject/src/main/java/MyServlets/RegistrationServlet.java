package MyServlets;
import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("username");
	        String password = request.getParameter("pword");
	        String dob = request.getParameter("dob");
	        
	        boolean isVoted=false;

	        Connection conn = null;
	        PreparedStatement stmt = null;
	        try {
	            // Connect to MySQL database
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "gurupreeth");

	            // Insert user data into users table
	            String sql = "INSERT INTO users (username, password, dob, isAdmin, isVoted) VALUES (?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmt.setString(3, dob);
	            stmt.setBoolean(4, false);
	            stmt.setBoolean(5, false);// Set isAdmin to false for normal users
	            stmt.executeUpdate();

	            
	            // Redirect to login page after successful registration
	            response.sendRedirect("home.jsp?registration=success");
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            // Redirect to registration page with error message
	            response.sendRedirect("login_register.jsp?error=" + e.getMessage());
	        } finally {
	            // Close resources
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            HttpSession session=request.getSession();
	            session.setAttribute("username",username);
	            session.setAttribute("isVoted", isVoted);
	            
	        }
	    }
	}


