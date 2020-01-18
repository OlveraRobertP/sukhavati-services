package com.sukhavati.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConn
 */
@WebServlet("/TestConn")
public class TestConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConn() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection conn;

    final String getUserId = "SELECT id, name FROM person";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    	resp.getWriter().println("////////TestConsxaXZssn.......");
    	
    	String url = System.getProperty("cloudsqldev");
    	//String url = System.getProperty("cloudsql");
      // Find the user ID from the full name
      try (Connection conn = DriverManager.getConnection(url);ResultSet rs = conn.prepareStatement(getUserId).executeQuery()) {
        while (rs.next()) {
        	resp.getWriter().println(rs.getInt("id")+" - "+rs.getString("name"));
        }


      } catch (SQLException e) {
    	  resp.getWriter().println(e.getMessage());
    	  e.printStackTrace();
      }
    }

}
