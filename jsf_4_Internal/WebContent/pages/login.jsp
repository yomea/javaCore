<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- core标签库是关于UI组件的，HTML是关于HTML进阶标签 -->
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<!-- 要使用jsf标签，它的所有标签必须在f:view中，就像HTML的标签要在<html>标签中一样 -->
	<f:view>
		<h:form>
			<h3>请输入您的名称</h3>
			<!-- 输入的值将传送到UserBean中 -->
			名称：<h:inputText value="#{user.name}"></h:inputText><p>
			密码：<h:inputText value="#{user.password}"></h:inputText><p>
			<!-- 这个action相当于Struts的action，只不过是直接告诉jsf调用verify方法 -->
			<h:commandButton value="送出" action="#{user.verify}"></h:commandButton>
		</h:form>
	
	</f:view>

</body>
</html>