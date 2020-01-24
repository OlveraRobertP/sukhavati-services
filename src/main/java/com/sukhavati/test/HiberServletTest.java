package com.sukhavati.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sukhavati.layer.bo.SecurityBo;
import com.sukhavati.models.dao.User;
import com.sukhavati.models.dto.UserDto;
import com.sukhavati.rest.services.SecurityBoImpl;

/**
 * Servlet implementation class HiberServletTest
 */
@WebServlet("/HiberServletTest")
public class HiberServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiberServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		SecurityBo personBo = new SecurityBoImpl();
		UserDto p =  personBo.getUserByUserIdAndPassword("admin", "pass");
		response.getWriter().println(p.getUserid() + " " + p.getUserName());
	}

	

}
