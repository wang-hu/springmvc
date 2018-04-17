<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<div class="container">
    <div class="fixContainer">
        <div id="toolbar" style="padding: 10px;">
            <form id="queryfm" style="margin: 0">
                登录名称： <input type="text" name="login_name" class="easyui-textbox"/>
                显示名称: <input type="text" name="nick_name" class="easyui-textbox"/>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="doQuery()">查询</a> <a
                    class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
                    onclick="doReset()">重置</a>
                <br>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addUser()">增加</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editUser()">修改</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="delUser()">删除</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-role',plain:true" onclick="showAuthority()">角色权限</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-group',plain:true" onclick="showGroups()">用户组权限</a>
                <!--
                <a class="easyui-linkbutton" data-options="iconCls:'icon-group'"
                onclick="opendlg()">ceshi</a>
                -->
                <a class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"
                   onclick="resetPW()">重置密码</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-unlock',plain:true"
                   onclick="unlock()">解锁帐号</a>
            </form>
        </div>
        <table id="data1" class="easyui-datagrid"
               data-options="fit:true,toolbar:'#toolbar',
                           pagination:true,singleSelect:true" >
            <thead>
            <tr class="header">
                <th data-options="field:'login_name',align:'center',width:100">登录名称</th>
                <th data-options="field:'nick_name',align:'center',width:150">
                    显示名称
                </th>
                <th data-options="field:'org_name',align:'center',width:150">
                    所在组织
                </th>
                <th data-options="field:'dept_name',align:'center',width:150">
                    所在部门
                </th>
                <th
                        data-options="field:'action',align:'center',width:200">
                    功能
                </th>

            </tr>
            </thead>
        </table><!--end of data1 -->


        <!-- 编辑窗口 -->
        <div id="dlg" class="easyui-dialog small_easyui_dlg"
             data-options="closed:true,resizable:true,modal:true,
        buttons:[
        { text:'保存',iconCls:'icon-ok', handler:function(){saveData();} },
        { text:'取消',iconCls:'icon-cancel', handler:function(){$('#dlg').dialog('close');} }]"
             style="padding: 30px 20px;">

            <form id="fm" method="post" class="easyuidlg">
                <input type="hidden" name="user_id" id="user_id" value=""/>
                <div class="form-group ">
                    <label> 登录名称： </label> <input type="text" name="login_name" id="login_name"
                                                  class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="form-group ">
                    <label> 显示名称： </label> <input type="text" name="nick_name"
                                                  class="easyui-validatebox" data-options="required:true"/>
                </div>
                <div class="form-group ">
                    <label> 所属组织： </label> <input type="text" name="org_id"
                                                  style="width: 75%" id="org_search" data-options="required:true"/>
                </div>
                <div class="form-group ">
                    <label> 所属部门： </label> <input type="text" name="dept_id"
                                                  style="width: 75%" id="dept_search"/>
                </div>

            </form>
        </div>


        <!-- 编辑窗口 -->
        <div id="authoritydlg" class="easyui-dialog"
             data-options="closed:true,resizable:true,modal:true,title:'用户权限设置',
        buttons:[
        { text:'保存',iconCls:'icon-ok', id:'authorityBtn', handler:function(){saveChange();} },
        { text:'取消',iconCls:'icon-cancel', handler:function(){$('#authoritydlg').dialog('close');} }]"
             style="width: 450px; height: 380px; padding: 30px 20px;">


            <!--
            <input type="text" class="easyui-combobox" id="authoritychoose"
            name="authoritychoose" style="width:100%;height:50px;" data-options="
            url:CTX_PATH+'sys/authority_get.json',
            multiple:true,multiline:true,
            panelHeight:'auto',
            editable:false,required:true,
            valueField:'authority',
            textField:'auth_name'"/> -->
            <select id='authoritychoose' name="authoritychoose" multiple='multiple'>
            </select>

        </div>

        <!-- 编辑窗口 -->
        <div id="groupdlg" class="easyui-dialog"
             data-options="closed:true,resizable:true,modal:true,title:'用户所属组',
        buttons:[
        { text:'保存',iconCls:'icon-ok', id:'groupBtn', handler:function(){saveGroupChange();} },
        { text:'取消',iconCls:'icon-cancel', handler:function(){$('#groupdlg').dialog('close');} }]"
             style="width: 400px; height: 320px; padding: 30px 20px;">

            <div id="groupshow" align="center">
                <input type="text" class="easyui-combobox" id="groupchoose"
                       name="groupchoose" style="width:100%;height:50px;" data-options="
        multiple:true,multiline:true,
        panelHeight:'auto',
        editable:false,required:true,
        valueField:'group_id',
        textField:'group_name'"/>
            </div>
        </div>
        <div id="testdlg"></div>

    </div>
