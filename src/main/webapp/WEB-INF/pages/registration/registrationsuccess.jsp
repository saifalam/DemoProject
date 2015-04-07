<%--
  Created by IntelliJ IDEA.
  User: saif
  Date: 3/27/15
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>

<h3>
  User Saved Successfully.
</h3>

<strong>Full Name:${viewModel.fullName}</strong><br>
<strong>User Name:${viewModel.userName}</strong><br>
<strong>User Email:${viewModel.email}</strong><br>
<strong>User Gender:${viewModel.gender}</strong><br>
<strong>User Birthday:<fmt:formatDate value="${viewModel.dateOfBirth}" type="date" /></strong><br>



