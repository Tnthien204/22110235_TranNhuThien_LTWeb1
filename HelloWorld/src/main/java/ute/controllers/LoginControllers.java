package ute.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})

public class LoginControllers extends HttpServlet {

	private static final long serialVersionUID = -848854439251622129L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		LoginModel bean = new LoginModel();
		bean.setName(name);
		bean.setPassword(password);
		req.setAttribute("bean", bean);
		boolean status = bean.validate();
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
			 rd.forward(req, resp);
		} else {
			 RequestDispatcher rd = req.getRequestDispatcher("login-error.jsp");
			 rd.forward(req, resp);
			 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}