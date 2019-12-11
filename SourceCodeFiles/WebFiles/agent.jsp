<%-- 
    Document   : agent
    Created on : Jul 18, 2014, 8:59:46 PM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <jsp:useBean id="AgentDAO" scope="session" class="CMIS.DAO.AgentDAO"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
        <script type="text/javascript" src="Script/jquery.js"></script>
        <title>Add New Agent</title>
        <%@ include file="midHeader.html" %>
        <!-- /head>
        <body -->
        <script>
            $(function() 
                {$('input[name=hireDate]').datepicker(); });
        </script>

        <div class="col-sm-offset-3 col-sm-8">
            <h3>Agent Form</h3>   
        </div>    
        <div class="col-md-8">
            <form  class="form-horizontal" role="form" data-parsley-validate method="POST" 
                   action="AgentController" name="frmAddAgent">
                <div class="form-group">
                    <label for="agentID" class="col-sm-2 control-label">Agent ID</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="Agent ID" type="text" readonly="readonly" 
                               name="agentID" value="<c:out value="${agent.agentID}" />"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title*</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="Title (no spaces)" 
                               data-parsley-required type="text" name="title" 
                               data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" 
                               data-parsley-error-message="Title accepts alphanumeric and space"
                           value="<c:out value="${agent.title}" />" />
                    </div>
                </div>    
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">First Name*</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="First Name" data-parsley-required 
                               data-parsley-pattern="/^[a-zA-Z ]*$/" type="text" 
                           name="first" value="<c:out value="${agent.first}" />" />
                    </div>
                </div>    
                <div class="form-group">
                   <label for="mi" class="col-sm-2 control-label">M.I.</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="M.I." type="text" 
                               data-parsley-pattern="/^[a-zA-Z]{1}$/" name="mi" 
                           data-parsley-error-message="M.I. input is a single letter" 
                           value="<c:out value="${agent.mi}" />" />
                    </div>
                </div>    
                <div class="form-group">
                    <label for="last" class="col-sm-2 control-label">Last Name*</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="Last Name" data-parsley-required 
                               type="text" data-parsley-pattern="/^[a-zA-Z ]*$/" 
                           name="last" value="<c:out value="${agent.last}" />" />
                    </div>
                </div>    
                <div class="form-group">
                    <label for="hireDate" class="col-sm-2 control-label">Hire Date*</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="mm/dd/yyyy" data-parsley-required 
                               type="text" name="hireDate" 
                               data-parsley-pattern="/^(0[1-9]|1[012])[\/](0[1-9]|[12][0-9]|3[01])[\/](19|20)\d\d$/" 
                           data-parsley-error-message="Date format mm/dd/yyyy" 
                           value="<fmt:formatDate pattern="MM/dd/yyyy" value="${agent.hireDate}" />" />
                    </div>
                </div>    
                <div class="form-group">
                    <label for="home_phone" class="col-sm-2 control-label">Home Phone*</label>
                    <div class="col-sm-8">
                    <input class="form-control"  placeholder="Home Phone (10 digits only)" 
                           data-parsley-required type="text" data-parsley-pattern="/^[0-9]{10}$/" 
                           data-parsley-error-message="10 digit number no dashes, spaces, parenthesis" 
                           name="home_phone" value="<c:out value="${agent.home_phone}" />" /> 
                    </div>
                </div>    
                <div class="form-group">
                    <label for="cell_phone" class="col-sm-2 control-label">Cell Phone*</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="Cell Phone (10 digits only)" 
                               data-parsley-required type="text" data-parsley-pattern="/^[0-9]{10}$/" 
                               name="cell_phone" data-parsley-error-message="10 digit number no dashes, spaces, parenthesis" 
                          value="<c:out value="${agent.cell_phone}" />" /> 
                    </div>
                </div>    
                <div class="form-group">
                    <label for="pager" class="col-sm-2 control-label">Pager</label>
                    <div class="col-sm-8">
                        <input class="form-control" placeholder="Pager (10 digits only)" 
                               type="text" name="pager" data-parsley-pattern="/^[0-9]{10}$/" 
                           data-parsley-error-message="10 digit number no dashes, spaces, parenthesis" 
                          value="<c:out value="${agent.pager}" />" />        
                    </div>
                </div> 
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" align="center" value="Submit" />
                    <input type="Reset" class="btn btn-info" name="cmdReset" value="RESET">  
                </div>
            </form>
        </div>
<%@ include file="footer.html" %>
<!-- /body>
</html -->


