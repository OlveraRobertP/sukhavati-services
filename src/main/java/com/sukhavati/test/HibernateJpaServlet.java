package com.sukhavati.test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sukhavati.models.dao.User;
/**
 * Servlet implementation class HibernateJpaServlet
 */
@WebServlet("/HibernateJpaServlet")
public class HibernateJpaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/plain");

		Map<String, String> properties = new HashMap();
		
		//properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url"));
		
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
//			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.GoogleDriver");
//			properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url"));
//		} else {
//			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//			properties.put("javax.persistence.jdbc.url", System.getProperty("cloudsql.url.dev"));
//		}

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demo");

		// Insert a few rows.
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(new Person(1,"Rob Olver"));
//		em.persist(new Person(2,"PaulPer"));
//		em.getTransaction().commit();
//		em.close();

		// List all the rows.
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> result = em.createQuery("FROM User", User.class).getResultList();
		for (User g : result) {
			res.getWriter().println(g.getUserId() + " " + g.getUserName());
		}
		em.getTransaction().commit();
		em.close();

	}
}
