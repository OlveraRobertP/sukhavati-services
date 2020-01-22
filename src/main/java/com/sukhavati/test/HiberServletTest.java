package com.sukhavati.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sukhavati.bo.PersonBo;
import com.sukhavati.bo.impl.PersonBoImpl;
import com.sukhavati.models.Person;

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
		PersonBo personBo = new PersonBoImpl();
		for (Person p :  personBo.findAll()) {
			response.getWriter().println(p.getId() + " " + p.getName());
		}
	}

	

}
