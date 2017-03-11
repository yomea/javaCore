<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core标签库是关于UI组件的，HTML是关于HTML布局标签 -->
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<f:view locale="#{user.locale }">
	<h:outputText value="#{user.locale }"></h:outputText>
	<f:loadBundle basename="message" var="msg" />
	<h:outputText value="#{msg }"></h:outputText>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<!-- 要使用jsf标签，它的所有标签必须在f:view中，就像HTML的标签要在<html>标签中一样 -->

	<!-- 列出所有错误信息 -->
	<h:messages layout="table" style="color:red" />
	<h:form>
		<h3>请输入您的名字</h3>
		<!-- 输入的值将传送到User中 -->
		<h:outputText value="#{msg.username }"></h:outputText>：<h:inputText
			value="#{user.name}" id="userField" required="true"
			requiredMessage="no empty">
		</h:inputText>
		<p>

			<h:outputText value="#{msg.password }"></h:outputText>
			：
			<h:inputText value="#{user.password}" required="true"
				valueChangeListener="#{user.valueChangeListener }">
				<%-- validator="user.validation" --%>
			</h:inputText>
		<p>
<div></div>
			<h:selectOneMenu value="en_US"
				valueChangeListener="#{user.valueChangeListener}">
				<f:valueChangeListener type="com.jsf.actionListener.ValueChangeListenerTest"/>
				<f:selectItem itemValue="zh_CN" itemLabel="Chinese" />
				<f:selectItem itemValue="en_US" itemLabel="English" />
			</h:selectOneMenu>

			<h:commandButton value="送出" actionListener="#{user.verify}"
				action="#{user.outcome}">
				<f:actionListener
					type="com.jsf.actionListener.AccessibleActionListener" />
				<f:actionListener type="com.jsf.actionListener.LogActionListener" />
			</h:commandButton>
			<!-- 设置立即事件，user的任何值都不会发生影响，即不会把写入的值赋给user，值也不进行验证 -->
			<h:commandButton value="#{user.type }" immediate="true"
				actionListener="#{user.changeLocale}"></h:commandButton>
	</h:form>



</body>
	</html>
</f:view>