</div><!--end of container -->
</body>
</html>
<myScript>

    <script type="text/javascript">
        $(document).ready(function () {

        });

        function doQuery() {
            var fmdata = $("#queryfm").form2json();
            $("#data1").datagrid("load", fmdata);
        }

        function doReset() {
            $("#queryfm").form("reset");

        }

        var url;

        function addUser() {

            $("#dlg").dialog("open").dialog("setTitle", "新增");
            $("#login_name").removeAttr("readonly");
            $("#fm").form("reset");
            url = CTX_PATH + "sys/user_add.do";
        }

        function editUser(index) {
            if (index || index == 0) {
                $("#data1").datagrid("selectRow", index);
            }
            var row = $("#data1").datagrid("getSelected");

            if (row) {
                $("#dlg").dialog("open").dialog("setTitle", "编辑");
                $("#login_name").attr("readonly", true);//设为只读
                $("#fm").form("load", row);
                $("#org_search").combogrid("setText", row.org_name);
                $("#dept_search").combogrid("options").curr_text = row.dept_name;
                url = CTX_PATH + "sys/user_edit.do";
            } else {
                $.messager.alert("警告", "请选择要修改的数据");
            }
        }

        function saveData() {
            if ($("#fm").form("validate") == false)
                return;
            var datafm = $("#fm").form2json();
            $.post(url, datafm, function (result) {
                if (result.success) {
                    $("#dlg").dialog("close");
                    $("#data1").datagrid("reload");
                    $.messager.alert("提示", result.msg);
                } else
                    $.messager.show({
                        title: "错误",
                        msg: result.msg
                    });
            }, "json");

        }

        function delUser(index) {
            if (index || index == 0) {
                $("#data1").datagrid("selectRow", index);
            }
            var row = $("#data1").datagrid("getSelected");
            if (row) {

                $.messager.confirm("确认", "是否删除用户[" + row.login_name + "]", function (r) {
                    if (r) {
                        $.post(CTX_PATH + "sys/user_del.do", row, function (result) {
                            if (result.success) {
                                $("#data1").datagrid("reload");
                                $.messager.show({
                                    title: "成功",
                                    msg: result.msg
                                });
                            } else
                                $.messager.show({
                                    title: "错误",
                                    msg: result.msg
                                });
                        }, "json");
                    }
                });

            } else {
                $.messager.alert("警告", "请选择要删除的数据");
            }
        }

        //显示权限列表
        function showAuthority(index) {

            if (index) {
                $("#data1").datagrid("selectRow", index);
            }
            var row = $("#data1").datagrid("getSelected");
            if (row) {
                $("#authoritydlg").dialog("open");
                $("#authorityBtn").linkbutton("enable");


                $.post(CTX_PATH + "sys/authority_ById.do", row,
                    function (result) {
                        if (result) {

                            $('#authoritychoose').html('');

                            for (var x1 in result.unselected) {
                                var auth = result.unselected[x1];
                                $('#authoritychoose').append("<option value='" + auth.authority + "'>" + auth.auth_name + "</option>");
                            }
                            for (var x2 in result.disabled) {
                                var auth = result.disabled[x2];
                                $('#authoritychoose').append("<option value='" + auth.authority + "' selected disabled > "+auth.auth_name+" < /option>");
                            }
                            for (var x3 in result.selected) {
                                var auth = result.selected[x3];
                                $('#authoritychoose').append("<option value='" + auth.authority + "' selected>" + auth.auth_name + "</option>");
                            }
                            $('#authoritychoose').multiSelect('refresh');

                        } else {
                            $.messager.alert('错误', '加载出错。');
                        }
                    }, 'json');
            } else {
                $.messager.alert("警告", "请选择一个用户");
            }

        }

        function saveChange() {
            //var authorities = $('#authoritychoose').combobox('getValues');
            var authorities = $('#authoritychoose').val();
            if (authorities == null) authorities = [];
            var row = $("#data1").datagrid("getSelected");
            $.post(CTX_PATH + "sys/authority_save.do", {
                user_id: row.user_id,
                authorities: authorities
            }, function (result) {
                if (result.success) {
                    $("#authoritydlg").dialog("close");
                    $("#data1").datagrid("reload");
                    $.messager.show({
                        title: "成功",
                        msg: result.msg
                    });
                } else {
                    $.messager.show({
                        title: "错误",
                        msg: result.msg
                    });
                }
            }, "json");
        }

        //显示用户组列表
        function showGroups(index) {
            if (index) {
                $("#data1").datagrid("selectRow", index);
            }
            var row = $("#data1").datagrid("getSelected");
            if (row) {
                $("#groupdlg").dialog("open");
                $("#groupBtn").linkbutton("enable");
                $.post(CTX_PATH + "sys/group_ById.do", row,
                    function (result) {
                        if (result) {
                            var t = [];
                            jsonList = result;
                            for (var i = 0; i < jsonList.length; i++) {
                                t[i] = jsonList[i].group_id;
                            }
                            $('#groupchoose').combobox('setValues', t);
                        } else {
                            $.messager.alert('错误', '加载出错。');
                        }
                    }, 'json');

            } else {
                $.messager.alert('警告', '请选择一个用户');
            }
        }

        function fmAction(value, row, index) {
            var blank = "&nbsp;&nbsp;";
            var str = "<span title='用户修改' class='icon-edit spbtn' onclick='editUser("
                + index + ")'>" + blank + blank + "</span>" + blank;
            str = str
                + "<span title='用户删除' class='icon-remove spbtn' onclick='delUser("
                + index + ")'>" + blank + blank + "</span>" + blank;

            str = str
                + "<span title='角色赋权' class='icon-role spbtn' onclick='showAuthority("
                + index + ")'>" + blank + blank + "</span>" + blank;
            str = str
                + "<span title='用户组赋权' class='icon-group spbtn' onclick='showGroups("
                + index + ")'>" + blank + blank + "</span>" + blank;
            return str;
        }

        function saveGroupChange() {
            var groups = $('#groupchoose').combobox('getValues');
            if (groups == null) groups = [];
            var row = $("#data1").datagrid("getSelected");
            $.post(CTX_PATH + "/sys/group_save.do", {user_id: row.user_id, group_id: groups}, function (result) {
                if (result.success) {
                    $("#groupdlg").dialog("close");
                    $("#data1").datagrid("reload");
                    $.messager.show({
                        title: "成功",
                        msg: result.msg
                    });
                } else
                    $.messager.show({
                        title: "错误",
                        msg: result.msg
                    });
            }, "json");

        }


        function opendlg() {
            $.ui.multiselect("#testdlg", "dialog").dialog("open");
        }


        //重置密码
        function resetPW() {
            var row = $("#data1").datagrid("getSelected");
            if (row) {
                $.messager.confirm("确认", "是否重置密码", function (r) {
                    if (r) {
                        $.post(CTX_PATH + "sys/user_resetPw.do", row, function (result) {
                            if (result.success) {
                                $.messager.alert("提示", "密码重置为：" + result.msg);
                            } else {
                                $.messager.show({
                                    title: "错误",
                                    msg: result.msg
                                });
                            }
                        }, "json");
                    }
                });
            } else {
                $.messager.alert("警告", "请选择要重置密码的数据");
            }
        }

        //解锁帐号
        function unlock() {
            var row = $("#data1").datagrid("getSelected");
            if (row) {
                $.messager.confirm("确认", "是否解锁帐号", function (r) {
                    if (r) {
                        $.post(CTX_PATH + "sys/user_unlock.do", row, function (result) {
                            if (result.success) {
                                $.messager.show({title: "提示", msg: result.msg});
                            } else {
                                $.messager.show({
                                    title: "错误",
                                    msg: result.msg
                                });
                            }
                        }, "json");
                    }
                });
            } else {
                $.messager.alert("警告", "请选择要解锁的帐号");
            }
        }
    </script>
</myScript>