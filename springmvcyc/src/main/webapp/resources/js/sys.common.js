/*******************************************************************************
 * 初始化参数
 ******************************************************************************/
$(document).ready(function()
{
    $.sys.disableBackSpace();
});


/**
 * ☆★★★★★注册函数到sys包为jQuery的静态方法★★★★★★★★★★★☆
 *
 */
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
                            $.messager.alert({title: "成功",msg: result.msg,icon:'info'});
                        } else {
                            $.messager.alert({title: "错误",msg: result.msg,icon:'error'});
                        }
                    }

                } catch (e) {
                    try {
                        var patt1 = /<p\s*class="lead"\s*>.*<\/p>/;
                        var html  = patt1.exec(rs)+"";
                        var error = html.replace(/<\/?[^>]*>/g, "");
                    }catch (e){}
                    if(error==undefined||error=="null")error="不可预料的内部错误:"+e.message;
                    //$.messager.show({title: "错误",msg: error});
                    $.messager.alert('错误', error, 'error');
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
                        $.messager.alert({title: "成功",msg: result.msg,icon:'info'});
                    } else {
                        $.messager.alert({title: "错误",msg: result.msg,icon:'error'});
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


    $.sys = {
        fmSubmit : fmSubmit,
        dgPost : dgPost,
        stayLogin : stayLogin,
        disableCopy : disableCopy,
        disableBackSpace : disableBackSpace,
        bindEnter : bindEnter
    };
})(jQuery)
