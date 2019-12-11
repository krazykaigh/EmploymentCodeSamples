<%-- 
    Document   : listSale
    Created on : Jul 22, 2014, 4:26:41 PM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <jsp:useBean id="SaleDAO" class="CMIS.DAO.SaleDAO"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Sales</title>
<%@ include file="midHeader.html" %>
    <h2>Sale Table</h2>
    <hr/>
        <table class="table table-hover" border=1>
            <thead>
                <tr>
                <th>Sale ID</th>
                <th>Actual Amt</th>
                <th>Sale Date</th>
                <th>Customer ID</th>
                <th>Agent ID</th>
                <th>Home ID</th>
                <th>Contract ID</th>
                <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${sales}" var="sale">
                <tr>
                    <td><c:out value="${sale.saleID}" /></td>  
                    <fmt:setLocale value="en_US"/>
                    <td><fmt:formatNumber value="${sale.actualamt}" type="currency"/></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${sale.saledate}" /></td>
                    <td><c:out value="${sale.custID}" /></td>
                    <td><c:out value="${sale.agentID}" /></td>                
                    <td><c:out value="${sale.homeID}" /></td>
                    <td><c:out value="${sale.contractID}" /></td>
                    <td><a href="SaleController?action=edit&saleID=<c:out value="${sale.saleID}"/>">Update</a></td>
                    <td><a href="SaleController?action=delete&saleID=<c:out value="${sale.saleID}"/>">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="SaleController?action=insert">Add Sale</a></p>
<%@ include file="footer.html" %>
<!-- /body>
</html -->