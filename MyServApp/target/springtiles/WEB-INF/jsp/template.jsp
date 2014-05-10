<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<head>
    <title>Game of Life</title>



    <style type="text/css">
        body {
            background-color: rgb(38, 38, 38);
        }

        canvas {
            border: 1px solid rgba(242, 198, 65, 0.1);
            margin: 50px auto 0 auto;
            display: block;
        }
    </style>
    <spring:theme code="styleSheet" var="app_css" />
    <spring:url value="/${app_css}" var="app_css_url" />
    <link rel="stylesheet" type="text/css" madia="screen" href="${app_css_url}" />
</head>

<%--<c:set var="userLocale">--%>
    <%--<c:set var="plocale" >--%>
        <%--${pageContext.request.locale}--%>
    <%--</c:set>--%>
    <%--<c:out value="${fn:replace(plocale, '_','-')}" default="en"/>--%>
<%--</c:set>--%>
<spring:message code="code1" var="co"/>


<body>

<tiles:insertAttribute name="top"></tiles:insertAttribute>
    Tiles Demo

<tiles:insertAttribute name="main"></tiles:insertAttribute>
    <div>
        ${co}
    </div>
-- <tiles:insertAttribute name="footer"></tiles:insertAttribute>

<input type="button" onclick="lol();"/>


<script type="text/coffeescript" src="<c:url value='../../resources/coffeescripts/game_of_life.coffee' /> ">
</script>
<script type="text/javascript">
    new GameOfLife();

//    function lol(){
//        a.cellSize = a.cellSize + 1;
//    }

</script>
</body>


</html>