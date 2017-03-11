<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <!-- core标签库是关于UI组件的，HTML是关于HTML进阶标签 -->
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fail</title>
</head>
<body>
	<f:view>
			<!-- 这个user是在faces-config.xml配置的bean名字 -->
			<h3>error</h3>
			<h:outputText value="#{user.errMessage }"></h:outputText>
			
	</f:view>
</body>
</html>