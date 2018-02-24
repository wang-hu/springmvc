var _preload=
"		<div id=\"loading-mask\""+
"			style=\"position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #ddd; z-index: 20000\">"+
"			<div id=\"pageloading\""+
"				style=\"position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #888; width: 200px; height: 20px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #222;\">"+
"				<span class=\"panel-loading \"></span> 正在加载中,请稍候..."+
"			</div>"+
"		</div>";
document.write(_preload);

function removePreload(){
	$("#loading-mask").css("display", "none");
}