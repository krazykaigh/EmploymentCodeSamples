<%-- 
    Document   : listHome
    Created on : Jul 22, 2014, 10:59:06 AM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <jsp:useBean id="HomeDAO" class="CMIS.DAO.HomeDAO"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Homes</title>
<%@ include file="midHeader.html" %>
    <h2>Home Table</h2>
    <hr/>
        <table class="table table-hover" border=1>
            <thead>
                <tr>
                <th>Home ID</th>
                <th>Lot Size</th>
                <th>Location</th>
                <th>Model ID</th>
                <th>Purchase Price</th>
                <th>Street</th>
                <th>City</th>
                <th>State</th>
                <th>ZipCode</th>
                <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${homes}" var="home">
                <tr>
                    <td><c:out value="${home.homeID}" /></td>                
                    <td><c:out value="${home.lot_size}" /></td>
                    <td><c:out value="${home.location}" /></td>
                    <td><c:out value="${home.model_ID}" /></td>
                    <fmt:setLocale value="en_US"/>
                    <td><fmt:formatNumber value="${home.purchaseprice}" type="currency"/></td>					
                    <td><c:out value="${home.street}" /></td>                
                    <td><c:out value="${home.city}" /></td>
                    <td><c:out value="${home.state}" /></td>
                    <td><c:out value="${home.zipcode}" /></td>
                    <td><a href="HomeController?action=edit&homeID=<c:out value="${home.homeID}"/>">Update</a></td>
                    <td><a href="HomeController?action=delete&homeID=<c:out value="${home.homeID}"/>">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="HomeController?action=insert">Add Home</a></p>
<%@ include file="footer.html" %>
<!-- /body>
</html -->