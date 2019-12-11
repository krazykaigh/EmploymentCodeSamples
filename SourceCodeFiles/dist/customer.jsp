<%-- 
    Document   : customer
    Created on : Jul 18, 2014, 8:59:46 PM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <jsp:useBean id="customerDAO" scope="session" class="CMIS.DAO.CustomerDAO"/>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
        <script type="text/javascript" src="Script/jquery.js"></script>
        <title>Add New Customer</title>
        
        <%@ include file="midHeader.html" %>
            <!-- /head>
            <body -->
        <script>
            $(function() 
                {$('input[name=dob]').datepicker(); });
        </script>

    <div class="col-sm-offset-3 col-sm-8">
        <h3>Customer Form</h3>   
    </div>    
    <div class="col-md-8">
        <form class="form-horizontal" role="form" data-parsley-validate method="POST" 
              action="CustomerController" name="frmAddCustomer">
            <div class="form-group">
                <label for="custID" class="col-sm-2 control-label">Customer ID</label> 
                <div class="col-sm-8">
                <input class="form-control" placeholder="Customer ID" type="text" readonly="readonly" 
                       name="custID" value="<c:out value="${customer.custID}" />"/>
                </div>
            </div>
            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">First Name*</label>
                <div class="col-sm-8">
                    <input class="form-control" placeholder="First Name" 
                           data-parsley-required data-parsley-pattern="/^[a-zA-Z ]*$/" type="text" name="first" 
                           value="<c:out value="${customer.first}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="mi" class="col-sm-2 control-label">M.I.</label>
                <div class="col-sm-8">
                    <input class="form-control" placeholder="M.I." typetype="text" 
                           data-parsley-pattern="/^[a-zA-Z]{1}$/" name="mi" 
                           data-parsley-error-message="M.I. input is a single letter" 
                           value="<c:out value="${customer.mi}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="last" class="col-sm-2 control-label">Last Name*</label>
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Last Name" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z ]*$/" name="last" 
                           value="<c:out value="${customer.last}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="street" class="col-sm-2 control-label">Street*</label> 
                 <div class="col-sm-8">
                    <input class="form-control" placeholder="Street" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" name="street" 
                           value="<c:out value="${customer.street}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="city" class="col-sm-2 control-label">City*</label> 
             <div class="col-sm-8">
                    <input class="form-control" placeholder="City" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z ]*$/"  name="city" 
                           value="<c:out value="${customer.city}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State*</label> 
            <div class="col-sm-8">
                    <input class="form-control" placeholder="State" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z ]*$/" name="state" 
                           value="<c:out value="${customer.state}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="zipcode" class="col-sm-2 control-label">Zip Code*</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Zip Code" data-parsley-required type="text" 
                           data-parsley-pattern="/[0-9]{5}$/" name="zipcode" 
                           data-parsley-error-message="Zip code accepts first five digits" 
                           value="<c:out value="${customer.zipcode}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="home_phone" class="col-sm-2 control-label">Home Phone*</label>
                <div class="col-sm-8">
                <input class="form-control"  placeholder="Home Phone (10 digits only)" 
                       data-parsley-required type="text" data-parsley-pattern="/^[0-9]{10}$/" 
                           data-parsley-error-message="10 digit number no dashes, spaces, parenthesis" 
                       name="home_phone" value="<c:out value="${customer.home_phone}" />" /> 
                 </div>
            </div>    
            <div class="form-group">
                <label for="dob" class="col-sm-2 control-label">Date of Birth*</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="mm/dd/yyyy" data-parsley-required 
                           type="text" name="dob" 
                           data-parsley-pattern="/^(0[1-9]|1[012])[\/](0[1-9]|[12][0-9]|3[01])[\/](19|20)\d\d$/" 
                           data-parsley-error-message="Date format mm/dd/yyyy" 
                           value="<fmt:formatDate pattern="MM/dd/yyyy" value="${customer.dob}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="profession" class="col-sm-2 control-label">Profession</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Profession" type="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" name="profession" 
                           value="<c:out value="${customer.profession}" />" /> 
                </div>
            </div>    
            <div class="form-group">
                <label for="referrer" class="col-sm-2 control-label">Referrer</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Referrer" type="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" name="referrer" 
                           value="<c:out value="${customer.referrer}" />" /> 
                </div>    
            </div>    
            <div class="form-group">                
                <label for="agentID" class="col-sm-2 control-label">Agent ID*</label>
                <div class="col-sm-8">
                    <select name="agentID" size="1" id="all-agents">
                        <c:forEach items="${customerDAO.agentList}" var="cust_agent">
                            <option ${customer.agentID == cust_agent.idNumber
                                ? 'selected="selected"' 
                                : ''
                                } value="<c:out value="${cust_agent.idNumber}"/>">
                            <c:out value="${cust_agent.idNumber}"/></option>
                        </c:forEach>
                    </select>
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
