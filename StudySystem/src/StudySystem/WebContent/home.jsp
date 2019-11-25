<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" /> 
	<title>YY-MSN</title>
	<link rel = "Shortcut Icon" href="images/yydou.ico">
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/controls.css">
    <link rel="stylesheet" href="css/index.css">
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
	<!-- banner end-->
	<!-- content -->
	<div class="content bg-f2f2f2">
		<div class="container">
			<!-- section1 -->
			<div class="section section1 clear">
				<!-- content_main -->
				<div class="content_main left recommend bg-white">
					<div class="title">
						<h2>推荐信息</h2><h2 style="color:red">${msg}</h2>
					</div>
					<div class="section_body">
						<div class="wrap">
						   <c:forEach items="${notices}" var="notice">
						        <a href="${pageContext.request.contextPath}/NoticeServlet?method=findNoticeById&id=${notice.id}"><em>【${notice.type.name}】</em>${notice.title}</a>
						   </c:forEach>
							<!-- <a href="city_info.html"><em>【寻找启示】</em>寻找启示标题</a>
							<a href="city_info.html"><em>【出售信息】</em>出售信息标题</a>
							<a href="city_info.html"><em>【车辆信息】</em>车辆信息标题 </a>
							<a href="city_info.html"><em>【家教信息】</em>家教信息标题</a>
							<a href="#"><em>【求职信息】</em>求职信息标题</a>
							<a href="#"><em>【公寓信息】</em>公寓信息标题</a>
							<a href="#"><em>【招商引资】</em>招商引资标题</a>
							<a href="#"><em>【招商引资】</em>求购信息标题</a>
							<a href="#"><em>【房屋引资】</em>房屋引资标题</a>
							<a href="#"><em>【房屋引资】</em>培训信息标题</a>
							<a href="#"><em>【招聘信息】</em>招聘信息标题</a> -->
						</div>
					</div>
				</div>
				<!-- content_main -->
				<!-- content_sidebar -->
				<div class="content_sidebar right bg-white">
					<div class="sidebar quiz">
						<div class="title">
							<h2>客户提问</h2>
						</div>
						<div class="sidebar_body">
							<ul>
								<li><a href="city_info.html">唯品会（信义馆）成功签约</a></li>
								<li><a href="city_info.html">成功签约广东珠江食品公司</a></li>
								<li><a href="city_info.html">珠江新城富力盈凯办公室装修工程签约</a></li>
								<li><a href="#">广州三甲医疗公司设计签约成功</a></li>
								<li><a href="#">唯品会（信义馆）成功签约</a></li>
								<li><a href="#">唯品会（信义馆）成功签约</a></li>
							</ul>
						</div>
					</div>
					
				</div>
				<!-- content_sidebar end-->
			</div>
			<!-- section1 end-->
			<!-- section2 -->
			<div class="section t-m20 bg-white honour">
				<div class="title">
					<h2>资质证书</h2>
				</div>
				<div class="section_body">
					<div class="wrap">
						<img src="images/honour/honour1.jpg" alt="">
						<img src="images/honour/honour2.jpg" alt="">
						<img src="images/honour/honour3.jpg" alt="">
						<img src="images/honour/honour4.jpg" alt="">
						<img src="images/honour/honour5.jpg" alt="">
						<img src="images/honour/honour1.jpg" alt="">
						<img src="images/honour/honour2.jpg" alt="">
						<img src="images/honour/honour3.jpg" alt="">
						<img src="images/honour/honour4.jpg" alt="">
						<img src="images/honour/honour5.jpg" alt="">
					</div>
				</div>
			</div>
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