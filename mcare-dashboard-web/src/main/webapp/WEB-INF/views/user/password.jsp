<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="org.mcare.common.util.CheckboxHelperUtil"%>

<%@page import="java.util.List"%>
<%@page import="org.mcare.acl.entity.Role"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Add user information</title>

<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
</head>

<body>
	<c:url var="saveUrl" value="/user/${id}/password.html" />
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/"/>">mCare2
					Dashboard</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/"/>">Home</a></li>
				<li><a href="<c:url value="/export"/>">CSV Export</a></li>
				<li><a href="<c:url value="/logout"/>">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form:form method="POST" action="${saveUrl}" modelAttribute="account">
					<div class="form-group form-group-lg">
                      <label class="col-sm-2 control-label">Password</label>
                      <div class="col-sm-10">
                       <form:password path="password" required="required"/>
                      
                      </div>
                     </div>
                     <div class="form-group form-group-lg">
                      <label class="col-sm-2 control-label">Re-type Password</label>
                      <div class="col-sm-10">
                       <form:password path="retypePassword" required="required" />
                      </div>
                                        ${passwordNotMatch}
                     </div>
						
    				 <form:hidden path="username"/>
                     <form:hidden path="id"  />
                     <form:hidden path="firstName" />
    				 <form:hidden path="lastName" />
    				 <form:hidden path="email" />
							
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" value="Edit" />
						</div>
					</div>
     
                  
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>