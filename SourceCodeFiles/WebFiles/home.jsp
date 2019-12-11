<%-- 
    Document   : home
    Created on : Jul 22, 2014, 10:52:28 AM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <jsp:useBean id="homeDAO" scope="session" class="CMIS.DAO.HomeDAO"/>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
        <script type="text/javascript" src="Script/jquery.js"></script>
        <title>Add New Home</title>
        
        <%@ include file="midHeader.html" %>

    <div class="col-sm-offset-3 col-sm-8">
        <h3>Home Form</h3>   
    </div>    
    <div class="col-md-8">
        <form  class="form-horizontal" role="form" data-parsley-validate method="POST"  
               action="HomeController" name="frmAddHome">
            <div class="form-group">
                <label for="homeID" class="col-sm-2 control-label">Home ID</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Home ID" type="text" readonly="readonly" 
                           name="homeID" value="<c:out value="${home.homeID}" />"/>
               </div>
            </div>
            <div class="form-group">
                <label for="lot_size" class="col-sm-2 control-label">Lot Size*</label> 
                 <div class="col-sm-8">
                    <input class="form-control" placeholder="Lot Size" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 \.]*$/" name="lot_size" 
                           data-parsley-error-message=="Lot size accepts alphanumeric, spaces, period" 
                           value="<c:out value="${home.lot_size}" />" />
                </div>
            </div>
            <div class="form-group">
                <label for="location" class="col-sm-2 control-label">Location</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Location" typetype="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" name="location" 
                           value="<c:out value="${home.location}" />" />
                </div>    
            </div>    
            <div class="form-group">                
                <label for="model_ID" class="col-sm-2 control-label">Model ID*</label> 
                 <div class="col-sm-8">
                    <input class="form-control" placeholder="Model ID" data-parsley-required type="text" 
                           data-parsley-pattern="/^[A-Za-z0-9\-\_]*$/" name="model_ID" 
                           data-parsley-error-message="Model ID accepts alphanumeric, dash, underscore" 
                           value="<c:out value="${home.model_ID}" />" />
                </div>    
            </div>    
            <div class="form-group">                
                <label for="purchaseprice" class="col-sm-2 control-label">Purchase Price*</label> 
                 <div class="col-sm-8">
                     <fmt:setLocale value="en_US"/>
                    <input class="form-control" placeholder="Purchase Price" data-parsley-required type="text" 
                           data-parsley-pattern="/^[0-9]+\.?[0-9]?[0-9]?$/" name="purchaseprice" 
                           data-parsley-error-message="Price accepts numbers, decimal to two places" 
                           value="<fmt:formatNumber value="${home.purchaseprice}" />" type="currency"/> 
                </div>
            </div>    
            <div class="form-group">
                <label for="street" class="col-sm-2 control-label">Street*</label> 
                 <div class="col-sm-8">
                    <input class="form-control" placeholder="Street" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z0-9 ]*$/" name="street" 
                           value="<c:out value="${home.street}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="city" class="col-sm-2 control-label">City*</label> 
             <div class="col-sm-8">
                    <input class="form-control" placeholder="City" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z ]*$/"  name="city" 
                           value="<c:out value="${home.city}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="state" class="col-sm-2 control-label">State*</label> 
            <div class="col-sm-8">
                    <input class="form-control" placeholder="State" data-parsley-required type="text" 
                           data-parsley-pattern="/^[a-zA-Z ]*$/" name="state" 
                           value="<c:out value="${home.state}" />" />
                </div>
            </div>    
            <div class="form-group">
                <label for="zipcode" class="col-sm-2 control-label">Zip Code*</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Zip Code" data-parsley-required type="text" 
                           data-parsley-pattern="/[0-9]{5}$/" name="zipcode" 
                           data-parsley-error-message="Zip code accepts five digits" 
                           value="<c:out value="${home.zipcode}" />" />
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
