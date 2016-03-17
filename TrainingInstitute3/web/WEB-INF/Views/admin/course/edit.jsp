<%-- 
    Document   : edit
    Created on : Feb 6, 2016, 3:25:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Edit Course</h1>
<form method="post" action="${SITE_URL}/c/update">
    <div class="form-group">
        <label for="id">Course Id</label>
        <input type="text" name="id" id="id" class="form-control" required="required" value="${c.id}">
    </div>
    <div class="form-group">
        <label for="name">Course Name</label>
        <input type="text" name="name" id="name" class="form-control" required="required" value="${c.name}">
    </div>
    <div class="form-group">
        <label for="description">Course Description</label>
        <textarea  name="description" id="description" class="form-control" required="required" >${c.description}</textarea>
    </div>
    <div class="form-group">
        <label for="fees">Course Fees </label>
        <input type="text" name="fees" id="fees" class="form-control" required="required" value="${c.fees}">
    </div>
    <div class="form-group">
        <label for="duration">Duration</label>
        <select class="form-group" name="duration">${c.duration}
            <c:forEach var="duration" begin="1" end="30" step="1">
                <option>${duration}</option>
            </c:forEach>
        </select>
            
        <label for="duration">Duration Type</label>
        <select class="form-group" name="durationType"  >
                <option>Day</option>
                <option>Week</option>
                <option>Month</option>
                <option>Year</option>
        </select>
    </div>
                
    <div class="form-group">
        <label for="status"> Status: </label>&nbsp;&nbsp;
        <input type="radio" name="status" id="status" value="1" <c:if test="${c.status}"> checked="checked"</c:if>/>&nbsp;&nbsp;&nbsp;<label>Active</label>
        &nbsp;&nbsp;<input type="radio" name="status" id="status" value="0" <c:if test="${!c.status}">checked="checked"</c:if>/>&nbsp;&nbsp;&nbsp;<label>Inactive</label>
    
    </div>
        
        <button type="submit" class="btn btn-success" name="submit"><span class="glyphicon glyphicon-ok"></span> Update Course</button>
    
</form>
        
        <%@include file="../footer.jsp" %>