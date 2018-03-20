<%@page import="org.mcare.etl.entity.ActionEntity"%>
<%@page import="java.util.List"%>
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

<jsp:include page="/WEB-INF/views/header.jsp" />

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> <a href="/child.html">Child List</a> /
					${actionlist.size()} Pending Visits of ${child.getFirstName()}
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div id="dataTable_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered dataTable" id="dataTable"
										style="width: 100%;">
										<thead>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Visit Code</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">Start Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">Expiry Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">Alert Status</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<ActionEntity> actionlist = (List<ActionEntity>) session
														.getAttribute("actionlist");
												for (ActionEntity action : actionlist) {
											%>
											<tr class="even">
												<td><%=action.getProvider()%></td>
												<td><%=action.getVisitCode()%></td>
												<td><%=action.getStartDate()%></td>
												<td><%=action.getExpiryDate()%></td>
												<td><%=action.getAlertStatus()%></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>