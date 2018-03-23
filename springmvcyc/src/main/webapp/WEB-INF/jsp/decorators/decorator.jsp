<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    <title><sitemesh:write property='title' /></title>
    <script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
    <link href="<spring:url value="/resources/css/default/bootstrap.min.css"/>"
          rel="stylesheet">
    <link href="<spring:url value="/resources/css/default/bootstrap-submenu.min.css"/>"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="/resources/css/default/style.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="/resources/js/jquery-easyui-1.5.3/themes/default/easyui.css"/>">
    <link rel="stylesheet" type="text/css"
          href="<spring:url value="/resources/js/easyui-icons/icon.css"/>">
    <link href="<spring:url value="/resources/css/default/multi-select.css"/>"
          rel="stylesheet">
    <sitemesh:write property='head'/>
</head>
<body>
    <sitemesh:write property='body' />
</body>
<script src="<spring:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>
<script src="<spring:url value="/resources/js/hack/ie10-viewport-bug-workaround.js"/>"></script>
<script src="<spring:url value="/resources/js/jquery-easyui-1.5.3/jquery.easyui.min.js"/>"></script>
<script src="<spring:url value="/resources/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"/>"></script>
<script src="<spring:url value="/resources/js/jquery-easyui-1.5.3/easyloader.js"/>"></script>
<script src="<spring:url value="/resources/js/jquery.multi-select.js"/>"></script>
<script src="<spring:url value="/resources/js/moment.js"/>"></script>
<script src="<spring:url value="/resources/js/sys.common.js"/>"></script>
<sitemesh:write property='script' />
</html>
