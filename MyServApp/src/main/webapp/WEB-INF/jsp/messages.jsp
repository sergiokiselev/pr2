<!DOCTYPE html>
<head>
    <%@ page pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
    <%--<link href="<c:url value='/resources/css/bootstrap.css'  />" rel="stylesheet"/>--%>
    <spring:theme code="styleSheet" var="app_css" />
    <spring:url value="/${app_css}" var="app_css_url" />
    <link rel="stylesheet" type="text/css" madia="screen" href="${app_css_url}" />
</head>
<body>

<tiles:insertAttribute name="top" />

<div class="jumbotron">
    <h1>Jumbotron</h1>
    <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <p><a class="btn btn-primary btn-lg">Learn more</a></p>
</div>

<div class="container">
<input type="text" id="messageInput"/>
<button type="button" id="but" class="btn btn-default">Send</button>
<div class="container row well" id="messageBox">
</div>
</div>


<tiles:insertAttribute name="footer" />
<script type="text/javascript" src="<c:url value='/resources/js/websocket.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/whiteboard.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jQuery.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script>

</body>
</html>