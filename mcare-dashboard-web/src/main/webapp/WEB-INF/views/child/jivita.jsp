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

<title>Child Details</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>
<c:url var="saveUrl" value="child/${id}/view.html" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/child.html">Child List</a>
				</li>
				<li class="breadcrumb-item active">Details of ${child.getJIVITAHHID()}</li>
			</ol>
			<div class="row">
				<div class="col-4">
					<p>Name : ${child.getFirstName()}</p>
				</div>
				<div class="col-4">
					<p>Birth Date : ${child.getBirthDate()}</p>
				</div>
				<div class="col-4">
					<p>Gender : ${child.getGender()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>caseId : ${child.getCaseId()}</p>
				</div>
				<div class="col-4">
					<p>Provider : ${child.getProvider()}</p>
				</div>
				<div class="col-4">
					<p>Start : ${child.getStart()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>End : ${child.getEnd()}</p>
				</div>
				<div class="col-4">
					<p>RegistrationDate : ${child.getRegistrationDate()}</p>
				</div>
				<div class="col-4">
					<p>Country : ${child.getCountry()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Division : ${child.getDivision()}</p>
				</div>
				<div class="col-4">
					<p>District : ${child.getDistrict()}</p>
				</div>
				<div class="col-4">
					<p>Upazila : ${child.getUpazila()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Union : ${child.getUnion()}</p>
				</div>
				<div class="col-4">
					<p>Ward : ${child.getWard()}</p>
				</div>
				<div class="col-4">
					<p>Subunit : ${child.getSubunit()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>MauzaPara : ${child.getMauzaPara()}</p>
				</div>
				<div class="col-4">
					<p>UserType : ${child.getUserType()}</p>
				</div>
				<div class="col-4">
					<p>CurrentFormStatus : ${child.getCurrentFormStatus()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>ReceivedTime : ${child.getReceivedTime()}</p>
				</div>
				<div class="col-4">
					<p>FWGOBHHID : ${child.getGOBHHID()}</p>
				</div>
				<div class="col-4">
					<p>FWNHHMBRNUM : ${child.getFWBNFCHILDNAME()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>FWNHHMWRA : ${child.getFWBNFCHILDNAME()}</p>
				</div>
				<div class="col-4">
					<p>ELCO : ${child.getFWWOMFNAME()}</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>