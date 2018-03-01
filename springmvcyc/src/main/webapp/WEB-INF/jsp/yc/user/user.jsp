<%--
  Created by IntelliJ IDEA.
  User: td-wh
  Date: 18-2-24
  Time: 下午4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
<div>
    <table class="easyui-datagrid" style="width:400px;height:250px"
           data-options="url:'user/showUser',fitColumns:true,singleSelect:true">
        <thead>
        <tr>
            <th data-options="field:'id',width:100">主键</th>
            <th data-options="field:'type',width:100">类型</th>
        </tr>
        </thead>
    </table>

</div>
</body>
</html>
