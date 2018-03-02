<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<spring:url value="/resources/css/default/frame/font-awesome.css"/>"
          rel="stylesheet">
    <link href="<spring:url value="/resources/css/default/frame/style.min.css?v=1.0.0"/>"
          rel="stylesheet">
    <style type="text/css">

    </style>
</head>
<body>
<div class="container">
<div id="cc" class="easyui-layout" style="width: 600px;height:600px;">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">

    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:10%;">

    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;width:90%;">

    </div>
</div>
</div>
</body>
</html>
