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
	

<!-- <input id="user" type="text" name="user" value="guest" />
<label for="user"> -->
<h:inputText id="user" value="#{user.name}"/>
<h:outputLabel for="user" value="#{user.name}"/>


<h:outputLink value="../index.jsp"/><!-- <a href="../index.jsp" /> -->


<f:loadBundle basename="messages" var="msgs"/>
<h:outputFormat value="#{msgs.welcomeText}">
	<f:param value="Hello"/>
	<f:param value="Guest"/>
</h:outputFormat>

<h:outputFormat value="{0}, Your name is {1}.">
	<f:param value="Hello"/>
	<f:param value="Guest"/>
</h:outputFormat>


<h:outputText value= "#{user.name}" />

<h:inputText value="#{user.name}"/><!-- <input type="text" /> -->

<h:inputTextarea value="#{user.command}"/><!-- <textarea rows="" cols=""></textarea> -->

<h:inputSecret value="#{user.password}"/><!-- <input type="password" /> -->

<h:inputHidden value="#{user.hiddenInfo}"/><!-- <input type="hidden" /> -->

<h:commandButton image="images/logowiki.jpg" type="submit" value="送出" action="#{user.verify}"/><!-- <input type="submit" /> -->

<!-- 可代替h:commandButton但显示的模样和a标签一样<a href="#" onclick="document.forms['_id3']['_id3:_idcl'].value='_id3:_id13';
document.forms['_id3'].submit(); return false;">Submit</a> -->
<h:commandLink value="#{msgs.commandText}" action="#{user.verify}"/>

<h:commandLink>
	<h:outputText value="welcome"/>
	<!-- 传递参数 -->
	<f:param name="locale" value="zh_CN"/>
</h:commandLink>

<h:selectBooleanCheckbox  value="#\{user.aggree\}"/>

<!-- 单选 布局方式lineDirection、pageDirection -->
<h:selectOneRadio  value="#{user.education}" layout="pageDirection">
<!-- 将itemValue的值设置到value="#{user.education}"，然后设置user的值 -->
	<f:selectItem itemLabel="高中" itemValue="高中"/>
	<f:selectItem itemLabel="大学" itemValue="大学"/>
	<f:selectItem itemLabel="研究所以上" itemValue="研究所以上"/>
</h:selectOneRadio>

<!-- value 所绑定的属性必须是数组或集合，除了基本类型如果是其它型态的对象，必要时必须搭配转换器（Converter）进行字符串与对象之间
的转换。 -->
<!-- h:selectManyListbox -->
<h:selectManyCheckbox layout="pageDirection"
value="#{user.preferColors}">
	<f:selectItem itemLabel="红" itemValue="false"/>
	<f:selectItem itemLabel="黄" itemValue="false"/>
	<f:selectItem itemLabel="蓝" itemValue="false"/>
</h:selectManyCheckbox>


<!-- <h:selectManyCheckbox layout="pageDirection"
value="#{user.preferColors}">
	<f:selectItem itemLabel="红" itemValue="false"/>
	<f:selectItem itemLabel="黄" itemValue="false"/>
	<f:selectItem itemLabel="蓝" itemValue="false"/>
</h:selectManyCheckbox> -->
<h:selectManyCheckbox layout="pageDirection"
value="#{user.preferColors}">
<!-- 取到user.preferColorItems会分散成一段 f:selectItem-->
<f:selectItems value="#{user.preferColorItems}"/>
</h:selectManyCheckbox>

<!-- 用来打印错误信息 -->
<h:messages layout="table" style="color:red;" />

<!-- <img src="" -->
<h:graphicImage value="/images/logowiki.jpg"/>

<!-- 设置两列，自动会将下面的组件按照两个两个排版 -->
<h:panelGrid columns="2">
	<h:outputText value="Username"/>
	<h:inputText id="name" value="#{userBean.name}"/>
	<h:outputText value="Password"/>
	<h:inputText id="password" value="#{userBean.password}"/>
	<h:commandButton value="submit" action="login"/>
	<h:commandButton value="reset" type="reset"/>
</h:panelGrid>


<%-- <h:panelGrid>的本体间只能包括 JSF 组件，如果想要放入非 JSF 组件，例如简单的
样版（template）文字，则要使用 <f:verbatim>包括住，例如： --%>
<h:panelGrid columns="2">
	<f:verbatim>Username</f:verbatim>
	<h:inputText id="name" value="#{userBean.name}"/>
	<f:verbatim>Password</f:verbatim>
	<h:inputText id="password" value="#{userBean.password}"/>
	<h:commandButton value="submit" action="login"/>
	<h:commandButton value="reset" type="reset"/>
</h:panelGrid>



<h:panelGrid columns="2">
	<h:outputText value="Username"/>
	<h:inputText id="name" value="#{userBean.name}"/>
	<h:outputText value="Password"/>
	<h:inputText id="password" value="#{userBean.password}"/>
	<!-- 表示以下的两个标签是一组 -->
	<h:panelGroup>
		<h:commandButton value="submit" action="login"/>
		<h:commandButton value="reset" type="reset"/>
	</h:panelGroup>
</h:panelGrid>



<h:dataTable value="#{tableBean.userList}" var="user">
	<h:column>
		<h:outputText value="#{user.name}"/>
	</h:column>
	<h:column>
		<h:outputText value="#{user.password}"/>
	</h:column>
</h:dataTable>

<!-- dataModel请参考数据手册 -->
<h:dataTable value="#{tableBean.userList}" var="user" styleClass="orders"
headerClass="ordersHeader"
rowClasses="evenColumn,oddColumn">
	<h:column>
		<f:facet name="header">
			<h:outputText value="Name"/>
		</f:facet>
		<h:outputText value="#{user.name}"/>
		<f:facet name="footer">
			<h:outputText value="****"/>
		</f:facet>
	</h:column>
	<h:column>
		<f:facet name="header">
			<h:outputText value="Password"/>
		</f:facet>
		<h:outputText value="#{user.password}"/>
		<f:facet name="footer">
			<h:outputText value="****"/>
		</f:facet>
	</h:column>
</h:dataTable>


</body>
	</html>
</f:view>