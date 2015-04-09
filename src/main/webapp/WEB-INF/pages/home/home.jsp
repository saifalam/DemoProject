<%--
  Created by IntelliJ IDEA.
  User: saif
  Date: 4/7/15
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div id="content_main" class="row">

  <div class="welcomePart">
    <h1>${message}</h1>
    <h2>Profile Description:</h2>
    <h3>Full Name: ${sessionScope.fullName}</h3>
    <h3>Email: ${sessionScope.email}</h3>
    <h3>Mobile: ${sessionScope.mobileNo}</h3>
    <h3>Gender: ${sessionScope.gender}</h3>
    <h3>Date of birth: ${sessionScope.dateOfBirth}</h3>

    <%--<c:if test="${pageContext['request'].userPrincipal != null}">--%>
      <%--<c:out value="${request.getUserPrincipal().getName()}" />--%>
     <%--</c:if>--%>
    <form action="/j_spring_security_logout">
      <input type="submit" name="logout" value="logout">
    </form>
  </div>

</div>
<%--<script src="/contents/js/jquery-ui-1.10.4.min.js"></script>--%>
<script src="/contents/js/jquery-1.10.1.min.js"></script>
<script>
  $(document).ready(function(){
    $(".welcomePart").show();
  });


</script>


