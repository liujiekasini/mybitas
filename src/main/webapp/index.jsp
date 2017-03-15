<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>  
<title>首页</title>
<script type="text/javascript">

		function lock(){
			 $.ajax({  
			    type : "POST",
		         url:"${pageContext.request.contextPath}/book/list",  
		         success:function(e){  
		        	alert(e);
		         }  
		     }); 
		}
		
</script>
</head>
<body>
这是首页！、
<input type="button" value="查询" onclick="lock()">
</body>
</html>
