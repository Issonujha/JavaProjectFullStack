package com.sonujha.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sonujha.Models.UsersModel;
import com.sonujha.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/operation")

public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/MyDB")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {
		case "listuser":
			listUser(request, response);
			break;
		case "adduser":
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
			break;
		case "update":
			updateUser(request, response);
			break;
		case "delete":
			deleteUser(Integer.parseInt(request.getParameter("userId")));
			listUser(request, response);
			break;
		default:
			error(request, response);
			break;
		}
	}

	private void deleteUser(int Id) {
		new UsersModel().deleteUser(dataSource, Id);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "adduser": {
			addUser(request, response);
			listUser(request, response);
			break;
		}
		case "updateuser": {
			User updateUser = new User(Integer.parseInt(request.getParameter("userId")), request.getParameter("name"),
					Integer.parseInt(request.getParameter("age")), request.getParameter("education"));
			updateUser(dataSource, updateUser);
			listUser(request, response);
			break;
		}
		default:
			error(request, response);
			break;
		}
	}

	private void updateUser(DataSource dataSource, User updateUser) {
		new UsersModel().updateUser(dataSource, updateUser);
		return;
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update User");
		try {
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) {
		List<User> listUser = new ArrayList<>();
		listUser = new UsersModel().ListUsers(dataSource);
		request.setAttribute("listUser", listUser);
		try {
			request.getRequestDispatcher("listUsers.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		User newUser = new User(request.getParameter("name"), Integer.parseInt(request.getParameter("age")),
				request.getParameter("education"));
		new UsersModel().addUser(dataSource, newUser);
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

}
