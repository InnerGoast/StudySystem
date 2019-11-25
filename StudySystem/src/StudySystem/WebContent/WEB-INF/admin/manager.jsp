<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>丫丫豆-都市信息平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
</head>
<frameset rows="52,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/topServlet" name="title" scrolling="no" noresize="noresize">
  <frameset cols="180,*" frameborder="no" border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath}/leftServlet" name="tree" scrolling="no" marginheight="0" marginwidth="0">
   <%--  <frame src="${pageContext.request.contextPath}/managerServlet?thisPage=1" name="main" scrolling="yes" frameborder="0" marginwidth="0" marginheight="0" noresize="noresize"> --%>
    <frame src="${pageContext.request.contextPath}/NoticePageServlet?thisPage=1" name="main" scrolling="yes" frameborder="0" marginwidth="0" marginheight="0" noresize="noresize">
  </frameset>
</frameset>
<noframes></noframes>
<body>
</body>
</html>