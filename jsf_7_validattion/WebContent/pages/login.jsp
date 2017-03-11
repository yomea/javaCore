<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- core标签库是关于UI组件的，HTML是关于HTML进阶标签 -->
<%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h"%>
<%@ taglib uri="http://com.jsf.study" prefix="co" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<!-- 要使用jsf标签，它的所有标签必须在f:view中，就像HTML的标签要在<html>标签中一样 -->
	<f:view>
	<!-- 列出所有错误信息 -->
	<h:messages layout="table" style="color:red"/>
		<h:form>
			<h3>请输入您的名字</h3>
			<!-- 输入的值将传送到User中 -->
			名字：<h:inputText value="#{user.firstName}" id="userField"  required="true" requiredMessage="no empty" >
				<f:validateLength minimum="1" maximum="3"></f:validateLength>
			</h:inputText><p>
			
			密码：<h:inputText value="#{user.lastName}"  required="true"  <%-- validator="user.validation" --%>>
			<%-- <f:validator validatorId="com.jsf.entity.pass"/>
			
			<f:attribute name="pattern" value=".+[0-9]+"/>
			 --%>
			 <%-- 这个自定义标签相当于前面两个converter也可以自定义标签 --%>
			<co:passwordValidator pattern=".+[0-9]+"/>
			</h:inputText><p>
			
			<h:commandButton value="送出" action="success"></h:commandButton>
		</h:form>
	
	</f:view>

</body>
</html>