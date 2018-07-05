<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>User List</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>

<c:url var="saveUrl" value="/role/add" />

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
		
			<div class="form-group">				
					   <a  href="<c:url value="/user.html"/>"> <strong> Manage User</strong> 
						</a>  |   <a  href="<c:url value="/role.html"/>"> <strong>Manage Role</strong>
						</a>			
			</div>
			
			<div class="form-group">
				<h1>User Management</h1>
				<a  href="<c:url value="/user/add.html"/>"> <strong>Add User</strong>
						</a>
			</div>
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> User List
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable">
							<thead>
								<tr>
									<th>FullName</th>
									<th>User Name</th>
									<th>Email</th>
									<th>Role</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>FullName</th>
									<th>User Name</th>
									<th>Email</th>
									<th>Role</th>
									<th>Actions</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="user" items="${users}" varStatus="loop">
									<tr>
										<td><a href="<c:url value="/user/${user.id}/edit.html"/>">${user.getFullName()}</a></td>
										<td>${user.getUsername()}</td>
										<td>${user.getEmail()}</td>
										<td><c:forEach var="role" items="${user.getRoles()}"
												varStatus="loop">
												<b> ${role.getName()} </b>
											</c:forEach></td>
										<td><a href="<c:url value="/user/${user.id}/edit.html"/>">Edit</a>
											| <a href="<c:url value="/user/${user.id}/password.html"/>">Reset
												Pasword</a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>