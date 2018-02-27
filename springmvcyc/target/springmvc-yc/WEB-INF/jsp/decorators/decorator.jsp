
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:theme code="css" var="css" />
<%--<spring:theme code="easyuitheme" var="easyuitheme" />
<spring:theme code="js" var="js" />
<spring:theme code="easyuiver" var="easyuiver" />--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
    <title><sitemesh:write property='title' /></title>
    <script src="<spring:url value="${js}/jquery.min.js"/>"></script>
    <script src="<spring:url value="${js}/sys.beforeParser.js"/>"></script>
    <link href="<spring:url value="${css}/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<spring:url value="${css}/bootstrap-submenu.min.css"/>"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="${css}/style.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="${easyuitheme}/easyui.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="${js}/easyui-icons/icon.css"/>">
    <link href="<spring:url value="${css}/multi-select.css"/>"
          rel="stylesheet">
    <sitemesh:write property='head'/>
    <style type="text/css">
        @media ( min-width : 768px) {
            /*原来body上面留白：padding: 20px 0px 0px 0px !important;*/
            body {
                padding: 0px 0px 0px 0px !important;
            }
            .navbar-brand img.logo {
                height: 35px;
            }
            /*body里面的container样式，左右不留白*/
            body > .container {
                width: auto !important;
                padding-right: -15px !important;
                padding-left: -15px !important;
                margin-right:-15px !important;
                margin-left: -15px !important;
            }
        }
    </style>
</head>
<body>
    <sitemesh:write property='body' />
</body>
<script src="<spring:url value="${js}/bootstrap/bootstrap.min.js"/>"></script>
<script src="<spring:url value="${js}/hack/ie10-viewport-bug-workaround.js"/>"></script>
<script src="<spring:url value="${easyuiver}/jquery.easyui.min.js"/>"></script>
<script src="<spring:url value="${easyuiver}/locale/easyui-lang-zh_CN.js"/>"></script>
<script src="<spring:url value="${easyuiver}/easyloader.js"/>"></script>
<script src="<spring:url value="${js}/sys.common.js"/>"></script>
<script src="<spring:url value="${js}/validatebox_extend_rules.js"/>"></script>
<script src="<spring:url value="${js}/jquery.multi-select.js"/>"></script>
<script src="<spring:url value="${js}/moment.js"/>"></script>
<sitemesh:write property='script' />
</html>
