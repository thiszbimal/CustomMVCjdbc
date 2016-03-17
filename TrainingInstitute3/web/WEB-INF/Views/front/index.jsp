<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>  

<h1>WELCOME To</h1>
<h2>ABC Training Institute</h2><hr><hr>

<div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Offered Courses
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
       <c:forEach var="course" items="${requestScope.courses}">
            <li role="presentation" class="active"><a href="${SITE_URL}/course/detail/?id=${course.id}">${course.name}</a></li>
       </c:forEach>
            <li class="divider"></li>
      
            <li><a href="#">About Us</a></li>
    </ul>
  </div>

<%@include file="footer.jsp" %>
