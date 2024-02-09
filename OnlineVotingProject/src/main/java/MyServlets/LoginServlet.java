package MyServlets;
import java.io.*;
import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean isAdmin = false;
        boolean isVoted = false;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Connect to MySQL database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "gurupreeth");

            // Check if the user exists and credentials match
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            
            if (rs.next()) {
            	
            	isAdmin = rs.getBoolean("isAdmin");
            
                HttpSession session = request.getSession();
                session.setAttribute("isAdmin", isAdmin);
                session.setAttribute("username", username);
                session.setAttribute("isVoted", isVoted);
               
                
            	if(isAdmin) {
            		response.sendRedirect("home_admin.jsp");
            	}
            	else {
            		response.sendRedirect("home.jsp");
            	}// Redirect to welcome page
            } else {
                // Authentication failed
                response.sendRedirect("login_register.jsp?error=invalid_credentials"); // Redirect to login page with error message
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}

	


