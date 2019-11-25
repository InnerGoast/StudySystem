<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>丫丫豆-都市信息平台</title>
		<link href="/city_info/favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/commons.js"></script>
		<style>
			#wrapper{ width:98%; border:#cbcbcb 1px solid; padding-top:17px; padding-left:14px; background:#f4f1e8;}
			#header{ padding-bottom:18px;}
			.box{ width:99%; border:#cbcbcb 1px solid; background:#ffffff;}
			.tab{ color:#c32c33; margin:0 auto;}
			.tab td{ text-align:center; height:40px; padding:0 10px;}
			.tab th{ background:url('${pageContext.request.contextPath}/images/tabThBg.png') right center no-repeat; padding:13px 10px;}
			.field{ cursor:pointer;}
			#header .search{ float:left;}
			.select{ float:left; vertical-align:middle;}
			.select select{ height:32px; line-height:32px; vertical-align:middle;}
		</style>
		<script>
			/** 当前文档加载完 */
			$(function(){
				/** 为全选绑定点击事件 */
				$(".checked").click(function(){
					$(".checkbox").attr("checked", this.checked);
				});
				
				/** 获取发布按钮绑定点击事件 */
				$("#publishBtn").click(function(){
					/** 获取下面所有选中的checkbox */
					var boxs = $("input[id^='box_']:checked");
					var ids="";
				    $.each(boxs,function(i,v){
				        //获取选中的box的value(数据的id)
				    	var id=boxs[i].value;
				        //通过id去获取该数据对应的发布状态
				    	var status =$("#status_"+id).val();
				        //刷选未发布的id拼接
				    	if(status==0){
				    		ids=ids+id+",";
				    	}
				    })
				    //过滤数据
			    	ids=ids.substring(0, ids.length-1);
			        //发送拼接完成的数据
			        if(ids!=""){
			        	if(confirm("您确定要发布选中信息吗？")){
				    		window.location="${pageContext.request.contextPath}/NoticeServlet?method=publish&ids="+ids;
				    	}
			        }else{
			        	alert("已发布的不能重复发布,请选择未发布的消息");
			        }
					/* alert(boxs.length); */
					/* if (boxs.length == 0){
						alert("请选择要发布的信息！");
					}else{
						if (confirm("您确定要发布选中的信息？")){
							var ids = boxs.map(function(){
								return this.value;
							});
							window.location = "${pageContext.request.contextPath}/notice.action?_method=publish&ids=" + ids.get();
						}
					} */
				});
				/** 定义提示信息 */
				var tip = "";
				if (tip != ""){
					alert(tip);
				}
			});
			
			/** 删除信息 */
			var deleteFn = function(id){
				if (confirm("您确定要删除吗？")){
					window.location = "${pageContext.request.contextPath}/NoticeServlet?method=deleteNotice&id=" + id;
				}
			};
			/** 修改信息 */
			var updateFn = function(id){
				window.location = "${pageContext.request.contextPath}/addOrUpdateNoticeServlet?id=" + id;
			};
		</script>
	</head>
<body>

<div id="wrapper">
	<div id="header" class="clear">
        <div class="search">
	        <form action="${pageContext.request.contextPath}/notice.action" method="post" id="searchForm">
	        	<input type="hidden" name="_method" value="selectNotice"/>
	            <input type="text" value="" id="title" name="title" class="text">
	            <input type="submit" value="" class="submit">
	        </form>
        </div>
         <div class="export">
        	<input type="button" value="发布" id="publishBtn" class="selectBtn"><span style="color:red;font-size:24px">${msg}</span>
        </div>
    </div>
    
    <div class="box">
    	<table width="98%" class="tab">
        	<tr style="border-bottom:#c32c33 1px solid;">
            	<th><input type="checkbox" name="" class="checked"></th>
            	<th>信息类型</th>
            	<th>编号</th>
                <th>标题</th>
                <th>创建时间</th>
                <th>发布时间</th>
                <th>发布状态</th>
                <th>发布人</th>
                <th style="background:none;" colspan="2">操作</th>
            </tr>
            <!-- 迭代数据 -->
                 <c:forEach items="${notices }" var="notice">
                     <tr class="field" style="border-bottom:#f3d5d6 1px dashed;">
                       <td><input class="checkbox" value="${notice.id}" id="box_${notice.id}" type="checkbox"/> </td>
                       <td>【${notice.type.name }】</td>
	            	<td>${notice.id}</td>
	                <td>${notice.title }</td>
	                <td>${notice.createDate }</td>
	                <td>${notice.publishDate }</td>
	                <td>
	                    <input type="hidden" id="status_${notice.id}" value="${notice.publishStatus}" />
	                    <c:if test="${notice.publishStatus==1 }">
	                        <font color="blue">已发布</font>
	                    </c:if>
	                	 <c:if test="${notice.publishStatus==0 }">
	                        <font color="blue">未发布</font>
	                    </c:if>
	                </td>
	                <td>${notice.user.name }</td>
	                <td><a href="javascript:void(0);" onclick="deleteFn(${notice.id});" style="color:blue;">删除</a></td>
	                <td><a href="javascript:void(0);" onclick="updateFn(${notice.id});" style="color:blue;">修改</a></td>
                     </tr>
                 </c:forEach>
	            <!-- <tr class="field" style="border-bottom:#f3d5d6 1px dashed;">
	            	<td><input class="checkbox" value="4" id="box_1" type="checkbox"/> </td>
	            	<td>【招聘信息】</td>
	            	<td>4</td>
	                <td>广州南方人才招聘会2015年5月份</td>
	                <td>2015-05-25</td>
	                <td>2015-05-25</td>
	                <td>
	                	
	                	
	                		<font color="blue">已发布</font>
	                	
	                </td>
	                <td>yayadou</td>
	                <td><a href="javascript:void(0);" onclick="deleteFn(4);" style="color:blue;">删除</a></td>
	                <td><a href="javascript:void(0);" onclick="updateFn(4);" style="color:blue;">修改</a></td>
	            </tr>
          	
	            <tr class="field" style="border-bottom:#f3d5d6 1px dashed;">
	            	<td><input class="checkbox" value="6" id="box_2" type="checkbox"/> </td>
	            	<td>【求购信息】</td>
	            	<td>6</td>
	                <td>求购回收老红木家具</td>
	                <td>2015-05-25</td>
	                <td>2015-05-25</td>
	                <td>
	                	
	                	
	                		<font color="blue">已发布</font>
	                	
	                </td>
	                <td>yayadou</td>
	                <td><a href="javascript:void(0);" onclick="deleteFn(6);" style="color:blue;">删除</a></td>
	                <td><a href="javascript:void(0);" onclick="updateFn(6);" style="color:blue;">修改</a></td>
	            </tr> -->
          	
        </table>
    </div>
    <!-- 判断总页数不等于1时，显示分页信息 -->
    
	    <div align="center">
	           <c:if test="${thisPage==1 }">
	                      【首页】
	    		【上一页】
	    		【<a href="/City_info/managerServlet?thisPage=${thisPage+1}" style="text-decoration:underline;color:blue;">下一页</a>】
	    		【<a href="/City_info/managerServlet?thisPage=${totalPage}" style="text-decoration:underline;color:blue;">尾页</a>】 
	           </c:if>
	           <c:if test="${thisPage>1 && thisPage<totalPage }">
	                      【<a href="/City_info/managerServlet?thisPage=1" style="text-decoration:underline;color:blue;">首页</a>】
	    		【<a href="/City_info/managerServlet?thisPage=${thisPage-1}" style="text-decoration:underline;color:blue;">上一页</a>】
	    		【<a href="/City_info/managerServlet?thisPage=${thisPage+1}" style="text-decoration:underline;color:blue;">下一页</a>】
	    		【<a href="/City_info/managerServlet?thisPage=${totalPage}" style="text-decoration:underline;color:blue;">尾页</a>】 
	           </c:if>
	           <c:if test="${thisPage==totalPage }">
	                     【<a href="/City_info/managerServlet?thisPage=1" style="text-decoration:underline;color:blue;">首页</a>】
	    		【<a href="/City_info/managerServlet?thisPage=${thisPage-1}" style="text-decoration:underline;color:blue;">上一页</a>】
	    		【下一页】
	    		【尾页】 
	           </c:if>
	    	 <!-- 控制首页 与 上一页  -->
	    	
	    	<!--
	    		【<a href="/city_info/notice.action?_method=selectNotice&pageIndex=1&title=" style="text-decoration:underline;color:blue;">首页</a>】
	    		【<a href="/city_info/notice.action?_method=selectNotice&pageIndex=1&title=" style="text-decoration:underline;color:blue;">上一页</a>】
	    	-->
	    	 <!--控制下一页 与 尾页  -->
	    	<!--
	    	
	    		【<a href="/city_info/notice.action?_method=selectNotice&pageIndex=3&title=" style="text-decoration:underline;color:blue;">下一页</a>】
	    		【<a href="/city_info/notice.action?_method=selectNotice&pageIndex=3&title=" style="text-decoration:underline;color:blue;">尾页</a>】 
	    	-->
	    </div>
    
</div>
</body>
</html>