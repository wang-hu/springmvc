<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="name/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>菜单设置</title>
</head>
<body class="label-hui">
<div class="margin clearfix" id="page_style">
    <div class="columns_list_style  clearfix inherit" id="Sellerber">
        <div class="Sellerber_left menu" id="menuBar">
            <div class="show_btn" id="rightArrow"><span></span></div>
            <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
            <div class="menu_style" id="menu_style">
                <div class="list_content">
                    <div class="side_list">
                        <div class="column_title"><h4 class="lighter smaller">系统栏目设置</h4></div>
                        <div class="Column_editing padding15">
                            <ul class="add_style">
                                <form id="fm" method="post">
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">栏目名称：</label><span
                                            class="Column_name col-xs-9">
				<input name="name" type="text" id="form-field-1" class="col-xs-8 col-sm-8"></span>
                                    </li>
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">所属分类：</label><span
                                            class="Column_name col-xs-9">
       	 	 <span id="cityDanXuan" class="col-xs-8 col-sm-8 fl_hsCheckData">   </span></span>
                                    </li>
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">排序：</label><span
                                            class="Column_name col-xs-9">
				<input name="menuOrder" type="text" id="form-field-3" class="col-xs-4 col-sm-4"></span>
                                    </li>
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">图标：</label><span
                                            class="Column_name col-xs-9">
				<input name="icon" type="text" id="form-field-5" class="col-xs-4 col-sm-8"></span>
                                    </li>
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">URL：</label><span
                                            class="Column_name col-xs-9">
				<input name="url" type="text" id="form-field-6" class="col-xs-4 col-sm-8"></span>
                                    </li>
                                    <li class="clearfix mb15">
                                        <label class="label_name col-xs-3 col-sm-3">显示位置：</label><span
                                            class="Column_name col-xs-9">
				<input name="" type="text" id="form-field-4" class="col-xs-8 col-sm-8"></span>
                                    </li>
                                    <%--<li class="clearfix mb15">--%>
                                    <%--<label class="label_name col-xs-3 col-sm-3">备注说明：</label><span class="Column_name col-xs-9"><textarea name="权限描述" class="form-control col-xs-10 col-sm-10" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea>--%>
                                    <%--<span class="wordage block l_f">剩余字数：<span id="sy" style="color:Red;">200</span>字</span>--%>
                                    <%--</span>--%>
                                    <%--</li>--%>
                                    <li class="clearfix mb15 align">
                                        <a href="javascript:void(0)" onclick="addMenu()" title="添加分类"
                                           class="btn button_btn bg-deep-blue"><i class="fa fa-plus"></i>添加分类</a>
                                    </li>
                                </form>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--数据展示-->
        <div class="list_show inherit">
            <div class="Column_display confirm detailed_style">
                <div class="title_name">栏目菜单功能区块展示设置</div>
                <div class="menu_Settings clearfix padding15">
                    <ul class="menu_operation" id="div1">
                        <li class="menu_title">系统首页</li>
                        <li>首页</li>
                        <li>地图展示</li>
                    </ul>
                    <ul class="menu_operation " id="div2">
                        <li class="menu_title">商品管理</li>
                        <li>品牌列表</li>
                        <li>商品列表</li>
                        <li>分类管理</li>
                    </ul>
                    <ul class="menu_operation" id="div3">
                        <li class="menu_title">交易管理</li>
                        <li>订单管理</li>
                        <li>退款管理</li>
                        <li>交易统计</li>
                        <li>订单处理</li>
                        <li>物流管理</li>
                        <li>订单统计</li>
                    </ul>
                    <ul class="menu_operation" id="div5">
                        <li class="menu_title">支付管理</li>
                        <li>支付配置</li>
                        <li>付款配置</li>
                    </ul>
                    <ul class="menu_operation" id="div6">
                        <li class="menu_title">支付管理</li>
                        <li>支付配置</li>
                        <li>付款配置</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<myScript>
    <script type="text/javascript">
        var url;
        $(document).ready(function () {
            url = 'listAllMenus';
            $.post(url, null, function (result) {
                if (result.success) {
                    $('#cityDanXuan').hsCheckData({
                        isShowCheckBox: false, //默认为false
                        data: result.object
                    });
                } else {
                    alert(result.msg);
                }
            });
        });
        //设置内页框架布局
        $(function () {
            $("#Sellerber").frame({
                float: 'left',
                color_btn: '.skin_select',
                Sellerber_menu: '.list_content',
                page_content: '.list_show',//内容
                datalist: ".menu_Settings",//数据列表高度取值
                mwidth: 400,//菜单栏宽度
                minStatue: true,
                drag: false,//是否启用拖拽功能水平拖拽
                dragclass: ".menu_operation",//选择移动参数
            });
        });

        /*字数限制*/
        function checkLength(which) {
            var maxChars = 200; //
            if (which.value.length > maxChars) {
                layer.open({
                    icon: 2,
                    title: '提示框',
                    content: '您输入的字数超过限制!',
                });
                // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
                which.value = which.value.substring(0, maxChars);
                return false;
            } else {
                var curr = maxChars - which.value.length; //250 减去 当前输入的
                document.getElementById("sy").innerHTML = curr.toString();
                return true;
            }
        };

        function addMenu() {
            var name = $('#form-field-1').val();
            if(name == null || name == '' || name == undefined)
                return;
            var datafm = $('#fm').form2json();
            var pid = $('#cityDanXuan').attr('data-id');
            datafm.pid = pid;
            url = "addMenu";
            $.post(url, datafm, function (result) {
                if (result.success) {
                    alert(result.msg)
                } else {
                    alert(result.msg);
                }
            });
        }
    </script>
</myScript>