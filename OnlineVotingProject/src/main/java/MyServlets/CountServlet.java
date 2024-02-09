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


public class CountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "gurupreeth");
      
            stmt = conn.createStatement();
            String sqlBJP = "SELECT COUNT(*) AS totalBJP FROM voting.voting_details WHERE partyVoted = 'BJP'";
            ResultSet rsBJP = stmt.executeQuery(sqlBJP);
            int countBJP = 0;
            if (rsBJP.next()) {
                countBJP = rsBJP.getInt("totalBJP");
            }
            
            String sqlAAP = "SELECT COUNT(*) AS totalAAP FROM voting.voting_details WHERE partyVoted= 'AAP'";
            ResultSet rsAAP = stmt.executeQuery(sqlAAP);
            int countAAP = 0;
            if (rsAAP.next()) {
                countAAP = rsAAP.getInt("totalAAP");
            }
            
            String sqlCONG = "SELECT COUNT(*) AS totalCONG FROM voting.voting_details WHERE partyVoted = 'CONG'";
            ResultSet rsCONG = stmt.executeQuery(sqlCONG);
            int countCONG = 0;
            if (rsCONG.next()) {
                countCONG = rsCONG.getInt("totalCONG");
            }

            HttpSession session = request.getSession();
            session.setAttribute("countBJP", countBJP);
            session.setAttribute("countCONG", countCONG);
            session.setAttribute("countAAP", countAAP);
            
            rsBJP.close();
            rsAAP.close();
            rsCONG.close();
            stmt.close();
            conn.close();
            
            response.sendRedirect("results.jsp");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}

