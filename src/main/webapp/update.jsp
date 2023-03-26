<style>
     <%@ include file="assets/css/style.css" %>
     <%@ include file="assets/css/bootstrap.min.css"%>
     <%@ include file="assets/css/responsive.css" %>
     <%@ include file="assets/css/jquery.mCustomScrollbar.min.css" %>
</style>
<%@include file="include/header.jsp" %>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<form action="${pageContext.request.contextPath}/operation" method="post">
				Name: <input type="text" name="name" value="${param.name }" required="required" /><br />
				Age: <input type="number" name="age" value="${param.age }" required="required"/><br />
				Education: <input type="text" name="education" value="${param.education }" required="required" /><br />
				<input type="hidden" name="userId" value="${param.userId }" />
				<input type="hidden" name="form" value="updateUser" />
				<input class="btn-custom" type="submit" value="Update User" />
			</form>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp" %>