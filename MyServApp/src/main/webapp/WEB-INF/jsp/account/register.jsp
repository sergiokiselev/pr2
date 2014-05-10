<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
    <%--<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />--%>
    <%--<link href="<c:url value='/resources/css/bootstrap.css'  />" rel="stylesheet"/>--%>
    <spring:theme code="styleSheet" var="app_css" />
    <spring:url value="/${app_css}" var="app_css_url" />
    <link rel="stylesheet" type="text/css" madia="screen" href="${app_css_url}" />
</head>
<body>
<div class="page-header">

</div>
<!--
    If the user is anonymous (not logged in), show the registration form.
-->
<%--<sec:authorize access="isAnonymous()">--%>
    <div class="panel panel-default">
        <div class="panel-body">
            <form:form modelAttribute="registrationModel"  method="POST" role="form">
                <!-- Add CSRF token to the request. -->
                <input type="hidden" name="" value=""/>
                <!--
                If the user is using social sign in, add the signInProvider
                as a hidden field.
                -->
                <%--<c:if test="${user.signInProvider != null}">--%>
                    <%--<form:hidden path="signInProvider"/>--%>
                <%--</c:if>--%>
                <div class="row">
                    <div id="form-group-firstName" class="form-group col-sm-6 col-sm-offset-3">
                        <label class="control-label">User Name:</label>
                        <form:input id="userName" path="userName" cssClass="form-control"/>
                        <%--<form:errors id="error-firstName" path="firstName" cssClass="help-block"/>--%>
                    </div>
                </div>
                <div class="row">
                    <div id="form-group-email" class="form-group col-sm-6 col-sm-offset-3">
                        <label class="control-label" for="email">Email:</label>
                        <form:input id="email" path="email" cssClass="form-control"/>
                        <%--<form:errors id="error-email" path="email" cssClass="help-block"/>--%>
                    </div>
                </div>
                <!--
                If the user is creating a normal user account, add password fields
                to the form.
                -->
                <%--<c:if test="${user.signInProvider == null}">--%>
                    <div class="row">
                        <div id="form-group-password" class="form-group col-sm-6 col-sm-offset-3">
                            <label class="control-label">Password:</label>
                            <form:password id="password" path="password" cssClass="form-control"/>
                            <%--<form:errors id="error-password" path="password" cssClass="help-block"/>--%>
                        </div>
                    </div>
                    <div class="row">
                        <div id="form-group-passwordVerification" class="form-group col-sm-6 col-sm-offset-3">
                            <label class="control-label">Password Confirm:</label>
                            <form:password id="passwordConfirm" path="passwordConfirm" cssClass="form-control"/>
                            <%--<form:errors id="error-passwordVerification" path="passwordVerification" cssClass="help-block"/>--%>
                        </div>
                    </div>
                <%--</c:if>--%>
                <!-- Add the submit button to the form. -->
                <div class="row">
                    <div id="form-group-but" class="form-group col-sm-6 col-sm-offset-4">
                        <button type="submit" class="btn btn-info">Register</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
<%--</sec:authorize>--%>
<!--
    If the user is authenticated, show a help message instead
    of registration form.
-->
<%--<sec:authorize access="isAuthenticated()">--%>
    <%--<p></p>--%>
<%--</sec:authorize>--%>
</body>
</html>