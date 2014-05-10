<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<%--<spring:message var="aaa" text="aaaaa"></spring:message>--%>
<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
<%--<link href="<c:url value='/resources/css/bootstrap.css'  />" rel="stylesheet"/>--%>
    <style type="text/css">
        /*body {*/
            /*background-color: rgb(38, 38, 38);*/
        /*}*/

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
<body>

    <tiles:insertAttribute name="top" />
    <button id="setBut" class="btn btn-default">Settings</button>
    <div class="row well" id="settings" style="visibility: hidden;">
        <div class="col-sm-3 col-sm-offset-0">
            <div>
                Field Size
                <button class="btn btn-danger" id="fsPlus"><span class="glyphicon glyphicon-plus"></span></button>
                <button class="btn btn-danger" id="fsMinus"><span class="glyphicon glyphicon-minus"></span></button>
            </div>
            <div>
                Cell Size
                <button class="btn btn-danger" id="csPlus"><span class="glyphicon glyphicon-plus"></span></button>
                <button class="btn btn-danger" id="csMinus"><span class="glyphicon glyphicon-minus"></span></button>
            </div>
            <div>
                <div class="row">
                    <button class="btn btn-primary" id="startStop" >Start/Stop</button>
                    <button class="btn btn-primary" id="nextGen">Next Generation</button>
                    <button class="btn btn-primary" id="clearField">Clear Field</button>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div id="liveDiv">
                Live cell lives
                1<input type="checkbox" id="chb1">
                2<input type="checkbox" id="chb2">
                3<input type="checkbox" id="chb3">
                4<input type="checkbox" id="chb4">
                5<input type="checkbox" id="chb5">
                6<input type="checkbox" id="chb6">
                7<input type="checkbox" id="chb7">
                8<input type="checkbox" id="chb8">
            </div>
            <div id="deadDiv">
                Dead cell lives
                1<input type="checkbox" id="chb21">
                2<input type="checkbox" id="chb22">
                3<input type="checkbox" id="chb23">
                4<input type="checkbox" id="chb24">
                5<input type="checkbox" id="chb25">
                6<input type="checkbox" id="chb26">
                7<input type="checkbox" id="chb27">
                8<input type="checkbox" id="chb28">
            </div>
            <div>
                <button class="btn btn-primary" id="saveBut">Save</button>
            </div>
        </div>
        <div class="col-sm-4">
            Generation Number:
            <label id="genNum"></label>

                <input type="button" class="btn btn-success" id="saveToDbBut" value="dsd" />
        </div>
    </div>
    <div class="row" >
        <div class="col-sm-offset-2" id="canvasPlace"></div>
    </div>


<footer>
    <div class="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</footer>

<script type="text/javascript" src="<c:url value='../../resources/coffeescripts/game_of_life.js' /> ">
</script>
<script type="text/javascript" src="<c:url value='../../resources/coffeescripts/index.js' /> ">
</script>


<script type="text/javascript" src="<c:url value='/resources/js/jQuery.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />"></script>
<script type="text/javascript">
    index = new Index();

        var but = document.getElementById('saveToDbBut');
        but.onmousedown = saveaa;

        function saveaa(){

            var json = { "authorId" : 1, "configName" : 'dasdas', "description": 'dsads'};
            <%--$.ajax({--%>
                <%--type: 'GET',--%>
                <%--url: '${pageContext.request.contextPath}/settings/save',--%>
                <%--data: json,--%>
                <%--success: function() {--%>
                    <%--var respContent = "";--%>
                    <%--alert('dasdaas');--%>
                <%--},--%>
                <%--done: function(){--%>
                    <%--alert('done')--%>
                <%--},--%>
                <%--error: function(res){--%>
                    <%--alert(res);--%>
                <%--}--%>
            <%--});--%>

            $.post(
                "/settings/save",json,function(){
                      alert('ddd');
                    });

        }

</script>
</body>

</html>



