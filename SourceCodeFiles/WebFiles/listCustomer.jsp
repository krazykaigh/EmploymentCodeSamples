<%-- 
Document   : listCustomer
    Created on : Jul 18, 2014, 5:22:20 PM
    Author     : Kaigh
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <jsp:useBean id="CustomerDAO" class="CMIS.DAO.CustomerDAO"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Customers</title>
<%@ include file="midHeader.html" %>
    <h2>Customer Table</h2>
    <hr/>
        <table class="table table-hover" border=1>
            <thead>
                <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>M.I.</th>
                <th>Last Name</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th>Home Phone</th>
                <th>Date of Birth</th>
                <th>Profession</th>
                <th>Referrer</th>
		<th>Agent ID</th>
                <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.custID}" /></td>                
                    <td><c:out value="${customer.first}" /></td>
                    <td><c:out value="${customer.mi}" /></td>
                    <td><c:out value="${customer.last}" /></td>
                    <td><c:out value="${customer.street}" /></td>                
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.state}" /></td>
                    <td><c:out value="${customer.zipcode}" /></td>
                    <td><c:out value="${customer.home_phone}" /></td>					
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${customer.dob}" /></td>
                    <td><c:out value="${customer.profession}" /></td>
                    <td><c:out value="${customer.referrer}" /></td>
                    <td><c:out value="${customer.agentID}" /></td>					
                    <td><a href="CustomerController?action=edit&custID=<c:out value="${customer.custID}"/>">Update</a></td>
                    <td><a href="CustomerController?action=delete&custID=<c:out value="${customer.custID}"/>">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="CustomerController?action=insert">Add Customer</a></p>
<%@ include file="footer.html" %>
<!-- /body>
</html -->