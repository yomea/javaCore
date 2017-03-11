<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>servlet + ajax</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul {
	list-style-type: none;
	border: solid 1px black;
}

ul li {
	height: 30px;
	line-height: 30px;
}

#mainBox {
	position: relative;
	width: 500px;
	margin: 0 auto;
}

#resultBox {
	position: absolute;
	width: 153px;
	display: none;
}

#soso {
	position: absolute;
	left: 200px;
}
</style>
<script type="text/javascript">
	window.onload = function() {

		document.onclick = function() {

			var resultList = document.getElementById("resultList");

			var resultBox = document.getElementById("resultBox");

			resultList.innerHTML = "";

			resultBox.style.display = "none";

		}

	}

	function getKeyword() {

		var keywordObject = document.getElementById("keyword");

		var keyword = keywordObject.value;

		var resultList = document.getElementById("resultList");

		var resultBox = document.getElementById("resultBox");

		keyword = keyword.replace(/(^\s+)|(\s+$)/g, "");

		if (keyword == "") {

			return;
		}

		ajax({
			url : "/Servlet_ajax/search",
			method : "get",
			async : true,
			data : {
				"keyword" : keyword
			},
			success : function(data) {

				resultList.innerHTML = "";

				var jsonData = JSON.parse(data);
				
				jsonData = jsonData.content;
				if(jsonData == null) {
					
					return;
				}

				for ( var c in jsonData) {

					var li = document.createElement("li");

					li.onclick = function() {
						keywordObject.value = (this.innerHTML);

					}

					li.onmouseover = function() {

						this.style.backgroundColor = "gray";

					}

					li.onmouseout = function() {

						this.style.backgroundColor = "white";

					}

					var content = document.createTextNode(jsonData[c]);
					li.appendChild(content);
					resultList.appendChild(li);

				}
				resultBox.style.display = "block";
			}
		});

	}

	function createXHR() {
		if (typeof XMLHttpRequest != 'undefined') {
			return new XMLHttpRequest();
		} else if (typeof ActiveXObject != 'undefined') {
			var version = [ 'MSXML2.XMLHttp.6.0', 'MSXML2.XMLHttp.3.0',
					'MSXML2.XMLHttp' ];
			for (var i = 0; version.length; i++) {
				try {
					return new ActiveXObject(version[i]);
				} catch (e) {
					//跳过
				}
			}
		} else {
			throw new Error('您的系统或浏览器不支持XHR对象！');
		}
	}

	//名值对转换为字符串
	function params(data) {
		var arr = [];
		for ( var i in data) {
			arr.push(encodeURIComponent(i) + '=' + encodeURIComponent(data[i]));
		}
		return arr.join('&');
	}

	function ajax(obj) {
		var xhr = createXHR();
		obj.url = obj.url + '?rand=' + Math.random();
		obj.data = params(obj.data);
		if (obj.method === 'get')
			obj.url += obj.url.indexOf('?') == -1 ? '?' + obj.data : '&'
					+ obj.data;
		if (obj.async === true) {
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					callback();
				}
			};
		}
		xhr.open(obj.method, obj.url, obj.async);
		if (obj.method === 'post') {
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send(obj.data);
		} else {
			xhr.send(null);
		}
		if (obj.async === false) {
			callback();
		}
		function callback() {
			if (xhr.status == 200) {
				//alert(xhr.responseText);
				obj.success(xhr.responseText); //回调传递参数
			} else {
				alert('获取数据错误！错误代号：' + xhr.status + '，错误信息：' + xhr.statusText);
			}
		}
	}
</script>

</head>
<body>

	<div id="mainBox">
		<form id="soso" action="" method="get">
			<input id="keyword" type="text" onkeyup="getKeyword()" /> <input
				type="submit" value="提交" />
			<div id="resultBox">
				<ul id="resultList">

				</ul>
			</div>
		</form>
	</div>

</body>
</html>