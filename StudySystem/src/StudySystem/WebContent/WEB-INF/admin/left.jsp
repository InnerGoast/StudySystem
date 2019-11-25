<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>丫丫豆-都市信息平台</title>
	<link href="/city_info/favicon.ico" rel="shortcut icon" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<script type="text/javascript">
		$(function(){
			
			$(".list").css({
				height:$(window).height() - 14	
			});
			$(window).resize(function(){
				$(".list").css({
					height:$(window).height() - 14	
				});	
			});
			$(".list").find("li").click(function(){
				$(".list").find("li").removeClass();
				$(this).addClass("list-active");	
			});
			
			/** 用户退出 */
			$("#exit").click(function(){
				if (confirm("您确定要退出系统吗？")){
					parent.window.location = "/city_info/logout.action";
				}
			});
		});
	</script>
	<style>
		#left{ width:171px; padding:0 0 0 9px; height:100%;}
		.list{ width:146px; padding:0 5px; border:#cbcbcb 1px solid; height:100%; background:#f4f1e8;}
		.list li{ height:40px; cursor:pointer; padding-left:18px; background:url(${pageContext.request.contextPath}/images/leftBg.png) 130px center no-repeat; line-height:40px; border-bottom:#c32c33 1px solid;}
		.list li:hover{ background:url(${pageContext.request.contextPath}/images/activeBg.png) left center no-repeat;}
		.list li:hover a{ color:#f4f1e8;}
		.list a{ color:#c32c33; display:block;}
		.list .list-active{ background:url(${pageContext.request.contextPath}/images/activeBg.png) left center no-repeat;}
		.list .list-active a{ color:#f4f1e8;}
	</style>
</head>


<body>

<div id="left">
	<div class="list">
    	<ul>
        	<li class="list-active"><a href="${pageContext.request.contextPath}/managerServlet" target="main">信息列表</a></li>
            <li><a href="${pageContext.request.contextPath}/addOrUpdateNoticeServlet" target="main">信息发布</a></li>
        	<li><a href="javascript:void(0);" id="exit">系统退出</a></li>
        </ul>
    </div>
</div>

</body>
</html>