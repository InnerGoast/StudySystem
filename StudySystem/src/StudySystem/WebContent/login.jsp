<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" /> 
	<title>YY-MAN</title>
	<link rel = "Shortcut Icon" href="images/yydou.ico">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/controls.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
	<!-- header -->
	<div class="header">
		<div class="top_nav">
			<div class="container clear">
				<a class="left" href="#">【进入后台】</a>
				<span class="right">
					<a href="#">设为主页</a>
					<font>-</font>
					<a href="#">收藏本页</a>
					<font>-</font>
					<a href="#">联系我们</a>
				</span>
			</div>
		</div>
		<div class="nav">
			<div class="container clear">
				<a href="index.html" class="left brand"><img src="images/heading.png" alt=""></a>
				<div class="nav_bar right">
					<p>
						<a href="index.html">首<i></i>页</a>
						<a href="">招聘信息</a>
						<a href="">培训信息</a>
						<a href="">房屋信息</a>
						<a href="">求购信息</a>
						<a href="">招商引资</a>
						<a href="">求购信息</a>
					</p>
					<p>
						<a href="">招商引资</a>
						<a href="">公寓信息</a>
						<a href="">求职信息</a>
						<a href="">家教信息</a>
						<a href="">车辆信息</a>
						<a href="">出售信息</a>
						<a href="">寻找启示</a>
					</p>
				</div>
			</div>
			
		</div>
	</div>
	<!-- header end-->
	<!-- banner -->
	<div class="banner">
			<a href="#"><img style="display:block;width:100%" src="images/banner/banner1.jpg" alt=""></a>
	</div>
	<!-- banner end-->
	<!-- content -->
	<div class="content bg-f2f2f2">
		<div class="container">
			<!-- section1 -->
			<div class="section section1 clear t-p40 ">
				<!-- content_main -->
				<div class="bg-white">
					<div class="title">
						<h2>登录<span style="color:red">${msg}</span></h2>
					</div>
					<style type="text/css">
							.section_body { padding-right: 100px; background: url('./images/login_bg.jpg') no-repeat left center;}
							.section_body form { *width: 340px;  padding-top: 60px; padding-bottom: 20px;}
							.section_body form p>input { width: 280px;  line-height: 26px; height: 26px; padding-left: 10px; }
							.section_body form p { line-height: 28px; padding-bottom: 20px;}
							.section_body label { color: #666666;}
							.section_body label input { margin-right: 10px;} 
							.section_body form p>a { margin-left: 10px; color: #666666;}
							.section_body form p>a:hover { color: red;}
							.section_body .btn { color: #333333; padding: 0; width: 78px; border: 1px solid #cccccc; background: #f1eeee;}
					</style>
					<div class="section_body">
						<form  class="right" action="${pageContext.request.contextPath}/loginServlet" method="post">
							<p class="f14 c-666666" >账号：<input  type="text" name="username" placeholder="请输入账号"></p>
							<p class="f14 c-666666" >密码：<input  type="password" name="password" placeholder="请输入密码"></p>
							<p class="clear"><label style="margin-left: 40px" class="left" for=""><input class="text-middle" type="checkbox">自动登录</label><a class="right" href="#">[注册新账号]</a><a class="right" href="#">[忘记密码] </a></p>
							<p class="text-center"><input class="btn" type="submit" value="确定"></p>
						</form>
					</div>
				</div>
				<!-- content_main -->
				<!-- content_sidebar -->
				<!-- content_sidebar end-->
			</div>
			<!-- section1 end-->
			<!-- section2 -->
			<!-- section2 end-->
			
		</div>
	</div>
	<!-- content end-->
	<!-- footer-->
	<div class="footer">
		<div class="footer_body">
			<span class="rightcopy"> Copyright ©360.cn. All Rights Reserved. 京ICP证080047号 京公网安备110000000006号</span>
		</div>
	</div>
	<!-- footer end-->
</body>

</html>