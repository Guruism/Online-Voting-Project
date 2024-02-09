package MyServlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class VotingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isAdmin=false;
        boolean isVoted=false;
        
		String username = (String) request.getSession().getAttribute("username");
        boolean isNota = request.getParameter("nota") != null;
        String partyVoted = isNota ? null : request.getParameter("voted");

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement userStmt = null;
        ResultSet userRs=null;
        try {
            // Connect to MySQL database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "gurupreeth");
            
            
            // Insert voting details into the database
            String sql = "INSERT INTO voting_details (username, isNota, partyVoted) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setBoolean(2, isNota);
            if (!isNota) {
                stmt.setString(3, partyVoted);
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }
            stmt.executeUpdate();
            
            String updateUserSql = "UPDATE users SET isVoted = ? WHERE username = ?";
            PreparedStatement updateUserStmt = conn.prepareStatement(updateUserSql);
            updateUserStmt.setBoolean(1, true);
            updateUserStmt.setString(2, username);
            updateUserStmt.executeUpdate();
            
            
            String userSql = "SELECT isAdmin,isVoted FROM users WHERE username = ?";
            userStmt = conn.prepareStatement(userSql);
            userStmt.setString(1, username);
            
            userRs = userStmt.executeQuery();
            
            
            
            if (userRs.next()) {
                // Get the value of isAdmin from the result set
                isAdmin = userRs.getBoolean("isAdmin");
                isVoted = userRs.getBoolean("isVoted");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
            	if (userRs != null) userRs.close();
                if (userStmt != null) userStmt.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("isAdmin", isAdmin);
        session.setAttribute("isVoted", isVoted);
        
        
        if(isVoted) {
        	if(isAdmin) {
        		response.sendRedirect("home_admin.jsp");
        	}else {
        		response.sendRedirect("home.jsp");
        	}
        }else {
        	response.sendRedirect("voting.jsp");
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Perform any necessary processing here
		boolean isVoted = getIsVotedFromDatabase(request.getSession().getAttribute("username").toString()); 
        
		HttpSession session = request.getSession();
        session.setAttribute("isVoted", isVoted);
        // Redirect based on the value of isVoted
        if (!isVoted) {
            // If isVoted is false, redirect to voting.jsp
            response.sendRedirect("voting.jsp");
        } else {
            // If isVoted is true, redirect to an error page
            response.sendRedirect("index.jsp");
        }
        }
        public boolean getIsVotedFromDatabase(String username) {
        	boolean isVoted = false;
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                // Connect to MySQL database
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "gurupreeth");

                // Check if the user exists and credentials match
                String sql = "SELECT isVoted FROM users WHERE username= ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                rs = stmt.executeQuery();
                
                // Checking if there are any results
                if (rs.next()) {
                    // Retrieving the value of is_voted
                    isVoted = rs.getBoolean("isVoted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any SQL errors here
            } finally {
                // Closing resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return isVoted;
        }
} 



