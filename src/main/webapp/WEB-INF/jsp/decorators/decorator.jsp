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
    <link href="/resources/css/shop.css" type="text/css" rel="stylesheet" />
    <link href="/resources/css/Sellerber.css" type="text/css"  rel="stylesheet" />
    <%--<link href="/resources/css/bkg_ui.css" type="text/css"  rel="stylesheet" />--%>
    <link href="/resources/font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/resources/js/jquery-easyui-1.5.4.5/themes/default/easyui.css"/>
    <link href="/resources/js/easyui-icons/icon.css"  rel="stylesheet" type="text/css" />
    <sitemesh:write property='head'/>
</head>
<body>
    <sitemesh:write property='body' />
</body>
<script src="/resources/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="/resources/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js" type="text/javascript"></script>
<script src="/resources/js/jquery-easyui-1.5.4.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/resources/js/jquery.cookie.js"></script>
<script src="/resources/js/Sellerber.js" type="text/javascript"></script>
<script src="/resources/js/shopFrame.js" type="text/javascript"></script>
<script src="/resources/js/dist/echarts.js" type="text/javascript"></script>
<script src="/resources/js/jquery.nicescroll.js" type="text/javascript"></script>
<link href="/resources/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<script src="/resources/js/layer/layer.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/resources/js/laydate/laydate.js" type="text/javascript"></script>
<script src="/resources/js/hsCheckData.js" type="text/javascript"></script>
<script src="/resources/js/sys.common.js" type="text/javascript"></script>
<script src="/resources/js/moment.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="/resources/js/html5shiv.js" type="text/javascript"></script>
<script src="/resources/js/respond.min.js"></script>
<script src="/resources/js/css3-mediaqueries.js"  type="text/javascript"></script>
<![endif]-->
</html>
<sitemesh:write property='myScript' />
