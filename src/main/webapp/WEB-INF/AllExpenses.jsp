<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Expenses</title>
</head>
<body>
<!-- All Expenses in forEach -->
<!-- New Expense Form -->
<h1>Save Travels</h1>

<table>
	<thead>
	<tr>
		<th>Expense</th>
		<th>Vendor</th>
		<th>Amount</th>
		<th>Actions</th>
	</tr>
	</thead>
	<tbody>
		<tr>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<td><a href="/one/expense/${expense.id}"><c:out value="${expense.expenseName}"/></a></td>
					<td><c:out value="${expense.vendorName}"/></td>
					<td><c:out value="${expense.amount}"/></td>
					<td>
						<a href="/expense/edit/${expense.id}">Edit</a>
						<form action="/delete/${expense.id}" method="POST">
							<!-- The controller looks for the delete mapping instead of the POST mapping -->
    						<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</tbody>
	<!-- The Model is the empty expense object overlaid the form -->
	<!-- @ModelAttribute is used for databinding -->
	<form:form action="/expense/new" method="post" modelAttribute="Expenses">
		<form:label path="expenseName">Expense Name:</form:label>
		<form:errors path="expenseName"/>
		<form:input path="expenseName"/>
		
		<form:label path="vendorName">Vendor:</form:label>
		<form:errors path="vendorName"/>
		<form:input path="vendorName"/>
		
		<form:label path="amount">Amount:</form:label>
		<form:errors path="amount"/>
		<form:input path="amount"/>
		
		<form:label path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:input path="description"/>
		
		<input type="submit" value="Submit"/>
	</form:form>
</table>

</body>
</html>