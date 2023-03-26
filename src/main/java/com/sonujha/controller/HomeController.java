package com.sonujha.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "home";
		if (request.getParameterNames().hasMoreElements()) {
			page = request.getParameter("page");
		}

		switch (page) {
		case "home":
			homepage(request, response);
			break;
		default:
			error(request, response);
			break;
		}
	}

	private void error(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void homepage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}