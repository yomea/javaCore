<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!-- core标签库是关于UI组件的，HTML是关于HTML进阶标签 -->
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	<!-- jsf的隐式变量与JSP的隐式变量差不多，不过JSP的page在jsf是view，pageContext是facesContext -->
	<!-- jsf的el表达式与JSP的el表达式差不多 -->
	<f:view locale="#{user.locale}"><!-- 也可在faces-config.xml中配置 -->
		<f:loadBundle basename="message" var="msg"/>
		<!-- 这个user是在faces-config.xml配置的bean名字 -->
		<h:outputText value="#{user.name },#{user.password }"></h:outputText>
		
		<h3><h:outputText value="#{msg.grate }"></h:outputText></h3>
		
		
		<h:selectOneRadio value="#{user.locale}">
			<f:selectItem itemValue="zh_CN"
			itemLabel="中文"/>
			<f:selectItem itemValue="en_US"
			itemLabel="英文"/>
		</h:selectOneRadio>
	</f:view>
</body>
</html>