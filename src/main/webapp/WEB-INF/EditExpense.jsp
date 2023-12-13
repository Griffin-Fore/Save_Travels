<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
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
    <meta charset="UTF-8">
    <title>Edit Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>


<h1>Edit Expense</h1>
<form:form action="/expense/edit/process/${oneExpense.id}" method="post" modelAttribute="editExpense">
    <input type="hidden" name="_method" value="put">
    <div>
    	<!-- Prepopulate with info -->
        <form:label path="expenseName">Expense Name:</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName" value="${oneExpense.expenseName}"/>
    </div>
    <div>
        <form:label path="vendorName">Vendor:</form:label>
        <form:errors path="vendorName"/>
        <form:input path="vendorName" value="${oneExpense.vendorName}"/>
    </div>
    <div>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input path="amount" value="${oneExpense.amount}"/>
    </div>
    <div>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description" placeholder="${oneExpense.description}"/>
    </div>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>

