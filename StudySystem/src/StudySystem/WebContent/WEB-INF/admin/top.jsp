<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>丫丫豆-都市信息平台</title>
<link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<script>	
</script>
<style>
#header {
	height: 37px;
	background: #f4f1e8;
	border-bottom: #bdbdbd 1px solid;
}

#header h3 {
	height: 37px;
	line-height: 37px;
	color: #c32c33;
	padding-left: 30px;
}
</style>
</head>

<body>

	<div id="header">
		<h3>欢迎你:${user.name}</h3>
	</div>

</body>
</html>