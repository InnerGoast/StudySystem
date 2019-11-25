<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" /> 
	<title>YY-MAN-D</title>
	<link rel = "Shortcut Icon" href="images/yydou.ico">
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/controls.css">
    <link rel="stylesheet" href="css/manage_details.css">
    <link rel="stylesheet" href="css/style.css">
	 <script src="js/jquery.min.js"></script>
</head>
<body>
	<!-- header -->
	<div class="header">
		<div class="top_nav">
			<div class="container clear">
				<a class="left" href="login.jsp">【进入后台】</a>
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
			<a href="#"><img style="display:block;width:100%" 
					src="images/banner/banner1.jpg" alt=""></a>
</div>
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
						<h2>${notice.type.name }</h2>
					</div>
					<div class="section_body">
						<h1 class="f24 c-333333">${notice.title }</h1>
						<small style="line-height: 20px;">${notice.publishDate }</small>
						<p class="f14 t-m20" style="line-height: 20px">${notice.content }</p>
						<br />
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