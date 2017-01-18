<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function test1(){
	var url = "<%=request.getContextPath()%>/HelloServlet?name1="+document.getElementById("name").value;
	this.location = url;
}
function test2(){
	var url = "<%=request.getContextPath()%>/HelloServletInWeb?name1="+document.getElementById("name").value;
	this.location = url;
}
function test3(){
	var url = "<%=request.getContextPath()%>/AsyncServlet?";
	this.location = url;
}
function test4(){
	var url = "<%=request.getContextPath()%>/FirstServletModule1";
	this.location = url;
}
function test5(){
	var url = "<%=request.getContextPath()%>/SecondServletModule2";
	this.location = url;
}
function test6(){
	var url = "<%=request.getContextPath()%>/module2.jsp";
	this.location = url;
}
</script>
</head>
<body >
  <h1 align="center">servlet3.0新特性测试页面</h1>
  <table align="center">
  <tr><td>名称</td><td><input type="text" name="name" id="name"/></td></tr>
  <tr><td><input type="button" value="测试servlet不在web.xml中配置" onclick="test1()"/></td></tr>
  <tr><td> </td></tr>
  <tr><td> </td></tr>
  <tr><td> <input type="button" value="测试servlet在web.xml中配置" onclick="test2()"/></td></tr>
  <tr><td> </td></tr>
  <tr><td> </td></tr>
  <tr><td><input type="button" value="测试servlet异步处理" onclick="test3()"/></td></tr>
  <tr><td>  <form method="post" action="/servlet3/UpLoadServlet" enctype="multipart/form-data">  
   <input type="file" name="upload"/>  
   <input type="submit" value="upload"/>  
  </form></td></tr>
  <tr><td><input type="button" value="测试web模块化servletModule1" onclick="test4()"/></td></tr>
  <tr><td> <a href="module1.jsp">测试web模块化jspModule1</a></td></tr>
  <tr><td><input type="button" value="测试web模块化servletModule2" onclick="test5()"/></td></tr>
  <tr><td> <a href="module2.jsp">测试web模块化jspModule2</a></td></tr>
  </table>
</body>
</html>