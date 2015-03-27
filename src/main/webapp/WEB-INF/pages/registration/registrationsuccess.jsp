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

<strong>Customer Name:${customer.email}</strong><br>
<strong>Customer Name:${customer.userName}</strong><br>
<strong>Customer Email:${customer.email}</strong><br>
<strong>Customer Gender:${customer.gender}</strong><br>
<strong>Customer Birthday:<fmt:formatDate value="${customer.dateOfBirth}" type="date" /></strong><br>


