<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="homeUrl" var="homeUrl" />
<spring:message code="siteName" var="siteName" />
<spring:message code="settings" var="settings" />
<spring:message code="exit" var="exit" />
<spring:message code="login" var="login"/>
<spring:message code="register" var="register" />
<spring:message code="search" var="search"/>
<spring:message code="messages" var="messages"/>
<spring:message code="light" var="light"/>
<spring:message code="dark" var="dark"/>
<spring:message code="red" var="red"/>
<spring:message code="theme" var="theme"/>

<div class="navbar navbar-default">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${homeUrl}">${siteName}</a>
    </div>
    <div class="navbar-collapse collapse navbar-responsive-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">${search}</a></li>
            <li><a href="/messages/"  >${messages}</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${theme} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${homeUrl}?theme=standard">${dark}</a></li>
                    <li><a href="${homeUrl}?theme=white">${light}</a></li>
                    <li><a href="${homeUrl}?theme=red">${red}</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left">
            <input type="text" class="form-control col-lg-8" placeholder="Search">
        </form>
        <c:choose>
       <c:when test="${sessionScope.isAuth == true}">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">${settings}</a></li>
            <li><a href="#">${exit}</a>
            </li>
        </ul>
       </c:when>
        <c:otherwise>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login/signup">${login}</a></li>
            <li><a href="/account/register">${register}</a></li>
        </ul>
        </c:otherwise>
        </c:choose>
    </div>
</div>