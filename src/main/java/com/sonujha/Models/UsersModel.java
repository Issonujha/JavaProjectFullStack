package com.sonujha.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sonujha.entity.User;

public class UsersModel {

	public List<User> ListUsers(DataSource dataSource) {
		// Step 1: Initialize connection object
		List<User> userList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = dataSource.getConnection();
			// Step 2: Create a SQL statement string
			String query = "SELECT * FROM family";
			stmt = connect.createStatement();
			// Step 3: Execute SQL Query
			rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while (rs.next()) {
				userList.add(
						new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("education")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public void addUser(DataSource dataSource, User newUser) {
//		Connection connect = null;
		PreparedStatement statement = null;
		Connection connect = null;
		String name = newUser.getName();
		int age = newUser.getAge();
		String education = newUser.getEducation();
		String query = "INSERT INTO FAMILY (name, age, education) VALUES (?, ?, ?)";
		try {
			connect = dataSource.getConnection();
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, education);
			System.out.println(statement.execute());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(DataSource dataSource, User updateUser) {
		PreparedStatement statement = null;
		int id = updateUser.getId();
		Connection connect = null;
		String name = updateUser.getName();
		int age = updateUser.getAge();
		String education = updateUser.getEducation();
		String query = "UPDATE family SET name=?, age=?, education=? WHERE id=?";
		try {
			connect = dataSource.getConnection();
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, education);
			statement.setInt(4, id);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(DataSource dataSource, int id) {
		PreparedStatement statement = null;
		Connection connect = null;
		String query = "delete from family WHERE id=?";
		try {
			connect = dataSource.getConnection();
			statement = connect.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
