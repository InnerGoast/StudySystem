<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>丫丫豆-都市信息平台</title>
		<link href="/favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons.js"></script>
		<!-- TinyMCE -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tiny_mce/tiny_mce.js"></script>
		<style>
			#wrapper{ width:98%; border:#cbcbcb 1px solid; padding-top:17px; padding-left:14px; background:#f4f1.e8;}
			#header{ padding-bottom:18px;}
			.box{ width:99%; border:#cbcbcb 1px solid; background:#ffffff;}
			.tab{ color:#c32c33; margin:0 auto;}
			.tab td{height:40px; padding:0 10px;}
			.tab th{ background:url('${pageContext.request.contextPath}/images/tabThBg.png') right center no-repeat; padding:13px 10px;}
			.field{ cursor:pointer;}
			#header .search{ float:left;}
			.select{ float:left; vertical-align:middle;}
			.select select{ height:32px; line-height:32px; vertical-align:middle;}
		</style>
		<script type="text/javascript">
			tinyMCE.init({
				mode : "exact", // mode:指定附加的模式 textareas : html页面上所有的textarea元素都附加上.
				elements : "content", // exact:精确的模式， 需要指定html元素id属性值
				theme : "advanced", // 主题：advanced(高级的) 、simple(简单的)
				language : "zh-cn", // 国际化
				/** 指定工具按钮资源文件存放的文件夹 */
				plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",
	
				/** 指定工具按钮在上面放四排 */
				theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
				
				/** 指定工具按钮上下的位置 top、bottom */
				theme_advanced_toolbar_location : "top",
				/** 指定工具按钮左、中、右显示的位置 left、center、right */
				theme_advanced_toolbar_align : "left",
				/** 指定状态栏的位置 (top、bottom) */
				theme_advanced_statusbar_location : "bottom",
				/** 指定编辑器是否可以拖动 */
				theme_advanced_resizing : true
			});
			
			$(document).ready(function() {
				
				/** 表单输入校验 */
				$("#noticeForm").submit(function(){
					var title = $("#title");
					var content = tinyMCE.get('content').getContent();
					var msg = "";
					if ($.trim(title.val()) == ""){
						msg = "信息息标题不能为空！";
						title.focus();
					}else if ($.trim(content) == ""){
						msg = "信息内容不能为空！";
					}
					if (msg != ""){
						alert(msg);
						return false;
					}else{
						// 提交表单的方法
						return true;
					}
				});
		    });
		</script>
	</head>
<body>

<div id="wrapper">
    <div class="box">
    	<!-- 表单 -->
    	<h1 style="color:red">${msg}</h1>
	  	<form id="noticeForm" action="doAddOrUpdateNoticeServlet" method="post">
	  		<input type="hidden" name="_method" value="addNotice"/>
	    	<table width="98%" class="tab">
	    		
	    		<tr align="left">
	    		   <tr align="left">
	        	 	   <td><input type="hidden" name="id" value="${notice.id}" /></td>
			       </tr>
	        	 	<td>信息类型：<select name="typeId">
		        	 		      <c:forEach items="${types}" var="type">
		        	 		          <c:if test="${notice.type.id ==type.id }">
		        	 		                <option value="${type.id }" selected="selected">${type.name }</option>
		        	 		          </c:if>
		        	 		          <c:if test="${notice.type.id !=type.id }">
		        	 		               <option value="${type.id }">${type.name }</option>
		        	 		          </c:if>
		        	 		      </c:forEach>
		        	 			<!-- <option value="1">招聘信息</option>
		        	 		
		        	 			<option value="2">培训信息</option>
		        	 		
		        	 			<option value="3">房屋信息</option>
		        	 		
		        	 			<option value="4">求购信息</option>
		        	 		
		        	 			<option value="5">招商引资</option>
		        	 		
		        	 			<option value="6">公寓信息</option>
		        	 		
		        	 			<option value="7">求职信息</option>
		        	 		
		        	 			<option value="8">家教信息</option>
		        	 		
		        	 			<option value="9">车辆信息</option>
		        	 		
		        	 			<option value="10">出售信息</option>
		        	 		
		        	 			<option value="11">寻找启示</option> -->
		        	 		
	        	 		</select>
	        	 		&nbsp;<font color="color"></font>
	        	 	</td>
			    </tr>
	    	
	    		<tr align="left">
	        	 	<td>信息标题：<input type="text" name="title" size="30" id="title" value="${notice.title }"/></td>
			    </tr>
			    
				<tr><td>信息内容：<br/>
					<textarea name="content" cols="100" rows="13" id="content" value="${notice.content }"></textarea>
				</td></tr>
				
				<tr><td>
						<input type="submit" value="确 定">&nbsp;
						<input type="reset" value="重 置">
				</td></tr>
	        </table>
		</form>
    </div>
</div>
</body>
</html>