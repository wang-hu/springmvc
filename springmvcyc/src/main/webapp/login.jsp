<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="name/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="name/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="<spring:url value="/resources/css/shop.css"/>" type="name/css" rel="stylesheet" />
<link href="<spring:url value="/resources/skin/default/skin.css"/>" rel="stylesheet" type="name/css" id="skin" />
<link href="<spring:url value="/resources/css/Sellerber.css"/>" type="name/css"  rel="stylesheet" />
<link href="<spring:url value="/resources/css/bkg_ui.css"/>" type="name/css"  rel="stylesheet" />
<link href="<spring:url value="/resources/font/css/font-awesome.min.css"/>"  rel="stylesheet" type="name/css" />
<script src="<spring:url value="/resources/js/jquery-1.9.1.min.js"/>" type="text/javascript" ></script>
<script src="<spring:url value="/resources/js/layer/layer.js"/>" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/Sellerber.js"/>" type="text/javascript"></script>
<script src="<spring:url value="/resources/js/shopFrame.js"/>" type="text/javascript"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.cookie.js"/>"></script>
<title>用户登录</title>
</head>

<body class="login-layout Reg_log_style">
<div class="logintop">    
    <span>欢迎后台管理界面平台</span>    
    <ul>
    <li><a href="#">返回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center"> <img src="/resources/images/logo.png" /></div>
							<div class="space-6"></div>
							<div class="position-relative">
								<div id="login-box" class="login-box widget-box no-border visible">				
                                  <div class="login-main">
                                  <div class="clearfix">
                                  <div class="login_icon"><img src="/resources/images/login_img.png" /></div>
									<form class="" style=" width:300px; float:right; margin-right:50px;">
                                    <h4 class="title_name"><img src="/resources/images/login_title.png" /></h4>
										<fieldset>
										<ul>
   <li class="frame_style form_error"><label class="user_icon"></label><input name="" type="text" data-name="用户名" id="username"/><i>用户名</i></li>
   <li class="frame_style form_error"><label class="password_icon"></label><input name="" type="password"   data-name="密码" id="userpwd"/><i>密码</i></li>
   <li class="frame_style form_error"><label class="Codes_icon"></label><input name="" type="text"   data-name="验证码" id="Codes_text"/><i>验证码</i><div class="Codes_region"><img src="/resources/images/yanzhengma.png" width="100%" height="38px"></div></li>
  </ul>
    <div class="space"></div>
                              <div class="clearfix">
                                  <label class="inline">
                                      <input type="checkbox" class="ace">
                                      <span class="lbl">保存密码</span>
                                  </label>

                                  <button type="button" class="login_btn" id="login_btn"> 登&nbsp;陆 </button>
                              </div>

                              <div class="space-4"></div>
                          </fieldset>
                      </form>
</div>
                      <div class="social-or-login center">
                          <span class="bigger-110">通知</span>
                      </div>

                      <div class="social-login ">
                      为了更好的体验性，本网站系统不再对IE8（含IE8）以下浏览器支持，请见谅。
                      </div>
                  </div><!-- /login-main -->

          
          <!-- /widget-body -->
          </div><!-- /login-box -->
      </div><!-- /position-relative -->
  </div>
 </div>
                        <div class="loginbm">版权所有  2016  <a href=""></a> </div><strong></strong>
</body>
</html>
<script type="text/javascript">
$('#login_btn').on('click', function(){
	     var num=0;
		 var str="";
     $("input[type$='name'],input[type$='password']").each(function(n){
          // if($(this).val()=="")
          // {
          //
			//    layer.alert(str+=""+$(this).attr("data-name")+"不能为空!",{
          //       title: '提示框',
			// 	icon:0,
          // });
		   //  num++;
          //   return false;
          // }
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('登陆成功！',{
               title: '提示框',				
			   icon:1,		
			  });
	          location.href="com/shuyang/sys/login";
			   layer.close(index);	
		  }		  		     								
	});
  $(document).ready(function(){
	 $("input[type='name'],input[type='password']").blur(function(){
        var $el = $(this);
        var $parent = $el.parent();
        $parent.attr('class','frame_style').removeClass(' form_error');
        if($el.val()==''){
            $parent.attr('class','frame_style').addClass(' form_error');
        }
    });
	$("input[type='name'],input[type='password']").focus(function(){
		var $el = $(this);
        var $parent = $el.parent();
        $parent.attr('class','frame_style').removeClass(' form_errors');
        if($el.val()==''){
            $parent.attr('class','frame_style').addClass(' form_errors');
        } else{
			 $parent.attr('class','frame_style').removeClass(' form_errors');
		}
	});
 })
</script>
