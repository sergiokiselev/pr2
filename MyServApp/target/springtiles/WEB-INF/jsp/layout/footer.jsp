<%--<?xml version="l.0" encoding="UTF-8" standalone=:"no"?>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib uri="http://Java.sun.com/JSP/Page" prefix="" %>--%>

<div id="footer" xmlns:jsp="http://Java.sun.com/JSP/Page">
    <%--<jsp:directive.page contentType="text/html;charset=UTF-8" />--%>
    <%--<jsp:output omit-xml-declaration="yes" />--%>
    <spring:message code="developer" var="developer"/>
    <spring:message code="label_en_US" var="labelEnUs"/>
    <spring:message code="label_zh_HK" var="labelZhHk"/>
<%--<spring:url value="/contacts" var="homeUrl"/>--%>
        <div class="row">
            <div class="col-sm-offset-4" style="padding-top: 50px;">
            ${developer}
            <a href="${homeUrl}?lang=en">${labelEnUs}</a> |
            <a href="${homeUrl}?lang=ru">${labelZhHk}</a>
            </div>
        </div>
</div> 