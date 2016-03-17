<%-- 
    Document   : add
    Created on : Feb 6, 2016, 3:25:35 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h1> Add New Course </h1>
    <form method="post" action="${SITE_URL}/c/save">
        <div class="form-group">
            <label for="name">Course Name</label>
            <input type="text" class="form-control" name="name" id="name" required="required"/>
        </div>
        
        <div class="form-group">
            <label for="description">Course Description</label>
            <textarea type="text" class="form-control" name="description" rows="5" id="description" required="required"></textarea>
        </div>
        <div class="form-group">
            <label for="fees">Course Fees</label>
            <input type="text" class="form-control" name="fees" id="fees" required="required"/>
        </div>
        <div class="form-group">
        <label for="duration">Duration</label>
        <select class="form-group" name="duration">
            <c:forEach var="duration" begin="1" end="30" step="1">
                <option>${duration}</option>
            </c:forEach>
        </select>&nbsp;&nbsp;&nbsp;
        <label for="duration">Duration Type</label>
        <select class="form-group" name="durationType">
                <option>Day</option>
                <option>Week</option>
                <option>Month</option>
                <option>Year</option>
        </select>
        </div>      
        
        <div class="form-group">
            <label for="status">Status: </label>&nbsp;&nbsp;
            <input type="radio" name="status" id="status" value="1">&nbsp;&nbsp;<label>Active</label>
            &nbsp;&nbsp;&nbsp;<input type="radio" name="status" id="status" value="0">&nbsp;&nbsp;<label>Inactive</label>
            
        </div>
        
        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-saved"></span>Save Course</button>
            
    </form>
    <%@include file="../footer.jsp" %>
