<%-- 
    Document   : saleInfo
    Created on : Jul 26, 2014, 12:01:20 PM
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
        <title>Show Sales Info</title>
<%@ include file="midHeader.html" %>
    <h2>Sales Report</h2>
    <hr/>
        <table class="table table-hover" border=1>
            <thead>
                <tr>
                <th>Sales COUNT</th>
                <th>Sales SUM</th>
                <th>Sales AVG</th>
                </tr>
            </thead>
            <tbody >
 
                <tr>
                    <fmt:setLocale value="en_US"/>
                    <td><c:out value="${saleRpt.totalSales}"/></td>                
                    <td><fmt:formatNumber value="${saleRpt.salesSum}" type="currency"/></td>
                    <td><fmt:formatNumber value="${saleRpt.salesAvg}" type="currency"/></td>
                </tr>

            </tbody>
        </table>
        <p><a href="index.jsp">Home</a></p>
<%@ include file="footer.html" %>