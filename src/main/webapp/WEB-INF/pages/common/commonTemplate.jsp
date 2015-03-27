<%--
  Created by IntelliJ IDEA.
  User: saif
  Date: 3/25/15
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--[if lt IE 7]>       <html class="no-js lt-ie9 lt-ie8 lt-ie7">   <![endif]-->
<!--[if IE 7]>          <html class="no-js lt-ie9 lt-ie8">          <![endif]-->
<!--[if IE 8]>          <html class="no-js lt-ie9">                 <![endif]-->
<!--[if IE 9]>          <html class="no-js lt-ie10">                 <![endif]-->
<!--[if gt IE 8]><!-->

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="Thu, 01 Jan 1970 00:00:00 GMT"/>

  <link type="text/css" href="/contents/css/customDesign.css" rel="stylesheet"/>
  <link type="text/css" href="/contents/framework/css/bootstrap.css" rel="stylesheet"/>
  <link type="text/css" href="/contents/framework/css/bootstrap.min.css" rel="stylesheet"/>
  <link type="text/css" href="/contents/framework/css/bootstrap-theme.css" rel="stylesheet"/>
  <link type="text/css" href="/contents/framework/css/bootstrap-theme.min.css" rel="stylesheet"/>

  <%--<tiles:getAsString  name="pageTitle" ignore="true"/>--%>
  <title>Demo Project</title>

  <meta name="viewport" content="width=device-width"/>
</head>
<body class="container-fluid">
   <div class="container" id="wrap">
     <!-- Insert common header -->
     <tiles:insertAttribute name="header" />
     <!-- Insert common top menu -->
     <%--<tiles:insertAttribute name="menu" />--%>
     <!-- Insert main content -->
     <tiles:insertAttribute name="content" />
     <!-- Insert footer content -->
     <tiles:insertAttribute name="footer" />
   </div>


  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="/contents/framework/js/bootstrap.js"></script>
  <script src="/contents/framework/js/bootstrap.min.js"></script>
</body>
</html>
