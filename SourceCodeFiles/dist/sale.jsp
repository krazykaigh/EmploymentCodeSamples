<%-- 
    Document   : sale
    Created on : Jul 22, 2014, 4:14:06 PM
    Author     : Kaigh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <jsp:useBean id="saleDAO" scope="session" class="CMIS.DAO.SaleDAO"/>
 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
        <script type="text/javascript" src="Script/jquery.js"></script>
        <title>Add New Sale</title>
        
        <%@ include file="midHeader.html" %>
            <!-- /head>
            <body -->
        <script>
            $(function() 
                {$('input[name=saledate]').datepicker(); });
        </script>
    
    <div class="col-sm-offset-3 col-sm-8">
        <h3>Sale Form</h3>   
    </div>    
    <div class="col-md-8">
        <form class="form-horizontal" role="form" data-parsley-validate method="POST" 
              action="SaleController" name="frmAddSale">
            <div class="form-group">
                <label for="saleID" class="col-sm-2 control-label">Sale ID</label> 
                <div class="col-sm-8">
                    <input class="form-control" placeholder="Sale ID" type="text" 
                           readonly="readonly" name="saleID" value="<c:out value="${sale.saleID}" />"/>
                </div>    
            </div>    
            <div class="form-group">                
                <label for="actualamt" class="col-sm-2 control-label">Actual Amt*</label> 
                 <div class="col-sm-8">
                     <fmt:setLocale value="en_US"/>
                    <input class="form-control" placeholder="Actual Amt" data-parsley-required type="text" 
                           data-parsley-pattern="/^[0-9]+\.?[0-9]?[0-9]?$/" name="actualamt" 
                            data-parsley-error-message="Amount accepts numbers, decimal to two places" 
                           value="<fmt:formatNumber value="${sale.actualamt}" />" type="currency"/>
                 </div>
            </div>    
            <div class="form-group">
                <label for="saledate" class="col-sm-2 control-label">Sale Date*</label>
                <div class="col-sm-8">
                    <input class="form-control" placeholder="mm/dd/yyyy" data-parsley-required 
                           type="text" name="saledate" 
                           data-parsley-pattern="/^(0[1-9]|1[012])[\/](0[1-9]|[12][0-9]|3[01])[\/](19|20)\d\d$/"
                           data-parsley-error-message="Date format mm/dd/yyyy" 
                           value="<fmt:formatDate pattern="MM/dd/yyyy" value="${sale.saledate}" />" />
                </div>    
            </div>    
            <div class="form-group">                
                <label for="custID" class="col-sm-2 control-label">Customer ID*</label>
                <div class="col-sm-8">
                    <select name="custID" size="1" id="all-customers">
                        <c:forEach items="${saleDAO.customerList}" var="sale_cust">
                            <option ${sale.custID == sale_cust.idNumber
                                ? 'selected="selected"' 
                                : ''
                                } value="<c:out value="${sale_cust.idNumber}"/>">
                                <c:out value="${sale_cust.idNumber}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>       
            <div class="form-group">                
                <label for="agentID" class="col-sm-2 control-label">Agent ID*</label>
                <div class="col-sm-8">
                    <select name="agentID" size="1" id="all-agents">
                        <c:forEach items="${saleDAO.agentList}" var="sale_agent">
                            <option ${sale.agentID == sale_agent.idNumber
                                ? 'selected="selected"' 
                                : ''
                                } value="<c:out value="${sale_agent.idNumber}"/>">
                                <c:out value="${sale_agent.idNumber}"/></option>
                        </c:forEach>
                    </select>
                </div>    
            </div>    
            <div class="form-group">                
                <label for="homeID" class="col-sm-2 control-label">Home ID*</label>
                <div class="col-sm-8">
                    <select name="homeID" size="1" id="all-homes">
                        <c:forEach items="${saleDAO.homeList}" var="sale_home">
                            <option ${sale.homeID == sale_home.idNumber
                                ? 'selected="selected"' 
                                : ''
                                } value="<c:out value="${sale_home.idNumber}"/>">
                                <c:out value="${sale_home.idNumber}"/></option>
                        </c:forEach>
                    </select>
                </div> 
            </div> 
            <div class="form-group">
                <label for="contractID" class="col-sm-2 control-label">Contract ID*</label>
                  <div class="col-sm-8">
                    <input class="form-control" placeholder="Contract ID" data-parsley-required type="text" 
                           data-parsley-pattern="/^[A-Za-z0-9\-\_]*$/" name="contractID" 
                           value="<c:out value="${sale.contractID}" />" /> 
                </div>
            </div> 
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" align="center" value="Submit" />
                    <input type="Reset" class="btn btn-info" name="cmdReset" value="RESET">  
                </div>
        </form>
    </div>

<%@ include file="footer.html" %>