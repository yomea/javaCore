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
			<h3>请输入您的名字</h3>
			<!-- 输入的值将传送到UserBean中 -->
			名字：<h:inputText value="#{user.user}" id="userField" converter="com.jsf.entity.User">
			
			</h:inputText><p>
			<!-- for="dateField"参考自h:inputText的id -->
			<h:message for="userField" style="color:red"/>
			<h:commandButton value="送出" action="success"></h:commandButton>
		</h:form>
	
	</f:view>

</body>
</html>