<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.sonujha.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
     <%@ include file="assets/css/style.css" %>
     <%@ include file="assets/css/bootstrap.min.css"%>
     <%@ include file="assets/css/responsive.css" %>
     <%@ include file="assets/css/jquery.mCustomScrollbar.min.css" %>
</style>
<%@ include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing Users</strong>
			<hr />
			<table border="1">
				<thead>
					<th> User Id </th>
					<th> Name </th>
					<th> Age </th>
					<th> Education </th>
					<th> Changes </th>
					
				</thead>
				
				<c:forEach items="${listUser }" var="user">
					
					<c:url var="updateURL" value="operation">
						<c:param name="page" value="update"></c:param>
						<c:param name="userId" value="${user.id }"></c:param>
						<c:param name="name" value="${user.name }"></c:param>
						<c:param name="age" value="${user.age }"></c:param>
						<c:param name="education" value="${user.education }"></c:param>
					</c:url>
					
					<c:url var="deleteURL" value="operation">
						<c:param name="page" value="delete"></c:param>
						<c:param name="userId" value="${user.id }"></c:param>
					</c:url>
					
					
					<tr>
						<td>${user.id }</td>
						<td>${user.name }</td>
						<td>${user.age }</td>
						<td>${user.education }</td>
						
						<td>
							<a href=${updateURL }>Update</a> | 
							<a href=${deleteURL } onclick="if(!confirm('Are you surely want to delete user?')) return false">Delete</a>
						</td>
					</tr>
				
				</c:forEach> 
				
				
				
				
				
			</table>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>