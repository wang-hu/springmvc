$(document).ready(function()
{
    $.sys.disableBackSpace();
});

/** ajax 全局参数 */
$.ajaxSetup({
    traditional : true,// 传统方式序列化参数 而不是a[]=1&&a[]=2
    contentType : 'application/x-www-form-urlencoded;  charset=UTF-8', // 确保ie下中文不乱码
    complete : function(XMLHttpRequest, textStatus) {

    },
    error:function(XMLHttpRequest, textStatus, errorThrown){
        var result = $.parseJSON(XMLHttpRequest.responseText);
        var msg="";

        msg=msg+"类型："+result.status;
        msg=msg+"<br>消息："+result.message;
        msg=msg+"<br>NO&nbsp;："+result.errid;
        $.messager.show({height:120,title:result.error,msg:msg});
    }
});

/*******************************************************************************
 * sys包 系统核心功能函数
 ******************************************************************************/
(function($) {
    /**
     * 将形如param1=x1&param2=x2&obj.name=name的form转化为
     * JSON{param1:x1,param2:x2,obj:{name:name}}
     *
     * @e.g. var json=$(formSelector).form2json();
     */
    $.fn.form2json = function() {
        var serializedParams = this.serialize();
        var obj = paramString2obj(serializedParams);
        return obj;
    };
    /**
     * 将形如param1=x1&param2=x2&obj.name=name的form转化为
     * JSON{param1:x1,param2:x2,obj.name:name}}
     *
     * @e.g. var param=$(formSelector).form2param();
     */
    $.fn.form2param = function() {
        var serializedParams = this.serialize();
        var obj = paramString2Param(serializedParams);
        return obj;
    };
    /**
     * 简单的隐藏POST提交
     * */
    $.fn.formPost = function (url,json) {
        var form = $("<form></form>");
        form.attr('action', url);
        form.attr('method', 'post');
        form.attr('target', '_self');
        var token = $("meta[name='_csrf']").attr("content");
        form.append("<input type='hidden' name='_csrf' value='"+token+"' /> ")
        for(var name in json){
            var input1 = $("<input type='hidden' name='"+name+"' />");
            input1.attr('value', json[name]);
            form.append(input1);
        }
        form.appendTo("body");
        form.css('display', 'none');
        form.submit();
        form.remove();
    };
    /**
     * 给json对象加前缀
     *
     * @param json
     *            json对象
     * @param perfix
     *            前缀
     * @e.g. var newJson=$.Json2Perfix(oldJson,"perfix");
     */
    $.Json2Perfix = function(json, perfix) {
        var data = $.param(json);
        data = data.replace(/(&?)(\w*)(=)/g, "$1" + perfix + "." + "$2$3");
        return paramString2Param(data);
    };

    /**
     * 将形如param1=x1&param2=x2&obj.name=name的串转化为JSON
     * {param1:x1,param2:x2,obj:{name:name}}
     */
    function paramString2obj(serializedParams) {
        var obj = {};
        function evalThem(str) {
            var attributeName = str.split("=")[0];
            var attributeValue = str.split("=")[1];
            if (!attributeValue) {
                return;
            }
            var array = attributeName.split(".");
            for ( var i = 1; i < array.length; i++) {
                var tmpArray = Array();
                tmpArray.push("obj");
                for ( var j = 0; j < i; j++) {
                    tmpArray.push(array[j]);
                }

                var evalString = tmpArray.join(".");
                if (!eval(evalString)) {
                    eval(evalString + "={};");
                }
            }
            ;
            //eval("obj." + attributeName + "='" + decodeURI(attributeValue)+ "';");
            var attr=attributeValue.replace(/\+/g, '%20');
            attr=decodeURIComponent(attr);
            attr=attr.replace(/\n/g, '\\n');
            attr=attr.replace(/\r/g, '\\r');
            var expr="obj." + attributeName + "='" + attr + "';";
            eval(expr);
        }
        ;
        var properties = serializedParams.split("&");
        for ( var i = 0; i < properties.length; i++) {
            evalThem(properties[i]);
        }
        ;
        return obj;
    }

    /**
     * 将形如param1=x1&param2=x2&obj.name=name的串转化为JSON
     * {param1:x1,param2:x2,obj.name:name}}
     */
    function paramString2Param(serializedParams) {
        var obj = {};
        function evalThem(str) {
            var attributeName = str.split("=")[0];
            var attributeValue = str.split("=")[1];
            if (!attributeValue) {
                return;
            }
            //obj[attributeName] = decodeURI(attributeValue);
            obj[attributeName]=decodeURIComponent(attributeValue.replace(/\+/g, '%20'));
        }
        ;
        var properties = serializedParams.split("&");
        for ( var i = 0; i < properties.length; i++) {
            evalThem(properties[i]);
        }
        ;
        return obj;
    }

    /**
     * 通用异步form 提交
     * @param fmSelector form 选择器
     * @param urls       执行url
     * @param callback   执行成功时的回调函数
     * @param btnID   按钮ID 暂时不可用 提交后恢复
     */
    function fmSubmit(fmSelector,urls,success,complete,btnID){
        var hasBtn=false;
        if(btnID){
            hasBtn=true;
            $(btnID).linkbutton("disable");
        }
        $(fmSelector).form("submit",{
            url: urls,
            onSubmit: function(){
                var flag=$(this).form("validate");
                if(!flag&&hasBtn)$(btnID).linkbutton("enable");
                if(flag)$.messager.progress({msg:"处理中.."});
                return flag;
            },
            success: function(rs){
                try {
                    var result = eval("("+rs+")");
                    //alert(result);
                    if(success)success(result);
                    else{
                        if (result.success){
                            $.messager.show({title: "成功",msg: result.msg});
                        } else {
                            $.messager.show({title: "错误",msg: result.msg});
                        }
                    }

                } catch (e) {
                    try {
                        var patt1 = /<h1\s*class="error"\s*>.*<\/h1>/;
                        var html  = patt1.exec(rs)+"";
                        var error = html.replace(/<\/?[^>]*>/g, "");
                    }catch (e){}
                    if(error==undefined||error=="null")error="不可预料的内部错误:"+e.message;
                    $.messager.show({title: "错误",msg: error});
                } finally{
                    if(complete)complete();
                    $.messager.progress("close");
                    if(hasBtn)$(btnID).linkbutton("enable");
                }


            }
        });
    }

    /**
     * 通用AJAX POST 提交
     *
     * @param url
     *            执行url
     * @param data
     *            参数
     * @param success
     *            成功回调函数
     */
    function dgPost(url, data,success,complete,btnID,progress) {
        if(btnID){
            $(btnID).linkbutton("disable");
        }
        if(progress){
            $.messager.progress({msg:"处理中.."});
        }
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            dataType: "json",
            success: function (result) {
                if(success)success(result);
                else{
                    if (result.success){
                        $.messager.show({title: "成功",msg: result.msg});
                    } else {
                        $.messager.show({title: "错误",msg: result.msg});
                    }
                }
            },
            complete: function (xhr) {
                if(complete)complete(xhr);

                if(btnID)$(btnID).linkbutton("enable");
                if(progress)$.messager.progress("close");
            }
        });
    }

    /**
     * 自动登出
     *
     * @param remain
     *            剩余时间
     */
    function stayLogin(remain) {
        var clock={};
        if (Number(remain) <= 80) {

            var dia = $("<div style=\"width:240px;height:150px;padding:10px 10px;\"><span id=\"sys_staylogin_msg\"></span></div>");
            dia.dialog({
                closed : false,
                resizable : true,
                modal : true,
                title : "安全登出",
                onClose : function() {
                    $(dia).dialog("destroy");
                    clearInterval(clock);
                },
                buttons : [ {
                    text : '保持登录',
                    plain : true,
                    iconCls : 'icon-ok',
                    handler : function() {
                        $.post("wel_stay");// <=========== here
                        $(dia).dialog("close");
                    }
                } ]
            });

            clock = setInterval(function() {
                remain = remain - 1;
                if (remain < 0) {
                    clearInterval(clock);
                    window.location.replace("/logout.do");
                } else {
                    $("#sys_staylogin_msg").html("" + remain + "秒后将自动登出");
                }
                ;
            }, 1000);

        }

    }
    /** 页面禁止拷贝 */
    function disableCopy() {
        document.oncontextmenu = function(e) {
            return false;
        };
        document.onselectstart = function(e) {
            return false;
        };
        $("body").css("-moz-user-select", "none");
    }
    /** 页面禁止后退 */
    function disableBackSpace(){
        function forbidBackSpace(e) {
            var ev = e || window.event; //获取event对象
            var obj = ev.target || ev.srcElement; //获取事件源
            var t = obj.type || obj.getAttribute('type'); //获取事件源类型
            //获取作为判断条件的事件类型
            var vReadOnly = obj.readOnly;
            var vDisabled = obj.disabled;
            //处理undefined值情况
            vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;
            vDisabled = (vDisabled == undefined) ? true : vDisabled;
            //当敲Backspace键时，事件源类型为密码或单行、多行文本的，
            //并且readOnly属性为true或disabled属性为true的，则退格键失效
            var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true);
            //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
            var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";
            //判断
            if (flag2 || flag1) return false;
        }
        //禁止后退键 作用于Firefox、Opera
        document.onkeypress = forbidBackSpace;
        //禁止后退键  作用于IE、Chrome
        document.onkeydown = forbidBackSpace;

    }
    /**
     * @param opts
     * @useage
     * bindEnter({
	 *		def:function(){alert(1);},
	 *		type:[{id:"#industry_dlg",handler:function(){alert(2);}},
	 *		 {id:"#product_dlg",handler:function(){alert(3);}}]
	 *	});
     */

    function bindEnter(opts) {
        $(document).keypress(function(e) {
            // 回车键事件
            if(e.which == 13) {
                if(opts.type){
                    for(x in opts.type){
                        if(!$(opts.type[x].id).panel("options").closed){
                            opts.type[x].handler();return;
                        }
                    }
                }
                if(opts.def)
                    opts.def();
            }
        });
    }
    /**
     * ☆★★★★★注册函数到sys包为jQuery的静态方法★★★★★★★★★★★☆
     *
     * @e.g. $.sys.fmSubmit(fmSelector, url, callback);
     */
    $.sys = {
        fmSubmit : fmSubmit,
        dgPost : dgPost,
        stayLogin : stayLogin,
        disableCopy : disableCopy,
        disableBackSpace : disableBackSpace,
        bindEnter : bindEnter
    };
})(jQuery);