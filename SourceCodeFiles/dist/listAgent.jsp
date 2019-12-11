<%-- 
Document   : listAgent
    Created on : Jul 18, 2014, 5:22:20 PM
    Author     : Kaigh
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <jsp:useBean id="AgentDAO" class="CMIS.DAO.AgentDAO"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Agents</title>
<%@ include file="midHeader.html" %>
    <h2>Agent Table</h2>
    <hr/>
        <table class="table table-hover" border=1>
            <thead>
                <tr>
                <th>Agent Id</th>
                <th>Title</th>
                <th>First Name</th>
                <th>M.I.</th>
                <th>Last Name</th>
                <th>Hire Date</th>
                <th>Home Phone</th>
                <th>Cell Phone</th>
                <th>Pager</th>
                <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${agents}" var="agent">
                <tr>
                    <td><c:out value="${agent.agentID}" /></td>
                    <td><c:out value="${agent.title}" /></td>                   
                    <td><c:out value="${agent.first}" /></td>
                    <td><c:out value="${agent.mi}" /></td>
                    <td><c:out value="${agent.last}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${agent.hireDate}" /></td>
                    <td><c:out value="${agent.home_phone}" /></td>
                    <td><c:out value="${agent.cell_phone}" /></td>
                    <td><c:out value="${agent.pager}" /></td>
                    <td><a href="AgentController?action=edit&agentID=<c:out value="${agent.agentID}"/>">Update</a></td>
                    <td><a href="AgentController?action=delete&agentID=<c:out value="${agent.agentID}"/>">Delete</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="AgentController?action=insert">Add Agent</a></p>
<%@ include file="footer.html" %>
<!-- /body>
</html -->

