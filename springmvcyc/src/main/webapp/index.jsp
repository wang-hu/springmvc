<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
<form method="post" action="/yc/login">
    登录名：<input type="text">
    密码：<input type="password">
    <button type="submit">提交</button>
</form>

<div>
    <table class="easyui-datagrid" style="width:400px;height:250px"
           data-options="url:'user/showUser',fitColumns:true,singleSelect:true">
        <thead>
        <tr>
            <th data-options="field:'code',width:100">Code</th>
            <th data-options="field:'name',width:100">Name</th>
            <th data-options="field:'price',width:100,align:'right'">Price</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>