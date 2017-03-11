<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dwr test</title>
<!-- 引入dwr相关的js，前面两个固定最后一个是自定义的，这些东西是dwr自动生成的，不需要手动去声明 -->
 <script type='text/javascript' src='dwr/engine.js'></script>
  <script type='text/javascript' src='dwr/util.js'></script>
  <!-- test.js是根据在dwr.xml中配置的JavaScript参数命的名 -->
  <script type='text/javascript' src='dwr/interface/JavaChat.js'></script>
  
  <script type="text/javascript">
  
  window.onload=function() {
	  //一定要再加载完成后才能使用，否则没用的，ajax反转，服务器程序调用ajax
	  dwr.engine.setActiveReverseAjax(true);
  }
  
  function javaChat() {
	  JavaChat.send("heihei");
	  
  }
  	
  function receiveMessages(msg) {
	  
	  document.body.appendChild(document.createTextNode(msg));
	  
  }
  
  </script>
  

</head>
<body>
<input type="button" value="click" onclick="javaChat()" />
</body>
</html>