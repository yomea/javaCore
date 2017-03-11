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
  <script type='text/javascript' src='dwr/interface/test.js'></script>
  
  <script type="text/javascript">
  //ajax反转
  dwr.engine.setActiveReverseAjax(true);
  	
  function dwr_test() {
	  
	  //下面的方法时通过异步的方式调用的，也就是同时调用，谁先执行完说不准
	  //如果需要顺序调用，可以设置为同步dwr.engine.setAsync(false);
	  
	  
	  //test.js中根据dwr.xml的配置的class自动声明了test对象，并且自动声明了与test.js相同的方法名。
	  test.sayHello(function(msg) {
		  
		 document.body.appendChild(document.createTextNode(msg));
		  
	  });
	  
	  //传递参数，最后一个参数是一个函数，用来处理返回值
	  test.sayHello("我喜欢一个女孩，她的名字叫做。。。", function(msg) {
		  
			 document.body.appendChild(document.createTextNode(msg));
			  
	 });
	  
	  
  }
  
  </script>
  

</head>
<body>
<input type="button" value="click" onclick="dwr_test()" />
</body>
</html>